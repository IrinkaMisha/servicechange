package by.nulay.taskexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import test.VKActionFirefox;

/**
 * Created by miha on 24.05.2017.
 */
public class TaskMain {
    public WebDriver driver;

    public TaskMain(WebDriver driver) {
        this.driver = driver;
    }

    public void moveTo(String groupURL) {
        driver.navigate().to(groupURL);
        VKActionFirefox.waitLoadSelector(By.id("post_field"), 2, driver);
    }

    public static void sleepOn(int millisecSleep) {
        try {
            Thread.sleep(millisecSleep);
        } catch (InterruptedException e1) {
        }
    }

    public void executeJavaScript(String script) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(script, "");
    }
}
