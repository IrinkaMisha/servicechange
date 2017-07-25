package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by miha on 18.12.2016.
 */
public class VKActionFirefoxTest {

    public static SynchronousQueue<String> queueForFilm = new SynchronousQueue<>();
    public static int sdf=0;

//    public static void main(String[] args) {
//        for(int i=0;i<20;i++){
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            startD();
//        }
//    }
    public static void main(String[] args) {
        List<String> user = new ArrayList<>();
        user.add("irNaid");
        user.add("+375299780180");
        user.add("vkurody3");

//        final List<List> listUser = new ArrayList<>();
//        listUser.add(user);

        VKActionFirefox vkActionST = new VKActionFirefox(user.get(0));
        vkActionST.loginToSight("https://vk.com", user.get(1), user.get(2));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        vkActionST.findRecords("https://vk.com/imixphoto");
    }

    public static void startD(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queueForFilm.put("Hello "+(sdf++));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(queueForFilm.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
