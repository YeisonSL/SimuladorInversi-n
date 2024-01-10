package interactions;

import net.serenitybdd.screenplay.Interaction;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Set;

import static utilities.constants.Constants.ZERO;

@AllArgsConstructor
public class SwitchToNewWindow implements Interaction {

    private static final Logger log = LoggerFactory.getLogger(SwitchToNewWindow.class);

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        String currHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        String[] allHandlesArray = allHandles.toArray(new String[0]);

        log.debug("open windows: " + allHandles.size());
        log.debug("current window: " + currHandle);

        for (int position = ZERO; position <= allHandlesArray.length; position++){
            if (position == allHandlesArray.length-1 && !Objects.equals(allHandlesArray[position], currHandle)){
                driver.switchTo().window(allHandlesArray[position]);
                break;
            }
        }

        log.debug("new window: " + driver.getWindowHandle());
    }

    public static SwitchToNewWindow change() {
        return Tasks.instrumented(SwitchToNewWindow.class);
    }

}
