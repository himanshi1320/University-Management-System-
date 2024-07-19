package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(900, 500);
        setLocation(400, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 0, 300, 200);
        add(image);

        JLabel heading = new JLabel("<html>University<br> Management System</html>");
        heading.setBounds(70, 15, 550, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        add(heading);

        JLabel name = new JLabel("Developed By : Himanshi Tyagi");
        name.setBounds(70, 200, 590, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(name);

        JLabel branch = new JLabel("BTech CSIT 3rd Year");
        branch.setBounds(70, 240, 590, 40);
        branch.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(branch);
        JLabel rollno = new JLabel("Roll no: 21007216847");
        rollno.setBounds(70, 280, 590, 40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(rollno);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
