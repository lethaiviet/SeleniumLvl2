package pages;

import commons.enums.PageURL;
import controls.common.imp.Label;
import controls.common.imp.TextBox;
import utils.DriverUtils;
import utils.JsonLocatorUtils;

import java.util.Map;

public class RegisterPage extends BasePage {
    public static final PageURL page = PageURL.REGISTER_PAGE;
    private final TextBox txtBoxEmail = new TextBox(JsonLocatorUtils.get("txtBoxEmail"));
    private final TextBox txtBoxConfirmPassword = new TextBox(JsonLocatorUtils.get("txtBoxConfirmPassword"));
    private final TextBox txtBoxPID = new TextBox(JsonLocatorUtils.get("txtBoxPID"));
    private final Label lblErrorMsg = new Label(JsonLocatorUtils.get("lblErrorMsg"));

    @Override
    public void load() {
        navigateTo(page);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL(page)) {
            throw new Error("REGISTER_PAGE was not successfully loaded");
        }
    }

    public boolean isMatchURL() {
        return isMatchURL(page);
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

    public String getErrorMsg() {
        lblErrorMsg.waitForVisibility();
        return lblErrorMsg.getText();
    }
}
