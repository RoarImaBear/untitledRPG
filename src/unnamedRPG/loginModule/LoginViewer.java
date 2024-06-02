/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.loginModule;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import unnamedRPG.utilities.ImageAssets;

/**
 *
 * @author sdyma
 */
public class LoginViewer extends JFrame {

    protected JPanel userPanel;
    protected JLabel playerName = new JLabel("PlayerName: ");
    protected JLabel password = new JLabel("Password: ");
    protected JTextField nameInput = new JTextField(10);
    protected JTextField passwordInput = new JTextField(10);
    protected JLabel wrongName = new JLabel("Wrong username or password.");
    protected JButton loginButton = new JButton("Log in");
    

    public LoginViewer() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 380);
        this.setTitle("UnnamedRPG");

        this.userPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (ImageAssets.loginBackground != null) {
                    g.drawImage(ImageAssets.loginBackground, 0, 50, getWidth(), getHeight(), this);
                }
            }

        };

        userPanel.add(playerName);
        userPanel.add(nameInput);
        userPanel.add(password);
        userPanel.add(passwordInput);
        userPanel.add(loginButton);
        this.add(userPanel);
    }
}
