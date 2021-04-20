package com.railway.controls.common;

import com.railway.controls.base.IClickable;

import java.util.List;

public interface IComboBox extends IClickable {
    void select(String var1);

    void select(int var1);

    String getSelected();

    List<String> getOptions();

    void waitForSelectedOptionToBePresent(String var1, int var2);
}
