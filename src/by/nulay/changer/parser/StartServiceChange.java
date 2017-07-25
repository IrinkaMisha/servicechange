package by.nulay.changer.parser;

import by.nulay.changer.ChangerException;
import by.nulay.changer.parser.MegacriticParser;
import by.nulay.changer.parser.ParserImpl;
import by.nulay.changer.parser.SerialochkaParser;
import by.nulay.changer.vk.Anekdot;
import by.nulay.changer.vk.AnekdotService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by miha on 23.01.2016.
 */
@Component("StartServiceChange")
public class StartServiceChange {
    private static Logger log= Logger.getLogger(StartServiceChange.class);
    @Autowired
            @Qualifier("MegacriticParser")
    ParserImpl megacriticParser;
    @Autowired
            @Qualifier("SerialochkaParser")
    ParserImpl serialochkaParser;

    @Autowired
    @Qualifier("AnekdotParser")
    AnekdotParser anekdotParser;

    @Autowired
    private AnekdotService anekdotService;

    @Scheduled(fixedRate = 14400000)
    public void startCheckFilms( ) throws IOException{
        try {
            megacriticParser.startParseAndSave();
        } catch (Exception e) {
            log.error(e);
        }
        try {
            serialochkaParser.startParseAndSave();
        } catch (ChangerException e) {
            log.error(e);
        }
        try {
            for(Anekdot anekdot : anekdotParser.startParse()) {
                try {
                    anekdotService.saveAnekdot(anekdot);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        } catch (ChangerException e) {
            log.error(e);
        }
    }
}
