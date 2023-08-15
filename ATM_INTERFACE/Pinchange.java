package banking_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Pinchange extends JFrame implements ActionListener{

    String pinno;
    JPasswordField newpintextfield, repintextfield;
    JButton change, back;

    Pinchange(String pinno){
        this.pinno = pinno;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your Pin!");
        text.setBounds(265,280,180,35);
        text.setFont(new Font(Font.SERIF, Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        JLabel pintext = new JLabel("New Pin: ");
        pintext.setBounds(165,330,180,25);
        pintext.setFont(new Font(Font.SERIF, Font.BOLD,16));
        pintext.setForeground(Color.white);
        image.add(pintext);

        newpintextfield = new JPasswordField();
        newpintextfield.setBounds(320,330,100,25);
        newpintextfield.setFont(new Font(Font.SERIF, Font.BOLD,16));
        newpintextfield.setForeground(Color.black);
        image.add(newpintextfield);

        JLabel repin = new JLabel("Re-enter new pin: ");
        repin.setBounds(165,370,180,25);
        repin.setFont(new Font(Font.SERIF, Font.BOLD,16));
        repin.setForeground(Color.white);
        image.add(repin);

        repintextfield = new JPasswordField();
        repintextfield.setBounds(320,370,100,25);
        repintextfield.setFont(new Font(Font.SERIF, Font.BOLD,16));
        repintextfield.setForeground(Color.black);
        image.add(repintextfield);

        change = new JButton("Change");
        change.setBounds(400,485,80,25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(400,520,80,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try {
                String npin = newpintextfield.getText();
                String rpin = repintextfield.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Please enter correct pin!");
                    return;
                } if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new pin!");
                    return;
                } if( rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter pin!");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinno+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinno+"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinno+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully!!");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }  catch(Exception e){
                System.out.println(e);
            }
        } else{
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Pinchange("");
    }
}
