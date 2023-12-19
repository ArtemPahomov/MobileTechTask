package android;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginAndroidTest extends AndroidTestBase{

    @Test
    public void checkLoginPositive(){
        new LoginPageAndroid(driver)
                .setLogin("Login")
                .setPassword("Password")
                .clickSubmitButton();
        Assert.assertTrue(new UserPageAndroid(driver).userPageHeaderIsDisplayed());
    }
    @Test
    public void checkLoginWithEmptyFields(){
        new LoginPageAndroid(driver)
                .setLogin("")
                .setPassword("")
                .clickSubmitButton();
        Assert.assertTrue(new LoginPageAndroid(driver).isErrorMessageShown());
    }
    @Test
    public void checkLoginWithNotCorrectPass(){
        new LoginPageAndroid(driver)
                .setLogin("Login")
                .setPassword("NotCorrectPassword")
                .clickSubmitButton();
        Assert.assertTrue(new LoginPageAndroid(driver).isErrorMessageShown());
    }
    @Test
    public void checkLoginWithNotCorrectLogin(){
        new LoginPageAndroid(driver)
                .setLogin("NotCorrectLogin")
                .setPassword("Password")
                .clickSubmitButton();
        Assert.assertTrue(new LoginPageAndroid(driver).isErrorMessageShown());
    }
    @Test
    public void checkLoginWithBothNotCorrectFields(){
        new LoginPageAndroid(driver)
                .setLogin("NotCorrectLogin")
                .setPassword("NotCorrectPassword")
                .clickSubmitButton();
        Assert.assertTrue(new LoginPageAndroid(driver).isErrorMessageShown());
    }
    @Test
    public void checkAllElementsIsVisible(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new LoginPageAndroid(driver).isLoginPageHeaderShown());
        softAssert.assertTrue(new LoginPageAndroid(driver).isLoginFieldShown());
        softAssert.assertTrue(new LoginPageAndroid(driver).isPasswordFieldShown());
        softAssert.assertTrue(new LoginPageAndroid(driver).isSubmitBtnShown());
        softAssert.assertAll();
    }
    @Test
    public void checkShowHidePassword(){
        new LoginPageAndroid(driver).setPassword("")
                .showPassword()
                .hidePassword();
    }
}
