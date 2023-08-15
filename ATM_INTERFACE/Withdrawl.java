package banking_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdrawl, back;
    JTextField amount;

    String pinno;
    Withdrawl(String pinno){

        this.pinno = pinno;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter your amount to withdrawl.");
        text.setBounds(170,300,400,20);
        text.setFont(new Font(Font.SERIF, Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font(Font.SERIF, Font.BOLD,16));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdrawl");
            } else {
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinno+"', '"+date+"', 'withdrawl', '"+number+"')";
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " + number + " Withdrawled Successfully!!");
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }

    public static void main(String[]args){
        new Withdrawl("");
    }
}
