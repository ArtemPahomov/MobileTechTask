package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public AndroidDriver createAndroidDriver() {
        DesiredCapabilities capabilities = new Capabilities().createAndroidCapabilities();
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    //Так же здесь можно создавать драйверы для различных платформ и с разными параметрами

//    public IOSDriver createIOSDriver() {
//        DesiredCapabilities capabilities = new Capabilities().createIOSCapabilities();
//        IOSDriver driver = null;
//        try {
//            driver = new IOSDriver(new URL(hubUrl), capabilities);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return driver;
//    }
}
