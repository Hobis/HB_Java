package hb.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;

/**
 * Created by snag on 2015-06-25.
 */
@SuppressWarnings({"unused", "UnusedAssignment"})
public final class HB_NetTool {

    private static String _LINE_SEPARATOR = System.getProperty("line.separator");

    // :: url 로드해서 스트링으로 뽑기
    public static String load_urlDataString(String url, String encoding) {
        URL t_url = null;
        URLConnection t_ucon = null;
        BufferedReader t_br = null;
        StringBuffer t_sb = null;

        try {
            t_url = new URL(url);
            t_ucon = t_url.openConnection();
            if (encoding == null) {
                t_br = new BufferedReader(new InputStreamReader(t_ucon.getInputStream()));
            }
            else {
                t_br = new BufferedReader(new InputStreamReader(t_ucon.getInputStream(), encoding));
            }

            String t_ls = null;
            while ((t_ls = t_br.readLine()) != null) {
                if (t_sb == null) {
                    t_sb = new StringBuffer();
                }
                t_sb.append(t_ls + _LINE_SEPARATOR);
            }

            try {
                t_br.close();
            }
            catch (Exception e) {
            }

            if (t_sb != null) {
                String t_rs = t_sb.toString();
                return t_rs;
            }
        }
        catch (Exception e) {
        }

        return null;
    }


    // ::
    public static String get_localHostAddress_a() {

        Enumeration<NetworkInterface> t_nis = null;

        try {
            t_nis = NetworkInterface.getNetworkInterfaces();

            while (t_nis.hasMoreElements()) {
                NetworkInterface t_ni = t_nis.nextElement();

                if (!t_ni.isLoopback()) {

                    if (t_ni.isUp()) {
                        Enumeration<InetAddress> t_ias = t_ni.getInetAddresses();

                        while (t_ias.hasMoreElements()) {
                            InetAddress t_ia = t_ias.nextElement();

                            if (t_ia.isSiteLocalAddress()) {
                                return t_ia.getHostAddress();
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e) {
        }

        return null;
    }

    // ::
    public static String get_localHostAddress_b() {

        Enumeration<NetworkInterface> t_nis = null;

        try {
            t_nis = NetworkInterface.getNetworkInterfaces();

            while (t_nis.hasMoreElements()) {
                NetworkInterface t_ni = t_nis.nextElement();
                Enumeration<InetAddress> t_ias = t_ni.getInetAddresses();

                while (t_ias.hasMoreElements()) {
                    InetAddress t_ia = t_ias.nextElement();

                    if (t_ia.isLoopbackAddress()) {
                    }
                    else {
                        if (t_ia.isSiteLocalAddress()) {
                            return t_ia.getHostAddress();
                        }
                    }
                }
            }
        }
        catch (Exception e) {
        }

        return null;
    }


    // ::
    public static String get_localHostAddress_w() {
        InetAddress t_ia = null;

        try {
            t_ia = InetAddress.getLocalHost();
            return t_ia.getHostAddress();
        }
        catch (UnknownHostException e) {
        }

        return null;
    }

}
