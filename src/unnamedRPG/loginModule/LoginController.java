/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.loginModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author sdyma
 */
public class LoginController extends JFrame{    
    private LoginViewer viewer;
    private LoginModel model;

    public LoginController(LoginViewer loginViewer, LoginModel loginModel) {
        this.model = loginModel;
        this.viewer = loginViewer;
        initializeListeners();
    }


    void initializeListeners() {  
        viewer.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLoginButton();
            }
        });
    }
    
    void handleLoginButton(){
        if (model.userLogin()){
            System.out.println("You've successfully logged in.");
        } else {
            System.out.println("Couldn't login.");
        }
    }
}
