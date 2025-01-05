package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.InternshipController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class empItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form empItemPanel
     */
    private emp_dashboard dash;
    
    public empItemPanel(int id, String t, int d, String s, emp_dashboard dash) {
        initComponents();
        
        this.dash = dash;
        
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
        
        
        //adding the context menu
        JPopupMenu contextmenu = new JPopupMenu();
        
        JMenuItem update = new JMenuItem("Update");
        JMenuItem delete = new JMenuItem("Delete");
        JMenuItem view_appl = new JMenuItem("View Applications");
        JMenuItem view_ongoing = new JMenuItem("View Ongoing Internships");
        JMenuItem view_cancelled = new JMenuItem("View Cancelled Internships");
        
        update.addActionListener(e->{
            dash.gp.setVisible(true);
            new InternshipUpdateForm(dash, id){{addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    dash.gp.setVisible(false); //hiding the glass pane once the jdialog is closed
                }
                
            });}};
        });
        
        delete.addActionListener(e-> {            
            InternshipController control = new InternshipController();
            try{
                control.deleteInternship(id);
                dash.updateInternshipList();
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Record could not be deleted", "Database Error", JOptionPane.ERROR_MESSAGE);
                }
        });
        
        view_appl.addActionListener(e-> {
            dash.gp.setVisible(true);
            new ViewApplicationsList("Dialog", true, id, dash){{
                addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {   
                        super.windowClosed(e);
                        dash.gp.setVisible(false);
                    }
                    
                });
            }};
        });
        
        view_ongoing.addActionListener(e->{
            dash.gp.setVisible(true);
            new ViewInternshipsList(dash, id, "Ongoing"){{
                addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        dash.gp.setVisible(false);
                    }
                    
                });
            }};
        });
        view_cancelled.addActionListener(e -> {
            dash.gp.setVisible(true);
            new ViewInternshipsList(dash, id, "Cancelled"){{
                addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        dash.gp.setVisible(false);
                    }
                    
                });
            }};
        });
        
        contextmenu.add(update); contextmenu.add(delete); contextmenu.add(view_appl); contextmenu.add(view_ongoing);
        contextmenu.add(view_cancelled);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == 3){                    
                    super.mousePressed(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    contextmenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            
        });
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
