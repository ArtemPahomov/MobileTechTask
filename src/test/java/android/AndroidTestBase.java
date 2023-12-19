package android;

import appium.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class AndroidTestBase {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new DriverFactory().createAndroidDriver();
        System.out.println("Driver was created");
    }
    @AfterMethod
    public void teardown(Method method){
        System.out.println("Driver will close");
        driver.quit();
    }
}
