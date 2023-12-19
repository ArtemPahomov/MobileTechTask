package android;

import appium.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageAndroid {
    private final By loginField = By.id("com.alfabank.qapp:id/etUsername");
    private final By loginPageHeader = By.xpath("//*[@resource-id=\"com.alfabank.qapp:id/tvTitle\"]");
    private final By passwordField = By.xpath("//android.widget.EditText[@resource-id=\"com.alfabank.qapp:id/etPassword\"]");
    private final By submitBtn = By.className("android.widget.Button");
    private final By errorMessage = By.cssSelector("#com.alfabank.qapp:id/tvError");
    private final By showPassBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Показать пароль\"]");
    private final By hidePassBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Показать пароль\"]");
    WebDriverWait wait;
    AndroidDriver driver;

    public LoginPageAndroid(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, 10);
        this.driver = driver;
    }

    public LoginPageAndroid setLogin(String login){
        wait.until(ExpectedConditions.elementToBeClickable(loginField));
        driver.findElement(loginField).sendKeys(login);
        return new LoginPageAndroid(driver);
    }
    public LoginPageAndroid setPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        return new LoginPageAndroid(driver);
    }
    public UserPageAndroid clickSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        driver.findElement(submitBtn).click();
        return new UserPageAndroid(driver);
    }

    public boolean isLoginFieldShown(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginField));
        return driver.findElement(loginField).isDisplayed();
    }
    public boolean isPasswordFieldShown(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        return driver.findElement(passwordField).isDisplayed();
    }
    public boolean isLoginPageHeaderShown(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPageHeader));
        return driver.findElement(loginPageHeader).isDisplayed();
    }
    public boolean isSubmitBtnShown(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginField));
        return driver.findElement(loginField).isDisplayed();
    }
    public boolean isErrorMessageShown(){
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }
    public LoginPageAndroid showPassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(showPassBtn));
        driver.findElement(showPassBtn).click();
        return this;
    }
    public void hidePassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(hidePassBtn));
        driver.findElement(hidePassBtn).click();
    }
    public String getTextFromPassField(){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        return driver.findElement(passwordField).getText();
    }
}
