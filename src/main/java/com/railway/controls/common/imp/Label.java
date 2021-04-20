package com.railway.controls.common.imp;

import com.railway.controls.base.imp.Clickable;
import com.railway.controls.common.ILabel;

public class Label extends Clickable implements ILabel {
    public Label(String locator) {
        super(locator);
    }
}
