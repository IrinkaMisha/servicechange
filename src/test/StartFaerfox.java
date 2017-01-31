package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miha on 16.04.2016.
 */
public class StartFaerfox {
    public static void main(String[] src) throws UnsupportedEncodingException {
//        firefox -P "Another User" -no-remote.
//         -no-remote -ProfileManager
        List<String> cmd = new ArrayList<>();
        cmd.add("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        cmd.add("-no-remote");
        cmd.add("-P");
        cmd.add("aesha2");
//        cmd.add("\"fileName\"");
        ProcessBuilder builder = new ProcessBuilder().command(cmd);
        Process process = null;
        int exitCode=-1;

        try {
            process = builder.start();
            final Process finalProcess = process;
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finalProcess.destroy();
                }
            });
            t.start();
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            String ed=new String(e.getMessage());
            System.out.println(ed);
        } catch (IOException e) {
            String ed=new String(e.getMessage());
            System.out.println(ed);
        }
        process.destroy();
        System.out.println(exitCode);
    }
}
