/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.loginModule;

import java.util.concurrent.CountDownLatch;
import static unnamedRPG.UnnamedRPG.DATABASE;

/**
 *
 * @author sdyma
 */
public class LoginModel {
    
    private LoginViewer viewer;
    private final CountDownLatch latch;
    public String playerName = null;
    public String password = null;
    
    public LoginModel(LoginViewer loginViewer, CountDownLatch latch) {
        this.latch = latch;
        this.viewer = loginViewer;
    }
    
    public boolean userLogin(){
        playerName = viewer.nameInput.getText();
        password = viewer.passwordInput.getText();
        if (playerName != null && password != null) {
            if (DATABASE.manageUserLogin(playerName, password));
            {
                System.out.println("Welcome " + playerName + ".");
                DATABASE.updatePlayerName(playerName);
                latch.countDown();
                return true;
            }
        }
        return false;
    }
    
}
