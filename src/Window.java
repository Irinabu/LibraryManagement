import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Window {

    public JFrame mainFrame;
    public JLabel header;
    public JPanel mainPanel;
    public JTextField email;
    public JTextField password;
    public JTextField text;


    public void init() {
        prepareFrame(this);
        showButtons();

    }

    public void Login(Window w){

        email = new JTextField("type your email");
        email.setBounds(10,10,120,20);
        email.setLocation(50,70);

        password = new JTextField("type your password");
        password.setBounds(10,10,120,20);
        password.setLocation(50, 110);

        mainFrame.setVisible(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainFrame.add(mainPanel);

        mainPanel.add(email);
        mainPanel.add(password);

        DataBase b = new DataBase();

        ArrayList<Librarian> l = b.listOfLibrarians();

        email.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailText = email.getText();

                //check if the email is valid

                boolean foundE = false;
                for(int i = 0; i < l.size() && !foundE; i ++)
                    if(emailText.equals(l.get(i).email)){
                        System.out.println(l.get(i).firstName + " " + l.get(i).lastName);

                        foundE = true;

                        password.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String passwordText = password.getText();
                                boolean foundP = false;
                                for(int i = 0; i < l.size() && foundP == false; i ++)
                                    if(passwordText.equals(l.get(i).password)){

                                        foundP = true;
                                        mainFrame.setVisible(false);

                                        prepareFrame(w);
                                        showOptions(w);


                                    }
                                if(foundP == false){
                                    JOptionPane.showMessageDialog(null, "Parola incorecta, incearca din nou");
                                }

                            }

                        });


                    }

                if(foundE == false){
                    JOptionPane.showMessageDialog(null, "Email invalid, incearca din nou");
                }


            }

        });



        mainFrame.setVisible(true);
    }

    public void prepareFrame(Window w){
        w.mainFrame = new JFrame("Login");
        w.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.mainFrame.setSize(400,400);
        w.mainFrame.setLayout(new GridLayout(3,1));
        w.header = new JLabel("Salutare", SwingConstants.CENTER);

        w.mainFrame.setLocationRelativeTo(null);

        w.mainFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
        });

        w.mainPanel = new JPanel();
        w.mainPanel.setLayout(new FlowLayout());


        w.mainFrame.add(w.header);
        w.mainFrame.add(w.mainPanel);
        mainFrame.setVisible(false);
        w.mainFrame.setVisible(true);

    }

    public void showOptions(Window w){

        w.header.setText("What do you want to do?");

        JButton b1 = new JButton("Borrow a book");
        JButton b2 = new JButton("Rent a book");
        JButton b3 = new JButton("Log out");

        DataBase b = new DataBase();

        ArrayList<Book> l = b.listOfBooks();

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window f1 = new Window();
                prepareFrame(f1);

                f1.header.setText("Type the name of the book");

                f1.text = new JTextField();
                f1.text.setBounds(10,10,300,20);
                f1.text.setLocation(50, 110);
                f1.text.setPreferredSize(new Dimension(300, 20));
                f1.mainPanel.add(f1.text);


                f1.text.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = f1.text.getText();
                        System.out.println(name);

                        boolean foundB = false;

                        for(int i = 0; i < l.size() && !foundB; i ++)
                            if(name.equals(l.get(i).title))
                            {
                                if(l.get(i).availableNumber >= 1) {
                                    foundB = true;
                                    l.get(i).availableNumber--;
                                    System.out.println(l.get(i));
                                    JOptionPane.showMessageDialog(null, "Imprumut realizat cu succes");
                                    f1.mainFrame.setVisible(false);
                                    w.mainFrame.setVisible(true);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Nu mai sunt carti disponibile");

                                }

                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Nume gresit sau carte inexistenta in sistem");
                            }
                    }
                });

            }
        });
        w.mainPanel.add(b1);
        w.mainPanel.add(b2);
        w.mainPanel.add(b3);

        w.mainFrame.setVisible(true);

    }

    public void showButtons(){

        header.setText("Choose your status");
        JButton admin = new JButton("Admin");
        JButton librarian = new JButton("Librarian");

        mainPanel.add(admin);
        mainPanel.add(librarian);
        mainFrame.setLocationRelativeTo(null );
        mainFrame.setVisible(true);

        admin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                AdminWindow wA = new AdminWindow();

            }

        });

        librarian.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setVisible(false);
                LibrarianWindow wL = new LibrarianWindow();


            }
        });



    }

}
