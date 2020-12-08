package com.hackerrank.util;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author gsharikadze
 */
public class IOUtil {

    public static String read(String fileName) {
        String content = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                content = sb.toString();
            } finally {
                br.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }


}
