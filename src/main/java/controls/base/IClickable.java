package controls.base;

import controls.base.imp.IBaseControl;

public interface IClickable extends IBaseControl {
    void click();

    void clickByJs();

    void doubleClick();

    void waitForElementClickable();

    void waitForElementClickable(int timeOutInSecond);
}
