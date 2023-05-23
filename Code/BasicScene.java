
package crazysnake;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BasicScene {

        private AudioClip backgroundMusic;
        private boolean isSoundPlaying;
        Button btn1 = new Button("Start Playing");
        Button btn2 = new Button(" How to play ");
        Button btn3 = new Button("      Exit      ");
        BorderPane p2 = new BorderPane();
        Scene basicscene = new Scene(p2, 750, 500);
        Audio Sound=new Audio();
    
    public void BasicScene(Stage primaryStage){
        
        
        Pane pane1 = new Pane();
        Image image = new Image(getClass().getResourceAsStream("/images/Background.jpg"));
        ImageView IV = new ImageView(image);
        pane1.getChildren().add(IV);
        Text txt = new Text("Crazy Snake  ");

        txt.setFill(Color.rgb(220, 120, 50, 1));
        txt.setStroke(Color.BLACK);
        txt.setFont(Font.font("Snap ITC", FontWeight.BOLD, 40));
        VBox VB = new VBox(30);
        //  start button
        btn1.setStyle("-fx-font: bold 15px Adobe ;"
                + "-fx-font-family: 'Goudy Old Style';"
                + "-fx-text-fill: yellow;"
                + "-fx-background-color: brown;"
                + "-fx-background-radius: 50;"
                + "-fx-border-color: orange;"
                + "-fx-border-radius:50;"
                + "-fx-padding:15;");
        // how to play button
        btn2.setStyle("-fx-font: bold 15px Adobe ;"
                + "-fx-font-family: 'Goudy Old Style';"
                + "-fx-text-fill: yellow;"
                + "-fx-background-color: brown;"
                + "-fx-background-radius: 50;"
                + "-fx-border-color: orange;"
                + "-fx-border-radius: 50;"
                + "-fx-padding: 15;");
        // exit button
        btn3.setStyle("-fx-font: bold 15px Adobe ;"
                + "-fx-font-family: 'Goudy Old Style';"
                + "-fx-text-fill: yellow;"
                + "-fx-background-color: brown;"
                + "-fx-background-radius: 50;"
                + "-fx-border-color: orange;"
                + "-fx-border-radius: 50;"
                + "-fx-padding: 15;");

        btn1.setOnMouseEntered(e -> {
            btn1.setStyle("-fx-font: bold 18px Adobe ;"
                    + "-fx-font-family: 'Goudy Old Style';"
                    + "-fx-text-fill: yellow;"
                    + "-fx-background-color: silver;"
                    + "-fx-background-radius: 50;"
                    + "-fx-border-color: black;"
                    + "-fx-border-radius: 50;"
                    + "-fx-padding: 15;");
        });
        btn1.setOnMouseExited(e -> {
            btn1.setStyle("-fx-font: bold 15px Adobe ;"
                    + "-fx-font-family: 'Goudy Old Style';"
                    + "-fx-text-fill: yellow;"
                    + "-fx-background-color: brown;"
                    + "-fx-background-radius: 50;"
                    + "-fx-border-color: orange;"
                    + "-fx-border-radius: 50;"
                    + "-fx-padding: 15;");
        });
        btn2.setOnMouseEntered(e -> {
            btn2.setStyle("-fx-font: bold 18px Adobe ;"
                    + "-fx-font-family: 'Goudy Old Style';"
                    + "-fx-text-fill: yellow;"
                    + "-fx-background-color: silver;"
                    + "-fx-background-radius: 50;"
                    + "-fx-border-color: black;"
                    + "-fx-border-radius: 50;"
                    + "-fx-padding: 15;");
        });
        btn2.setOnMouseExited(e -> {
            btn2.setStyle("-fx-font: bold 15px Adobe ;"
                    + "-fx-font-family: 'Goudy Old Style';"
                    + "-fx-text-fill: yellow;"
                    + "-fx-background-color: brown;"
                    + "-fx-background-radius: 50;"
                    + "-fx-border-color: orange;"
                    + "-fx-border-radius: 50;"
                    + "-fx-padding: 15;");
        });
        btn3.setOnMouseEntered(e -> {
            btn3.setStyle("-fx-font: bold 18px Adobe ;"
                    + "-fx-font-family: 'Goudy Old Style';"
                    + "-fx-text-fill: yellow;"
                    + "-fx-background-color: silver;"
                    + "-fx-background-radius: 50;"
                    + "-fx-border-color: black;"
                    + "-fx-border-radius: 50;"
                    + "-fx-padding: 15;");
        });
        btn3.setOnMouseExited(e -> {
            btn3.setStyle("-fx-font: bold 15px Adobe ;"
                    + "-fx-font-family: 'Goudy Old Style';"
                    + "-fx-text-fill: yellow;"
                    + "-fx-background-color: brown;"
                    + "-fx-background-radius: 50;"
                    + "-fx-border-color: orange;"
                    + "-fx-border-radius: 50;"
                    + "-fx-padding: 15;");
        });

        VB.setAlignment(Pos.CENTER);
        VB.getChildren().addAll(btn1, btn2, btn3);
        BorderPane p = new BorderPane();
        p.setBottom(VB);
        p.setLeft(txt);

        p2.setCenter(pane1);
//        p2.setLeft(p1);
        p2.setRight(p);

        primaryStage.setTitle("Crazy Snake");
        
        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
        isSoundPlaying = false;

        basicscene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.O) {
                if (isSoundPlaying) {
                    stopSound();
                } else {
                    playSound();
                }
            }
        });
        
        primaryStage.setScene(basicscene);
//        primaryStage.setResizable(false);
        primaryStage.show();
    }
     private void playSound() {
        backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
        backgroundMusic.play();
        isSoundPlaying = true;
    }

    private void stopSound() {
        backgroundMusic.stop();
        isSoundPlaying = false;
    }

   
}