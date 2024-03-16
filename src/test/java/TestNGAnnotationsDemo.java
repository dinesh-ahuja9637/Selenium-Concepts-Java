import org.testng.annotations.*;

@Test(groups = {"e2e","regression"})
public class TestNGAnnotationsDemo {

    @BeforeGroups(groups = {"e2e"})
    public void BeforeGroups1()
    {
        System.out.println("BeforeGroups1");
    }



    @AfterGroups(groups = {"e2e"})
    public void afterGroups1()
    {
        System.out.println("afterGroups1");
    }



    @BeforeSuite
    public void BeforeSuite1()
    {
        System.out.println("BeforeSuite1");
    }


    @AfterSuite
    public void AfterSuite1()
    {
        System.out.println("AfterSuite1");
    }




    @BeforeClass
    public void beforeClass1()
    {
        System.out.println("beforeClass1");
    }

    @AfterClass
    public void AfterClass1()
    {
        System.out.println("AfterClass1");
    }





    @BeforeMethod
    public void BeforeMethod1()
    {
        System.out.println("BeforeMethod1");
    }

    @AfterMethod
    public void AfterMethod1()
    {
        System.out.println("AfterMethod1");
    }



    @BeforeTest
    public void BeforeTest1()
    {
        System.out.println("BeforeTest1");
    }

    @AfterTest
    public void AfterTest()
    {
        System.out.println("AfterTest");
    }

    @Test(groups = "regression")
    public void test1_Annotation()
    {

        System.out.println("test1_Annotation");

    }

    @Test
    public void test2_Annotation()
    {
        System.out.println("test2_Annotation");
    }


    @Test
    public void test3_Annotation()
    {
        System.out.println("test3_Annotation");
    }
}
