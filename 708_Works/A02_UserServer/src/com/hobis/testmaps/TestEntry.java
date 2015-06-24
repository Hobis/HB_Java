package com.hobis.testmaps;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by snag on 2015-06-24.
 */
public final class TestEntry {
    public static void main(String[] args) {
        ServerSocket t_ss = null;
        Socket t_s = null;

        try {
            t_ss = new ServerSocket(9994);
            t_s = t_ss.accept();
            System.out.println("~~~~~~~");
        }
        catch (IOException e) {
        }
    }
}
