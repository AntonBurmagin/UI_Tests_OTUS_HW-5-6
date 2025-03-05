package registrationpage.optionsfree;

import components.SelectLanguage;
import data.User;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

import java.util.List;

public class OptionsFree_Test {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;


    @BeforeAll
    public static void beforeAllSettings(){
        webDriverFactory.webDriverManagerSetup();
    }

    @BeforeEach
    public void createDriver(){
        driver = webDriverFactory.create();
    }

    //positive test
    @Test
    public void registrationFormTest() throws InterruptedException {
        RegistrationPage page = new RegistrationPage(driver);
        page.open();

        SelectLanguage selectLang = new SelectLanguage(driver);
        selectLang.initSelectLanguage(driver);
        User user = new User("Anton", "Antonio_is_SanAntonio@gmail.com", "1", "1", "09-02-1994", selectLang);

        page.fillEveryInputForm(user);

        page.getSubmitButton().click();

        page.outputMessageIsEqualToUser(user);

        Thread.sleep(3000);

    }

//    @Test
//    public void registrationFormPositive() throws InterruptedException {
//        RegistrationPage page = new RegistrationPage(driver);
//        page.open();
//
//        User positiveUser = new User("Anton",
//                                    "Antonio_is_SanAntonio@gmail.com",
//                                    "1111",
//                                "1111",
//                                "09-02-1994",
//                                        selectLang);
//        page.fillEveryInputForm(positiveUser);
//        Thread.sleep(3000);
//
//    }

    // testing all formGroups for required property
//    @Test
//    public void formGroupsAreRequired() {
//        RegistrationPage page = new RegistrationPage(driver);
//        page.open();
//
//        page.formGroupShouldBeRequired();
//    }

    @AfterEach
    public void driverClose(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
