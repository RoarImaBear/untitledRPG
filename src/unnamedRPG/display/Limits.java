package unnamedRPG.display;

/**
 *
 * @author seb
 */
public class Limits {
    
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    
    public int lengthX;
    public int lengthY;
    
    public int centerX;
    public int centerY;

    public Limits(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lengthX = endX - startX;
        this.lengthY = endY - startY;
        this.centerX = startX + lengthX/2;
        this.centerY = startY + lengthY/2;
    }
    
    //128; 64; 32; 16
    
    
    
}
