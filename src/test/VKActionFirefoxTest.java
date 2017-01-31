package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miha on 18.12.2016.
 */
public class VKActionFirefoxTest {
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
}
