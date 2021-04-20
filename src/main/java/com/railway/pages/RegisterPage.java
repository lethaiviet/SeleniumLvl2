package com.railway.pages;

import com.railway.controls.common.imp.Label;
import com.railway.commons.enums.PageURL;
import com.railway.controls.common.imp.TextBox;
import com.railway.utils.DriverUtils;
import com.railway.utils.JsonLocatorUtils;

import java.util.Map;

public class RegisterPage extends BasePage {
    public static final PageURL PAGE = PageURL.REGISTER_PAGE;
    private final TextBox txtBoxEmail = new TextBox(JsonLocatorUtils.get("txtBoxEmail"));
    private final TextBox txtBoxConfirmPassword = new TextBox(JsonLocatorUtils.get("txtBoxConfirmPassword"));
    private final TextBox txtBoxPID = new TextBox(JsonLocatorUtils.get("txtBoxPID"));
    private final Label lblErrorMsg = new Label(JsonLocatorUtils.get("lblErrorMsg"));

    @Override
    public void load() {
        navigateTo(PAGE);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL()) {
            throw new Error("REGISTER_PAGE was not successfully loaded");
        }
    }

    public void fillRegisterForm(Map<String, String> data) {
        txtBoxEmail.clear();
        txtBoxEmail.enter(data.get("Email"));

        txtBoxPassword.clear();
        txtBoxPassword.enter(data.get("Password"));

        txtBoxConfirmPassword.clear();
        txtBoxConfirmPassword.enter(data.get("Password"));

        txtBoxPID.clear();
        txtBoxPID.enter(data.get("PID"));
    }

    public boolean isMatchURL() {
        return isMatchURL(PAGE);
    }

    public String getErrorMsg() {
        lblErrorMsg.waitForVisibility();
        return lblErrorMsg.getText();
    }
}
