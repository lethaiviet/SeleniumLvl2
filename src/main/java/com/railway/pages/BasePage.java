package com.railway.pages;

import com.railway.commons.Constants;
import com.railway.commons.enums.NavBar;
import com.railway.commons.enums.PageURL;
import com.railway.controls.common.imp.Element;
import com.railway.controls.common.imp.TextBox;
import com.railway.utils.DriverUtils;
import com.railway.utils.JsonLocatorUtils;
import com.railway.utils.ScraperHelper;
import com.railway.controls.common.imp.Button;
import com.railway.data.TicketInfo;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {
    private final Element navBar = new Element(JsonLocatorUtils.get("navBar"));
    private final Element navBarItem = new Element(JsonLocatorUtils.get("navBarItem"));
    protected final Button btnSubmit = new Button(JsonLocatorUtils.get("btnSubmit"));
    protected final TextBox txtBoxPassword = new TextBox(JsonLocatorUtils.get("txtBoxPassword"));

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
    }

    public void selectNavBarItem(String name) {
        String navBarName = NavBar.valueOf(name).getName();
        navBar.waitForVisibility(Constants.TIME_OUT_IN_SECONDS);
        navBarItem.setDynamicValue(navBarName);
        navBarItem.click();
    }

    public void clickSubmitButton() {
        btnSubmit.waitForElementClickable();
        btnSubmit.click();
        waitForCompletedSubmitting();
    }

    public void waitForCompletedSubmitting() {
        DriverUtils.waitForAjaxJQueryProcess();
    }

    public void navigateTo(PageURL page) {
        DriverUtils.navigate(page.getURL());
    }

    public void navigateTo(String pageName) {
        navigateTo(PageURL.valueOf(pageName));
    }

    public boolean isMatchURL(PageURL page) {
        return DriverUtils.getCurrentURL().equals(page.getURL());
    }

    public boolean isMatchURL(String pageName) {
        return isMatchURL(PageURL.valueOf(pageName));
    }

    public List<TicketInfo> getTicketInfoInTableOnCurrentPage() {
        List<List<String>> data = ScraperHelper.scrapeLastTableInPage();
        return data.stream()
                .map(TicketInfo::new)
                .collect(Collectors.toList());
    }
}
