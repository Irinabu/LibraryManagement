import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminWindow extends Window{

    public AdminWindow(){

        mainFrame = new JFrame("Login Admin");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        mainFrame = new JFrame("Login Admin");
        mainFrame.setSize(300,300);
        mainFrame.setLocationRelativeTo(null);
        Login(this);

    }
}
