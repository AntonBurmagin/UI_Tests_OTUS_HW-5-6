package factory.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings{

    public AbstractDriverOptions settings(String ... optionsArgs) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(optionsArgs);
        return options;
    }

}