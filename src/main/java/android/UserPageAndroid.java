package android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPageAndroid {
    private final By userPageHeader = By.xpath("//android.widget.TextView[@text=\"Вход в Alfa-Test выполнен\"]");
    WebDriverWait wait;
    AndroidDriver driver;

    public UserPageAndroid(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver,10);
        this.driver = driver;
    }
    public boolean userPageHeaderIsDisplayed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(userPageHeader));
        return driver.findElement(userPageHeader).isDisplayed();
    }
}
