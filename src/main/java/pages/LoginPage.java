package pages;

import commons.enums.PageURL;
import controls.common.imp.Element;
import controls.common.imp.TextBox;
import data.UserInfo;
import utils.DriverUtils;

public class LoginPage extends BasePage {
    public static final PageURL page = PageURL.LOGIN_PAGE;
    private static final Element hyperlink = new Element("//a[normalize-space()=\"%s\"]");
    private static final TextBox txtBoxUserName = new TextBox("//*[@id='username']");
    private static final TextBox txtBoxPassword = new TextBox("//*[@id='password']");

    @Override
    public void load() {
        navigateTo(page);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL(page)) {
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
}
