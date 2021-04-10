package pages;

import controls.common.imp.Element;
import io.cucumber.java8.El;
import org.openqa.selenium.support.ui.LoadableComponent;

public class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {
    private final static Element menuTab = new Element("//*[@id='menu']");
    private Element menuItem = new Element("//a[span='%s']");

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
    }

    public void selectMenuTab(String tab) {
        menuTab.waitForVisibility(3);
        menuItem.setDynamicValue(tab);
        menuItem.click();
    }
}
