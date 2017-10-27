package com.caleb.source;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ATM {
    
    final static int WIDTH = 800;
    final static int HEIGHT = 480;
    final static Dimension BUTTON_SIZE = new Dimension(240, 80);
    
    static Keypad keypad = new Keypad();
    
    JPanel title = new JPanel();
        
    static List<User> users = new ArrayList<User>();
    static List<String> ids = new ArrayList<String>();
    
    static Buttons buttons;
    static Window frame;
    
    static int currentUser;
    
    String userInput = "";
    
    public static void main(String[] args) {

        buttons = new Buttons(BUTTON_SIZE);
        frame = new Window(800, 480, "test");
        
        frame.setTopMiddle(new JLabel("<html>"+"Please swipe your card"+"</html>"));
        frame.setMiddleMiddle(buttons.userLogin);
        frame.redraw();//NUT
        buttons.userLogin.requestFocus();
        
    }
    
    public static void deposit(double money) {   
        
        users.get(currentUser).addMoney(money);
        
        frame.clearMiddleLeft();
        frame.setMiddleLeft(new JLabel("You successfully deposited $" + money + " into your account."));
        
        frame.redraw();
    }
    
    
    public static void withdrawl(double money) {
        frame.clearMiddleLeft();
        
        if (money <= users.get(currentUser).getBalance()) {
            if (money % 20 == 0) {
                double numberOfTwenties = money / 20;
                frame.setMiddleLeft(new JLabel("You withdrew " + (int) numberOfTwenties + " Twenties, which adds up to $" + money));
                users.get(currentUser).getMoney(money);
            } else {
                frame.setMiddleLeft(new JLabel("Please input a number divisible by 20"));
            }
        } else {
            frame.setMiddleLeft(new JLabel("You cannot make your account go negative"));
        }
        frame.redraw();
    }
    
    public void pressStart() {
        buttons.currentScreen = "menu";
        frame.clear();
        if (!ATM.ids.contains(userInput)) {
            User user = new User(userInput, 1234, 0);
            ATM.users.add(user);
            ATM.ids.add(user.getId());
            currentUser = ATM.users.size() - 1;
        } else {
            currentUser = ATM.ids.indexOf(userInput);
        }
        
        //adding buttons to main's grid layout
        frame.setMiddleLeft(buttons.deposit);
        frame.setMiddleRight(buttons.withdraw);
        frame.setBottomLeft(buttons.checkBalance);
        frame.setBottomRight(buttons.exit);
        
        frame.redraw();
    }
    public void pressDeposit() {
        buttons.currentScreen = "deposit";
        frame.clear();
        frame.redraw();
        frame.setMiddleLeft(new JLabel("How much would you like to deposit?"));
        frame.setMiddleMiddle(buttons.depositSpinner);
        frame.setMiddleRight(buttons.submit);
        
        frame.setBottomRight(buttons.exit);
        
        frame.redraw();
    }
    public void pressWithdraw() {
        buttons.currentScreen = "withdrawl";
        frame.clear();
        frame.setMiddleLeft(new JLabel("How much would you like to withdraw?"));
        frame.setMiddleMiddle(buttons.withdrawlSpinner);
        frame.setMiddleRight(buttons.submit);
        
        frame.setBottomRight(buttons.exit);
        
        frame.redraw();
    }
    public void pressCheckBalance() {
        buttons.currentScreen = "checkBalance";
        
        frame.clear();
        frame.setMiddleMiddle(new JLabel("Your current balance is $" + users.get(currentUser).getBalance()));
        
        frame.setBottomRight(buttons.exit);
        
        frame.redraw();
    }
    public void pressExit() {
        frame.clear();
        if (buttons.currentScreen.equals("menu")) {
            buttons.currentScreen = "start";
            frame.setMiddleMiddle(buttons.userLogin);
            buttons.userLogin.setFocusable(true);
            buttons.userLogin.requestFocusInWindow();
            userInput = "";
            frame.setTopMiddle(new JLabel("Please swipe your card"));
        } else {
            buttons.currentScreen = "menu";
            frame.setMiddleLeft(buttons.deposit);
            frame.setMiddleRight(buttons.withdraw);
            frame.setBottomLeft(buttons.checkBalance);
            frame.setBottomRight(buttons.exit);
        }
        
        frame.redraw();
    }
    
    
}