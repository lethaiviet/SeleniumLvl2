package pages;

import commons.enums.PageURL;
import controls.common.imp.Button;
import controls.common.imp.Element;
import utils.DriverUtils;
import utils.StringHelper;

import java.util.List;

public class MyTicketPage extends BasePage {
    public static final PageURL page = PageURL.MY_TICKET_PAGE;
    public static final Element txtMessageNoData = new Element("//*[@id='content']");
    public static final Element txtNote = new Element("//*[@id='content']/div/li[1]");
    public static final Button btnCancel = new Button("//td/input[@value='Cancel']");

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

    public boolean isMatchURL() {
        return isMatchURL(page);
    }

    public int getAmountOfTicketOnNote() {
        if (txtNote.isDisplayed()) {
            String txt = txtNote.getText();
            List<String> numList = StringHelper.extractStringAsList(txt, "\\d+");
            return Integer.parseInt(numList.get(0));
        }
        return 0;
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

    public void removeAllTickets() {
        while (!isDisplayMessageNoData()) {
            if (btnCancel.isDisplayed()) {
                btnCancel.click();
                DriverUtils.getWebDriver().switchTo().alert().accept();
                DriverUtils.waitForAjaxJQueryProcess();
            }
        }
    }
}
