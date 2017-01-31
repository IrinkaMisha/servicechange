package by.nulay.changer.by.nulay.sightbot;

/**
 * Created by miha on 26.11.2016.
 */
public class SettingsBrowser {
    private String pathBrowser;
    private String profileName;

    public SettingsBrowser(String pathBrowser, String profileName) {
        this.pathBrowser = pathBrowser;
        this.profileName = profileName;
    }

    public String getPathBrowser() {
        return pathBrowser;
    }

    public void setPathBrowser(String pathBrowser) {
        this.pathBrowser = pathBrowser;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
