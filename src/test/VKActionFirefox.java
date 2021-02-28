package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by miha on 16.10.2016.
 */
public class VKActionFirefox implements VKAction {

    private static Logger log = Logger.getLogger(VKActionFirefox.class);
    public static Map<String, String> strCh = new HashMap<>();
    private static Map<String, FilterArticle> filterMap = new HashMap<>();
    public static VKAction VKACTIONFIREFOX = new VKActionFirefox();

    {
        strCh.put("пизд", "п&зд");
        strCh.put("Пизд", "П&зд");
        strCh.put("хуй", "х4й");
        strCh.put("Хуй", "Х4й");
        strCh.put("ебат", "@бат");
        strCh.put("Ебат", "@бат");
        strCh.put("ебан", "@бан");
        strCh.put("Ебан", "@бан");
        strCh.put("&nbsp;", "");

        strCh.put("anekdotov.net", "");
        strCh.put("анeкдотoв.net", "");
        strCh.put("анекдотов.nеt", "");
        strCh.put("aнекдотов.nеt", "");
        strCh.put("aнекдoтов.net", "");
        strCh.put("aнекдотoв.net", "");
        strCh.put("aнекдoтов.nеt", "");
        strCh.put("aнeкдoтов.nеt", "");
        strCh.put("анeкдoтов.net", "");
        strCh.put("aнeкдoтoв.nеt", "");
        strCh.put("анeкдотов.nеt", "");
        strCh.put("анeкдoтoв.net", "");
        strCh.put("анeкдoтoв.nеt", "");
        strCh.put("анeкдoтов.nеt", "");
        strCh.put("aнeкдoтoв.net", "");
        strCh.put("aнекдотoв.nеt", "");
        strCh.put("анекдoтов.nеt", "");
        strCh.put("анекдoтов.net", "");
        strCh.put("анeкдотов.nеt", "");
        strCh.put("анекдотoв.nеt", "");
        strCh.put("анекдотoв.net", "");
        strCh.put("aнeкдoтов.net", "");
        strCh.put("aнекдoтoв.net", "");
        strCh.put("aнeкдотoв.net", "");


        strCh.put("ебу", "@бу");
        strCh.put("Ебу", "@бу");
        strCh.put("еби", "@би");
        strCh.put("Eби", "@би");
        strCh.put("бля", "бл9");
        strCh.put("Бля", "Бл9");

        filterMap.put("https://vk.com/i.love.smile", new FilterArticle(2, 0));

    }

    public static SynchronousQueue<Article> queueForFilm = new SynchronousQueue();


    public static void main(String[] args) {

        List<String> user1 = new ArrayList<>();
//        Account irNaid = new Account("irNaid", "+375299780180", "vkurody3");
        user1.add("irNaid");
        user1.add("+375299780180");
        user1.add("vkurody3");

//        Account irNaid2 = new Account("irNaid2", "neznashk@mail.ru", "vkurody3");
        List<String> user2 = new ArrayList<>();
        user2.add("irNaid2");
        user2.add("neznashk@mail.ru");
        user2.add("vkurody3");

//        Account miha = new Account("Miha", "+375297350741", "vkurody3");
        List<String> user3 = new ArrayList<>();
        user3.add("Miha");
        user3.add("+375297350741");
        user3.add("vkurody3");

//        startCatcherFilms();

        final List<List> listUser = new ArrayList<>();
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);

        for (List<String> user : listUser) {
            VKActionFirefox.startLiker(user);
        }
        VKActionFirefox.startPostFilm(user1);

        VKActionFirefox.startPostAnekdot(user1);

