### Code review
There is obviously no framework in place in the sample project provided for this coding round test, making it difficult to reuse and maintain. I have designed a framework that will help to address these problems. The details are below.

In `FlightBookingTest.java` these is no POM concept in play and this makes storing and updating the elements extremely difficult. In addition, the `waitFor`method (line 60) is better replaced by the inbuilt implicit or explicit wait.

In `HotelBookingTest.java` there is POM concept but there is no segregation between test method and POM class. Ideally the pom class should worry about elements and methods to perform actions on elements, and test class should just call those pom class methods as needed.

`SignInTest.java` has an issue with `iframe`.  The `signInButton` in line 23 is in another frame and we should switch to the frame before accessing the button using `driver.switchTo().frame()`. Once again the code is hard to maintain and it is not modular.



## Framework Design

**Technology stack:** *Java, Selenium, TestNG, Maven*

I have built a framework from scratch with **abstractions, reusability and maintenance** in mind. Here are some of the points about the framework:


 - There are three packages - **generic, pom and scripts** - that house codes for different purposes.
 >- `generic` package contains classes that are reusable across different projects
 >- `pom` package contains application-specific Page-Object Model classes or element repositories)
 >- `scripts` package contains application-specific testng scripts
- For every test case there is a *@Test* method, and in every test method there are some common steps such as opening application, closing application etc. Instead of repeating these steps in all *@Test* methods these actions are put into separate methods. In addition, to avoid calling them explicitly in each test scripts, these actions are designed with *@BeforeMethod* and *@AfterMethod* provided by TestNG.
- For **reusability** a base test class, `BaseTest` houses the above methods. This class is present in `generic` package and all the test scripts inside `scripts` package extends this class.
- Similarly, a base page class, `BasePage` inside `generic` package houses all the common actions that might be require to perform on all the pages/screens such as verifying the title, verifying the presence of an element etc.
- For the ease of **maintenance**, for each web page/screen there is a corresponding pom class inside the `pom` package. These classes extend the `BasePage` class. These classes are used to store and update elements. Methods of this class are called from test classes present in `scripts` package as and when needed.
- All the test classes are inside scripts package and are designed with *@Test*. The sole purpose of test classes is to instantiate the necessary pom class and call the methods of those classes as needed. (Additionally, reading data from various resources can be done here). This is **abstraction** in play as the test classes need to know only the methods and not their implementation.
- generic package also has an `AutoConsts` interface that houses all the constants such as the location of driver executables data files, databases, user credentials etc. `BaseTest` implements this interface.
- *testng.xml* is modified to use *\<package\>* tag so that all the scripts inside the `scripts`package can be run.
- All the driver executables and `jar` files are put in separate folders

Here is the flow of control in the framework.

   ![enter image description here](https://lh3.googleusercontent.com/15Hg7dN-zjk2F3F0d6Tjd5oqvm2rkCG4IpFipXcCay0c2TXjJuq-HnItnUG3Lz9NYfsSKPd7dO2T "Automation framework flow")