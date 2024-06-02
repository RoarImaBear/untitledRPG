/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unnamedRPG.model;

import static unnamedRPG.UnnamedRPG.RANDOM;

/**
 *
 * @author sdyma
 */
public class FloraGod {
    
    private Tile tiles[][];

    private int mapLength;
    private int mapWidth;
    
    public FloraGod(int mapWidth, int mapLength) {
        this.mapLength = mapLength;
        this.mapWidth = mapWidth;
  
    }

    
    public void floraSpawn(Tile[][] tiles){
        this.tiles = tiles;
        sowGrass();
        plantTrees(100);
        plantBushes(300);       
        for (int i = 0; i < 500; i++) {
            plantForest(100, 20);
        }        
        for (int i = 0; i < 100; i++) {
            formRiver(RANDOM.nextInt(5));
        }    
    }
    
    void sowGrass() {
        for (int y = 0; y < mapLength; y++) {
            for (int x = 0; x < mapWidth; x++) {
                tiles[x][y].terrainType = '„';//„ 
            }
        }
    }
    
    void plantBushes(int density) {
        for (int y = 0; y < mapLength; y++) {
            for (int x = 0; x < RANDOM.nextInt(density); x++) {
                tiles[RANDOM.nextInt(mapWidth)][y].terrainType = 'ϫ';
            }
        }
    }
//
    void plantTrees(int density) {
        for (int y = 0; y < mapLength; y++) {
            for (int x = 0; x < RANDOM.nextInt(density); x++) {
                tiles[RANDOM.nextInt(mapWidth)][y].terrainType = 'ϒ';
            }
        }
    }

    // Bias can be set
    void formRiver(int riverWidth) {
        int x = RANDOM.nextInt(mapWidth);
        int randomRigger = 0;
        boolean flowingRight = RANDOM.nextBoolean();
        int flowLeftBias = 3;
        int depth = -1;

        for (int y = 0; y < mapLength; y++) {
            randomRigger++;
            for (int i = x, j = riverWidth; i < x + riverWidth; i++) {
                if (i > 0 && i < mapWidth) {
                    if (tiles[i][y].terrainType == '~') {
                        break;
                    }
                    tiles[i][y].terrainType = '~';
                    //topography[i][y] = depth;
                }
            }

            if (flowingRight && x < (mapWidth - 1)) {
                x++;
            } else if (x > 0) {
                x--;
            }

            if (RANDOM.nextInt(flowLeftBias) % flowLeftBias == 0 || randomRigger > 6) {
                flowingRight = true;
                randomRigger = 0;
            } else {
                flowingRight = false;
            }
        }

    }

    void plantForest(int size, int density) {
        int radius = size/2 + RANDOM.nextInt(size/2);
        int sourceX = RANDOM.nextInt(mapWidth);
        int sourceY = RANDOM.nextInt(mapLength);
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
        if (endX > mapWidth) {
            endX = mapWidth;
        }
        if (endY > mapLength) {
            endY = mapLength;
        }

        if (startX < 0) {
            startX = 0;
        }
        if (startY < 0) {
            startY = 0;
        }
        if (endX > mapWidth) {
            endX = mapWidth;
        }
        if (endY > mapLength) {
            endY = mapLength;
        }

        for (int i = 0; i < density; i++) {
            int parcelRadius = RANDOM.nextInt(size / 10);
            int parcelSourceX = startX + RANDOM.nextInt(size);
            int parcelSourceY = startY + RANDOM.nextInt(size);
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
                    if ( RANDOM.nextInt(8)%8 == 0 && (y - parcelSourceY) * (y - parcelSourceY) + (x - parcelSourceX)
                            * (x - parcelSourceX) <= (parcelRadius * parcelRadius)+1) {
                        tiles[x][y].terrainType = 'ϒ';
                    }
                }
            }
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