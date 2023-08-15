package banking_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton savingacount, currentacount, recurringdepositeacount, fixeddepositeacount;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;

    String formno;
    SignupThree(String formno){

        this.formno = formno;

        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font(Font.SERIF, Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Details");
        type.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        type.setBounds(100,140,200,30);
        add(type);

        savingacount = new JRadioButton("Savings Account:");
        savingacount.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        savingacount.setBackground(Color.WHITE);
        savingacount.setBounds(100,180,180,20);
        add(savingacount);

        currentacount = new JRadioButton("Current Account:");
        currentacount.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        currentacount.setBackground(Color.WHITE);
        currentacount.setBounds(400,180,180,20);
        add(currentacount);

        fixeddepositeacount = new JRadioButton("Fixed Deposite Account:");
        fixeddepositeacount.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        fixeddepositeacount.setBackground(Color.WHITE);
        fixeddepositeacount.setBounds(100,220,250,20);
        add(fixeddepositeacount);

        recurringdepositeacount = new JRadioButton("Recurring Deposite Account:");
        recurringdepositeacount.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        recurringdepositeacount.setBackground(Color.WHITE);
        recurringdepositeacount.setBounds(400,220,300,20);
        add(recurringdepositeacount);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(savingacount);
        groupaccount.add(currentacount);
        groupaccount.add(fixeddepositeacount);
        groupaccount.add(recurringdepositeacount);

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        cardno.setBounds(100,260,250,30);
        add(cardno);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4183");
        number.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        number.setBounds(300,260,300,30);
        add(number);

        JLabel carddetails = new JLabel("This is your 16 digit card number.");
        carddetails.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        carddetails.setBounds(100,285,300,20);
        add(carddetails);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        pin.setBounds(100,300,250,30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        pnumber.setBounds(300,300,250,30);
        add(pnumber);

        JLabel pindetails = new JLabel("This is your pin number.");
        pindetails.setFont(new Font(Font.SERIF, Font.BOLD, 12));
        pindetails.setBounds(100,325,300,20);
        add(pindetails);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font(Font.SERIF, Font.BOLD, 22));
        services.setBounds(100,360,300,30);
        add(services);

        c1 = new JCheckBox ("ATM Card");
        c1.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,410,150,20);
        add(c1);

        c2 = new JCheckBox ("Internet Banking");
        c2.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(300,410,200,20);
        add(c2);

        c3 = new JCheckBox ("Mobile Banking");
        c3.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,450,150,20);
        add(c3);

        c4 = new JCheckBox ("Email & sms Alert");
        c4.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(300,450,200,20);
        add(c4);

        c5 = new JCheckBox ("Cheque Book");
        c5.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,490,150,20);
        add(c5);

        c6 = new JCheckBox ("E-Statement");
        c6.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(300,490,130,20);
        add(c6);

        c7 = new JCheckBox ("I hereby declares that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,530,650,40);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font(Font.SERIF, Font.BOLD,14));
        submit.setBounds(600,640,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font(Font.SERIF, Font.BOLD,14));
        cancel.setBounds(100,640,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 820);
        setLocation(350,0);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accounttype = null;
            if(savingacount.isSelected()){
                accounttype = "Savings Account";
            } else if(currentacount.isSelected()){
                accounttype = "Current Account";
            } else if(fixeddepositeacount.isSelected()){
                accounttype = "Fixed Deposite Account";
            } else if(recurringdepositeacount.isSelected()){
                accounttype = "Recurring Deposite Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            }if(c2.isSelected()){
                facility = facility + "Internet Banking";
            }if(c3.isSelected()){
                facility = facility + "Mobile Banking";
            }if(c4.isSelected()){
                facility = facility + "Email & sms Alert";
            }if(c5.isSelected()){
                facility = facility + "Cheque Book";
            }if(c6.isSelected()){
                facility = facility + "E-Statement";
            }

            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required!");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            } catch (Exception e){
                System.out.println(e);
            }


        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args){
        new SignupThree("");
    }
}
