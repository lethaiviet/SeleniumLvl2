package com.railway.controls.base.imp;

import com.railway.controls.common.imp.Element;
import com.railway.utils.DriverUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseControl {
    private Logger logger = Logger.getLogger(Element.class);
    private String dynamicLocator;
    private By byLocator;
    private BaseControl parent;
    private String locator;

    public BaseControl(String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = this.getByLocator();
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

    public boolean isDisplayed() {
        try {
            this.logger.debug(String.format("is control displayed or not: %s", this.getLocator().toString()));
            return this.getElement().isDisplayed();
        } catch (Exception var2) {
            this.logger.error(String.format("IsDisplayed: Has error with control '%s': %s", this.getLocator().toString(), var2.getMessage()));
            return false;
        }
    }


    public void waitForVisibility() {
        this.waitForVisibility(DriverUtils.getTimeOut());
    }

    public void waitForVisibility(int timeOutInSeconds) {
        try {
            DriverUtils.waitForAjaxJQueryProcess();

            this.logger.info(String.format("Wait for control display %s", this.getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(this.getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()));
        } catch (Exception var3) {
            this.logger.error(String.format("WaitForDisplay: Has error with control '%s': %s", this.getLocator().toString(), var3.getMessage()));
        }

    }

    public void waitForDisplay(int timeOutInSeconds) {
        try {
            DriverUtils.waitForAjaxJQueryProcess();

            this.logger.info(String.format("Wait for control display %s", this.getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(this.getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(this.getLocator()));
        } catch (Exception var3) {
            this.logger.error(String.format("WaitForDisplay: Has error with control '%s': %s", this.getLocator().toString(), var3.getMessage()));
        }

    }

    public String getText() {
        try {
            this.logger.debug(String.format("Get text of element %s", this.getLocator().toString()));
            return this.getElement().getText();
        } catch (Exception var2) {
            this.logger.error(String.format("Has error with control '%s': %s", this.getLocator().toString(), var2.getMessage()));
            throw var2;
        }
    }

    public List<WebElement> getElements() {
        DriverUtils.waitForAjaxJQueryProcess();
        return this.parent != null ? this.parent.getElement().findElements(this.getLocator()) : this.getDriver().findElements(this.getLocator());
    }
}
