package com.hackerrank.util;

import sun.misc.IOUtils;

import java.io.*;
import java.net.*;

/**
 * @author gsharikadze
 */
public class HttpUtil {
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";

    public static String get(String url) {
        try {
            if (url.contains(" ")) {
                url = url.replace(" ", "%20");
            }

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("User-Agent", USER_AGENT);


            InputStream inputStream = connection.getInputStream();
            return convertStreamToString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


}
