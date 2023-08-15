package banking_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposite, withdrawl, fastcash, ministatement, balanceenquery, pinchange, transfer, exit;
    String pinno;

    Transactions(String pinno){

        this.pinno = pinno;

        setLayout(null);
        ImageIcon I1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your transaction!");
        text.setBounds(235,300,700,35);
        text.setFont(new Font(Font.SERIF, Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        deposite = new JButton("Deposite");
        deposite.setBounds(170,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fastcash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquery = new JButton("Balance Enquery");
        balanceenquery.setBounds(355,485,150,30);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);

        transfer = new JButton("Transfer");
        transfer.setBounds(170,520,150,30);
        transfer.addActionListener(this);
        image.add(transfer);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        } else if(ae.getSource() == deposite) {
            setVisible(false);
            new Deposite(pinno).setVisible(true);
        } else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinno).setVisible(true);
        } else if(ae.getSource() == transfer){
            setVisible(false);
            new Transfer(pinno).setVisible(true);
        } else if(ae.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinno).setVisible(true);
        } else if(ae.getSource() == ministatement){
//            setVisible(false);
            new MiniStatement(pinno).setVisible(true);
        } else if(ae.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pinno).setVisible(true);
        } else if(ae.getSource() == balanceenquery){
            setVisible(false);
            new BalanceEnquery(pinno).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Transactions("");
    }
}

