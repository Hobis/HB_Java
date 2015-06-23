package com.hobis.testa;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


/**
 * Created by Hobis-PC on 2015-06-20.
 */
public final class RollTask extends Thread {

    public RollTask(Socket cs) {
        this._cs = cs;
        try {
            this._scan = new Scanner(new InputStreamReader(this._cs.getInputStream()));


        }
        catch (IOException e) {
        }
    }

    private Socket _cs = null;
    private Scanner _scan = null;
    private boolean _isLoop = true;


    // ::
    public void kill() {
        _isLoop = false;

        if (_cs != null) {
            try {
                _cs.close();
            }
            catch (Exception e) {
            }
            _cs = null;
        }

        if (_scan != null) {
            _scan.close();
            _scan = null;
        }

        RollUtil.trace("RollTask가 죽었어요");
    }


    @Override
    public void run() {

        if (this._scan == null) return;


        while (_isLoop) {
            try {
                System.out.println("~~~~~~");
                String t_lstr = _scan.nextLine();
                if (t_lstr != null) {
                    System.out.println("t_lstr: " + t_lstr);
                    MainStarter.get_rform().append_txt(RollUtil.MT_SYSTEM, "t_lstr: " + t_lstr);
                }
                else {
                    kill();
                }
            }
            catch (Exception e) {
                kill();
            }

            RollUtil.trace("밴복");
        }
    }
}
