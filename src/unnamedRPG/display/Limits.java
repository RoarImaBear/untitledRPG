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

    public Limits(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lengthX = endX - startX;
        this.lengthY = endY- startY;
    }
    
    //128; 64; 32; 16
    
    
    
}
