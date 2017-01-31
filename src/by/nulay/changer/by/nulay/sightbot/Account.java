package by.nulay.changer.by.nulay.sightbot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.File;

/**
 * Created by miha on 26.11.2016.
 */
public class Account {
    private String name;
    private String login;
    private String password;

    private WebDriver driver;

    public Account(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void createDriver(SettingsBrowser settingsBrowser) {
        ProfilesIni profile = new ProfilesIni();
        File pathToBinary = new File(settingsBrowser.getPathBrowser());
        FirefoxBinary binary = new FirefoxBinary(pathToBinary);


        FirefoxProfile myprofile = profile.getProfile(settingsBrowser.getProfileName());
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new FirefoxDriver(binary, myprofile);
    }
}
