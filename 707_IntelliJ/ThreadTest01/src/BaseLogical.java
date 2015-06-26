import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by snag on 2015-06-26.
 */
@SuppressWarnings("Convert2Lambda")
public final class BaseLogical {

    public static void get_tokenNum() {

    }

    public static void main(String[] args) throws Exception {

        Enumeration<NetworkInterface> t_nis = NetworkInterface.getNetworkInterfaces();
        while (t_nis.hasMoreElements()) {
            NetworkInterface t_ni = t_nis.nextElement();
            if (!t_ni.isLoopback()) {
                if (t_ni.isUp()) {
                    //System.out.println("t_ni.getDisplayName(): " + t_ni.getDisplayName());
                    //System.out.println("t_ni.isLoopback(): " + t_ni.isLoopback());
                    //System.out.println("t_ni.isPointToPoint(): " + t_ni.isPointToPoint());
                    //System.out.println("t_ni.isUp(): " + t_ni.isUp());
                    //System.out.println("t_ni.isVirtual(): " + t_ni.isVirtual());
                    Enumeration<InetAddress> t_ias = t_ni.getInetAddresses();
                    while (t_ias.hasMoreElements()) {
                        InetAddress t_ia = t_ias.nextElement();
                        if (t_ia.isSiteLocalAddress()) {
                            System.out.println("t_ia.getHostAddress(): " + t_ia.getHostAddress());
                        }
                        //System.out.println("t_ni.isVirtual(): " + t_ia.getHostAddress());
//                        System.out.println("t_ia.isAnyLocalAddress(): " + t_ia.isAnyLocalAddress());
//                        System.out.println("t_ia.isLinkLocalAddress(): " + t_ia.isLinkLocalAddress());
//                        System.out.println("t_ia.isLoopbackAddress(): " + t_ia.isLoopbackAddress());
//                        System.out.println("t_ia.isMCGlobal(): " + t_ia.isMCGlobal());
//                        System.out.println("t_ia.isSiteLocalAddress(): " + t_ia.isSiteLocalAddress());
                    }
                }
            }
        }

        //System.out.println(InetAddress.getLocalHost().);


        /*
        final ArrayList<String> t_al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            t_al.add(String.format("%03d%03d%03d%03d", i, i, i, i));
        }


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    while (true) {
                        for (String t_str : t_al) {
                            System.out.println(t_str);
                        }
                    }
                }
            }).start();
        }*/

    }

}
