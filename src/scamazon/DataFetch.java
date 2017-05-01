/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scamazon;

/**
 *
 * @author alexbuhler
 */
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class DataFetch extends javax.swing.JFrame implements  ActionListener {
    JTextArea textarea=new JTextArea(5,20);
    JButton b=new JButton("Get Data");
    public void createUI()
    {
        JFrame f=new JFrame();
        f.setLayout(null);
        JLabel label=new JLabel("Database data : ");        
        b.addActionListener((ActionListener) this);
        
        label.setBounds(10,40,100,20);
        textarea.setBounds(120,40,150,60);
        b.setBounds(120,110,100,20);
        
        f.add(label);        
        f.add(textarea);
        f.add(b);
        f.setVisible(true);
        f.setSize(350,200);
    }
//    public static void main(String[] args){
//        DataFetch dd = new DataFetch();
//        dd.createUI();
//    }

    public void actionPerformed(ActionEvent e) {
        b = (JButton)e.getSource();        
        getOperation();
    }
    public void getOperation(){        
       
    }   
   
}
