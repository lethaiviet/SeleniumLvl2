package controls.base.imp;

import controls.base.IEditable;
import org.apache.log4j.Logger;

public class Editable extends Clickable implements IEditable {
    private Logger logger = Logger.getLogger(Editable.class);

    public Editable(String locator) {
        super(locator);
    }

    public void enter(CharSequence... value) {
        try {
            this.logger.debug(String.format("Enter '%s' for %s", value, this.getLocator().toString()));
            this.getElement().sendKeys(value);
        } catch (Exception var3) {
            this.logger.error(String.format("Has error with control '%s': %s", this.getLocator().toString(), var3.getMessage()));
            throw var3;
        }
    }

    public void setValue(String value) {
        try {
            String js = String.format("arguments[0].value='%s';", value);
            this.logger.debug(String.format("Set value '%s' for %s", value, this.getLocator().toString()));
            this.jsExecutor().executeScript(js, new Object[]{this.getElement()});
        } catch (Exception var3) {
            this.logger.error(String.format("Has error with control '%s': %s", this.getLocator().toString(), var3.getMessage()));
            throw var3;
        }
    }

    public void clear() {
        try {
            this.logger.debug(String.format("Clean text for %s", this.getLocator().toString()));
            this.getElement().clear();
        } catch (Exception var2) {
            this.logger.error(String.format("Has error with control '%s': %s", this.getLocator().toString(), var2.getMessage()));
            throw var2;
        }
    }
}
