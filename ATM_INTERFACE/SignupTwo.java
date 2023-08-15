package banking_management_system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField pantextfield, adhartextfield, actextfield, addresstextfield, citytextfield, statetextfield, pincodetextfield;
    JComboBox religionbox, categorybox, Incomebox, educationbox, Occupationbox;
    JButton next;
    JRadioButton yes, no, acyes, acno;
    String formno;

    SignupTwo(String formno){
        this.formno = formno;

        setLayout(null);

        setTitle("NEW APPLICATION FORM: PAGE 2 ");

        JLabel additionaldetails = new JLabel("Page 2: Additional Details:");
        additionaldetails.setFont(new Font(Font.SERIF, Font.BOLD,30));
        additionaldetails.setBounds(250,40,600,40);
        add(additionaldetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font(Font.MONOSPACED, Font.BOLD,18));
        religion.setBounds(100,140,200,30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Shikh", "Christian", "Others"};
        religionbox = new JComboBox(valReligion);
        religionbox.setBounds(300,140,400,30);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        categorybox = new JComboBox(valCategory);
        categorybox.setBounds(300,190,400,30);
        categorybox.setBackground(Color.WHITE);
        add(categorybox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        income.setBounds(100,240,250,30);
        add(income);

        String valIncome[] = {"null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        Incomebox = new JComboBox(valIncome);
        Incomebox.setBounds(300,240,400,30);
        Incomebox.setBackground(Color.WHITE);
        add(Incomebox);

        JLabel education = new JLabel("Educational");
        education.setFont(new Font(Font.MONOSPACED, Font.BOLD,18));
        education.setBounds(100,280,150,30);
        add(education);
        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        Qualification.setBounds(100,300,250,30);
        add(Qualification);

        String valEducation[] = {"non-graduated", "graduated", "post-graduated", "Doctorate", "Others"};
        educationbox = new JComboBox(valEducation);
        educationbox.setBounds(300,290,400,30);
        educationbox.setBackground(Color.WHITE);
        add(educationbox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        Occupationbox = new JComboBox(valOccupation);
        Occupationbox.setBounds(300,340,400,30);
        Occupationbox.setBackground(Color.WHITE);
        add(Occupationbox);

        JLabel pan = new JLabel("Pan Number:");
        pan.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        pan.setBounds(100,390,200,30);
        add(pan);

        pantextfield = new JTextField();
        pantextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        pantextfield.setBounds(300,390,200,30);
        add(pantextfield);

        JLabel adhar = new JLabel("Adhar Number:");
        adhar.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        adhar.setBounds(100,440,200,30);
        add(adhar);

        adhartextfield = new JTextField();
        adhartextfield.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        adhartextfield.setBounds(300,440,200,30);
        add(adhartextfield);


        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        seniorcitizen.setBounds(100,490,200,30);
        add(seniorcitizen);

        yes = new JRadioButton("YES");
        yes.setBounds(300,490,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);


        no = new JRadioButton("NO");
        no.setBounds(400,490,100,30);
        no.setBackground(Color.WHITE);
        add(no);

        JLabel existingac = new JLabel("Existing Account:");
        existingac.setFont(new Font(Font.MONOSPACED, Font.BOLD,18));
        existingac.setBounds(100,540,300,30);
        add(existingac);

        acyes = new JRadioButton("YES");
        acyes.setBounds(300,540,100,30);
        acyes.setBackground(Color.WHITE);
        add(acyes);


        acno = new JRadioButton("NO");
        acno.setBounds(400,540,100,30);
        acno.setBackground(Color.WHITE);
        add(acno);

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
        String religion = (String) religionbox.getSelectedItem();
        String category = (String) categorybox.getSelectedItem();
        String income = (String) Incomebox.getSelectedItem();
        String education = (String) educationbox.getSelectedItem();
        String occupation = (String) Occupationbox.getSelectedItem();

        String seniorcitizen = null;
        if(yes.isSelected()){
            seniorcitizen = "YES";
        } else if(no.isSelected()) {
            seniorcitizen = "NO";
        }

        String existingaccount = null;
        if(acyes.isSelected()){
            existingaccount = "YES";
        } else if(acno.isSelected()) {
            existingaccount = "NO";
        }

        String pan = pantextfield.getText();
        String adhar = adhartextfield.getText();

        try {
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+adhar+"', '"+existingaccount+"', '"+seniorcitizen+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    //signup3 object

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
