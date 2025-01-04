package com.mycompany.internshipmanager.custom_components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class SideMenu extends javax.swing.JPanel {

    /**
     * Creates new form SideMenu
     */
    public SideMenu() {
        initComponents();
        setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics g) {
        int arc = 15;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#73c8a9"), 0, getHeight(), Color.decode("#373b44"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
        g2.fillRect(arc, 0, getWidth()-arc, getHeight());
        super.paintChildren(g);
    }
    
    private int x;
    private int y;
    
    public void initMoving(JFrame frame){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){                
                x = e.getX();
                y = e.getY();
            }
            });
        addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                int newx = e.getXOnScreen()-x;
                int newy = e.getYOnScreen()-y;
                
                frame.setLocation(newx, newy);
            }
            });       
            
            
            
       
    }

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}