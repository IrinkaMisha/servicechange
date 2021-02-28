package by.nulay.changer.taskexecutor;

import by.nulay.changer.parser.SerialochkaParser;
import by.nulay.changer.vk.FilmTake;
import by.nulay.changer.taskexecutor.sightbot.Account;
import org.eclipse.jetty.util.ArrayQueue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import test.Article;
import test.VKAction;
import test.VKActionFirefox;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.*;


/**
 * Class for post Film to VK
 */
public class PostFilmTask extends AddArticleTask implements Task{

    public static SerialochkaParser serialochkaParser = new SerialochkaParser();

    public static Queue<Article> queueForFilm = new ArrayQueue<>();

    /**
     * Account
     */
    private Account account;

    public PostFilmTask(WebDriver driver) {
        super(driver);
    }

    public PostFilmTask(WebDriver driver, Account account) {
        super(driver);
        this.account = account;
    }



    @Override
    public void execute() {
        startPostFilm();
    }

    public void startPostFilm(){

            System.out.println("thFilm:start execution");

            Date d1 = new Date();
//            if (d1.getHours() + 1 > 23 || d1.getHours() < 5) {
//                System.out.println("thFilm:sleep 6 hours");
//                sleepOn(1000 * 60 * 60 * 6);
//            }
            Article article = getArticle();
            if (article != null) {
                VKAction vkActionST = null;
                try {
                    vkActionST = new VKActionFirefox(account.getName());
                } catch (Exception e) {
                }
                if (vkActionST != null) {
                    try {
                        vkActionST.loginToSight("https://vk.com", account.getLogin(), account.getPassword());
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

                            queueForFilm.add(article);

                    } finally {
                        vkActionST.stopBrowser();
                    }
                }
            }
            System.out.println("thFilm:sleep 2 hours");
            sleepOn(1000 * 60 * 60 * 2);


    }

    public static void sleepOn(int millisecSleep) {
        try {
            Thread.sleep(millisecSleep);
        } catch (InterruptedException e1) {
        }
    }

    public static void main(String[] args) {
        try {
            PostFilmTask.getSertificat();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PostFilmTask.getArticle();
        Account miha = new Account("Miha", "+375297350741", "vkurody3");
        Task task = new PostFilmTask(null, miha);
        task.execute();
    }


    private static Article getArticle() {
        Article article = null;
        if (queueForFilm.size() > 0) {
                article = queueForFilm.peek();
        } else {
            try {
                List<FilmTake>  listFilm = startParse();
                for(FilmTake film : listFilm){
                    article = new Article();

                    String content = film.getName() + "\r\n" + film.getFilm() + "\r\n" + film.getDiscription();
                    content = content.replaceAll("<br>", "\r\n");
                    System.out.println(content);
                    article.setArticle(content);
                    article.setImages(new String[]{film.getImg()});

                        queueForFilm.add(article);

                }
                if (queueForFilm.size() > 0) {

                        article = queueForFilm.peek();

                }
            } catch (IOException e) {
            }
        }
        return article;
    }

    private static String urlSite="http://serialochka.ru/";

    private static void getSertificat() throws NoSuchAlgorithmException, KeyManagementException, MalformedURLException, IOException {
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
        SSLContext.setDefault(ctx);
        URL url = new URL(null, urlSite, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();
        for (Certificate cert : certs) {
            if (cert instanceof X509Certificate) {
                X509Certificate cert509 = (X509Certificate)cert;
                System.out.println("Certificate is: " + cert509.getSubjectDN());
            }
        }
        conn.disconnect();
    }



    public static List<FilmTake> startParse() throws IOException {

        Document doc = null;
        try {
            doc = Jsoup.connect(urlSite).get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
        Elements newsHeadlines = doc.select(".mainprasp tr.serin");
        List<FilmTake> listFilmTake=new ArrayList<FilmTake>();
        Map<String,FilmTake> hrefs = new HashMap<String,FilmTake>();
        for(Element el:newsHeadlines) {
            FilmTake filmTakeF = new FilmTake();
            filmTakeF.setName((el.select(".serinf").text()+" "+el.select(".rsdtv").text()).trim());
            filmTakeF.setDiscription(doc.select(".mainprasp h3.tb").text());
            filmTakeF.setDiscription(filmTakeF.getDiscription().substring(0,filmTakeF.getDiscription().length()-35));
            hrefs.put(el.select(".serinf a").attr("href"),filmTakeF);
        }
        for(String els:hrefs.keySet()){
            Document docS = Jsoup.connect(urlSite+els).get();
            Elements oneF = docS.select(".serialinfo");
            String res=oneF.text();
            res=res.replaceAll("Рейтинг Kinopoisk - Р","Р");
            res=res.replaceAll("Рейтинг ImDb - М","М");
            if(res.endsWith("Место в топе -"))
                res=res.replaceAll("Место в топе -","");
            Elements opisser = docS.select(".opisser");
            String descr=opisser.text();
            descr=descr.replaceAll("Наша рецензия","Рецензия");

//            String name = docS.select(".filmfull h1[itemprop=name]").text()+" "+
//                    docS.select(".filmfull .engname").text()+" "+
//                    docS.select(".filmfull .atitle").text();
            String img="http://serialochka.ru"+docS.select(".series-poster img").attr("src");

            FilmTake filmTakeF=hrefs.get(els);
            filmTakeF.setFilm(res);
            //filmTakeF.setName(hrefs.get(els).trim());
            filmTakeF.setDiscription(filmTakeF.getDiscription()+" "+descr);
            filmTakeF.setImg(img);
            filmTakeF.setSight("http://serialochka.ru/");
            filmTakeF.setDateCreate(new Date());
            listFilmTake.add(filmTakeF);

        }
        return listFilmTake;
    }
}
