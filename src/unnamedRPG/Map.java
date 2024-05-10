/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG;

import static unnamedRPG.UnnamedRPG.MAP_LENGTH;
import static unnamedRPG.UnnamedRPG.MAP_WIDTH;
import static unnamedRPG.UnnamedRPG.random;
import unnamedRPG.entities.Entity;
import unnamedRPG.entities.Player;

/**
 *
 * @author seb
 */
public class Map {

    int width, length;

    public int[][] topography; // 0 - 4, depending on difficulty
    public Tile[][] tiles;
    public Entity[][] entities;



    public Map() {

        this.width = MAP_WIDTH;
        this.length = MAP_LENGTH;
        this.topography = new int[width][length];
        this.tiles = new Tile[width][length];
        this.entities = new Entity[width][length];
        
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = new Tile();
            }
        }
        
        sowGrass();

        plantTrees(100);
        plantBushes(300);
        
        for (int i = 0; i < 1500; i++) {
            plantForest(100, 100);
        }
        
        for (int i = 0; i < 100; i++) {
            formRiver(random.nextInt(5));
        }
        

        
    }

    
    
//            initiatePlane();
//        raiseTopography(10, 5);
//        sowGrass();
//        plantBushes(120);
//        //plantTrees(70);
//        drawFissure();
//
//        for (int i = 0; i < 100; i++) {
//            plantForest(10, 100);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            formRiver(3);
//        }
//
//        insertPlayer();
    
    
//    void insertPlayer() {
//        entities[width / 2][length / 2] = new Player();
//
//    }
//
//    void initiatePlane() {
//        for (int y = 0; y < length; y++) {
//            for (int x = 0; x < width; x++) {
//                topography[x][y] = 0;
//            }
//        }
//    }
//
    void sowGrass() {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y].terrainType = '„';//„ 
            }
        }
    }
    
    void plantBushes(int density) {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < random.nextInt(density); x++) {
                tiles[random.nextInt(width)][y].terrainType = 'ϫ';
            }
        }
    }
//
    void plantTrees(int density) {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < random.nextInt(density); x++) {
                tiles[random.nextInt(width)][y].terrainType = 'ϒ';
            }
        }
    }
//
//    void drawFissure() {
//        int x = random.nextInt(width);
//        for (int y = 0; y < 10; y++) {
//            terrain[x][y] = fissure;
//            if (random.nextBoolean() && x < (width - 2)) {
//                x++;
//            } else if (x > 0) {
//                x--;
//            }
//        }
//    }
//
    // Bias can be set
    void formRiver(int riverWidth) {
        int x = random.nextInt(width);
        int randomRigger = 0;
        boolean flowingRight = random.nextBoolean();
        int flowLeftBias = 3;
        int depth = -1;

        for (int y = 0; y < length; y++) {
            randomRigger++;
            for (int i = x, j = riverWidth; i < x + riverWidth; i++) {
                if (i > 0 && i < width) {
                    if (tiles[i][y].terrainType == '~') {
                        break;
                    }
                    tiles[i][y].terrainType = '~';
                    //topography[i][y] = depth;
                }
            }

            if (flowingRight && x < (width - 1)) {
                x++;
            } else if (x > 0) {
                x--;
            }

            if (random.nextInt(flowLeftBias) % flowLeftBias == 0 || randomRigger > 6) {
                flowingRight = true;
                randomRigger = 0;
            } else {
                flowingRight = false;
            }
        }

    }
//
//    void makeHill(int size, int numberNodes) {
//
//        for (int i = 0; i < 10; i++) {
//
//            int sourceX = random.nextInt(width);
//            int sourceY = random.nextInt(length);
//            int startX = sourceX - size;
//            int startY = sourceY - size;
//
//            int endX = sourceX + size;
//            int endY = sourceY + size;
//
//            if (startX < 0) {
//                startX = 0;
//            }
//            if (startY < 0) {
//                startY = 0;
//            }
//            if (endX > width) {
//                endX = width;
//            }
//            if (endY > length) {
//                endY = length;
//            }
//
//            for (int y = startY; y < endY; y++) {
//                for (int x = startX; x < endX; x++) {
//                    if ((y - sourceY) * (y - sourceY) + (x - sourceX)
//                            * (x - sourceX) <= (size * size)) {
//                        topography[x][y]++;
//                    }
//                }
//            }
//        }
//    }
//
//    void raiseTopography(int numSourcePoints, int maxRadius) {
//
//        int radius = maxRadius + random.nextInt(3);
//
//        for (int i = 0; i < numSourcePoints; i++) {
//            int sourceX = random.nextInt(width);
//            int sourceY = random.nextInt(length);
//            int startX = sourceX - radius;
//            int startY = sourceY - radius;
//
//            int endX = sourceX + radius;
//            int endY = sourceY + radius;
//
//            if (startX < 0) {
//                startX = 0;
//            }
//            if (startY < 0) {
//                startY = 0;
//            }
//            if (endX > width) {
//                endX = width;
//            }
//            if (endY > length) {
//                endY = length;
//            }
//
//            for (int y = startY; y < endY; y++) {
//                for (int x = startX; x < endX; x++) {
//                    if ((y - sourceY) * (y - sourceY) + (x - sourceX)
//                            * (x - sourceX) <= (radius * radius)) {
//                        topography[x][y]++;
//                    }
//                }
//            }
//        }
//    }
//
    void plantForest(int size, int density) {

        size = 30;
        density = 80;
        
        int radius = random.nextInt(size);
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

        for (int i = 0; i < density; i++) {
            int parcelRadius = random.nextInt(size / 10);
            int parcelSourceX = startX + random.nextInt(size);
            int parcelSourceY = startY + random.nextInt(size);
            int parcelStartX = parcelSourceX - radius;
            int parcelStartY = parcelSourceY - radius;
            int parcelEndX = parcelSourceX + radius;
            int parcelEndY = parcelSourceY + radius;

            if (parcelStartX < startX) {
                parcelStartX = startX;
                radius = radius / 2;
            }

            if (parcelStartY < startY) {
                parcelStartY = startY;
                radius--;
            }
            if (parcelEndX > endX) {
                parcelEndX = endX;
                radius--;
            }
            if (parcelEndY > endY) {
                parcelEndY = endY;
                radius--;
            }

            for (int y = parcelStartY; y < parcelEndY; y++) {
                for (int x = parcelStartX; x < parcelEndX; x++) {
                    if ( random.nextInt(2)%2 != 0 && (y - parcelSourceY) * (y - parcelSourceY) + (x - parcelSourceX)
                            * (x - parcelSourceX) <= (parcelRadius * parcelRadius)+1) {
                        tiles[x][y].terrainType = 'ϒ';
                    }
                }
            }
        }
    }
//
//    void printTopography() {
//        for (int y = length - 1; y >= 0; y--) {
//            System.out.print("Row: " + y + " ");
//            for (int x = 0; x < width; x++) {
//                System.out.print(String.format("%3d", topography[x][y]));
//            }
//            System.out.println("");
//        }
//    }
//
//    void printTerrain() {
//        for (int y = length - 1; y >= 0; y--) {
//            System.out.print("Row: " + String.format("%3c", y) + " ");
//            for (int x = 0; x < width; x++) {
//                System.out.print(String.format("%3s", terrain[x][y]));
//            }
//            System.out.println("");
//        }
//    }

}
