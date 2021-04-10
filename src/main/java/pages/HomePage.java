package pages;

import commons.enums.PageURL;
import utils.DriverUtils;

public class HomePage extends BasePage {

    @Override
    public void load() {
        DriverUtils.navigate(PageURL.HOME_PAGE.getURL());
        DriverUtils.navigate(PageURL.HOME_PAGE.getURL());
    }

    @Override
    public void isLoaded() throws Error {
        if (!DriverUtils.getCurrentURL().contains(PageURL.HOME_PAGE.getURL())) {
            throw new Error("HOME_PAGE was not successfully loaded");
        }
    }
}
