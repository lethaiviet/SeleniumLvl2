package pages;

import commons.enums.PageURL;
import controls.common.imp.Element;
import controls.common.imp.Label;
import utils.DriverUtils;

public class LoginPage extends BasePage {
    public static final PageURL page = PageURL.LOGIN_PAGE;
    private static final Element hyperlink = new Element("//a[normalize-space()=\"%s\"]");

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

}
