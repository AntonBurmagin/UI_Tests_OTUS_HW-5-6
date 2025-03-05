package data;

import components.SelectLanguage;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.Scanner;

public class User {
    private String name;
    private String email;
    private String pass;
    private String confirmPass;
    private String birthdate;
    private WebElement languageLevel;

    public User(String name, String email, String birthdate, SelectLanguage selLang) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.languageLevel = selLang.getRandomOption();

        Scanner input = new Scanner(System.in);
        System.out.println("Input password:");
        pass = input.nextLine();
        System.out.println("Input confirm password:");
        confirmPass = input.nextLine();
    }

    public User(String name, String email, String pass, String confPass, String birthdate, SelectLanguage selLang) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.pass = pass;
        this.confirmPass = confPass;
        this.languageLevel = selLang.getRandomOption();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getLanguageLevelText() {
        return languageLevel.getText();
    }

    public String getLanguageLevelValue() {
        return languageLevel.getDomProperty("value");
    }

}
