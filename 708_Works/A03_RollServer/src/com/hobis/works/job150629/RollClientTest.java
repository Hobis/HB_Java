package com.hobis.works.job150629;

import java.io.*;
import java.net.Socket;

/**
 * Created by snag on 2015-07-01.
 */
@SuppressWarnings({"UnusedAssignment", "unused"})
public final class RollClientTest {

    public static void main(String[] args) {
        Socket t_cs = null;
        BufferedWriter t_cbw = null;
        BufferedReader t_cbr = null;
        BufferedReader t_br = null;
        BufferedWriter t_bw = null;

        try {
            t_cs = new Socket("192.168.0.13", 9937);


            RollUtil.trace("서버 접속 시작");

            t_cbr = new BufferedReader(new InputStreamReader(System.in));

            String t_ls = null;
            while ((t_ls = t_cbr.readLine()) != null) {
                if (t_ls.equals("exit")) {
                    break;
                }
                RollUtil.trace("t_ls: " + t_ls);
            }

            RollUtil.trace("서버 접속 종료");



            //t_cbw = new BufferedWriter(System.out);


            /*
            t_cs = new Socket("192.168.0.13", 9937);
            t_br = new BufferedReader(new InputStreamReader(t_cs.getInputStream()));
            t_bw = new BufferedWriter(new OutputStreamWriter(t_cs.getOutputStream()));

            t_bw.write("안녕하세요.");*/

            //Roll
        }
        catch (IOException e) {
        }
    }

}
