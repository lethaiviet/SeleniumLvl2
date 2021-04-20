package com.railway.controls.common.imp;

import com.railway.controls.base.imp.Editable;
import com.railway.controls.common.IElement;

public class Element extends Editable implements IElement {
    public Element(String locator) {
        super(locator);
    }
}