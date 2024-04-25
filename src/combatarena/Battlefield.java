/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combatarena;

import static combatarena.CombatArena.MAP_LENGTH;
import static combatarena.CombatArena.MAP_WIDTH;
import static combatarena.CombatArena.random;

/**
 *
 * @author seb
 */
public class Battlefield {

    int width, length;

    int[][] topography; // 0 - 4, depending on difficulty
    char[][] terrain;
    
    char grass = '„'; 
    char bush = 'ϫ';
    char tree = 'ϒ';
    char fissure = '|';
    char water = '~';
    

    public Battlefield() {

        this.width = MAP_WIDTH;
        this.length = MAP_LENGTH;
        this.topography = new int[width][length];
        this.terrain = new char[width][length];

        initiatePlane();
        raiseTopography(10, 5);
        sowGrass();
        plantBushes(10);
        plantTrees(2);
        drawFissure();
        formRiver(5);

        printTopography();
        System.out.println("");
        printTerrain();
    }

    void initiatePlane() {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                topography[x][y] = 0;
            }
        }
    }

    void sowGrass() {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                terrain[x][y] = grass;//„ 
            }
        }
    }

    void plantBushes(int density) {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < random.nextInt(density); x++) {
                terrain[random.nextInt(width)][y] = bush;
            }
        }
    }

    void plantTrees(int density) {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < random.nextInt(density); x++) {
                terrain[random.nextInt(width)][y] = tree;
            }
        }
    }

    void drawFissure() {
        int x = random.nextInt(width);
        for (int y = 0; y < 10; y++) {
            System.out.println(x + " " + y);
            terrain[x][y] = fissure;  
            if (random.nextBoolean() && x < (width - 2)) {
                x++;
            } else if (x > 0) {
                x--;
            }
        }
    }

    // Bias can be set
    void formRiver(int riverWidth) {
        int x = random.nextInt(width);
        int randomRigger = 0;
        boolean flowingRight = random.nextBoolean();
        int flowLeftBias = 3;
        
        for (int y = 0; y < length; y++) {
            randomRigger++;
            int depth = -1;
            for (int i = x, j = riverWidth; i < x + riverWidth; i++) {
                if (i > 0 && i < width) {
                    if (terrain[i][y] == water)
                        break;
                    terrain[i][y] = water;
                    topography[i][y] = depth;
                    
                    if(i >= x + riverWidth/2)
                        depth++;
                    else
                        depth--;
                }
            }
            
            if (flowingRight && x < (width - 1)) {
                x++;
            } else if (x > 0) {
                x--;
            }
            
            if(random.nextInt(flowLeftBias)%flowLeftBias == 0 || randomRigger > 6 ) {
                flowingRight = true;
                randomRigger = 0;
            }
            else {
                flowingRight = false;
            }
        }

    }

    void makeHill(int size, int numberNodes) {

        for (int i = 0; i < 10; i++) {

            int sourceX = random.nextInt(width);
            int sourceY = random.nextInt(length);
            int startX = sourceX - size;
            int startY = sourceY - size;

            int endX = sourceX + size;
            int endY = sourceY + size;

            if (startX < 0) {
                startX = 0;
            }
            if (startY < 0) {
                startY = 0;
            }
            if (endX > width) {
                endX = width;
            }
            if (endY > length) {
                endY = length;
            }

            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    if ((y - sourceY) * (y - sourceY) + (x - sourceX)
                            * (x - sourceX) <= (size * size)) {
                        topography[x][y]++;
                    }
                }
            }
        }
    }

    void raiseTopography(int numSourcePoints, int maxRadius) {

        int radius = maxRadius + random.nextInt(3);

        for (int i = 0; i < numSourcePoints; i++) {
            int sourceX = random.nextInt(width);
            int sourceY = random.nextInt(length);
            int startX = sourceX - radius;
            int startY = sourceY - radius;

            int endX = sourceX + radius;
            int endY = sourceY + radius;

            if (startX < 0) {
                startX = 0;
            }
            if (startY < 0) {
                startY = 0;
            }
            if (endX > width) {
                endX = width;
            }
            if (endY > length) {
                endY = length;
            }

            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    if ((y - sourceY) * (y - sourceY) + (x - sourceX)
                            * (x - sourceX) <= (radius * radius)) {
                        topography[x][y]++;
                    }
                }
            }

        }
    }

    void printTopography() {
        for (int y = length - 1; y >= 0; y--) {
            System.out.print("Row: " + y + " ");
            for (int x = 0; x < width; x++) {
                System.out.print(String.format("%3d", topography[x][y]));
            }
            System.out.println("");
        }
    }

    void printTerrain() {
        for (int y = length - 1; y >= 0; y--) {
            System.out.print("Row: " + String.format("%3c", y) + " ");
            for (int x = 0; x < width; x++) {
                System.out.print(String.format("%3s", terrain[x][y]));
            }
            System.out.println("");
        }
    }

}
