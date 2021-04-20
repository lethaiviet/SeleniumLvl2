package com.railway.controls.base;

public interface IEditable extends IClickable {
    void setValue(String var1);

    void enter(CharSequence... var1);

    void clear();
}
