package banking_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;

public class Transfer extends JFrame implements ActionListener{

    String pinno;
    JPasswordField pin;
    JTextField acnotextfield, acnumber;
    JButton transfer, back;

    Transfer(String pinno){
        this.pinno = pinno;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Transfer Money");
        text.setBounds(265,280,180,35);
        text.setFont(new Font(Font.SERIF, Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        JLabel transferedac = new JLabel("Account number to transfer money: ");
        transferedac.setBounds(170,330,400,20);
        transferedac.setFont(new Font(Font.SERIF, Font.BOLD,16));
        transferedac.setForeground(Color.white);
        image.add(transferedac);

        acnotextfield = new JTextField();
        acnotextfield.setBounds(170,350,180,25);
        acnotextfield.setFont(new Font(Font.SERIF, Font.BOLD,16));
        acnotextfield.setForeground(Color.black);
        image.add(acnotextfield);

        JLabel pintext = new JLabel("Your pin:");
        pintext.setBounds(170,390,180,25);
        pintext.setFont(new Font(Font.SERIF, Font.BOLD,16));
        pintext.setForeground(Color.white);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setBounds(300,390,80,25);
        pin.setFont(new Font(Font.SERIF, Font.BOLD,16));
        pin.setForeground(Color.black);
        image.add(pin);

        JLabel amount = new JLabel("Amount");
        amount.setBounds(170,430,180,25);
        amount.setFont(new Font(Font.SERIF, Font.BOLD,16));
        amount.setForeground(Color.white);
        image.add(amount);

        acnumber = new JTextField();
        acnumber.setBounds(300,430,100,25);
        acnumber.setFont(new Font(Font.SERIF, Font.BOLD,16));
        acnumber.setForeground(Color.black);
        image.add(acnumber);

        transfer = new JButton("Transfer");
        transfer.setBounds(400,485,100,25);
        transfer.addActionListener(this);
        image.add(transfer);

        back = new JButton("Back");
        back.setBounds(400,520,100,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == transfer){
            try {
                String acno = acnotextfield.getText();
                String pinnum = pin.getText();
                String a1 = acnumber.getText();
                if(!pinnum.equals(pinno)){
                    JOptionPane.showMessageDialog(null, "Please enter correct pin!");
                } else {

                    Conn c = new Conn();
                    Date date = new Date();
                    String query1 = "insert into bank values('" + pinnum + "', '" + date + "', 'transfer', '" + a1 + "')";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Rs " + a1 + " transfered " + acno + " Successfully!!");
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);

                }
            } catch(Exception e){
                System.out.println(e);
            }

        } else {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Transfer("");
    }
}
