package banking_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;

    Login(){

        setTitle("AUTOMATED TELLER MACHINE");		 // set name for the machine
        setLayout(null);   	//to set custom layout

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);  	//give boundaries to image
        add(label);

        //Font font = new Font(Font.SERIF, Font.BOLD, 40);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font(Font.SERIF,Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);				//give boundaries to text
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font(Font.SERIF,Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 40);				//give boundaries to text
        add(cardno);

        cardtextfield = new JTextField();
        cardtextfield.setBounds(300, 160, 250, 30);
        cardtextfield.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        add(cardtextfield);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font(Font.SERIF,Font.BOLD,28));
        pin.setBounds(120, 220, 150, 30);				//give boundaries to text
        add(pin);

        pintextfield = new JPasswordField();
        pintextfield.setBounds(300, 230, 150, 30);
        add(pintextfield);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);												//after clicking button what should be done that said by action listener.
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);   //length & breadth of the frame
        setVisible(true); 	 //by default visibility was false.frame will be visible
        setLocation(350,170);
    }

    public void actionPerformed(ActionEvent ae) {			//action event class told us which component(button) is being clicked.
        if(ae.getSource() == clear) {
            cardtextfield.setText("");
            pintextfield.setText("");
        } else if(ae.getSource() == login) {
            Conn conn = new Conn();
            String cardno = cardtextfield.getText();
            String pinno = pintextfield.getText();
            String query = "select * from login where card_number = '"+cardno+"' and pin = '"+pinno+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
                }
            } catch(Exception e){
                System.out.println(e);
            }

        } else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Login();
    }

}

