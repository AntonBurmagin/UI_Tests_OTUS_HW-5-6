package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbsCommon {
    protected WebDriver driver;
    protected WebDriverWait waiter;

    public AbsCommon(WebDriver driver){
        this.driver = driver;
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
//        PageFactory.initElements(driver, this);
    }

}
