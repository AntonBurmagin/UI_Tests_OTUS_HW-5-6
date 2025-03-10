package registrationpage.optionsfree;

import components.formgroups.SelectLanguageFormGroup;
import data.User;
import factory.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class OptionsFree_Test {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;
    private static SelectLanguageFormGroup selectLang;
    private static User user;
    private static WebDriver driverBeforeAll;


    @BeforeAll
    public static void beforeAllSettings(){
        webDriverFactory.webDriverManagerSetup();
    }

    @BeforeAll
    public static void initFeatures() {
        driverBeforeAll = webDriverFactory.create("--headless");
        RegistrationPage page = new RegistrationPage(driverBeforeAll);
        page.open();

        selectLang = new SelectLanguageFormGroup(driverBeforeAll);
        user = new User("Anton",
                "Antonio_is_SanAntonio@gmail.com",
                "1",
                "1",
                "09-02-1994",
                selectLang);
    }

    @BeforeEach
    public void createDriver(){
        driver = webDriverFactory.create();
    }

//    @Test
//    public void labelsTextTest(){
//        RegistrationPage page = new RegistrationPage(driver);
//        page.open();
//
//        page.formGroupLabelTextShouldBeEqual(page.getUsernameInputFormGroup(), "Имя пользователя:");
//        page.formGroupLabelTextShouldBeEqual(page.getEmailInputFormGroup(), "Электронная почта:");
//        page.formGroupLabelTextShouldBeEqual(page.getPasswordInputFormGroup(), "Пароль:");
//        page.formGroupLabelTextShouldBeEqual(page.getConfirmPasswordInputFormGroup(), "Подтвердите пароль:");
//        page.formGroupLabelTextShouldBeEqual(page.getBirthdateInput(), "Дата рождения:");
//        page.formGroupLabelTextShouldBeEqual(page.getSelectLanguage(), "Уровень знания языка:");
//    }

    //positive test
//    @Test
//    public void submitUserPositiveTest() {
//        RegistrationPage page = new RegistrationPage(driver);
//        page.open();
//
//        page.fillEveryInputForm(user);
//
//        page.getSubmitButton().click();
//        page.outputMessageShouldBeEqualToUser(user);
//    }

    //different passwords test
    @Test
    public void submitUserDifferentPassTest() {
        String expected = "Пароли не совпадают!";
        RegistrationPage page = new RegistrationPage(driver);
        page.open();
        User diffPassUser = new User("Anton",
                                    "Antonio_is_SanAntonio@gmail.com",
                                    "1",
                                    "2",
                                    "09-02-1994",
                                    selectLang);

        page.fillEveryInputForm(diffPassUser);

        page.alertShouldNotBePresent();
        page.getSubmitButton().click();
        page.alertShouldBePresent();

        page.alertTextShouldBeEqual(expected);
    }


    // testing all formGroups for required property
//    @Test
//    public void formGroupsAreRequired() {
//        RegistrationPage page = new RegistrationPage(driver);
//        page.open();
//
//        page.formGroupElementsShouldBeRequired();
//    }


    @AfterEach
    public void driverClose(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @AfterAll
    public static void driverBeforeAllClose(){
        if (driverBeforeAll != null) {
            driverBeforeAll.close();
            driverBeforeAll.quit();
        }
    }


}
