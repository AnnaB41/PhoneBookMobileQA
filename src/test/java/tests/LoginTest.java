package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig {

    @Test
    public void loginPositive(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("myemail5@mail.com")
                .fillPasswordField("Tt123456$")
                .clickByLoginButton();
        AuthenticationScreen authenticationScreen = contactListScreen.logout();
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }

    @Test
    public void loginNegative(){
       AuthenticationScreen authenticationScreen = new SplashScreen(driver).switchToAuthScreen()
                .fillEmailField("myeemail")
                .fillPasswordField("123Wwjkl$")
                .clickByLoginButton();

       //authenticationScreen.clickError();

       Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());

    }

}
