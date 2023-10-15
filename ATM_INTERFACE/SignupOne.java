package banking_management_system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    JTextField nametextfield, fnametextfield, emailtextfield, addresstextfield, citytextfield, statetextfield, pincodetextfield;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, other, married, unmarried, othergender;

    Random ran = new Random();
    long random = (ran.nextLong() % 9000L) + 1000L;
    String rand = "" + Math.abs(random);

    SignupOne(){

        setLayout(null);

        JLabel formno = new JLabel("APPLICATION FORM NO: " + rand);
        formno.setFont(new Font(Font.MONOSPACED, Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personaldetails = new JLabel("Page 1: Personal Details:-");
        personaldetails.setFont(new Font(Font.SERIF, Font.BOLD,22));
        personaldetails.setBounds(290,80,300,30);
        add(personaldetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nametextfield = new JTextField();
        nametextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnametextfield = new JTextField();
        fnametextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        fnametextfield.setBounds(300,190,400,30);
        add(fnametextfield);

        JLabel dob = new JLabel("Date of Birthday:");
        dob.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        dob.setBounds(100,240,250,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);


        female=new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        othergender=new JRadioButton("Other");
        othergender.setBounds(600,290,100,30);
        othergender.setBackground(Color.WHITE);
        add(othergender);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(othergender);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailtextfield = new JTextField();
        emailtextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        emailtextfield.setBounds(300,340,400,30);
        add(emailtextfield);

        JLabel martial = new JLabel("Martial Status:");
        martial.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        martial.setBounds(100,390,200,30);
        add(martial);

        married=new JRadioButton("married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);


        unmarried=new JRadioButton("unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other=new JRadioButton("Other");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup martialgroup=new ButtonGroup();
        martialgroup.add(married);
        martialgroup.add(unmarried);
        martialgroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addresstextfield = new JTextField();
        addresstextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);

        JLabel city = new JLabel("City:");
        city.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        citytextfield = new JTextField();
        citytextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);

        JLabel state = new JLabel("State:");
        state.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        statetextfield = new JTextField();
        statetextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodetextfield = new JTextField();
        pincodetextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        pincodetextfield.setBounds(300,590,400,30);
        add(pincodetextfield);

        next = new JButton("NEXT");
        next.setBounds(600,640,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);												//after clicking button what should be done that said by action listener.
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = rand;
        String name = nametextfield.getText();
        String fname = fnametextfield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "MALE";
        } else if(female.isSelected()){
            gender = "FEMALE";
        } else if(othergender.isSelected()){
            gender = "OTHER";
        }

        String email = emailtextfield.getText();
        String martial = null;
        if(married.isSelected()){
            gender = "MARRIED";
        } else if(unmarried.isSelected()){
            gender = "UNMARRIED";
        } else if(other.isSelected()){
            gender = "OTHER";
        }

        String address = addresstextfield.getText();
        String city = citytextfield.getText();
        String state = statetextfield.getText();
        String pin = pincodetextfield.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+martial+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne().setVisible(true);
    }
}
