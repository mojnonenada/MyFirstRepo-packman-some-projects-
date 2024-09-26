public class Tests {
    @BeforeSuite
    public void methodBeforeSuite(){System.out.println("BeforeSuite");}

    @AfterSuite
    public void methodAfterSuite(){System.out.println("AfterSuite");}

    @Test (priority = 1)
    public void test_1(){System.out.println("Test_1");}

    @Test(priority = 2)
    public void test_2(){System.out.println("Test_2");}

    @Test(priority = 3)
    public void test_3(){System.out.println("Test_3");}

    @Test(priority = 4)
    public void test_4(){System.out.println("Test_4");}

    @Test(priority = 5)
    public void test_5(){System.out.println("Test_5");}

    @Test(priority = 10)
    public void test_10(){System.out.println("Test_10");}
}

