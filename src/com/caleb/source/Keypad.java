package com.caleb.source;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Keypad {
    JPanel panel = new JPanel(new GridLayout(4,4));
    
    JButton one    = new JButton("1");
    JButton two    = new JButton("2");
    JButton three  = new JButton("3");
    JButton four   = new JButton("4");
    JButton five   = new JButton("5");
    JButton six    = new JButton("6");
    JButton seven  = new JButton("7");
    JButton eight  = new JButton("8");
    JButton nine   = new JButton("9");
    JButton zero   = new JButton("0");
    
    JButton enter  = new JButton("enter");
    JButton period = new JButton(".");
    
    ATM atm = Buttons.getATM();
    
    public Keypad() {
        
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(new JLabel(""));
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(new JLabel(""));
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(zero);
        panel.add(period);
        panel.add(enter);
        
        
        
        
    }
}
