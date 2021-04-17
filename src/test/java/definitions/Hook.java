package definitions;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import utils.DriverUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hook implements En {
    public Hook() {
        AfterStep((Scenario scenario) -> {
            if (scenario.isFailed()) {
                DriverUtils.scrollToBottom();
                String screenshotName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                scenario.attach(DriverUtils.getByteScreenshot(), "image/png", screenshotName);
            }
        });
    }
}
