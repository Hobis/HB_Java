package com.hobis.testa;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
public final class TestStarter {

    private static void p_closed(Closeable c) {
        if (c != null) {
            try {
                c.close();
            }
            catch (IOException e) {
            }
        }
    }

    //
    //


    private static void p_read_BufferedReader(URLConnection urlc) {
        InputStream t_is = null;
        InputStreamReader t_isr = null;
        BufferedReader t_br = null;
        String t_ls = null;

        try {
            t_is = urlc.getInputStream();
            t_isr = new InputStreamReader(t_is);
            t_br = new BufferedReader(t_isr);
            while ((t_ls = t_br.readLine()) != null) {
                System.out.println(t_ls);
            }
        }
        catch (IOException e) {
        }

        p_closed(t_br);
    }

    private static void p_read_Scanner(URLConnection urlc) {
        InputStream t_is = null;
        Scanner t_scan = null;
        String t_ls = null;

        try {
            t_is = urlc.getInputStream();
            t_scan = new Scanner(t_is);
            while (t_scan.hasNext()) {
                t_ls = t_scan.nextLine();
                System.out.println(t_ls);
            }
        }
        catch (IOException e) {
        }

        p_closed(t_scan);
    }

    public static void main(String[] args) {
        URL t_url = null;
        URLConnection t_urlc = null;
        Scanner t_scan = null;
        BufferedReader t_br = null;

        try {
            t_url = new URL("https://www.google.co.kr/?gfe_rd=cr&ei=KUocU5qBOILH8gfvjYDwDg#newwindow=1&q=bufferedreader");
            t_urlc = t_url.openConnection();

            // Scanner 클래스 사용
            p_read_Scanner(t_urlc);

            // BufferedReader 클래스 사용
            //p_read_BufferedReader(t_urlc);

        }
        catch (Exception e) {
        }
    }

}
