package com.railway.pages;

import com.railway.commons.enums.PageURL;
import com.railway.utils.DriverUtils;

public class HomePage extends BasePage {
    public static final PageURL PAGE = PageURL.HOME_PAGE;

    @Override
    public void load() {
        navigateTo(PAGE);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL()) {
            throw new Error("HOME_PAGE was not successfully loaded");
        }
    }

    public boolean isMatchURL() {
        return isMatchURL(PAGE);
    }
}
