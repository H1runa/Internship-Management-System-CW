package com.mycompany.internshipmanager.custom_ui;

import com.mycompany.internshipmanager.NavHistory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Asus
 */
public class BackButton extends JButton {
    
    public BackButton(String text, JPanel panel){
        super(text);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                Stack<JPanel> st = NavHistory.get();   
                JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(panel);
                
                if(st.size() > 1){
                
                    frame.getContentPane().removeAll();
                    st.pop();

                    frame.add(st.peek(), "dock north, span");
                    frame.revalidate();
                    frame.repaint(); 
                } else {
                    System.out.println("Navigation History is empty");
                }
            }
        });
    }
    
}
