/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.loginModule;

import static unnamedRPG.UnnamedRPG.DATABASE;

/**
 *
 * @author sdyma
 */
public class LoginModel {
    
    LoginViewer viewer;
    public String username = null;
    public String password = null;
    
    public LoginModel(LoginViewer loginViewer) {
        this.viewer = loginViewer;
    }
    
    public boolean userLogin(){
        username = viewer.unInput.getText();
        password = viewer.pwInput.getText();
        if (username != null && password != null) {
            if (DATABASE.checkUser(username, password));
            {
                viewer.show = false;
                return true;
            }
        }
        return false;
    }
    
}
