import hb.tools.NetTool;

import java.util.*;

/**
 * Created by Hobis-PC on 2015-06-24.
 */
@SuppressWarnings({"SpellCheckingInspection", "unchecked"})
public final class TestMain {
    public static void main(String[] args) {
        /*
        String t_str = NetTool.load_urlDataString(
                "https://www.youtube.com/watch?v=PpmSvKe3nOY&index=5&list=PL9O4Fkn5dFJMHfWMmKuvOJPFZ0tTA5QfO",
                StandardCharsets.UTF_8.name());
        */
        //System.out.println(t_str);
        //System.out.println(System.getProperty("line.separator"));

        //System.out.println(System.getProperty("java.vendor"));
/*
        Properties t_props = System.getProperties();
        t_props.list(System.out);*/


/*
        System.out.println(NetTool.get_localHostAddress_a());
        System.out.println(NetTool.get_localHostAddress_b());
        System.out.println(NetTool.get_localHostAddress_w());


        HashMap<String, _UserItem> t_usc = null;
        t_usc = new HashMap<>();
        t_usc.put("HobisJung", new _UserItem("jhb0b@naver.com", "123456", "Hobis"));
        System.out.println(t_usc.size());

        //synchronized ()
        */

/*
        Hashtable<String, String> t_ht = new Hashtable<>();
        t_ht.put("Name_01", "jhb0b");
        t_ht.put("Name_02", "pook61");
        t_ht.put("Name_03", "inoff79");
        System.out.println(t_ht.size());
        Enumeration<String> t_ens = t_ht.elements();
        while(t_ens.hasMoreElements()) {
            System.out.println(t_ens.nextElement());
        }*/

        //Vector<String> t_v = new Vector<>(t_ht);



        Vector<Object> t_vec = new Vector<>();
        System.out.println(t_vec.isEmpty());
        t_vec.add(new Object());
        System.out.println(t_vec.isEmpty());
        t_vec.remove(0);
        System.out.println(t_vec.isEmpty());


    }




    @SuppressWarnings("unused")
    private static final class _UserItem {
        public _UserItem(String email, String pw, String alias) {
            this._email = email;
            this._pw = pw;
            this._alias = alias;
        }

        private String _email = null;
        public String get_email() {
            return _email;
        }

        private String _pw = null;
        public String get_pw() {
            return _pw;
        }

        private String _alias = null;
        public String get_alias() {
            return _alias;
        }

        @Override
        public String toString() {
            return "(email=" + _email + ", pw=" + _pw + ", alias=" + _alias + ")";
        }
    }

}
