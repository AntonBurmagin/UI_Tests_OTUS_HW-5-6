package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiter.CustomWaiter;


public abstract class AbsCommon {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(AbsCommon.class);
    protected final CustomWaiter waiter;

    public AbsCommon(WebDriver driver){
        this.driver = driver;
        this.waiter = new CustomWaiter(driver, logger);
//        PageFactory.initElements(driver, this);
    }

}
