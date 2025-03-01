package pages;

import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage {
    protected WebDriver driver;
    private final String path;

    public AbsBasePage(WebDriver driver, String addPath) {
        this.driver = driver;
        this.path = System.getProperty("base.url") + addPath;
    }

    public void open() {
        driver.get(path);
    }
}
