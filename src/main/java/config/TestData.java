package config;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] loginData(){

        return new Object[][]{ // двумерный массив
                {"fakeUser1@mail.com", "fakePassword1"},
                {"fakeUser2mail.com", "fakePassword2$"}
        }; // можно использовать генераторы, не как здесь хардкод
    }

}
