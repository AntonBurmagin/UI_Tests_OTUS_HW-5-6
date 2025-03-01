package mainpage.optionsfree;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.util.Scanner;

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

    @Test
    public void registrationFormTest() throws InterruptedException {
        String user = "Anton", email = "Antonio_is_SanAntonio@gmail.com", pass, confirmPass;

        Scanner input = new Scanner(System.in);
        System.out.println("Input password:");
        pass = input.nextLine();
        System.out.println("Input confirm password:");
        confirmPass = input.nextLine();

        MainPage page = new MainPage(driver);
        page.open();



        page.fillUsernameInput(user);
        page.fillEmailInput(email);
        page.fillPasswordInput(pass);
        page.fillConfirmPasswordInput(confirmPass);

        Thread.sleep(3000);
//        page.fillBirthdateInput();




    }


    @AfterEach
    public void driverClose(){
        if (driver != null)
            driver.close();
    }

}
