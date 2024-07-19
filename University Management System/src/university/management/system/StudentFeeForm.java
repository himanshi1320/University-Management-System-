package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JButton submit, cancel, payfees;
    JLabel amount;

    StudentFeeForm() {
        setSize(1000, 600);
        setLocation(500, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, 50, 500, 300);
        add(image);

        JLabel rollno = new JLabel("Select Roll No");
        rollno.setBounds(10, 20, 200, 40);
        rollno.setFont(new Font("serif", Font.BOLD, 20));
        add(rollno);
        crollno = new Choice();
        crollno.setBounds(230, 30, 200, 30);
        add(crollno);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(10, 70, 200, 40);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);
        JLabel labelname = new JLabel();
        labelname.setBounds(230, 70, 200, 40);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(10, 120, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);
        JLabel labelfname = new JLabel();
        labelfname.setBounds(230, 120, 200, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
 try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel course = new JLabel("Course");
        course.setBounds(10, 170, 200, 30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        String choose_course[] = {"BTech", "Bsc", "BA", "MTech", "MSc", "BCom", "MA"};
        cbcourse = new JComboBox(choose_course);
        cbcourse.setBounds(230, 170, 200, 30);
        add(cbcourse);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(10, 220, 200, 30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);

        String choose_branch[] = {"Mechanical", "Electrical", "CS", "Civil", "AIML"};
        cbbranch = new JComboBox(choose_branch);
        cbbranch.setBounds(230, 220, 200, 30);
        add(cbbranch);

        JLabel semester = new JLabel("Semester");
        semester.setBounds(10, 270, 200, 30);
        semester.setFont(new Font("serif", Font.BOLD, 20));
        add(semester);

        String choose_semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        cbsemester = new JComboBox(choose_semester);
        cbsemester.setBounds(230, 270, 200, 30);
        add(cbsemester);

        JLabel pay = new JLabel("Total Payable");
        pay.setBounds(10, 320, 200, 40);
        pay.setFont(new Font("serif", Font.BOLD, 20));
        add(pay);
        amount = new JLabel();
        amount.setBounds(230, 320, 200, 40);
        amount.setFont(new Font("serif", Font.BOLD, 20));
        add(amount);

        submit = new JButton("Submit");
        submit.setBounds(25, 450, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(225, 450, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        payfees = new JButton("Pay Fee");
        payfees.setBounds(415, 450, 120, 30);
        payfees.setBackground(Color.BLACK);
        payfees.setForeground(Color.WHITE);
        payfees.addActionListener(this);
        payfees.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(payfees);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course='" + course + "'");
                while (rs.next()) {
                    amount.setText(rs.getString(semester));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == payfees) {
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String amount=payfees.getText();
            
            
            try{
                Conn c=new Conn();
                String query="insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Collge fee submitted successfully");
                setVisible(false);
}
catch(Exception e){
    e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();

    }

}
