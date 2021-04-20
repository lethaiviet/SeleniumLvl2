package com.railway.pages;

import com.railway.commons.Constants;
import com.railway.commons.enums.PageURL;
import com.railway.controls.common.imp.Label;
import com.railway.utils.DriverUtils;
import com.railway.commons.enums.Dropdown;
import com.railway.controls.common.imp.ComboBox;
import com.railway.utils.JsonLocatorUtils;

import java.util.*;

public class BookTicketPage extends BasePage {
    public static final PageURL PAGE = PageURL.BOOK_TICKET_PAGE;
    private final ComboBox dropdownBookTicket = new ComboBox(JsonLocatorUtils.get("dropdownBookTicket"));
    private final Label lblPid = new Label(JsonLocatorUtils.get("lblPid"));

    @Override
    public void load() {
        navigateTo(PAGE);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL()) {
            throw new Error("BOOK_TICKET_PAGE was not successfully loaded");
        }
    }

    public void selectOptionFromDropdown(String dropdownKey, String option) {
        if (option.equals("default")) return;

        String name = Dropdown.valueOf(dropdownKey).getName();
        dropdownBookTicket.setDynamicValue(name);
        if (option.equals("random")) option = dropdownBookTicket.getRandomOption();

        if (!option.equals(dropdownBookTicket.getSelected())) {
            dropdownBookTicket.select(option);
            dropdownBookTicket.waitForSelectedOptionToBePresent(option, Constants.TIME_OUT_IN_SECONDS);
        }
    }

    public boolean isMatchURL() {
        return isMatchURL(PAGE);
    }

    public String getOptionOfSelectedDropdown(Dropdown dropdown) {
        dropdownBookTicket.setDynamicValue(dropdown.getName());
        return dropdownBookTicket.getSelected();
    }

    public String getTextPid() {
        return lblPid.getText();
    }

    public Map<String, String> getAllOptionsOfSelectedDropdown() {
        Map<String, String> result = new HashMap<>();
        Arrays.stream(Dropdown.values())
                .forEach(x -> result.put(x.name(), getOptionOfSelectedDropdown(x)));
        return result;
    }
}
