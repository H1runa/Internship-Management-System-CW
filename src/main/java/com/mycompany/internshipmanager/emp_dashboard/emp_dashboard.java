package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.custom_ui.GlassPane;
import com.mycompany.internshipmanager.models.Internship;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class emp_dashboard extends javax.swing.JFrame {

    /**
     
     */
    private InternshipController c = new InternshipController();
    public GlassPane gp;
            
    
    public emp_dashboard() {
        initComponents();
        init();
        updateInternshipList();
    }        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_panel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        itemList_panel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("Employer Dashboard");
        background_panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 360, 43));

        scrollpane.setViewportView(itemList_panel);

        background_panel.add(scrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 650, 340));

        addButton.setText("Add");
        background_panel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, -1, -1));

        getContentPane().add(background_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(emp_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emp_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emp_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emp_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new emp_dashboard().setVisible(true);
            }
        });
    }
    
    private void init(){
        //setting up the internship list view
        itemList_panel.setLayout(new MigLayout("wrap"));
        TitledBorder scrollpaneborder = BorderFactory.createTitledBorder("Internships");
        scrollpaneborder.setTitlePosition(TitledBorder.CENTER);
        scrollpaneborder.setTitleJustification(TitledBorder.CENTER);
        scrollpane.setBorder(scrollpaneborder);
        
        //setting up add button
        addButton.addActionListener(e -> {
            gp.setVisible(true);
            new InternshipAddForm(emp_dashboard.this){{addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    gp.setVisible(false);
                }
                
            });}};
        });
        
        //setting up glass pane
        gp = new GlassPane(this);
        setGlassPane(gp); gp.setVisible(false);
    }
    
    public void updateInternshipList(){
        itemList_panel.removeAll();
        List<Internship> list = c.getInternships();
        for (Internship i:list){
            empItemPanel item = new empItemPanel(i.getId(), i.getTitle(), i.getDuration(), i.getStatus(), emp_dashboard.this);
            itemList_panel.add(item);
        }
        
        revalidate();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel background_panel;
    private javax.swing.JPanel itemList_panel;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
