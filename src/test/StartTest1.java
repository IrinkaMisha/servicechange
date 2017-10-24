package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by miha on 03.10.2014.
 */
public class StartTest1 {
    public static void main(String[] str){
        String h="&nbsp;Сидят два товарища в баре. . Проходит мимо &nbsp;потрясающая дивчина, один другому говорит:\n" +
                "—  Неделю бы не ел, не пил... Только бы переспать с ней... Подруга анeкдотoв.net это дело слышит, оборачивается, говорит:\n" +
                "—  Легко! Если неделю не ешь, не пьешь — я тебе отдамся.\n" +
                "Короче приводит товарища домой, закрывает в шкаф. Проходит  анeкдотoв.net неделя, подруга выпускает она его из шкафа, раздевается, ложится на кровать, говорит, мол, выиграл ты спор, я твоя. Он подходит к девушке, трогает грудь и вздыхая говорит:\n" +
                "—  Мягкая такая... . Как ХЛЕБУШЕК...\n" +
                "anekdotov.net\n" +
                "анекдотов.nеt\n" +
                "        strCh.put(\"\", \"\");\n" +
                "        strCh.put(\"анекдотов.nеt\", \"\");\n" +
                "        strCh.put(\"aнекдотов.nеt\", \"\");\n" +
                "        strCh.put(\"aнекдoтов.net\", \"\");\n" +
                "        strCh.put(\"aнекдотoв.net\", \"\");\n" +
                "        strCh.put(\"aнекдoтов.nеt\", \"\");\n" +
                "        strCh.put(\"aнeкдoтов.nеt\", \"\");\n" +
                "        strCh.put(\"анeкдoтов.net\", \"\");\n" +
                "        strCh.put(\"aнeкдoтoв.nеt\", \"\");\n" +
                "        strCh.put(\"анeкдотов.nеt\", \"\");\n" +
                "        strCh.put(\"анeкдoтoв.net\", \"\");\n" +
                "        strCh.put(\"анeкдoтoв.nеt\", \"\");\n" +
                "        strCh.put(\"анeкдoтов.nеt\", \"\");\n" +
                "        strCh.put(\"aнeкдoтoв.net\", \"\");\n" +
                "        strCh.put(\"aнекдотoв.nеt\", \"\");\n" +
                "        strCh.put(\"анекдoтов.nеt\", \"\");\n" +
                "        strCh.put(\"анекдoтов.net\", \"\");\n" +
                "        strCh.put(\"анeкдотов.nеt\", \"\");\n" +
                "        strCh.put(\"анекдотoв.nеt\", \"\");\n" +
                "        strCh.put(\"анекдотoв.net\", \"\");\n" +
                "        strCh.put(\"aнeкдoтов.net\", \"\");\n" +
                "        strCh.put(\"aнекдoтoв.net\", \"\");\n" +
                "        strCh.put(\"aнeкдотoв.net\", \"\");\n" +
                "Наедине со всеми Первый канал 4 сезон 132 серия «Людмила Сенчина»\n" +
                "Год 2013 - ... Старт сериала 14 октября 2013 Длительность 45 минут Страна Россия Телеканал Первый канал Время выхода Пн-Чт, 17:00 \n" +
                "Сегодня, 17 апреля 2017 года (понедельник) Рецензия о данном тв-шоу: Этот цикл ТВ-передач, идущих по 1 каналу, относится к формату «беседа с гостем». Её постоянная ведущая Юлия Меньшова – дочь актёров.  aнeкдoтoв.net\n" +
                "Она и сама снималась, но также полностью состоялась в профессии телеведущей. В разговоре Юлию отличают выдержанность, такт, внимание и даже сопереживание своим собеседникам. От ведущей никогда не услышишь провокационных, либо «с подвохом» вопросов. Героями «Наедине» являются люди известные, и в этой передаче они раскрываются зрителям не только как профессионалы, жены, мужья, любовники, но и просто как люди.\n" +
                "Attempt #1\n&nbsp;";

        h=h.replaceAll("[aа].{8}\\..{2}t","").replaceAll("&nbsp;","");
        Pattern.compile("[aа].{8}\\..{2}t").matcher(h).replaceAll("");


        String strs="skdljfsa;kj html sadfasdfj;kjdiv;lsjkdf;k";
        String sdf="<%@ page import=\"org.springframework.context.i18n.LocaleContextHolder\" %>\n" +
                "<%@ page import=\"by.imix.webcms.form.NodeView\" %>\n" +
                "<%@ page import=\"java.util.Locale\" %>\n" +
                "<%--\n" +
                "  Created by IntelliJ IDEA.\n" +
                "  User: miha\n" +
                "  Date: 28.01.13\n" +
                "  Time: 11:48\n" +
                "  To change this template use File | Settings | File Templates.\n" +
                "--%>\n" +
                "<%@ page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>\n" +
                "<%--<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>--%>\n" +
                "<%@ taglib prefix=\"tiles\" uri=\"http://tiles.apache.org/tags-tiles\" %>\n" +
                "<%@ taglib prefix=\"spring\" uri=\"http://www.springframework.org/tags\" %>\n" +
                "<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>\n" +
                "<%--<%@ taglib uri=\"http://struts.apache.org/tags-titles\" prefix=\"titles\"%>--%>\n" +
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n" +
                "\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                "\n" +
                "    <title>\n" +
                "        <%--Если есть атрибут titlePage - то вставляется он иначе вставляется атрибут titleKey --%>\n" +
                "        <c:choose>\n" +
                "            <c:when test=\"${titlePage!=null}\">\n" +
                "                ${titlePage}\n" +
                "            </c:when>\n" +
                "            <c:otherwise>\n" +
                "                <c:set var=\"titleKey\"><tiles:getAsString name=\"titleKey\"/></c:set>\n" +
                "                <spring:message code=\"${titleKey}\" />\n" +
                "            </c:otherwise>\n" +
                "        </c:choose>\n" +
                "    </title>\n" +
                "\t<!--# javascript #-->\n" +
                "</head>\n" +
                "<body marginwidth=\"0\" marginheight=\"0\"  leftmargin=\"0\" topmargin=\"0\" class=\"bodyCl\">\n" +
                "<div>\n" +
                "\t<!--# javascript2 #-->\n" +
                "    <tiles:insertAttribute name=\"header\" />\n" +
                "</div>\n" +
                "<div>\n" +
                "    <%--Блоки входа пользователя и другие--%>\n" +
                "    <c:set var=\"nameBlock\"><spring:message code=\"programm.userauth\" /></c:set>\n" +
                "    <%\n" +
                "        Locale l=LocaleContextHolder.getLocale();\n" +
                "        NodeView n = new NodeView();\n" +
                "        n.setTitles(\"authblock.jsp\");\n" +
                "        n.setName((String) pageContext.getAttribute(\"nameBlock\"));\n" +
                "        request.setAttribute(\"CURENT_NODEA\", n);\n" +
                "    %>\n" +
                "    <jsp:include page=\"../../template/blockview.jsp\"/>\n" +
                "</div>\n" +
                "\tsafasfasf<!--# javascript3 #-->sdfsdf sdf \n" +
                "<div>\n" +
                "    <%--Ошибки системы--%>\n" +
                "    <jsp:include page=\"../../template/error.jsp\"/>\n" +
                "    <%--Центральная страница--%>\n" +
                "    <tiles:insertAttribute name=\"content\" />\n" +
                "</div>\n" +
                "<div>\n" +
                "    <tiles:insertAttribute name=\"footer\" />\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        Pattern p = Pattern.compile("<\\!--#.+#-->",Pattern.MULTILINE);
        Matcher m =  p.matcher(sdf);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
