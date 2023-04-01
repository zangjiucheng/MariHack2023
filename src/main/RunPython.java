package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunPython {
    public static void executive(String stmt) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        try {
            String[] command = { "python3.9", "orc.py", "-i", stmt };
            Process process = runtime.exec(command);
            String errStr = consumeInputStream(process.getErrorStream());
            int proc = process.waitFor();

            if (proc == 0) {
                System.out.println("Success!");
            } else {
                System.out.println("Fail! " + errStr);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String consumeInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            sb.append(s);
        }
        return sb.toString();
    }
}
