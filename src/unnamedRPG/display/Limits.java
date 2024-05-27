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
    
    public void shiftDimension (char dimension, int amount){
        switch(dimension){
            case 'x':
                startX += amount;
                if(startX < 0){
                    startX = 0;
                    break;
                }
                endX += amount;
                lengthX += amount;
                centerX += amount;
                break;
            case 'y':
                startY += amount;
                if(startY < 0){
                    startY = 0;
                    break;
                }
                endY += amount;
                lengthY += amount;
                centerY += amount;
                break;
        }
    }
    
    public void resizeLimits(int newLengthX, int newLengthY){
        System.out.println("entered resizeLimits");
        startX = centerX - newLengthX/2;
        startY = centerY - newLengthY/2;
        
        if (startX < 0){
            startX = 0;
        }
        if (startY < 0){
            startY = 0;
        }
        lengthX = newLengthX + 1;
        lengthY = newLengthY + 1;
        endX = startX + lengthX;
        endY = startY + lengthY;

    }
    
    
    //128; 64; 32; 16
    
    
    
}
