package by.nulay.taskexecutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.Article;
import test.VKActionFirefox;


/**
 * Created by miha on 14.05.2017.
 *
 * Class for create task add article and store data for it
 */
public class AddArticleTask extends TaskMain implements Task, TaskExecutor {

    private static Logger log = Logger.getLogger(VKActionFirefox.class);

    public Article article;
    public String url;

    public AddArticleTask(WebDriver driver) {
        super(driver);
    }

    /**
     * @OverrideDoc
     */
    @Override
    public void execute(Task task) {
        moveTo(url);
        addArticle(article);
    }

    public void addArticle(Article article) {
        log.debug("addArticle method start.");
        WebElement elementArt = null;
        int ind = 0;
        boolean d = false;
        while (!d) {
            elementArt = searchContainerForPastArticle();
            try {
                elementArt.click();
                d = true;
            } catch (Exception e) {
                if (ind > 9) {
                    log.debug("We could not add article");
                    return;
                }
                sleepOn(1000);
                ind++;
                log.debug("Attempt #" + ind);
            }
        }

        if (article.getImages() != null) {
            pastImagesToArticle(article.getImages(), elementArt);
        }

        sleepOn(500);
        elementArt.sendKeys(article.getArticle());
        sleepOn(2000);
        executeJavaScript(" wall.sendPost()");
        sleepOn(2000);
        log.debug("addArticle method end.");
    }

    private WebElement searchContainerForPastArticle() {
        WebElement element = driver.findElement(By.id("post_field"));
        return element;
    }

    private void pastImagesToArticle(String[] images, WebElement elementArt) {
        for (String image : images) {
            pastImageToArticle(image, elementArt);
        }
    }

    private void pastImageToArticle(String image, WebElement elementArt) {
        elementArt.sendKeys(image);
        sleepOn(1000);
        elementArt.sendKeys(" ");
        sleepOn(5000);
        elementArt.clear();
    }
}
