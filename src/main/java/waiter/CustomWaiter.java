package waiter;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CustomWaiter {
    private final WebDriverWait waiter;
    private final Logger logger;


    public CustomWaiter(WebDriver driver, Logger logIn){
        waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        logger = logIn;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        try {
            waiter.until(condition);
        } catch (TimeoutException exception) {
            logger.error("Timeout exception in " + condition);
            return false;
        }
        return true;
    }

}
