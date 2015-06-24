package com.hobis.works.job150621;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings("unused")
public class UserTask extends Thread implements Closeable {

    public UserTask(Socket s) {
        this._socket = s;
    }

    private Socket _socket = null;
    private Scanner _scan = null;


    // ::
    private void p_loop() {
        while (this._scan.hasNextLine()) {
            String t_ls = this._scan.nextLine();
            System.out.println("t_ls: " + t_ls);
        }
    }


    @Override
    public void run() {
        try {
            this._scan = new Scanner(this._socket.getInputStream());
        }
        catch (IOException e) {
            this.close();
        }

        this.p_loop();
    }

    @Override
    public void close() {
        if (this._socket != null) {
            try {
                this._socket.close();
            }
            catch (Exception e) {
            }

            try {
                this._scan.close();
            }
            catch (Exception e) {
            }

            this._socket = null;
        }
    }
}
