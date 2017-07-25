package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by miha on 08.10.2014.
 */
public class StartTest2 {
    //мой старт класс
    public static void main(String str[]){
  //
//        HashMap strCh = new HashMap();
//
//
//
//        strCh.put("anekdotov.net", "");
//        strCh.put("анeкдотoв.net", "");
//        strCh.put("анекдотов.nеt", "");
//        strCh.put("aнекдотов.nеt", "");
//        strCh.put("aнекдoтов.net", "");
//        strCh.put("aнекдотoв.net", "");
//        strCh.put("aнекдoтов.nеt", "");
//        strCh.put("aнeкдoтов.nеt", "");
//
//        strCh.put("анeкдoтов.net", "");
//        strCh.put("aнeкдoтoв.nеt", "");
//        strCh.put("анeкдотов.nеt", "");
//        strCh.put("анeкдoтoв.net", "");
//        strCh.put("анeкдoтoв.nеt", "");
//        strCh.put("анeкдoтов.nеt", "");
//        strCh.put("aнeкдoтoв.net", "");
//
//
//        Set sdf = new HashSet();
//
//        for (Object dsf:strCh.keySet()){
//            sdf.add((String)dsf);
//        }
//
//       if(sdf!=null) return;
        VKActionFirefox vjk=new VKActionFirefox();
        String sdfs = vjk.changeV("Мужик с удочкой сидит на берегу реки. \n" +
                "анекдотов.nеt\n" +
                "\n" +
                "Подходит \n" +
                "женщина, раздевается догола, а в интимном месте пирсинг, и идет купаться. \n" +
                "\n" +
                "Рыбак: \n" +
                "\n" +
                "— Ты трусы-то надень, тут щука на блесну хорошо берет.\n",vjk.strCh);
    }
}
