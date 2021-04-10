package controls.common.imp;

import controls.base.imp.Editable;
import controls.common.IElement;

public class Element extends Editable implements IElement {
    public Element(String locator) {
        super(locator);
    }
}