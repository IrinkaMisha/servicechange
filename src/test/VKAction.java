package test;

/**
 * Created by miha on 05.11.2016.
 */
public interface VKAction {
    /**
     * Say frands about random record
     * @param groupURL group URL
     */
    void sayFriendsRandomRecord(String groupURL);

    /**
     * Login sight
     * @param urlSight URL sight
     * @param login login
     * @param password password
     */
    void loginToSight(String urlSight, String login, String password);

    void addFrands();

    /**
     * Stop Browser
     */
    void stopBrowser();

    void addArticle(String groupURL, String article);

    void addArticle(String groupURL, String article, String[] images);
}
