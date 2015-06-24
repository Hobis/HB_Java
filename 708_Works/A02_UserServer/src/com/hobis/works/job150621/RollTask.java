package com.hobis.works.job150621;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings("unused")
public class RollTask extends Thread implements Closeable {

    public RollTask(Socket s, Vector<RollTask> clients) {
        this._socket = s;
        this._clients = clients;
        this._clients.add(this);
        this._hostAddress = this._socket.getInetAddress().getHostAddress();
    }

    private Socket _socket = null;
    private Vector<RollTask> _clients = null;

    private String _hostAddress = null;
    private Scanner _scan = null;


    // ::
    private void p_msgPush() {
        if (this._clients == null) return;

        //for (RollTask t_rt : this._clients) {
        //    t_rt._socket.getOutputStream()
        //}
    }

    // ::
    private void p_loop() {
        while (this._scan.hasNextLine()) {
            String t_ls = this._scan.nextLine();
            RollUtil.println(this._hostAddress + ", " + t_ls);
        }
        this.close();
    }


    @Override
    public void run() {
        try {
            this._scan = new Scanner(this._socket.getInputStream());
            this.p_loop();
        }
        catch (IOException e) {
            this.close();
        }
    }

    @Override
    public void close() {
        if (this._socket != null) {
            try {
                this._socket.close();
            }
            catch (Exception e) {
            }
            this._socket = null;

            try {
                this._scan.close();
            }
            catch (Exception e) {
            }
            this._scan = null;

            try {
                this._clients.remove(this);
            }
            catch (Exception e) {
            }

            //RollUtil.trace("this._clients.size(): " + this._clients.size());
            this._clients = null;


            //RollUtil.trace("클라이언트를 삭제합니다.");
        }
    }
}
