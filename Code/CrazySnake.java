
package crazysnake;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;


public class CrazySnake extends Application {
    LowLevelShapes LLS = new LowLevelShapes();
    MiddleLevelShapes MLS = new MiddleLevelShapes();
    MiddleLevelShapes MLS2 = new MiddleLevelShapes();
    HighLevelShapes HiLS = new HighLevelShapes();
    HardLevelShapes HaLS = new HardLevelShapes();
    HardLevelShapes HaLS2 = new HardLevelShapes();
    Audio Sound=new Audio();
    
    @Override
    public void start(Stage primaryStage) {
        
        // Basic Scene
        BasicScene BS = new BasicScene();
        BS.BasicScene(primaryStage);

        // Start Playing Scene
        StartPlayingScene SPS = new StartPlayingScene(BS.btn1, BS.basicscene, LLS, MLS,MLS2, HiLS, HaLS,HaLS2);
        SPS.StartPlayingScene(primaryStage);

        // How To Play Scene
        HowToPlayScene HTPS = new HowToPlayScene(BS.btn2, BS.basicscene);
        HTPS.HowToPlayScene(primaryStage);

        // Exit
        BS.btn3.setOnAction(e -> {
            Sound.ClickSound();
            primaryStage.close();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
