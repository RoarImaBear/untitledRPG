/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sdyma
 */
public class ImageAssets {

    public static BufferedImage playerIcon;
    
    
    public ImageAssets() {
        loadImage();
    }

    public void loadImage(){
        try {
            // Load the PNG image
            playerIcon = ImageIO.read(new File("resources/playerIcon.png"));
            System.out.println(playerIcon);
        } catch (IOException e) {
            // Handle image loading errors
            System.out.println("error loading image: " + e.getMessage());
        }
    }
    
}
