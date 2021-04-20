package com.railway.controls.common.imp;

import com.railway.controls.base.imp.Clickable;
import com.railway.controls.common.IButton;

public class Button extends Clickable implements IButton {
    public Button(String locator) {
        super(locator);
    }
}
