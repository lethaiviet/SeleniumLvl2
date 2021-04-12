package pages;

import commons.Constants;
import commons.enums.Dropdown;
import commons.enums.PageURL;
import controls.common.imp.ComboBox;
import controls.common.imp.Label;
import utils.DriverUtils;

import java.util.*;

public class BookTicketPage extends BasePage {
    public static final PageURL page = PageURL.BOOK_TICKET_PAGE;
    private static final ComboBox dropdownBookTicket = new ComboBox("//select[@name='%s']");
    private static final Label lblPid = new Label("//li[2]/strong[2]");

    @Override
    public void load() {
        navigateTo(page);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL(page)) {
            throw new Error("BOOK_TICKET_PAGE was not successfully loaded");
        }
    }

    public void selectOptionFromDropdown(String dropdownKey, String option) {
        if (option.equals("default")) return;

        String name = Dropdown.valueOf(dropdownKey).getName();
        dropdownBookTicket.setDynamicValue(name);
        if (option.equals("random")) {
            option = dropdownBookTicket.getRandomOption();
        }

        if (!option.equals(dropdownBookTicket.getSelected())) {
            dropdownBookTicket.select(option);
            dropdownBookTicket.waitForSelectedOptionToBePresent(option, Constants.TIME_OUT_IN_SECONDS);
        }
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
        Arrays.stream(Dropdown.values()).forEach(x ->
                result.put(x.name(), getOptionOfSelectedDropdown(x)));
        return result;
    }
}
