package banking_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BalanceEnquery extends JFrame implements ActionListener {

    JButton back;

    String pinno;
    BalanceEnquery(String pinno){

        this.pinno = pinno;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinno + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("deposite")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }

        JLabel text =new JLabel("Your current account balance is Rs. " + balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource() == deposite){
//            String number = amount.getText();
//            Date date = new Date();
//            if(number.equals("")){
//                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");
//            } else {
//                Conn conn = new Conn();
//                String query = "insert into bank values('"+pinno+"', '"+date+"', 'deposite', '"+number+"')";
//                try {
//                    conn.s.executeUpdate(query);
//                    JOptionPane.showMessageDialog(null,"Rs " + number + " Deposited Successfully!!");
//                    setVisible(false);
//                    new Transactions(pinno).setVisible(true);
//                } catch (SQLException e) {
//                    System.out.println(e);
//                }
//            }
//        } else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinno).setVisible(true);
//        }
    }

    public static void main(String[]args){
        new BalanceEnquery("");
    }
}
