package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbqualification,cbdepartment;
    JButton submit,cancel;
    
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempid);

        labelempid= new JLabel("1533" + first4);
        labelempid.setBounds(200, 200, 200, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempid);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Address");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X(%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);
        
        JLabel lblxii=new JLabel("Class XII(%)");
        lblxii.setBounds(50,350,150,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        tfxii=new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);
        
        JLabel lblaadhar=new JLabel("Aadhar No.");
        lblaadhar.setBounds(400,350,150,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel lblqualification=new JLabel("Qualification");
        lblqualification.setBounds(50,400,200,30);
        lblqualification.setFont(new Font("serif",Font.BOLD,20));
        add(lblqualification);
        
        String qualification[]={"B.Tech","BBA","BCA","Bsc","MBA","MCA","B.com","BA","MA","Msc"};
        cbqualification=new JComboBox(qualification);
        cbqualification.setBounds(200,400,150,30);
        cbqualification.setBackground(Color.WHITE);
        add(cbqualification);
        
        JLabel lbdepartment=new JLabel("Department");
        lbdepartment.setBounds(400,400,150,30);
        lbdepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lbdepartment);
        
        String department[]={"CS","Mechanical","Electronics","Civil","AIML","CSIT","IT"};
        cbdepartment=new JComboBox(department);
        cbdepartment.setBounds(600,400,150,30);
        cbdepartment.setBackground(Color.WHITE);
        add(cbdepartment);
        
        submit=new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
         cancel=new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        
        

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name=tfname.getText();
            String fname=tffname.getText();
            String empid=labelempid.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String x=tfx.getText();
            String xii=tfxii.getText();
            String aadhar=tfaadhar.getText();
            String qualification=(String)cbqualification.getSelectedItem();
            String department=(String)cbdepartment.getSelectedItem();
            
            try{
            String query="insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+qualification+"','"+department+"')";
            Conn con=new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Teacher details inserted successfully");
            setVisible(false);
            
            }
            catch(Exception e){
            e.printStackTrace();}
            
        }
        else{
            setVisible(false);
        }
        
    }
    public static void main(String[] args) {
        new AddTeacher();

    }

}
