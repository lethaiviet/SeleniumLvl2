package pages;

import commons.enums.PageURL;
import controls.common.imp.Element;
import controls.common.imp.TextBox;
import data.UserInfo;
import utils.DriverUtils;
import utils.JsonLocatorUtils;

public class LoginPage extends BasePage {
    public static final PageURL page = PageURL.LOGIN_PAGE;
    private final Element hyperlink = new Element(JsonLocatorUtils.get("hyperlink"));
    private final TextBox txtBoxUserName = new TextBox(JsonLocatorUtils.get("txtBoxUserName"));

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
