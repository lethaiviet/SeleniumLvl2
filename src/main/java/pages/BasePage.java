package pages;

import commons.Constants;
import commons.enums.NavBar;
import commons.enums.PageURL;
import controls.common.imp.Button;
import controls.common.imp.Element;
import data.TicketInfo;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.DriverUtils;
import utils.ScraperHelper;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {
    private static final Element navBar = new Element("//*[@id='menu']");
    private Element navBarItem = new Element("//a[span='%s']");
    protected static final Button btnSubmit = new Button("//input[@type='submit']");

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

    public boolean isMatchURL(PageURL page) {
        return DriverUtils.getCurrentURL().equals(page.getURL());
    }

    public boolean isMatchURL(String pageName) {
        return isMatchURL(PageURL.valueOf(pageName));
    }

    public void navigateTo(PageURL page) {
        DriverUtils.navigate(page.getURL());
    }

    public void navigateTo(String pageName) {
        navigateTo(PageURL.valueOf(pageName));
    }

    public List<TicketInfo> getTicketInfoInTableOnCurrentPage() {
        List<List<String>> data = ScraperHelper.scrapeFirstTableInPage();
        List<TicketInfo> result = data.stream()
                .map(TicketInfo::new)
                .collect(Collectors.toList());
        return result;
    }
}
