package com.caleb.source;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
    
    JFrame frame;
    
    GridLayout grid     = new GridLayout(3, 3);
    
    JPanel main         = new JPanel(grid);
    JPanel topLeft      = new JPanel();
    JPanel topMiddle    = new JPanel();
    JPanel topRight     = new JPanel();
    JPanel middleLeft   = new JPanel();
    JPanel middleMiddle = new JPanel();
    JPanel middleRight  = new JPanel();
    JPanel bottomLeft   = new JPanel();
    JPanel bottomMiddle = new JPanel();
    JPanel bottomRight  = new JPanel();

    public Window(int width, int height, String name) {
        
        frame = new JFrame(name);
        frame.setSize(width, height);
        
        main.add(topLeft);
        main.add(topMiddle);    //Top row
        main.add(topRight);
        
        main.add(middleLeft);
        main.add(middleMiddle); //Middle row
        main.add(middleRight);
        
        main.add(bottomLeft);
        main.add(bottomMiddle); //Bottom row
        main.add(bottomRight);
        
        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void setTopLeft(Component c) {
        topLeft.add(c);
    }
    public void clearTopLeft() {
        topLeft.removeAll();
    }
    public void setTopMiddle(Component c) {
        topMiddle.add(c);
    }
    public void clearTopMiddle() {
        topMiddle.removeAll();
    }
    public void setTopRight(Component c) {
        topRight.add(c);
    }
    public void clearTopRight() {
        topRight.removeAll();
    }
    public void setMiddleLeft(Component c) {
        middleLeft.add(c);
    }
    public void clearMiddleLeft() {
        middleLeft.removeAll();
    }
    public void setMiddleMiddle(Component c) {
        middleMiddle.add(c);
    }
    public void clearMiddleMiddle() {
        middleMiddle.removeAll();
    }
    public void setMiddleRight(Component c) {
        middleRight.add(c);
    }
    public void clearMiddleRight() {
        middleRight.removeAll();
    }
    public void setBottomLeft(Component c) {
        bottomLeft.add(c);
    }
    public void clearBottomLeft() {
        bottomLeft.removeAll();
    }
    public void setBottomMiddle(Component c) {
        bottomMiddle.add(c);
    }
    public void clearBottomMiddle() {
        bottomMiddle.removeAll();
    }
    public void setBottomRight(Component c) {
        bottomRight.add(c);
    }
    public void clearBottomRight() {
        bottomRight.removeAll();
    }
    public void redraw() {
        frame.setVisible(true);
    }
    public void clear() {
        
        topLeft.removeAll();
        topMiddle.removeAll();
        topRight.removeAll();
        middleLeft.removeAll();
        middleMiddle.removeAll();
        middleRight.removeAll();
        bottomLeft.removeAll();
        bottomMiddle.removeAll();
        bottomRight.removeAll();
        
        main.repaint();
    }
    
}
