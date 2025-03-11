package pages;

import annotations.Path;
import components.formgroups.AbsFormGroup;
import components.formgroups.InputFormGroup;
import components.formgroups.SelectLanguageFormGroup;
import data.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import waiter.CustomWaiter;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Path("/form.html")
public class RegistrationPage extends AbsBasePage{
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);
    private final CustomWaiter waiter = new CustomWaiter(driver, logger);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    //Locators
//    @FindBy(id="email")
//    private WebElement email;

    private final By usernameFormGroupSelector = By.cssSelector(".form-group:has(#username)");
    private final By emailFormGroupSelector = By.cssSelector(".form-group:has(#email)");
    private final By passwordFormGroupSelector = By.cssSelector(".form-group:has(#password)");
    private final By confirmPasswordFormGroupSelector = By.cssSelector(".form-group:has(#confirm_password)");
    private final By birthdateFormGroupSelector = By.cssSelector(".form-group:has(#birthdate)");
    private final By formGroupSelector = By.cssSelector(".form-group input, select");
    private final By submitButtonSelector = By.cssSelector("input[type=\"submit\"]");
    private final By outputId = By.id("output");



    //methods
    public InputFormGroup getInputFormGroup(By by) {
        return new InputFormGroup(driver, by);
    }

    public InputFormGroup getUsernameInputFormGroup(){
        return getInputFormGroup(usernameFormGroupSelector);
    }


    public void outputMessageShouldBeEqualToUser(User user){
        String userDateBirthOutForm = String.join( "-", List.of(user.getBirthdate().split("-")).reversed());

        String expected = String.format("Имя пользователя: %s\n" +
                "Электронная почта: %s\n" +
                "Дата рождения: %s\n" +
                "Уровень языка: %s", user.getName(), user.getEmail(), userDateBirthOutForm, user.getLanguageLevelValue());

        assertThat(expected).isEqualTo(getOutputMessage());
    }


    public WebElement getSubmitButton(){
        return driver.findElement(submitButtonSelector);
    }

    public void fillTextInputElement(InputFormGroup inputForm, String value){
        inputForm.setInputText(value);
    }

    public InputFormGroup getEmailInputFormGroup(){
        return getInputFormGroup(emailFormGroupSelector);
    }

    public void fillEmailInputFormGroup(String emailIn){
        getEmailInputFormGroup().setInputText(emailIn);
    }

    public InputFormGroup getPasswordInputFormGroup(){
        return getInputFormGroup(passwordFormGroupSelector);
    }

    public void fillPasswordInput(String password){
        getPasswordInputFormGroup().setInputText(password);
    }

    public InputFormGroup getConfirmPasswordInputFormGroup(){
        return getInputFormGroup(confirmPasswordFormGroupSelector);
    }

    public void fillConfirmPasswordInput(String confirmPass){
        getConfirmPasswordInputFormGroup().setInputText(confirmPass);
    }

    public InputFormGroup getBirthdateInput(){
        return getInputFormGroup(birthdateFormGroupSelector);
    }

    public void fillBirthdateInput(String birthdate){
        getBirthdateInput().setInputText(birthdate);
    }


    public SelectLanguageFormGroup getSelectLanguageFormGroup() {
        return new SelectLanguageFormGroup(driver);
    }

    public void fillRandomSelectLanguage(){
        getSelectLanguageFormGroup().setRandomOption();
    }

    public List<WebElement> getFormGroupElements(){
        return driver.findElements(formGroupSelector);
    }

    public WebElement getOutput() {
        return driver.findElement(outputId);
    }

    public String getOutputMessage(){
        return getOutput().getText();
    }



    public void formGroupElementsShouldBeRequired(){
        List<WebElement> formGroupList = getFormGroupElements();
        assertThat(formGroupList.size()).isNotZero();
        for (WebElement el : formGroupList){
            assertThat(el.getDomProperty("required")).asBoolean().isTrue();
        }
    }


    public void fillEveryInputForm(User user) {
        fillTextInputElement(getUsernameInputFormGroup(), user.getName());
        fillTextInputElement(getEmailInputFormGroup(), user.getEmail());
        fillTextInputElement(getPasswordInputFormGroup(), user.getPass());
        fillTextInputElement(getConfirmPasswordInputFormGroup(), user.getConfirmPass());
        fillTextInputElement(getBirthdateInput(), user.getBirthdate());
        getSelectLanguageFormGroup().setOption(user.getLanguageLevel());
    }

    public void formGroupLabelTextShouldBeEqual(AbsFormGroup formGroup, String expected) {
        assertThat(formGroup.getLabelText()).isEqualTo(expected);
    }


    public void alertShouldNotBePresent() {
        assertTrue(waiter.waitForCondition(ExpectedConditions.not(ExpectedConditions.alertIsPresent())));
    }

    public void alertShouldBePresent() {
        assertTrue(waiter.waitForCondition(ExpectedConditions.alertIsPresent()));
    }

    public void alertTextShouldBeEqual(String expected) {
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText()).isEqualTo(expected);
        alert.dismiss();
    }

    public void validationMessageShouldBe(WebElement element, String expected) {
        assertTrue(waiter.waitForCondition(ExpectedConditions.domPropertyToBe(element, "validationMessage", expected)));
    }







}
