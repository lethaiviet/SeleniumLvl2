package pages;

import commons.enums.PageURL;
import controls.common.imp.Button;
import controls.common.imp.Label;
import controls.common.imp.TextBox;
import utils.DriverUtils;

import java.util.Map;

public class RegisterPage extends BasePage {
    public static final PageURL page = PageURL.REGISTER_PAGE;
    private static final TextBox txtBoxEmail = new TextBox("//*[@id='email']");
    private static final TextBox txtBoxPassword = new TextBox("//*[@id='password']");
    private static final TextBox txtBoxConfirmPassword = new TextBox("//*[@id='confirmPassword']");
    private static final TextBox txtBoxPID = new TextBox("//*[@id='pid']");
    private static final Button btnRegister = new Button("//input[@type='submit']");
    private static final Label lblErrorMsg = new Label("//*[@class='message error']");

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

    public void clickRegisterButton() {
        btnRegister.waitForElementClickable();
        btnRegister.click();
        waitForCompletedRegistering();
    }

    public void waitForCompletedRegistering() {
        DriverUtils.waitForAjaxJQueryProcess();
    }

    public String getErrorMsg() {
        lblErrorMsg.waitForVisibility();
        return lblErrorMsg.getText();
    }
}
