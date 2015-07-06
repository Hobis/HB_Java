package hb.tests;

import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by Hobis-PC on 2015-07-02.
 */
@SuppressWarnings("UnusedAssignment")
public final class CallServer extends Thread {
    // ##
    public CallServer() {
        this.setDaemon(true);
    }
    private ServerSocket _ss = null;

    // ::
    private void p_loop() {
        CallHelper.trace("# 서버를 시작함");

        try {
            this._ss = new ServerSocket(9957);

            while ((this._ss != null) && !this._ss.isClosed()) {
                CallHelper.trace("# 클라이언트 대기중");
                Socket t_cs = this._ss.accept();
                CallTask.addStart("", t_cs);
                CallHelper.trace("# 클라이언트 들어옴");
            }
        }
        catch (Exception e) {
        }

        CallHelper.close(this._ss);
        this._ss = null;

        CallTask.removeAll();


        CallHelper.trace("# 서버를 종료함");
    }

    @Override
    public void run() {
        this.p_loop();
    }







    public static void main(String[] args) {
        CallServer t_cs =  new CallServer();
        t_cs.start();
        try {
            t_cs.join();
        }
        catch (Exception e) {
        }


/*
        CallHelper.trace("# 서버를 시작함");


        boolean t_isLoop = true;
        ServerSocket t_ss = null;
        Socket t_cs = null;

        try {
            t_ss = new ServerSocket(9957);

            while (t_isLoop) {
                CallHelper.trace("# 클라이언트 대기중");
                t_cs = t_ss.accept();
                CallTask.addStart("", t_cs);
                CallHelper.trace("# 클라이언트 들어옴");
            }

        }
        catch (Exception e) {
        }


        CallHelper.close(t_ss);
        t_ss = null;

        CallTask.removeAll();


        CallHelper.trace("# 서버를 종료함");
        */
    }

}
