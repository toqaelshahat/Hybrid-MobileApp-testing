package com.sample.testcases;

import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.Eyes;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseApplitoolsTest extends BaseTest{
    Eyes eyes;


    @BeforeClass
    public void setUp() throws Exception {
        super.beforeclass();

        // Initialize the Eyes SDK with our API key (set it as an environment variable)
        eyes = new Eyes();
        eyes.setLogHandler(new StdoutLogHandler());
        eyes.setApiKey("hr9x92352tTJXqg0cmzdopBSnmtSoojO8gtK6fAhxOs110");
    }

    @AfterClass
    public void tearDown() {
        eyes.abortIfNotClosed();

    }

}
