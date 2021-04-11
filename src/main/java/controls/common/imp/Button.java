package controls.common.imp;

import controls.base.imp.Clickable;
import controls.common.IButton;

public class Button extends Clickable implements IButton {
    public Button(String locator) {
        super(locator);
    }
}
