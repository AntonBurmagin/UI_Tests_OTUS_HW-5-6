package components.formgroups;

import annotations.Component;
import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

@Component("id:::language_level")
public class SelectLanguageFormGroup extends FormGroup {
    private WebElement selectLanguage = null;
    private List<WebElement> options;


    public SelectLanguageFormGroup(WebDriver driver) {
        super(driver, By.cssSelector(".form-group:has(#language_level)"));
        selectLanguage = driver.findElement(getComponentBy());
        options = selectLanguage.findElements(By.cssSelector("option:not([disabled])"));
    }
    

    public void setOption(WebElement option){
        selectLanguage.sendKeys(option.getText());
    }

    public void setRandomOption(){
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        setOption(options.get(randomIndex));
    }

    public WebElement getRandomOption(){
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        return options.get(randomIndex);
    }




}
