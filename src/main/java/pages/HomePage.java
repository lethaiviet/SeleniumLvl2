package pages;

import commons.enums.PageURL;
import utils.DriverUtils;

public class HomePage extends BasePage {
    public final static PageURL page = PageURL.HOME_PAGE;

    @Override
    public void load() {
        navigateTo(page);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL(page)) {
            throw new Error("HOME_PAGE was not successfully loaded");
        }
    }

    public boolean isMatchURL() {
        return isMatchURL(page);
    }
}
