package banking_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton amount1, amount2, amount3, amount4, amount5, amount6, exit;
    String pinno;

    Fastcash(String pinno){

        this.pinno = pinno;

        setLayout(null);
        ImageIcon I1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(235,300,700,35);
        text.setFont(new Font(Font.SERIF, Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        amount1 = new JButton("Rs. 100");
        amount1.setBounds(170,415,150,30);
        amount1.addActionListener(this);
        image.add(amount1);

        amount2 = new JButton("Rs. 500");
        amount2.setBounds(355,415,150,30);
        amount2.addActionListener(this);
        image.add(amount2);

        amount3 = new JButton("Rs. 1000");
        amount3.setBounds(170,450,150,30);
        amount3.addActionListener(this);
        image.add(amount3);

        amount4 = new JButton("Rs. 2000");
        amount4.setBounds(355,450,150,30);
        amount4.addActionListener(this);
        image.add(amount4);

        amount5 = new JButton("Rs. 5000");
        amount5.setBounds(170,485,150,30);
        amount5.addActionListener(this);
        image.add(amount5);

        amount6 = new JButton("Rs. 10,000");
        amount6.setBounds(355,485,150,30);
        amount6.addActionListener(this);
        image.add(amount6);

        exit = new JButton("Back");
        exit.setBounds(263,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        } else {
            String a = ((JButton)ae.getSource()).getText().substring(4);   //Rs. 500
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposite")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(a)){
                    JOptionPane.showMessageDialog(null,"Insufficient Amount!");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinno+"', '"+date+"', 'withdrawl', '"+a+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + a + " Debited Succesfully!!");
                setVisible(false);
                new Transactions(pinno).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        new Fastcash("");
    }
}

