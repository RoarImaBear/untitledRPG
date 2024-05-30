/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.loginModule;

/**
 *
 * @author sdyma
 */
public class LoginManager {

    private LoginViewer loginViewer;
    private LoginModel loginModel;
    private LoginController loginController;
    
    public LoginManager() {    
        this.loginViewer = new LoginViewer();
        this.loginModel = new LoginModel(loginViewer);
        this.loginController = new LoginController(loginViewer, loginModel);
    }

    
    public void login(){
        loginViewer.show = true;
        loginViewer.setVisible(true);
        while(loginViewer.show){
            System.out.println(loginViewer.show);
        }
        loginViewer.setVisible(false);
    }
    
}
