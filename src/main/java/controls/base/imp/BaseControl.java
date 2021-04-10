package controls.base.imp;

import controls.common.imp.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

public class BaseControl {
    private Logger logger = Logger.getLogger(Element.class);
    private String dynamicLocator;
    private By byLocator;
    private BaseControl parent;
    private String locator;

    public BaseControl(String locator) {
        this.locator = locator;
    }

    public void setDynamicValue(Object... args) {
        this.locator = String.format(this.dynamicLocator, args);
        this.byLocator = this.getByLocator();
    }

    protected WebDriver getDriver() {
        return DriverUtils.getWebDriver();
    }

    public By getLocator() {
        return this.byLocator;
    }

    private By getByLocator() {
        return By.xpath(this.locator);
    }

    public WebElement getElement() {
        WebElement element = null;
        DriverUtils.waitForAjaxJQueryProcess();

        try {
            if (this.parent != null) {
                WebElement eleParent = this.parent.getElement();
                element = eleParent.findElement(this.getLocator());
            } else {
                element = this.getDriver().findElement(this.getLocator());
            }

            return element;
        } catch (StaleElementReferenceException var3) {
            this.logger.error(String.format("StaleElementReferenceException '%s': %s", this.getLocator().toString(), var3.getMessage()));
            return this.getElement();
        }
    }

    public void waitForVisibility(int timeOutInSeconds) {
        try {
            DriverUtils.waitForAjaxJQueryProcess();

            this.logger.info(String.format("Wait for control display %s", this.getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(this.getDriver(), (long) timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()));
        } catch (Exception var3) {
            this.logger.error(String.format("WaitForDisplay: Has error with control '%s': %s", this.getLocator().toString(), var3.getMessage()));
        }

    }
}
