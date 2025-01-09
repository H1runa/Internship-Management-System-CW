package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.ApplicationController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.Application;
import com.mycompany.internshipmanager.models.Student;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class ViewApplicationsList extends javax.swing.JDialog {

    /**
     * Creates new form ViewApplicationsList
     */
    private int id; //employer id
    private emp_dashboard dash;
    private JPanel panel;
    
    public ViewApplicationsList(String title, boolean modal, int id, emp_dashboard dash) {
        super(dash, title, modal);
        this.dash = dash;
        this.id = id;
        initComponents();
        init();
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
            .addGap(0, 383, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init(){
        
        setLayout(new MigLayout("fill"));
        
        JScrollPane scrollpane = new JScrollPane();        
        panel = new JPanel(new MigLayout("fillx, flowy"));
        JPanel buttonPanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]", "[]"));
        scrollpane.setBorder(BorderFactory.createTitledBorder("Select Application"));
                        
        loadApplicationItems(); //loads in the application item for the selected internship
        
        JButton close = new JButton("Close"){{addActionListener(e -> { //adding action listener to close button
            ViewApplicationsList.this.dispose();        });}}; 
        
        buttonPanel.add(close, "cell 1 0, align center");
        
        add(buttonPanel, "dock south");
        
        scrollpane.setViewportView(panel);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollpane, "dock center");
        setSize(600, 400);
        setLocationRelativeTo(this.dash);
        setUndecorated(true);
        setVisible(true);  
    }
    
    public void loadApplicationItems(){        
        //loading the items
        panel.removeAll();
        Dimension itemPanelSize = new Dimension(560,50);
        ApplicationController applControl = new ApplicationController();
        StudentController stdControl = new StudentController();
        List<Application> applList = applControl.getApplications();
        
        for (Application appl : applList){
            if (appl.getInternship_id() == this.id && appl.getStatus().equals("To be reviewed")){
                JPanel itemPanel = new JPanel(new MigLayout("fill, insets 10", "[33%][33%][33%]", "[]"));
                itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                itemPanel.setPreferredSize(itemPanelSize);
                itemPanel.setMinimumSize(itemPanelSize);
                itemPanel.setMaximumSize(itemPanelSize);
                itemPanel.setBackground(Color.decode("#556270"));
                
                itemPanel.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        itemPanel.setBackground(Color.white);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        itemPanel.setBackground(Color.decode("#556270"));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        new ViewApplication(ViewApplicationsList.this, appl.getApplication_id(), dash.empId);
                    }
                    
                    
                    
                });
                
                Student std = stdControl.getStudentByID(appl.getStu_id());
                itemPanel.add(new JLabel(std.getFirst_name() + " " + std.getLast_name()){{setForeground(Color.black);}}, "cell 0 0");
                itemPanel.add(new JLabel(appl.getDate()){{setForeground(Color.black);}}, "cell 1 0");
                itemPanel.add(new JLabel(appl.getStatus()){{setForeground(Color.black);}}, "cell 2 0");
                panel.add(itemPanel);
            }
        }
        revalidate();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
