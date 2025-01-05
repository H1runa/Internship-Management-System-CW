package com.mycompany.internshipmanager.emp_dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class empItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form empItemPanel
     */
    public empItemPanel(String t, int d, String s) {
        initComponents();
        
        setLayout(new MigLayout("fill, insets 10", "[33%][33%][33%]", "[]"));
        
        
        JLabel title= new JLabel(t);
        JLabel duration = new JLabel("Duration: " + String.valueOf(d));
        JLabel status = new JLabel(s);
        
        title.setForeground(Color.black);
        duration.setForeground(Color.black);
        if (s.equals("Open")){
            status.setForeground(Color.green);
        } else if (s.equals("Closed")){
            status.setForeground(Color.red);
    }
        
        
        Dimension size = new Dimension(620, 50);
        
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        
        add(title, "cell 0 0, align left");
        add(duration, "cell 1 0 , align center");
        add(status, "cell 2 0, align center");
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
