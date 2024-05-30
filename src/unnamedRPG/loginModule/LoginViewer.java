/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.loginModule;

import java.util.concurrent.CountDownLatch;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sdyma
 */
public class LoginViewer extends JFrame {
    
    protected JPanel userPanel = new JPanel();
    protected JPanel calcPanel = new JPanel();
    protected JLabel playerName = new JLabel("PlayerName: ");
    protected JLabel password = new JLabel("Password: ");
    protected JTextField nameInput = new JTextField(10);
    protected JTextField passwordInput = new JTextField(10);
    protected JLabel wrongName = new JLabel("Wrong username or password.");
    protected JButton loginButton = new JButton("Log in");
    
    
    public LoginViewer() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        userPanel.add(playerName);
        userPanel.add(nameInput);
        userPanel.add(password);
        userPanel.add(passwordInput);
        userPanel.add(loginButton);
        this.add(userPanel);
    }

    void displayExitScreen (int score){
        JPanel quitPanel = new JPanel();
            JLabel scoreLabel = new JLabel("Your score: " + score);
            quitPanel.add(scoreLabel);
            this.getContentPane().removeAll();
            this.add(quitPanel);
            this.revalidate();
            this.repaint();
    }
}
