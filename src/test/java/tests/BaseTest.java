package tests;

import org.testng.annotations.AfterClass;

import java.util.Properties;

public class BaseTest {

    Properties config = new Properties();

    @AfterClass(alwaysRun = true)
    public void tearDown() {

    }
}
