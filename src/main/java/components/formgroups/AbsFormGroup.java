package components.formgroups;

import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbsFormGroup extends AbsComponent {
    public WebElement formGroup;

    public AbsFormGroup(WebDriver driver, By by) {
        super(driver);
        formGroup = driver.findElement(by);
    }

    public String getLabelText() {
        return formGroup.findElement(By.cssSelector("label")).getText();
    }



}