        while (true) {
            Scanner in = new Scanner(System.in);
            String a = in.next();//считываем ввод
            System.out.print(a);//выводим сумму a+b

            if (a.equals("start write anekdot")) {
                System.out.print("start write anekdot");
            }
            if (a.equals("start write film")) {
                System.out.print("start write film");
            }
        }
    }

    private static void startCatcherFilms() {
//        String configFiles = "modules" + File.separator + "startservicechange" + File.separator + "src" + File.separator + "spring-app-modules.xml";
//
//        Thread CatcherFilms = new Thread(new Runnable() {
//            FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext(configFiles);
//            ParserImpl b1 = (MegacriticParser) factory.getBean("MegacriticParser");
//            ParserImpl b2 = (SerialochkaParser) factory.getBean("SerialochkaParser");
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        b1.startParseAndSave();
//                        b2.startParseAndSave();
//                    } catch (ChangerException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        Thread.sleep(1000 * 60 * 60 * 4);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        CatcherFilms.start();
    }


    private static void startPostAnekdot(final List<String> user) {
        Thread thAnek = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thAnek:start execution");

                    Date d1 = new Date();
                    if (d1.getHours() + 1 > 23 || d1.getHours() < 5) {
                        System.out.println("thAnek:sleep 6 hours");
                        sleepOn(1000 * 60 * 60 * 6);
                    }
                    String anek = getAnekdotString();
                    if (anek != null) {
                        VKAction vkActionST = null;
                        try {
                            vkActionST = new VKActionFirefox(user.get(0));
                        } catch (Exception e) {
                        }
                        if (vkActionST != null) {
                            try {
                                vkActionST.loginToSight("https://vk.com", user.get(1), user.get(2));
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                vkActionST.addArticle("https://vk.com/notgravity", changeV(anek.replaceAll("[aа].{8}\\..{2}t", ""), strCh));
                            } catch (Exception e) {
                                System.out.println("thAnek:didn`t find anekdot");
                            } finally {
                                vkActionST.stopBrowser();
                            }
                        }
                    }
                    System.out.println("thAnek:sleep 30 min");
                    sleepOn(1000 * 60 * 30);
                }
            }
        });

        thAnek.start();
    }

    /**
     * Method return anekdot
     * @return
     */
    private static String getAnekdotString() {
        String anek="";
        try {
            anek = new LoaderArticle().getAnekdot().getArticle();
            if (anek.split(" ").length<4){
                return getAnekdotString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return anek;
    }

    private static void startPostFilm(final List<String> user) {
        Thread thFilm = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thFilm:start execution");

                    Date d1 = new Date();
                    if (d1.getHours() + 1 > 23 || d1.getHours() < 5) {
                        System.out.println("thFilm:sleep 6 hours");
                        sleepOn(1000 * 60 * 60 * 6);
                    }
                    Article article = getArticle();
                    if (article != null) {
                        VKAction vkActionST = null;
                        try {
                            vkActionST = new VKActionFirefox(user.get(0));
                        } catch (Exception e) {
                        }
                        if (vkActionST != null) {
                            try {
                                vkActionST.loginToSight("https://vk.com", user.get(1), user.get(2));
                                sleepOn(2000);
                                boolean chP = true;
                                int repeat = 0;
                                while (chP & repeat < 18) {
                                    repeat++;
                                    if (article != null && article.getArticle() != null) {
                                        vkActionST.addArticle("https://vk.com/smedia_club", article.getArticle(), article.getImages());
                                        int t = new Random().nextInt(10);
                                        System.out.println("thFilm:sleep " + t + " мин.");
                                        sleepOn(1000 * 60 * t);
                                    } else {
                                        chP = false;
                                    }
                                    article = getArticle();
                                }
                            } catch (Exception e) {
                                // e.printStackTrace();
                                try {
                                    queueForFilm.put(article);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            } finally {
                                vkActionST.stopBrowser();
                            }
                        }
                    }
                    System.out.println("thFilm:sleep 2 hours");
                    sleepOn(1000 * 60 * 60 * 2);

                }
            }
        });

        thFilm.start();
    }

    private static Article getArticle() {
        Article article = null;
        if (queueForFilm.size() > 0) {
            try {
                article = queueForFilm.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // for(int i=0;i<1000;i++) {
            try {
                article = new LoaderArticle().getFilm();
            } catch (IOException e) {
            }
            // }
        }
        return article;
    }

    private static void startLiker(final List<String> user) {
        Thread thLike = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thLike:start execution");
                    sleepOn(1000 * 60 * new Random().nextInt(60));
                    VKAction vkActionST = null;
                    try {
                        vkActionST = new VKActionFirefox(user.get(0));
                    } catch (Exception e) {
                    }
                    if (vkActionST != null) {
                        try {
                            vkActionST.loginToSight("https://vk.com", user.get(1), user.get(2));
                            sleepOn(2000);
                            vkActionST.addFrands();
                            sleepOn(2000);
                            vkActionST.sayFriendsRandomRecord("https://vk.com/notgravity");
                            sleepOn(2000);
                            if (new Random().nextInt(3) == 2) {
                                vkActionST.sayFriendsRandomRecord("https://vk.com/smedia_club");
                            }
                            sleepOn(2000);

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            vkActionST.stopBrowser();
                        }
                    }
                }
            }
        });
        thLike.start();
    }

    private WebDriver driver;

    public VKActionFirefox() {
    }

    public VKActionFirefox(String profileName) {
        ProfilesIni profile = new ProfilesIni();
        File pathToBinary = new File("C:\\files\\work\\Firefox32\\firefox.exe");
        FirefoxBinary binary = new FirefoxBinary(pathToBinary);


        FirefoxProfile myprofile = profile.getProfile(profileName);
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new FirefoxDriver(binary, myprofile);
    }


    public List<Article> findRecords(String url) {
        driver.navigate().to(url);
        waitLoadSelector(By.cssSelector("#global_prg"), 1,driver);
        List<WebElement> wel = null;
        List<Article> artticles = new ArrayList<>();
        try {
            wel = driver.findElements(By.cssSelector("._post"));
            if (wel != null && wel.size() > 0) {
                for (WebElement we : wel) {
                    if (checkFilter(we, filterMap.get(url))) {
                        try {
                            Article article = new Article();
                            WebElement elText = we.findElement(By.cssSelector("div.wall_post_text"));
                            if (elText != null) {
                                article.setArticle(elText.getText());
                            }
                            List<WebElement> imgs = we.findElements(By.cssSelector(".page_post_sized_thumbs a.page_post_thumb_wrap"));
                            if (imgs != null && imgs.size() > 0) {
                                List<String> lI = getAllURsImagesFromElement(imgs);
                                article.setImages(lI.toArray(new String[lI.size()]));
                            }
                            artticles.add(article);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artticles;
    }

    private List<String> getAllURsImagesFromElement(List<WebElement> imgs) {
        List<String> lI = new ArrayList<>();
        if (imgs != null && imgs.size() > 0) {
            for (WebElement wed : imgs) {
                String l = wed.getAttribute("style");
                if (isURLtoContent(l)) {
                    lI.add(getURLfromStyleContent(l));
                }
            }
        }
        return lI;
    }

    private String getURLfromStyleContent(String l) {
        return l.substring(l.indexOf("url(") + 5, l.lastIndexOf(")") - 1);
    }

    private boolean isURLtoContent(String l) {
        return l != null && l.indexOf("url(") > -1 && l.lastIndexOf(")") > -1;
    }

    private boolean checkFilter(WebElement we, FilterArticle filter) {
        if (filter != null) {
            List<WebElement> lL = null;
            if (filter.getCountLike() != null && filter.getCountLike() > 0) {
                lL = we.findElements(By.cssSelector(".post_full_like .post_like span"));
                if (lL != null && lL.size() > 0) {
                    int cL = 0;
                    try {
                        cL = Integer.parseInt(lL.get(1).getText());
                    } catch (NumberFormatException e) {
                    }
                    if (cL < filter.getCountLike()) {
                        return false;
                    }
                } else {
                    //Not like
                    return false;
                }
            }
            if (filter.getCountPost() != null && filter.getCountPost() > 0) {
                lL = we.findElements(By.cssSelector(".post_full_like .post_share span"));
                if (lL != null && lL.size() > 0) {
                    int cL = 0;
                    try {
                        cL = Integer.parseInt(lL.get(1).getText());
                    } catch (NumberFormatException e) {
                    }
                    if (cL < filter.getCountPost()) {
                        return false;
                    }
                } else {
                    //Not post
                    return false;
                }
            }
        }
        return true;
    }

    public void addFrands() {

        String bDay = "1";
        String age = "16";
        String bmonth = "1";
        String sex = "2";
        String country = "392";

        String url = "https://vk.com/friends?act=find&c%5Bage_from%5D=" + age + "&c%5Bage_to%5D=" + age + "&c%5Bbday%5D=" + bDay +
                "&c%5Bbmonth%5D=" + bmonth + "&c%5Bcity%5D=" + country +
                "&c%5Bcountry%5D=3&c%5Bname%5D=1&c%5Bphoto%5D=1&c%5Bsection%5D=people&c%5Bsex%5D=" + sex + "&c%5Bsort%5D=1";

        driver.navigate().to(url);

        waitLoadSelector(By.cssSelector("#l_fr"), 2,driver);
        WebElement we = null;
        waitLoadSelector(By.cssSelector("#l_fr span.inl_bl.left_count"), 1,driver);
        try {
            we = driver.findElement(By.cssSelector("#l_fr span.inl_bl.left_count"));
        } catch (Exception e) {
        }
        if (we != null && !"".equals(we.getText().trim())) {
            try {
                we.click();
            } catch (Exception e) {
                e.printStackTrace();
            }
            waitLoadSelector(By.cssSelector("div.friends_user_row"), 2,driver);
            List<WebElement> listWe = driver.findElements(By.cssSelector("div.friends_user_row"));
            for (WebElement wefr : listWe) {
                try {
                    wefr.findElements(By.cssSelector("button.flat_button")).get(0).click();
                    System.out.println("add friend");
                } catch (Exception e) {
                    System.out.println("friend wasn't added");
                }
            }
        }
    }

    public void loginToSight(String url, String login, String password) {
        driver.navigate().to(url);

        WebElement elementLogin = driver.findElement(By.id("index_email"));
//        WebElement elementLogin = driver.findElement(By.id("quick_email"));
        elementLogin.sendKeys(login);

        WebElement elementPass = driver.findElement(By.id("index_pass"));
//        WebElement elementPass = driver.findElement(By.id("quick_pass"));
        elementPass.sendKeys(password);

        WebElement elementButLogin = driver.findElement(By.id("index_login_button"));
//        WebElement elementButLogin = driver.findElement(By.id("quick_login_button"));
        elementButLogin.click();

        WebElement element = (new WebDriverWait(driver, 5)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.top_profile_name")));
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("govno");
        }
    }

    public void waitForLoad(WebDriver driver, int sekwait) {
        sleepOn(1000);
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, sekwait);
        wait.until(pageLoadCondition);
    }

    public static void waitLoadSelector(final By selector, int delay, WebDriver driver) {
        try {
            (new WebDriverWait(driver, delay)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    WebElement el = null;
                    try {
                        el = d.findElement(selector);
                    } catch (Exception e) {
                    }
                    return el != null && el.isEnabled();
                }
            });
        } catch (Exception e) {
            System.out.println("govnoto");
        }
    }

    public void sayFriendsRandomRecord(String groupURL) {

        driver.navigate().to(groupURL);
        waitLoadSelector(By.cssSelector("i.post_share_icon"), 2,driver);
        // Find the text input element by its name
//        List<WebElement> elementsShareBut0 = driver.findElements(By.className("post_share"));

        scrollAndSleep();
        scrollAndSleep();

        //driver.findElements(By.cssSelector("i.post_share_icon"));
        List<WebElement> pressedShareBtns = getAllPressedShareButton();

        if (pressedShareBtns.size() > 0) {
            log.debug("Element size: " + pressedShareBtns.size());
            boolean d = false;
            int ind = 0;
            while (!d) {
                try {
                    clickRandomButton(pressedShareBtns);
                    d = true;
                } catch (Exception e) {
                    ind++;
                    if (ind > 10) {
                        d = true;
                    }
                    sleepOn(1000);
                    System.out.println("Page error: " + ind);
                }
            }
            // Wait for the page to load, timeout after 10 seconds
            waitLoadSelector(By.cssSelector("#like_share_send:visible"), 2,driver);

            sleepOn(2000);
            List<WebElement> elementButShare = driver.findElements(By.cssSelector("#like_share_send"));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            if (elementButShare != null && elementButShare.size() > 0) {
                elementButShare.get(0).click();
            } else {
                System.out.println("I didn't share film");
            }

            // Should see: "cheese! - Google Search"
            System.out.println("Page title is: " + driver.getTitle());

            //Close the browser

        }
    }

    public static void sleepOn(int millisecSleep) {
        try {
            Thread.sleep(millisecSleep);
        } catch (InterruptedException e1) {
        }
    }

    private void clickRandomButton(List<WebElement> pressedShareBtns) {
        pressedShareBtns.get(new Random().nextInt(pressedShareBtns.size())).click();
    }

    private List<WebElement> getAllSharedBtns() {
        return driver.findElements(By.cssSelector("a.post_share._share_wrap:not(.my_share) i.post_share_icon"));
    }

    private List<WebElement> getAllPressedShareButton() {
        List<WebElement> elementsShareBut2 = new ArrayList<>();
        for (WebElement el : getAllSharedBtns()) {
            if (isBtnPressed(el)) {
                elementsShareBut2.add(el.findElement(By.xpath("..")));
            }
        }
        return elementsShareBut2;
    }

    private void scrollAndSleep() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,550)", "");
        sleepOn(2000);
    }

    private boolean isBtnPressed(WebElement el) {
        return el.getCssValue("opacity") != "1";
    }

    public void stopBrowser() {
        driver.quit();
    }

    public void addArticle(String groupURL, String article) {
        addArticle(groupURL, article, null);
    }

    public void addArticle(String groupURL, String article, String[] images) {
        driver.navigate().to(groupURL);
        waitLoadSelector(By.id("post_field"), 2,driver);
        WebElement elementArt = null;
        int ind = 0;
        boolean d = false;
        while (!d) {
            elementArt = driver.findElement(By.id("post_field"));
            try {
                elementArt.click();
                d = true;
            } catch (Exception e) {
                if (ind > 9) {
                    System.out.println("addArticle жопа");
                    return;
                }
                sleepOn(1000);
                ind++;
                System.out.println("Attempt #" + ind);
            }
        }
        if (images != null) {
            for (String image : images) {
                elementArt.sendKeys(image);
                sleepOn(1000);
                elementArt.sendKeys(" ");
                sleepOn(5000);
                elementArt.clear();
            }
        }

        sleepOn(500);
        elementArt.sendKeys(article);
        sleepOn(1000);
//        ind = 0;
//        d = false;
//        WebElement butEl = driver.findElement(By.cssSelector("button.flat_button.addpost_button"));
        sleepOn(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(" wall.sendPost()", "");
        sleepOn(2000);
        System.out.println("addArticleS");
    }

    /**
     * Method for change word from changeSent on value from this map in doc
     *
     * @param doc        document
     * @param changeSent map for change
     * @return change doc
     */
    public static String changeV(String doc, Map<String, String> changeSent) {
        for (String sent : changeSent.keySet()) {
            try {
                doc = doc.replaceAll(sent, changeSent.get(sent));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doc;
    }
}
