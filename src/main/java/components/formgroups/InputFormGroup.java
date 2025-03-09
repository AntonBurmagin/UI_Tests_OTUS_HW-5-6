package components.formgroups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputFormGroup extends AbsFormGroup {

    public InputFormGroup(WebDriver driver, By by) {
        super(driver, by);
    }

    public String getInputText() {
        return formGroup.findElement(By.cssSelector("input")).getText();
    }

    public void setInputText(String text) {
        formGroup.findElement(By.cssSelector("input")).sendKeys(text);
    }

}
