package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.controllers.PlacementController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.Internship;
import com.mycompany.internshipmanager.models.Placement;
import com.mycompany.internshipmanager.models.Student;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class ViewInternshipsList extends javax.swing.JDialog {

    private emp_dashboard dash;
    private JPanel panel;
    private int emp_id;
    private String state;
    
    public ViewInternshipsList(emp_dashboard dash, int id, String state) {
        super(dash, "View Internships", true);
        this.state = state;
        this.emp_id = id;
        initComponents();
        init();
    }
    
    private void init(){
        setLayout(new MigLayout("fill"));
        
        JScrollPane scrollpane = new JScrollPane();        
        panel = new JPanel(new MigLayout("fillx, flowy"));
        JPanel buttonPanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]", "[]"));
        scrollpane.setBorder(BorderFactory.createTitledBorder("Ongoing Internships"));
                        
        loadApplicationItems(); //loads in the application item for the selected internship
        
        JButton close = new JButton("Close"){{addActionListener(e -> { //adding action listener to close button
        ViewInternshipsList.this.dispose();        });}}; 
        
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
        //loading items
        panel.removeAll();
        Dimension itemPanelSize = new Dimension(560,50);
        PlacementController plaControl = new PlacementController();
        StudentController stdControl = new StudentController();
        InternshipController internControl = new InternshipController();
        List<Placement> plaList = plaControl.getPlacements();
        
        for (Placement p:plaList){
            if(p.getStatus().equals(state) && emp_id == p.getEmp_id()){
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
                        new ViewInternship(ViewInternshipsList.this, p.getPlacement_id(), p.getStatus());
                    }
                    
                });
                
                Student std = stdControl.getStudentByID(p.getStd_id());
                Internship intern = internControl.getInternshipByID(p.getInternship_id());
                itemPanel.add(new JLabel(std.getFirst_name() + " " + std.getLast_name()){{setForeground(Color.black);setFont(getFont().deriveFont(Font.PLAIN, 20f));}}, "cell 0 0");
                itemPanel.add(new JLabel(intern.getTitle()){{setForeground(Color.black);setFont(getFont().deriveFont(Font.PLAIN, 20f));}}, "cell 1 0");
                itemPanel.add(new JLabel(p.getStatus()){{setFont(getFont().deriveFont(Font.PLAIN, 20f));
                    if(p.getStatus().equals("Ongoing")){
                        setForeground(Color.green);
                    } else if (p.getStatus().equals("Cancelled")){
                        setForeground(Color.red);
                    } else if (p.getStatus().equals("Finished")){
                        setForeground(Color.yellow);
                    }
                }}, "cell 2 0");
                panel.add(itemPanel);
            }
        }
        revalidate();
        repaint();
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
