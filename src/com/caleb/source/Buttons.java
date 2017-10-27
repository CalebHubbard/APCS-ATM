package com.caleb.source;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Buttons {
    
    String currentScreen;
    
    
    SpinnerModel model        = new SpinnerNumberModel(0.00, 0.00, 2000.00, 1.00);     
    JSpinner depositSpinner   = new JSpinner(model);
    JSpinner withdrawlSpinner = new JSpinner(model);
    
    JPanel userLogin      = new JPanel();
    
    JButton deposit           = new JButton("Deposit");
    JButton withdraw          = new JButton("Withdraw");
    JButton checkBalance      = new JButton("Check Balance");
    JButton exit              = new JButton("Exit");
    JButton submit            = new JButton("Submit");
    
    int currentUser;
    
    static ATM atm = new ATM();
    
    public static ATM getATM() {
        return atm;
    }
    
    public Buttons(Dimension size) {
        
        
        deposit.setPreferredSize(size);
        withdraw.setPreferredSize(size);
        checkBalance.setPreferredSize(size);
        exit.setPreferredSize(size);
        submit.setPreferredSize(size);
        
        userLogin.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) { 
                    atm.pressStart();
                } else {
                    atm.userInput += e.getKeyChar();                    
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        userLogin.setFocusable(true);
        userLogin.requestFocusInWindow();
        
        
        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.pressDeposit();
            }
        });
        
        withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.pressWithdraw();
            }
        });
        
        checkBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.pressCheckBalance();
            }
        });
        
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atm.pressExit();
            }
        });
        
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentScreen.equals("deposit")) {
                    ATM.deposit((double) depositSpinner.getValue());
                } else if (currentScreen.equals("withdrawl")) {
                    ATM.withdrawl((double) withdrawlSpinner.getValue());
                }
            }
        });        
    }
    
    
    
    
}
