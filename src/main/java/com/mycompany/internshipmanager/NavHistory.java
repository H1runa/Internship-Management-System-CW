package com.mycompany.internshipmanager;

import java.util.Stack;
import javax.swing.JPanel;

public class NavHistory {

    private static final Stack<JPanel> nStack = new Stack<>();

    // Private constructor to prevent instantiation
    private NavHistory() {}

    // Static method to provide access to the single stack instance
    public static Stack<JPanel> get() {
        return nStack;
    }
}
