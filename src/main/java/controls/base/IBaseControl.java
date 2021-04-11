package controls.base.imp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IBaseControl {
    void setDynamicValue(Object... var1);

    By getLocator();

    WebElement getElement();

    boolean isDisplayed();

    void waitForVisibility(int timeOutInSeconds);

    void waitForDisplay(int timeOutInSeconds);

    String getText();
}
