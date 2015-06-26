import hb.tools.HB_NetTool;

/**
 * Created by Hobis-PC on 2015-06-24.
 */
public final class TestMain {
    public static void main(String[] args) {
        /*
        String t_str = HB_NetTool.load_urlDataString(
                "https://www.youtube.com/watch?v=PpmSvKe3nOY&index=5&list=PL9O4Fkn5dFJMHfWMmKuvOJPFZ0tTA5QfO",
                StandardCharsets.UTF_8.name());
        */
        //System.out.println(t_str);
        //System.out.println(System.getProperty("line.separator"));

        //System.out.println(System.getProperty("java.vendor"));
/*
        Properties t_props = System.getProperties();
        t_props.list(System.out);*/



        System.out.println(HB_NetTool.get_localHostAddress_a());
        System.out.println(HB_NetTool.get_localHostAddress_b());
        System.out.println(HB_NetTool.get_localHostAddress_w());

    }
}
