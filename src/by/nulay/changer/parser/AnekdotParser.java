package by.nulay.changer.parser;

import by.nulay.changer.vk.Anekdot;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import test.VKActionFirefox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by miha on 28.03.2017.
 */
@Component("AnekdotParser")
public class AnekdotParser {

    public static void main(String arg[]) {
        AnekdotParser aa = new AnekdotParser();
        try {
            aa.startParse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Logger log = Logger.getLogger(AnekdotParser.class);

    public AnekdotParser() {
    }

    private String urlSite = "http://anekdotov.net/anekdot/today.html";

    public List<Anekdot> startParse() throws IOException {

        Document doc = null;
        try {
            doc = Jsoup.connect(urlSite).timeout(10 * 1000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select("form div");
        Elements newsTable = doc.select("form table");
        List<Anekdot> listAnek = new ArrayList<Anekdot>();
        int k = 0;
        for (int i = 0; i < newsHeadlines.size(); i++) {
            Element el = newsHeadlines.get(i);

            if ("justify".equals(el.attr("align"))) {
                Anekdot anekdot = new Anekdot();
                el.select("a").removeAttr("href").removeAttr("target").tagName("span");
                anekdot.setAnekdot(el.select("div").html().replaceAll("<br>", "\r\n").replaceAll("<.*?>", "").replaceAll("[aа].{8}\\..{2}t","").replaceAll("&nbsp;",""));

                if (anekdot.getAnekdot() == null) continue;
                Element t = null;
                try {
                    t = newsTable.get((k == 0) ? k : (k * 2));
                } catch (Exception e) {
                    t = el;
                }
                if (t != null) {
                    try {
                        Double d = Double.parseDouble(getNumber(t.select("img").attr("title"), p1)) * 100;
                        anekdot.setCountAdded(d.intValue());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    try {
                        anekdot.setCountLike(Integer.parseInt(getNumber(t.select("img").attr("title"), p3)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                anekdot.setDateCreate(new Date());
                anekdot.setAnekdot(VKActionFirefox.changeV(anekdot.getAnekdot(), VKActionFirefox.strCh));
                anekdot.setGroup("anekdotov.net");
                if (anekdot.getCountAdded() > 300) {
                    listAnek.add(anekdot);
                }
                k++;
            }
        }
        return listAnek;
    }

    Pattern p1 = Pattern.compile("Р.*, п");
    Pattern p2 = Pattern.compile("\\d+\\.?\\d?");
    Pattern p3 = Pattern.compile("пр.*, C");

    private String getNumber(String str, Pattern p) {
        Matcher m = p.matcher(str);
        if (m.find()) {
            Matcher m2 = p2.matcher(m.group());
            if (m2.find()) {
                return m2.group();
            }
        }
        return "0";
    }
}
