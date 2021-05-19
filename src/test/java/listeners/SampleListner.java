package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SampleListner implements ITestListener {
    public void onTestFailure(ITestResult result){
        if(result.getThrowable() != null){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);


        }

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if(result.isSuccess()==true){
            System.out.println("hhhhhhooooooooooo");

        }
    }



}
