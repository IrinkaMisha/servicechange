package by.nulay.changer.parser;

import by.nulay.changer.vk.FilmTake;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by miha on 19.01.2016.
 * Class parser megacritic site for select new Films
 */
@Component("MegacriticParser")
public class MegacriticParser extends ParserImpl{
    private static Logger log= Logger.getLogger(MegacriticParser.class);

    public MegacriticParser(){
    }

    private String urlSite="https://www.kinopoisk.ru";

    public List<FilmTake> startParse() throws IOException {

        Document doc = null;
//        System.setProperty("javax.net.ssl.keyStore", "megacriticru.crt");
//        System.setProperty("javax.net.ssl.trustStoreType","megacriticru.crt");
//        System.setProperty("javax.net.ssl.keyStore", "C:\\\\files\\work\\openshift\\task2\\src\\main\\webapp\\resources\\sertificat\\megacriticru.crt");
//        System.setProperty("javax.net.ssl.keyPassword","qwerty");
        try {
            doc = Jsoup.connect(urlSite+"/premiere/ru/date/"+ new SimpleDateFormat("YYYY-MM-dd").format(new Date(new Date().getTime()+60000*60*24))+"/").timeout(10*1000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select(".premier_item");
        List<FilmTake> listFilmTake=new ArrayList<FilmTake>();
        for(Element el:newsHeadlines){
            String name=el.select(".text").text() + el.select(".ajax_rating").text();
            doc = Jsoup.connect(urlSite+el.select(".text a").get(0).attr("href")).timeout(10*1000).get();
            String img= doc.select(".popupBigImage img").attr("src");
            String film=doc.select(".moviename-big").text();
            String discription=doc.select("div.film-synopsys").text();

            FilmTake filmTakeF = new FilmTake();
            filmTakeF.setFilm(film);
            filmTakeF.setName(name);
            filmTakeF.setDiscription(discription);
            filmTakeF.setImg(img);
            filmTakeF.setSight("https://www.kinopoisk.ru");
            filmTakeF.setDateCreate(new Date());
            listFilmTake.add(filmTakeF);
        }
        return listFilmTake;
    }
}
