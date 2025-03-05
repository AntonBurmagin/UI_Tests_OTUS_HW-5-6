package pages;

import annotations.Path;
import components.SelectLanguage;
import data.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Path("")  ///  ИСПРАВИТЬ!!!!!!
public class RegistrationPage extends AbsBasePage{
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(id="email")
    private WebElement email;

    private final By usernameInputId = By.id("username");
    private final By emailInputId = By.id("email");
    private final By passwordInputId = By.id("password");
    private final By confirmPasswordInputId = By.id("confirm_password");
    private final By birthdateInputId = By.id("birthdate");
    private final By languageLevelSelector = By.cssSelector("select#language_level");
    private final By languageLevelOptionsSelector = By.cssSelector("#language_level option");
    private final By formGroupSelector = By.cssSelector(".form-group input, select");
    private final By submitButtonSelector = By.cssSelector("input[type=\"submit\"]");
    private final By outputId = By.id("output");

//    #language_level option[selected]
//    #language_level option:not([disabled])


    //methods
    public WebElement getUsernameInput(){
        return driver.findElement(usernameInputId);
    }

    public WebElement getOutput() {
        return driver.findElement(outputId);
    }

//    public List<String> getOutputMessage(){
//        return List.of(getOutput().getText().split("\n"));
//    }

    public String getOutputMessage(){
        return getOutput().getText();
    }

    public void outputMessageIsEqualToUser(User user){
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

    public void fillTextInputElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public WebElement getEmailInput(){
        return driver.findElement(emailInputId);
    }

    public void fillEmailInput(String emailIn){
        email.sendKeys(emailIn);
    }

    public WebElement getPasswordInput(){
        return driver.findElement(passwordInputId);
    }

    public void fillPasswordInput(String password){
        getPasswordInput().sendKeys(password);
    }

    public WebElement getConfirmPasswordInput(){
        return driver.findElement(confirmPasswordInputId);
    }

    public void fillConfirmPasswordInput(String confirmPass){
        getConfirmPasswordInput().sendKeys(confirmPass);
    }

    public WebElement getBirthdateInput(){
        return driver.findElement(birthdateInputId);
    }

    public void fillBirthdateInput(String birthdate){
        getBirthdateInput().sendKeys(birthdate);
    }

    public WebElement getLanguageLevelSelect(){
        return driver.findElement(languageLevelSelector);
    }

    public List<WebElement> getLanguageLevelSelectOptions(){
        return driver.findElements(languageLevelOptionsSelector);
    }

    public SelectLanguage getSelectLanguage() {
        return new SelectLanguage(driver);
    }

    public void fillRandomSelectLanguage(){
        getSelectLanguage().setRandomOption();
    }

    public List<WebElement> getFormGroupElements(){
        return driver.findElements(formGroupSelector);
    }

    public void formGroupShouldBeRequired(){
        List<WebElement> formGroupList = getFormGroupElements();
        assertThat(formGroupList.size()).isNotZero();
        for (WebElement el : formGroupList){
            assertThat(el.getDomProperty("required")).asBoolean().isTrue();
        }
    }


    public void fillEveryInputForm(User user) {
        fillTextInputElement(getUsernameInput(), user.getName());
        fillTextInputElement(getEmailInput(), user.getEmail());
        fillTextInputElement(getPasswordInput(), user.getPass());
        fillTextInputElement(getConfirmPasswordInput(), user.getConfirmPass());
        fillTextInputElement(getBirthdateInput(), user.getBirthdate());
        fillTextInputElement(getLanguageLevelSelect(), user.getLanguageLevelText());
    }







}
