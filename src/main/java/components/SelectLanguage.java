package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Component("id:::language_level")
public class SelectLanguage extends AbsComponent {
    private WebElement selectLanguage = null;
    private List<WebElement> options;


    public SelectLanguage(WebDriver driver) {
        super(driver);
    }

    public void initSelectLanguage(WebDriver driver) {
        selectLanguage = driver.findElement(getComponentBy());
        options = selectLanguage.findElements(By.cssSelector("option:not([disabled])"));
    }

    public void setRandomOption(){
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        selectLanguage.sendKeys(options.get(randomIndex).getText());
    }

    public WebElement getRandomOption(){
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        return options.get(randomIndex);
    }


}
