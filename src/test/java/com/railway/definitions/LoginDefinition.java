package com.railway.definitions;

import com.railway.data.UserInfo;
import io.cucumber.java8.En;
import com.railway.pages.LoginPage;
import com.railway.utils.UserInfoUtils;

public class LoginDefinition implements En {
    LoginPage loginPage = new LoginPage();

    public LoginDefinition() {
        When("I click on the hyperlink text {string}", (String itemName) -> {
            loginPage.clickHyperLinkText(itemName);
        });

        Given("I login with {word} account", (String userKey) -> {
            UserInfo userInfo = UserInfoUtils.getUserInfo(userKey);
            loginPage.login(userInfo);
        });
    }
}
