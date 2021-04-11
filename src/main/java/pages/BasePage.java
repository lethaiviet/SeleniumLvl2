package pages;

import commons.Constants;
import commons.enums.NavBar;
import commons.enums.PageURL;
import controls.common.imp.Element;
import io.cucumber.java8.El;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.DriverUtils;

public class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {
    private final static Element navBar = new Element("//*[@id='menu']");
    private Element navBarItem = new Element("//a[span='%s']");

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
}
