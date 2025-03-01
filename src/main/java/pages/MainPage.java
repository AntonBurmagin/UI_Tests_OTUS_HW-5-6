package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbsBasePage{
    private final WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(3));
    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver, "");
    }

    //Locators
    private final By usernameInputId = By.id("username");
    private final By emailInputId = By.id("email");
    private final By passwordInputId = By.id("password");
    private final By confirmPasswordInputId = By.id("confirm_password");
    private final By birthdateInputId = By.id("birthdate");
    private final By languageLevelSelector = By.cssSelector("select#language_level");


    //methods
    public WebElement getUsernameInput(){
        return driver.findElement(usernameInputId);
    }

    public void fillUsernameInput(String username){
        getUsernameInput().sendKeys(username);
    }

    public WebElement getEmailInput(){
        return driver.findElement(emailInputId);
    }

    public void fillEmailInput(String email){
        getEmailInput().sendKeys(email);
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





}
