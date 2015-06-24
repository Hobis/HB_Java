import com.hobis.servers.chatServer.ServerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by snag on 2015-06-11.
 */
public final class MainStarter {

    // ::
    private static void p_trace(String msg) {
        final String t_tag = "[hb] ";
        System.out.println(t_tag + msg);

        //this.
    }

    // ::
    private static int _count = 0;
    private static void p_dirLoop(File tf, boolean b) {
        if (b) {
            _count = 0;
        }

        if (tf.exists()) {
            if (tf.isDirectory()) {
                for (File t_f : tf.listFiles()) {
                    _count++;
                    //t_f.
                    if (t_f.getName().lastIndexOf(".dll") > -1) {
                        p_trace(t_f.getPath());
                    }

                    //
                    if (t_f.isDirectory()) {
                        p_dirLoop(t_f, false);
                    }
                }
            }
        }
    }

/*
    // ::
    private static String[] p_file_getSearcheDlls(File tf, boolean b) {
        if (!tf.exists())
            return null;

        if (!tf.isDirectory())
            return null;


        String[] t_fps;



        for (File t_f : tf.listFiles()) {
            if (t_f.getName().lastIndexOf(".dll") > -1) {

            }

            //
            if (t_f.isDirectory()) {
                p_file_getSearcheDlls(t_f, false);
            }
        }

        return t_fps;
    }*/






    // ::
    public static void main(String[] args) {
        // 이렇게 하면 한글 입력이 잘 안되는거 같드만...
        //String t_path = "C:\\Program Files (x86)\\JetBrains\\IntelliJ IDEA Community Edition 14.1.3";
        //p_dirLoop(new File(t_path), true);
        //p_trace("" + _count);


/*
        File t_f = new File(t_path);
        if (t_f.exists()) {
            //p_trace("" + t_f.isDirectory());
            for (String t_s : t_f.list()) {
                p_trace(t_s);
            }
        }*/

        // 최고의 자바 에디터 입니다. IntelliJ









        //String[] t_strs = new String[] {"Hobis_1", "Hobis_2", "Hobis_3"};
        //Arrays.copyOf(t_strs);
        //System.arraycopy(t_strs, );

        //System.out.println("~~~~~~~~~~~~~");
        //FileUtil.textReadAll("C:\\Users\\snag\\Desktop\\Test.txt");
        //String t_str = FileUtil.textReadAll("D:\\700_hbworks\\1503_Engloo\\Game3\\Game3_Step2.json");
        //System.out.println("t_str: " + t_str);
/*
        Vector<String> t_vec = FileUtil.text_readAll("D:\\700_hbworks\\1503_Engloo\\Game3\\Game3_Step2.json");
        Iterator<String> t_iter = t_vec.iterator();
        while (t_iter.hasNext()) {
            String t_ls = t_iter.next();
            if (t_ls.indexOf("\"mean\":\"별\"") > -1) {
                //System.out.println("t_ls: " + t_ls.trim());
                System.out.println("t_ls: " + StringUtil.trim_right(t_ls));
            }
            //System.out.println("t_ls: " + t_ls);
        }*/

        //FileUtil.text_lindSearchDelete();

        /*
        UserItem t_ui = new UserItem("HobisJung", 35);
        p_trace(t_ui.toString());

        p_trace("" + "axxxxx".hashCode());
        p_trace("" + "bxxxxx".hashCode());
        */
/*

        if (true) {
            System.out.println("Square-Enix");
        }


        for (int k = 0; k < 100; k++) {
            p_trace("" + (char)k);
        }



        Thread t_th = new Thread(new Runnable() {

            private int _count = 0;

            @Override
            public void run() {
                while (true) {
                    if (_count < 30) {
                        try {
                            Thread.sleep(100);
                        }
                        catch (Exception e) {
                        }


                        System.out.println("쓰레드가 진행중입니다. " + _count);

                        _count++;
                    }
                    else {
                        break;
                    }
                }
            }
        });
        t_th.setDaemon(true);
        t_th.start();
        p_trace("여기~~~~~~~~~");

        try {
            t_th.join(200);
        }
        catch (Exception e) {
        }

        p_trace("끝났어요.");
*/



/*
        안드로이드 블루투스 워키토키
        1. 소켓통신 다시 이해하기
        2. 안드로이드 블루투스 패키지 이해하기
        3. 샘플 검색및 분석 이해도 올리기
        4. 화면 Ui설계 및 적용
        5. 구현...
        6. 테스트...
        */

/*
        try {
            p_trace(InetAddress.getLocalHost().getHostAddress());
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }*/


        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable() {

            private ActionListener _al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Component t_c = (Component) e.getSource();
                    switch (t_c.getName()) {
                        case "btn1": {
                            try {
                                _ta.setText("");
                            }
                            catch (Exception e2) {
                            }

                            break;
                        }

                        case "btn2": {

                            break;
                        }

                        case "btn3": {

                            break;
                        }
                    }
                }
            };


            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch (Exception e) {
                }

                JFrame t_frame = new JFrame();
                t_frame.setTitle("Host Frame Ver 1.0");
                t_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Rectangle t_rect = new Rectangle(100, 60, 400, 600);
                t_frame.setBounds(t_rect);
                //t_frame.setPreferredSize(t_rect.getSize());
                t_frame.setResizable(false);

                Container t_pane = t_frame.getContentPane();
                t_pane.setPreferredSize(new Dimension(400, 600));
                t_pane.setLayout(null);
                t_pane.setBackground(Color.BLACK);


                JScrollPane t_sp = null;
                JTextArea t_ta = null;
                JButton t_btn = null;

                t_ta = new JTextArea();
                t_sp = new JScrollPane();
                t_sp.setBounds(0, 0, 400, 540);
                t_sp.setViewportView(t_ta);
                t_pane.add(t_sp, null);
                t_ta.setEditable(false);
                _ta = t_ta;


                t_btn = new JButton("Clear");
                t_btn.setSize(70, 26);
                t_btn.setLocation(400 - (76 * 1), 566);
                t_pane.add(t_btn, null);
                t_btn.addActionListener(_al);
                t_btn.setName("btn1");


                t_btn = new JButton("Stop");
                t_btn.setSize(70, 26);
                t_btn.setLocation(400 - (76 * 2), 566);
                t_pane.add(t_btn, null);
                t_btn.addActionListener(_al);
                t_btn.setName("btn2");


                t_btn = new JButton("Start");
                t_btn.setSize(70, 26);
                t_btn.setLocation(400 - (76 * 3), 566);
                t_pane.add(t_btn, null);
                t_btn.addActionListener(_al);
                t_btn.setName("btn3");


                t_frame.pack();
                t_frame.setVisible(true);
            }
        });


    }

    private static JTextArea _ta = null;





    // ::
    //sprivate

}

