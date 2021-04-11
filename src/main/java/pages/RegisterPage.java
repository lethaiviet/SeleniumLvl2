package pages;

import commons.enums.PageURL;
import utils.DriverUtils;

public class RegisterPage extends BasePage {
    public final static PageURL page = PageURL.REGISTER_PAGE;

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
}
