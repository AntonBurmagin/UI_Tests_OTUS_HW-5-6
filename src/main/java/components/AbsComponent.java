package components;

import annotations.Component;
import common.AbsCommon;
import exceptions.ComponentByTypeNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbsComponent extends AbsCommon {

    public AbsComponent(WebDriver driver) {
        super(driver);
    }

    protected By getComponentBy() {
        Class clazz = getClass();
        if (clazz.isAnnotationPresent(Component.class)) {
            Component component = (Component) clazz.getDeclaredAnnotation(Component.class);
            String[] value = component.value().split(":::");
            switch (value[0]) {
                case "css": {
                    return By.cssSelector(value[1]);
                }
                case "xpath": {
                    return By.xpath(value[1]);
                }
                case "id": {
                    return By.id(value[1]);
                }
            }
        }
        throw new ComponentByTypeNotFoundException();
    }


}
