package controls.base.imp;

import utils.DriverUtils;

public class Action {
    BaseControl control;

    public Action(BaseControl control) {
        this.control = control;
    }

    public void click() {
        DriverUtils.actions().click(this.control.getElement()).build().perform();
    }

    public void clickAndHold() {
        DriverUtils.actions().clickAndHold(this.control.getElement()).build().perform();
    }

    public void moveTo() {
        DriverUtils.actions().moveToElement(this.control.getElement()).build().perform();
    }

    public void moveTo(int xOffset, int yOffset) {
        DriverUtils.actions().moveToElement(this.control.getElement(), xOffset, yOffset).build().perform();
    }
}
