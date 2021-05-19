package reports;


import com.sample.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Reporrs extends BaseTest {






    @Test
    public void test1(){
        System.out.println("HI from testcase1");
    }
    @Test
    public void test2(){
       // System.out.println("HI from test2");
        Assert.assertTrue(false,"sorry about your mum" );
    }

}
