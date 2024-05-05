package config;

import helpers.EmailGenerator;
import helpers.PasswordStringGenerator;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] loginData(){

        return new Object[][]{ // двумерный массив
                {EmailGenerator.generateWrongEmailWithoutSymbol(5,3,2), "fakePassword1"},
                {"fakeUser2mail.com", "PasswordStringGenerator."}
        }; // можно использовать генераторы, не как здесь хардкод
    }

}
