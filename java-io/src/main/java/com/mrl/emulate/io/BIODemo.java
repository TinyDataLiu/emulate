package com.mrl.emulate.io;

import java.io.*;

/**
 * BIO
 *
 * @author liuchun
 * @date 2020/02/26  15:25
 */
public class BIODemo {
    private static final File file = new File("user.txt");

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("user.txt")))) {
            for (String line = reader.readLine(); null != line && !line.equals(""); line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


}
