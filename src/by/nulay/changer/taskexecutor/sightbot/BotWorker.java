package by.nulay.changer.taskexecutor.sightbot;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.File;

/**
 * Class for full information what is needed for executing work of bot
 */
public class BotWorker {
    private Account account;
    private SettingsProperty settingsProperty;

    public BotWorker() {
        settingsProperty = new SettingsProperty();
    }

    public BotWorker(Account account) {
        this(account, new SettingsProperty());
    }

    public BotWorker(Account account, SettingsProperty settingsProperty) {
        this.account = account;
        this.settingsProperty = settingsProperty;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SettingsProperty getSettingsProperty() {
        return settingsProperty;
    }

    public void setSettingsProperty(SettingsProperty settingsProperty) {
        this.settingsProperty = settingsProperty;
    }

    public void createDriver(SettingsBrowser settingsBrowser) {
        ProfilesIni profile = new ProfilesIni();
        File pathToBinary = new File(settingsBrowser.getPathBrowser());
        FirefoxBinary binary = new FirefoxBinary(pathToBinary);


//        FirefoxProfile myprofile = profile.getProfile(settingsBrowser.getProfileName());
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
//        driver = new FirefoxDriver(binary, myprofile);
    }

}
