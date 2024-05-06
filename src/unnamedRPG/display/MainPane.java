//
//package unnamedRPG.display;
//
//import static unnamedRPG.UnnamedRPG.FRAME_HEIGHT;
//import static unnamedRPG.UnnamedRPG.FRAME_WIDTH;
//import java.awt.Color;
//import javax.swing.JFrame;
//import javax.swing.JLayeredPane;
//import javax.swing.Timer;
//import unnamedRPG.Map;
//
///**
// * @author Sebastian Dymanski
// * @id 14850975
// */
//public class MainPane extends JLayeredPane  {
//
//    Color color;
//    Map map;
//    Camera camera;
//    JFrame frame;
//    Timer timer;
//    GameBoardComponent gameBoard;
//    TokenLayer tokenLayer;
//    
//    
//    int frameTracker = 0;
//    public MainPane(JFrame frame, Map map, Camera camera) {
//        this.frame = frame;
//        this.map = map;
//        this.camera = camera;
//        
//        this.setFocusable(true);
//        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
//        
//        this.gameBoard  = new GameBoardComponent(map, camera, boardXYLimits);
//        gameBoard.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
//        this.add(gameBoard, 100);
//        
//        this.tokenLayer = new TokenLayer(map, camera);
//        tokenLayer.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
//        this.add(tokenLayer, 100);
//        
//        setComponentZOrder(gameBoard, 1);
//        setComponentZOrder(tokenLayer, 0); 
//
//    }
//    
//    public void refresh() {
//        if(frameTracker%10 == 0) {
//            //terrainLayer.repaint();
//            tokenLayer.repaint();
//        }
//        frameTracker++;
//    }
//}
