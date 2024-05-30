/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.loginModule;

import java.util.concurrent.CountDownLatch;
import unnamedRPG.model.entities.Player;

/**
 *
 * @author sdyma
 */
public class LoginManager {

    private final LoginViewer loginViewer;
    private final LoginModel loginModel;
    private final LoginController loginController;
    private final CountDownLatch latch;
    
    public LoginManager() {    
        this.latch = new CountDownLatch(1);
        this.loginViewer = new LoginViewer();
        this.loginModel = new LoginModel(loginViewer, latch);
        this.loginController = new LoginController(loginViewer, loginModel);
    }
    
    public void login(){
        loginViewer.setVisible(true);
        try {
            latch.await();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        loginViewer.setVisible(false);
    }
    
}
