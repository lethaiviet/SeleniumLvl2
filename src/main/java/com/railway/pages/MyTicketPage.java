package com.railway.pages;

import com.railway.commons.enums.PageURL;
import com.railway.controls.common.imp.Element;
import com.railway.utils.DriverUtils;
import com.railway.utils.StringHelper;
import com.railway.controls.common.imp.Button;
import com.railway.utils.JsonLocatorUtils;

import java.util.List;

public class MyTicketPage extends BasePage {
    public static final PageURL page = PageURL.MY_TICKET_PAGE;
    public final Element txtMessageNoData = new Element(JsonLocatorUtils.get("txtMessageNoData"));
    public final Element txtNote = new Element(JsonLocatorUtils.get("txtNote"));
    public final Button btnCancel = new Button(JsonLocatorUtils.get("btnCancel"));

    @Override
    public void load() {
        navigateTo(page);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL(page)) {
            throw new Error("MY_TICKET_PAGE was not successfully loaded");
        }
    }

    public void removeAllTickets() {
        while (!isDisplayMessageNoData()) {
            DriverUtils.waitForAjaxJQueryProcess();
            if (btnCancel.isDisplayed()) {
                btnCancel.click();
                DriverUtils.getWebDriver().switchTo().alert().accept();
            } else {
                break;
            }
        }
    }

    public boolean isMatchURL() {
        return isMatchURL(page);
    }

    public boolean isDisplayMessageNoData() {
        boolean result = false;
        if (txtNote.isDisplayed()) {
            result = getAmountOfTicketOnNote() == 0;
        } else {
            String txt = txtMessageNoData.getText();
            result = txt.contains("You haven't booked any tickets yet.");
        }
        return false;
    }

    public int getAmountOfTicketOnNote() {
        if (txtNote.isDisplayed()) {
            String txt = txtNote.getText();
            List<String> numList = StringHelper.extractStringAsList(txt, "\\d+");
            return Integer.parseInt(numList.get(0));
        }
        return 0;
    }
}
