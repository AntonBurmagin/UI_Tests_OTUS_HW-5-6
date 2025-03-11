package components.formgroups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputFormGroup extends AbsFormGroup {

    public InputFormGroup(WebDriver driver, By by) {
        super(driver, by);
    }

    public String getInputText() {
        return formGroup.findElement(By.cssSelector("input")).getText();
    }

    public WebElement getInputField() {
        return formGroup.findElement(By.cssSelector("input"));
    }

    public void setInputText(String text) {
        formGroup.findElement(By.cssSelector("input")).sendKeys(text);
    }

}
