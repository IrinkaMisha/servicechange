package by.nulay.changer.taskexecutor.sightbot;

import java.util.ArrayList;
import java.util.List;

/**
 * Class contain some properties for understanding what action need to do by bot
 */
public class SettingsProperty {
    private List<String> property;

    public SettingsProperty() {
        this(new ArrayList<String>());
    }

    public SettingsProperty(List<String> property) {
        this.property = property;
    }

    public List<String> getProperty() {
        return property;
    }

    public void setProperty(List<String> property) {
        this.property = property;
    }
}
