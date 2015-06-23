package com.hobis.testa;


import javax.swing.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

/**
 * Created by Hobis-PC on 2015-06-19.
 */
public final class RollFrame extends JFrame {

    private static final String _LINE_STR = System.lineSeparator();
    private final Object _lockObj = new Object();
    private Dimension _fsize = null;
    private Container _cont = null;
    private ActionListener _clickListener = null;

    private JButton _btn1 = null;
    private JButton _btn2 = null;
    private JButton _btn3 = null;

    private JTextArea _txtArea = null;
    /*
    public JTextArea get_txtArea() {
        return _txtArea;
    }*/


    private RollServer _rserver = null;

    public RollFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        this.setTitle("Host Frame Ver 1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(10, 10);

        this._cont = this.getContentPane();
        this._fsize = new Dimension(600, 800);
        this._cont.setPreferredSize(_fsize);
        this._cont.setLayout(null);
        this.p_componentsInit();

        this.pack();
        this.setVisible(true);
    }

    private void p_componentsInit() {
        final int t_mgl = 4;
        //final int t_mgr = 10;
        //final int t_mgu = 10;
        //final int t_mgd = 10;


        final Dimension t_dim = new Dimension(80, 26);


        _clickListener = e -> {
            Component t_c = (Component) e.getSource();
            switch (t_c.getName()) {
                case "btn1": {
                    clear_txt();
                    break;
                }

                case "btn2": {
                    p_rserverStop();
                    break;
                }

                case "btn3": {
                    //p_rserverStart();
                    break;
                }
            }
        };

        _btn1 = new JButton();
        _btn1.setText("Clear");
        _btn1.setSize(t_dim);
        _btn1.setLocation(
                _fsize.width - ((t_dim.width + t_mgl) * 1),
                _fsize.height - (t_dim.height + t_mgl));
        _btn1.setName("btn1");
        _btn1.addActionListener(_clickListener);
        _cont.add(_btn1);


        _btn2 = new JButton();
        _btn2.setText("Stop");
        _btn2.setSize(t_dim);
        _btn2.setLocation(
                _fsize.width - ((t_dim.width + t_mgl) * 2),
                _fsize.height - (t_dim.height + t_mgl));
        _btn2.setName("btn2");
        _btn2.addActionListener(_clickListener);
        _cont.add(_btn2);

        _btn3 = new JButton();
        _btn3.setText("Start");
        _btn3.setSize(t_dim);
        _btn3.setLocation(
                _fsize.width - ((t_dim.width + t_mgl) * 3),
                _fsize.height - (t_dim.height + t_mgl));
        _btn3.setName("btn3");
        _btn3.addActionListener(_clickListener);
        _cont.add(_btn3);


        JScrollPane t_sp = new JScrollPane();
        _txtArea = new JTextArea();
        _txtArea.setLineWrap(true);
        _txtArea.setEditable(false);
        _txtArea.setWrapStyleWord(true);
        t_sp.setViewportView(_txtArea);
        t_sp.setSize(_fsize.width, 760);
        t_sp.setLocation(0, 0);
        _cont.add(t_sp);


        append_txt(RollUtil.MT_SYSTEM, "시스템 준비됨.");
    }

    private void p_rserverStop() {
        if (_rserver != null) {
            _rserver.kill();
            _rserver = null;
            append_txt(RollUtil.MT_SYSTEM, "서버를 종료합니다.");
        }
    }

    private void p_rserverStart() {
        if (_rserver == null) {
            _rserver = new RollServer(9865);
            _rserver.start();
            append_txt(RollUtil.MT_SYSTEM, "서버를 시작합니다.");
        }

    }

    // ::
    private void p_checkMax() {
        String t_str = _txtArea.getText();
        if (t_str.length() > 50000) {
            clear_txt();
        }
    }

    // ::
    public void append_txt(String mt, String str) {
        synchronized (_lockObj) {
            _txtArea.append(mt + str + _LINE_STR);
        }
    }

    // ::
    public void clear_txt() {
        synchronized (_lockObj) {
            _txtArea.setText("");
        }
    }


}
