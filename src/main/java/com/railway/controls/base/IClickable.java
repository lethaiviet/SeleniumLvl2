package com.railway.controls.base;

public interface IClickable extends IBaseControl {
    void click();

    void clickByJs();

    void doubleClick();

    void waitForElementClickable();

    void waitForElementClickable(int timeOutInSecond);
}
