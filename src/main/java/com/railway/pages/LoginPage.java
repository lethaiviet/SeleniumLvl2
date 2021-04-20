package com.railway.pages;

import com.railway.commons.enums.PageURL;
import com.railway.controls.common.imp.Element;
import com.railway.controls.common.imp.TextBox;
import com.railway.utils.DriverUtils;
import com.railway.data.UserInfo;
import com.railway.utils.JsonLocatorUtils;

public class LoginPage extends BasePage {
    public static final PageURL PAGE = PageURL.LOGIN_PAGE;
    private final Element hyperlink = new Element(JsonLocatorUtils.get("hyperlink"));
    private final TextBox txtBoxUserName = new TextBox(JsonLocatorUtils.get("txtBoxUserName"));

    @Override
    public void load() {
        navigateTo(PAGE);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL()) {
            throw new Error("LOGIN_PAGE was not successfully loaded");
        }
    }

    public void clickHyperLinkText(String name) {
        hyperlink.setDynamicValue(name);
        hyperlink.waitForElementClickable();
        hyperlink.click();
    }

    public void fillLoginForm(String email, String password) {
        txtBoxUserName.clear();
        txtBoxUserName.enter(email);

        txtBoxPassword.clear();
        txtBoxPassword.enter(password);
    }

    public void login(UserInfo userInfo) {
        fillLoginForm(userInfo.getEmail(), userInfo.getPassword());
        clickSubmitButton();
    }

    public boolean isMatchURL() {
        return isMatchURL(PAGE);
    }
}
