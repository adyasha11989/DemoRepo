package practice;

import org.testng.annotations.*;

public class testNGcheck {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite output");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before Test output");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before the class output");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before the method");
    }

    @Test
    public void testing(){
        System.out.println("testing method");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after testcase");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
