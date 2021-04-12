package controls.common.imp;

import controls.base.imp.Clickable;
import controls.common.IComboBox;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ComboBox extends Clickable implements IComboBox {
    private Logger logger = Logger.getLogger(Element.class);

    public ComboBox(String locator) {
        super(locator);
    }

    public void select(String text) {
        Select select = new Select(this.getElement());
        select.selectByVisibleText(text);
    }

    public void select(int index) {
        Select select = new Select(this.getElement());
        select.selectByIndex(index);
    }

    public String getSelected() {
        Select select = new Select(this.getElement());
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getOptions() {
        List<String> ops = new ArrayList();
        Select select = new Select(this.getElement());
        List<WebElement> options = select.getOptions();
        Iterator var4 = options.iterator();

        while (var4.hasNext()) {
            WebElement option = (WebElement) var4.next();
            ops.add(option.getText());
        }

        return ops;
    }

    public String getRandomOption() {
        List<String> options = getOptions();
        return options.get(new Random().nextInt(options.size()));
    }

    private boolean isSelectedOption(String option) {
        return option.equals(getSelected());
    }

    public void waitForSelectedOptionToBePresent(final String option, int timeOutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(this.getDriver(), timeOutInSecond);
            wait.until(driver -> {
                Boolean isSelected = (Boolean) ComboBox.this.jsExecutor().executeScript(String.format("var ele = arguments[0];return ele.options[ele.selectedIndex].text=='%s';", option), new Object[]{ComboBox.this.getElement()});
                return isSelected;
            });
        } catch (Exception var4) {
            this.logger.error(String.format("waitForSelectedOptionToBePresent: Has error with control '%s': %s", this.getLocator().toString(), var4.getMessage()));
        }
    }
}
