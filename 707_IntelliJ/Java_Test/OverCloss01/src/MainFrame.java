import javax.swing.*;

/**
 * Created by Hobis-PC on 2015-06-19.
 */
public final class MainFrame extends JFrame {

    public MainFrame() {
        this.setTitle("XXXX");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocation(10, 10);
        this.setVisible(true);
        this.setResizable(false);
    }


    private JPanel panel1;


    public static void main(String[] args) {
        System.out.println("HelloWorld");

        new MainFrame();
    }
}
