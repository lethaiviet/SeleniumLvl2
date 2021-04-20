package com.railway.controls.base.imp;

import com.railway.controls.base.IClickable;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.railway.utils.DriverUtils;

public class Clickable extends BaseControl implements IClickable {
    private Logger logger = Logger.getLogger(Clickable.class);

    public Clickable(String locator) {
        super(locator);
    }

    protected JavascriptExecutor jsExecutor() {
        return (JavascriptExecutor) this.getDriver();
    }

    public void click() {
        this.click(3);
    }

    public void click(int times) {
        if (times > 0) {
            try {
                this.logger.debug(String.format("Click on %s", this.getLocator().toString()));
                this.getElement().click();
            } catch (Exception var3) {
                if (!var3.getMessage().contains("Other element would receive the click")) {
                    this.logger.error(String.format("Error occurred while clicking on control '%s': %s", this.getLocator().toString(), var3.getMessage()));
                    throw var3;
                }

                --times;
                DriverUtils.delay(1.0D);
                if (times == 1) {
                    this.clickByJs();
                } else {
                    this.click(times);
                }
            }
        }
    }

    public void clickByJs() {
        try {
            this.logger.debug(String.format("Click by js on %s", this.getLocator().toString()));
            this.jsExecutor().executeScript("arguments[0].click();", new Object[]{this.getElement()});
        } catch (Exception var2) {
            this.logger.error(String.format("Has error with control '%s': %s", this.getLocator().toString(), var2.getMessage()));
            throw var2;
        }
    }

    public void doubleClick() {
        try {
            this.logger.debug(String.format("Double click on %s", this.getLocator().toString()));
            (new Actions(this.getDriver())).doubleClick(this.getElement()).build().perform();
        } catch (Exception var2) {
            this.logger.error(String.format("Has error with control '%s': %s", this.getLocator().toString(), var2.getMessage()));
            throw var2;
        }
    }

    public void waitForElementClickable() {
        this.waitForElementClickable(DriverUtils.getTimeOut());
    }

    public void waitForElementClickable(int timeOutInSecond) {
        try {
            DriverUtils.waitForAjaxJQueryProcess();

            if (!this.isDisplayed()) {
                this.waitForDisplay(timeOutInSecond);
            }

            this.logger.info(String.format("Wait for element click able %s", this.getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(this.getDriver(), timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(this.getElement()));
        } catch (Exception var3) {
            this.logger.error(String.format("WaitForElementClickable: Has error with control '%s': %s", this.getLocator().toString(), var3.getMessage()));
        }

    }
}
