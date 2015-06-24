import com.hobis.works.job150621.UserServer;
import com.hobis.works.job150621.utils.UserUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by Hobis-PC on 2015-06-21.
 */
@SuppressWarnings("Convert2Lambda")
public final class MainStarter {
    public static void main(String[] args) {
        UserServer t_us = new UserServer("MainServer", 9982);
        t_us.setDaemon(true);

        UserUtil.trace(null, "서버가 시작됩니다.");
        t_us.start();
        try {
            t_us.join();
        }
        catch (InterruptedException e) {
        }


/*
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        }
        catch (UnknownHostException e) {
        }
        */


//
//
//        Thread t_th = new Thread(new Runnable() {
//
//            private int _count = 0;
//
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(100);
//                    }
//                    catch (InterruptedException e) {
//                    }
//
//                    System.out.println("시작합니다.");
//
//                    if (_count > 7) {
//                        break;
//                    }
//                    else {
//                        _count++;
//                    }
//                }
//            }
//        });
//        //t_th.setDaemon(true);
//        t_th.start();
////        try {
////            t_th.join();
////        }
////        catch (InterruptedException e) {
////        }
//
//        System.out.println("~~~~끝~~~~");


    }
}
