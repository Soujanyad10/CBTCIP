package banking_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{

    String pinno;

    MiniStatement(String pinno){
        this.pinno = pinno;

        setTitle("Mini-Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinno+"'");
            while(rs.next()){
                card.setText("Card number: " + rs.getString("card_number").substring(0,4) + "-XXXX-XXXX-" + rs.getString("card_number").substring(12));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");      //&nbsp for space
                if (rs.getString("type").equals("deposite")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("YOUR CURRENT BALANCE IS: Rs. " + bal);
        } catch (Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args){
        new MiniStatement("");
    }
}
