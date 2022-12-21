import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginpage extends JFrame implements ActionListener {
    JFrame frame;
    JLabel l1, l2, l3, l4;
    JTextField t1;
    JPasswordField p1;
    JButton b1;

    public Loginpage() {
        frame = new JFrame("Login page");
        setLayout(null);
        setSize(500, 500);

        setBackground(Color.lightGray);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l3 = new JLabel("Account Login");
        l3.setBounds(60, 0, 150, 60);

        l1 = new JLabel("Enter Username : ");
        l1.setBounds(20, 60, 150, 30);

        l2 = new JLabel("Enter Password : ");
        l2.setBounds(20, 100, 150, 30);

        t1 = new JTextField(5);
        t1.setBounds(120, 60, 150, 30);

        p1 = new JPasswordField(5);
        p1.setBounds(120, 100, 150, 30);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 100, 30);

        l4 = new JLabel();
        l4.setBounds(40, 200, 350, 30);

        b1.addActionListener(this);

        add(l3);
        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);
        add(l4);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Loginpage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String username = t1.getText().toString();
            String password = p1.getText().toString();

            if (username.equals("Tsec") && password.equals("2025")) {
                new display1();
            }
            else {
                l4.setText("Sorry,Username or Password is incorrect // Try again");
            }

        }

    }
}