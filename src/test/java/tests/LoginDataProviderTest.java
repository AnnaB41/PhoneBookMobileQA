package tests;

import config.AppiumConfig;
import config.TestData;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.SplashScreen;

public class LoginDataProviderTest extends AppiumConfig {

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    // указываем название метода и название класса
    public void loginTestNegative(String email, String password){
        Allure.description("Login in with incorrect data");
        AuthenticationScreen authenticationScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField(email)
                .fillPasswordField(password)
                .clickByLoginButton();
        Allure.step("Result of login");

        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }
}
