package unnamedRPG.display;

/**
 *
 * @author seb
 */
public class Limits {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private int lengthX;
    private int lengthY;

    private int centerX;
    private int centerY;

    public Limits(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lengthX = endX - startX;
        this.lengthY = endY - startY;
        this.centerX = startX + lengthX / 2;
        this.centerY = startY + lengthY / 2;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getLengthX() {
        return lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void shiftPosition(char axis, int amount) {
        switch (axis) {
            case 'x':
                startX += amount;
                if (startX < 0) {
                    startX = 0;
                    break;
                }
                endX += amount;
                lengthX += amount;
                centerX += amount;
                break;
            case 'y':
                startY += amount;
                if (startY < 0) {
                    startY = 0;
                    break;
                }
                endY += amount;
                lengthY += amount;
                centerY += amount;
                break;
        }
    }

    public void goTo(int x, int y) {
        if(x < 0)
            x = 0;
        if(y < 0)
            y = 0;
        this.startX = x;
        this.startY = y;
        this.endX = x + this.lengthX;
        this.endY = y + this.lengthY;
        this.centerX = startX + this.lengthX / 2;
        this.centerY = startY + this.lengthY / 2;
    }

    public void resizeLimits(int newLengthX, int newLengthY) {
        startX = centerX - newLengthX / 2;
        startY = centerY - newLengthY / 2;

        if (startX < 0) {
            startX = 0;
        }
        if (startY < 0) {
            startY = 0;
        }
        lengthX = newLengthX + 1;
        lengthY = newLengthY + 1;
        endX = startX + lengthX;
        endY = startY + lengthY;
    }
}
