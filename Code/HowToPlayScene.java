package crazysnake;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HowToPlayScene {

    private AudioClip backgroundMusic;
    private boolean isSoundPlaying;
    Button btn2;
    Scene basicscene;
    Audio Sound = new Audio();

    public HowToPlayScene(Button btn2, Scene basicscene) {
        this.btn2 = btn2;
        this.basicscene = basicscene;
    }

    public void HowToPlayScene(Stage primaryStage) {

////////// how to play 
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Sound.ClickSound();
                Button backButton = new Button("Back");
                Button NextButton = new Button("Next");
                HBox Buttons = new HBox(10);
                Buttons.getChildren().addAll(backButton, NextButton);
                backButton.setStyle("-fx-font: bold 12px Adobe ;"
                        + "-fx-text-fill: yellow;"
                        + "-fx-background-color: green;"
                        + "-fx-background-radius: 50;"
                        + "-fx-border-color: orange;"
                        + "-fx-border-radius: 50;"
                        + "-fx-padding: 15");
                backButton.setOnMouseEntered(event -> {
                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: silver;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: black;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15");
                });
                backButton.setOnMouseExited(event -> {
                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: green;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: orange;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15");
                });
                NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                        + "-fx-text-fill: yellow;"
                        + "-fx-background-color: green;"
                        + "-fx-background-radius: 50;"
                        + "-fx-border-color: orange;"
                        + "-fx-border-radius: 50;"
                        + "-fx-padding: 15");
                NextButton.setOnMouseEntered(event -> {
                    NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: silver;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: black;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15");
                });
                NextButton.setOnMouseExited(event -> {
                    NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: green;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: orange;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15");
                });

                Pane pane2 = new Pane();
                Text txt1 = new Text(" How To Play");
                txt1.setFill(Color.DARKGREEN);
                txt1.setStroke(Color.GREEN);
                txt1.setFont(Font.font("Snap ITC", FontWeight.BOLD, 30));
                pane2.getChildren().add(txt1);

                Text txt2 = new Text("     Controls :");
                txt2.setFill(Color.ALICEBLUE);
                txt2.setStroke(Color.rgb(100, 100, 12));
                txt2.setFont(Font.font("Snap ITC", FontWeight.BOLD, 23));

                VBox vb = new VBox(15);
                Text txt3 = new Text("               Press \"W\" to \"Move Up\" .");
                txt3.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                Text txt4 = new Text("               Press \"S\" to \"Move Down\" .");
                txt4.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                Text txt5 = new Text("               Press \"D\" to \"Move Right\" .");
                txt5.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                Text txt6 = new Text("               Press \"A\" to \"Move Left\" .");
                txt6.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                Text txt7 = new Text("               Press \"Q\" to \"Stop or Restart\" .");
                txt7.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                Text txt8 = new Text("               Press \"E\" to \"Increase Speed\" .");
                txt8.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                Text txt9 = new Text("               Press \"R\" to \"Decrease Speed\" .");
                txt9.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                Text txt10 = new Text("               Press \"O\" to \" Turn on\"or \"Turn off\" Musics .");
                txt10.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                vb.getChildren().addAll(txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9,txt10);

                VBox vb1 = new VBox(35);
                vb1.getChildren().addAll(txt1, vb);

                Pane pa = new Pane();
                Image image2 = new Image(getClass().getResourceAsStream("/images/Background2.jpg"));
                ImageView IV2 = new ImageView(image2);
                pa.getChildren().add(IV2);

                VBox vb2 = new VBox(40);
                vb2.getChildren().addAll(pa, vb1, Buttons);
                Scene HowToPlayScene = new Scene(vb2, 750, 500);

                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                HowToPlayScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.O) {
                        if (isSoundPlaying) {
                            stopSound();
                        } else {
                            playSound();
                        }
                    }
                });

                primaryStage.setScene(HowToPlayScene);

                backButton.setOnAction(event -> {
                    Sound.ClickSound();
                    primaryStage.setScene(basicscene);
                });
///////////// important tips 
                NextButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Sound.ClickSound();
                        Button backButton = new Button("Back");
                        Button NextButton = new Button("Next");
                        HBox Buttons = new HBox(10);
                        Buttons.getChildren().addAll(backButton, NextButton);
                        backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: green;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: orange;"
                                + "-fx-border-radius: 50;"
                                + "-fx-padding: 15");
                        backButton.setOnMouseEntered(event -> {
                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15");
                        });
                        backButton.setOnMouseExited(event -> {
                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: green;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: orange;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15");
                        });
                        NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: green;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: orange;"
                                + "-fx-border-radius: 50;"
                                + "-fx-padding: 15");
                        NextButton.setOnMouseEntered(event -> {
                            NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15");
                        });
                        NextButton.setOnMouseExited(event -> {
                            NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: green;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: orange;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15");
                        });
                        Pane pane2 = new Pane();
                        Text txt1 = new Text("  Important Tips :");
                        txt1.setFill(Color.DARKGREEN);
                        txt1.setStroke(Color.GREEN);
                        txt1.setFont(Font.font("Snap ITC", FontWeight.BOLD, 30));
                        pane2.getChildren().add(txt1);

                        VBox vb = new VBox(40);
                        Text txt2 = new Text("   \"Red Apple\" : Increas Score By A Value Between 50-200 .");
                        txt2.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                        Text txt3 = new Text("   \"Brown Apple\" : Decrease Score By A Value Between 50-200 .");
                        txt3.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                        Text txt4 = new Text("   \"Golden Apple\" : Make Your Score Double A Value Between 100-400 .");
                        txt4.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                        Text txt5 = new Text("   \"Explosive Load\" : Make You Die (Game Over) .");
                        txt5.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                        Text txt6 = new Text("   \"Bomb Load\" : Lose Your Score .");
                        txt6.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));

                        vb.getChildren().addAll(txt2, txt3, txt4, txt5, txt6);
                        VBox vb1 = new VBox(70);
                        vb1.getChildren().addAll(txt1, vb);
                        Pane pa = new Pane();
                        Image image2 = new Image(getClass().getResourceAsStream("/images/Background2.jpg"));
                        ImageView IV2 = new ImageView(image2);
                        pa.getChildren().add(IV2);
                        VBox vb2 = new VBox(40);
                        vb2.getChildren().addAll(pa, vb1, Buttons);
                        Scene TipsScene1 = new Scene(vb2, 750, 500);
                        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                        TipsScene1.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                            if (event.getCode() == KeyCode.O) {
                                if (isSoundPlaying) {
                                    stopSound();
                                } else {
                                    playSound();
                                }
                            }
                        });
                        primaryStage.setScene(TipsScene1);
                        backButton.setOnAction(event -> {
                            Sound.ClickSound();
                            primaryStage.setScene(HowToPlayScene);
                        });
///////////// Low Level tips
                        NextButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                Sound.ClickSound();
                                Button backButton = new Button("Back");
                                Button NextButton = new Button("Next");
                                HBox Buttons = new HBox(10);
                                Buttons.getChildren().addAll(backButton, NextButton);
                                backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: green;"
                                        + "-fx-background-radius: 50;"
                                        + "-fx-border-color: orange;"
                                        + "-fx-border-radius: 50;"
                                        + "-fx-padding: 15");
                                backButton.setOnMouseEntered(e -> {
                                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 50;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 50;"
                                            + "-fx-padding: 15");
                                });
                                backButton.setOnMouseExited(e -> {
                                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: green;"
                                            + "-fx-background-radius: 50;"
                                            + "-fx-border-color: orange;"
                                            + "-fx-border-radius: 50;"
                                            + "-fx-padding: 15");
                                });
                                NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: green;"
                                        + "-fx-background-radius: 50;"
                                        + "-fx-border-color: orange;"
                                        + "-fx-border-radius: 50;"
                                        + "-fx-padding: 15");
                                NextButton.setOnMouseEntered(e -> {
                                    NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 50;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 50;"
                                            + "-fx-padding: 15");
                                });
                                NextButton.setOnMouseExited(e -> {
                                    NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: green;"
                                            + "-fx-background-radius: 50;"
                                            + "-fx-border-color: orange;"
                                            + "-fx-border-radius: 50;"
                                            + "-fx-padding: 15");
                                });
                                Pane pane2 = new Pane();
                                Text txt1 = new Text("  Low Level Tips :");
                                txt1.setFill(Color.DARKGREEN);
                                txt1.setStroke(Color.GREEN);
                                txt1.setFont(Font.font("Snap ITC", FontWeight.BOLD, 30));
                                pane2.getChildren().add(txt1);

                                VBox vb = new VBox(40);
                                Text txt2 = new Text("        When \"Score<1000\" : Red Apples begin to appear . ");
                                txt2.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                Text txt3 = new Text("        When \"Score>1000\" : Golden Apples begin to appear also .");
                                txt3.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                Text txt4 = new Text("        \"Golden Apples\" rare to appear .");
                                txt4.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                Text txt5 = new Text("        Reflection in this level is available .");
                                txt5.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));

                                vb.getChildren().addAll(txt2, txt3, txt4, txt5);
                                VBox vb1 = new VBox(80);
                                vb1.getChildren().addAll(txt1, vb);
                                Pane pa = new Pane();
                                Image image2 = new Image(getClass().getResourceAsStream("/images/Background2.jpg"));
                                ImageView IV2 = new ImageView(image2);
                                pa.getChildren().add(IV2);
                                VBox vb2 = new VBox(60);
                                vb2.getChildren().addAll(pa, vb1, Buttons);
                                Scene LowLevel = new Scene(vb2, 750, 500);
                                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                LowLevel.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
                                    if (e.getCode() == KeyCode.O) {
                                        if (isSoundPlaying) {
                                            stopSound();
                                        } else {
                                            playSound();
                                        }
                                    }
                                });
                                primaryStage.setScene(LowLevel);
                                backButton.setOnAction(e -> {
                                    Sound.ClickSound();
                                    primaryStage.setScene(TipsScene1);
                                });
////////////////////  Middle Level tips
                                NextButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        Sound.ClickSound();
                                        Button backButton = new Button("Back");
                                        Button NextButton = new Button("Next");
                                        HBox Buttons = new HBox(10);
                                        Buttons.getChildren().addAll(backButton, NextButton);
                                        backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                + "-fx-text-fill: yellow;"
                                                + "-fx-background-color: green;"
                                                + "-fx-background-radius: 50;"
                                                + "-fx-border-color: orange;"
                                                + "-fx-border-radius: 50;"
                                                + "-fx-padding: 15");
                                        backButton.setOnMouseEntered(e -> {
                                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                    + "-fx-text-fill: yellow;"
                                                    + "-fx-background-color: silver;"
                                                    + "-fx-background-radius: 50;"
                                                    + "-fx-border-color: black;"
                                                    + "-fx-border-radius: 50;"
                                                    + "-fx-padding: 15");
                                        });
                                        backButton.setOnMouseExited(e -> {
                                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                    + "-fx-text-fill: yellow;"
                                                    + "-fx-background-color: green;"
                                                    + "-fx-background-radius: 50;"
                                                    + "-fx-border-color: orange;"
                                                    + "-fx-border-radius: 50;"
                                                    + "-fx-padding: 15");
                                        });
                                        NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                + "-fx-text-fill: yellow;"
                                                + "-fx-background-color: green;"
                                                + "-fx-background-radius: 50;"
                                                + "-fx-border-color: orange;"
                                                + "-fx-border-radius: 50;"
                                                + "-fx-padding: 15");
                                        NextButton.setOnMouseEntered(e -> {
                                            NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                    + "-fx-text-fill: yellow;"
                                                    + "-fx-background-color: silver;"
                                                    + "-fx-background-radius: 50;"
                                                    + "-fx-border-color: black;"
                                                    + "-fx-border-radius: 50;"
                                                    + "-fx-padding: 15");
                                        });
                                        NextButton.setOnMouseExited(e -> {
                                            NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                    + "-fx-text-fill: yellow;"
                                                    + "-fx-background-color: green;"
                                                    + "-fx-background-radius: 50;"
                                                    + "-fx-border-color: orange;"
                                                    + "-fx-border-radius: 50;"
                                                    + "-fx-padding: 15");
                                        });
                                        Pane pane2 = new Pane();
                                        Text txt1 = new Text("  Middle Level Tips :");
                                        txt1.setFill(Color.DARKGREEN);
                                        txt1.setStroke(Color.GREEN);
                                        txt1.setFont(Font.font("Snap ITC", FontWeight.BOLD, 30));
                                        pane2.getChildren().add(txt1);

                                        VBox vb = new VBox(30);
                                        Text txt2 = new Text("        When \"Score<1000\" : Red Apple begin to appear . ");
                                        txt2.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                        Text txt3 = new Text("        When \"Score>1000\" : Brown Apple begin to appear also .");
                                        txt3.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                        Text txt4 = new Text("        When \"Score>2000\" : Golden Apple begin to appear also .");
                                        txt4.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                        Text txt5 = new Text("       \"Golden Apples\" rare to appear .");
                                        txt5.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                        Text txt6 = new Text("        Reflection in this level is available only in one direction .");
                                        txt6.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));

                                        vb.getChildren().addAll(txt2, txt3, txt4, txt5, txt6);
                                        VBox vb1 = new VBox(70);
                                        vb1.getChildren().addAll(txt1, vb);
                                        Pane pa = new Pane();
                                        Image image2 = new Image(getClass().getResourceAsStream("/images/Background2.jpg"));
                                        ImageView IV2 = new ImageView(image2);
                                        pa.getChildren().add(IV2);
                                        VBox vb2 = new VBox(60);
                                        vb2.getChildren().addAll(pa, vb1, Buttons);
                                        Scene MiddleLevel = new Scene(vb2, 750, 500);
                                        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                        MiddleLevel.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
                                            if (e.getCode() == KeyCode.O) {
                                                if (isSoundPlaying) {
                                                    stopSound();
                                                } else {
                                                    playSound();
                                                }
                                            }
                                        });
                                        primaryStage.setScene(MiddleLevel);
                                        backButton.setOnAction(e -> {
                                            Sound.ClickSound();
                                            primaryStage.setScene(LowLevel);
                                        });
//////////                  high level tips
                                        NextButton.setOnAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                Sound.ClickSound();
                                                Button backButton = new Button("Back");
                                                Button NextButton = new Button("Next");
                                                HBox Buttons = new HBox(10);
                                                Buttons.getChildren().addAll(backButton, NextButton);
                                                backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                        + "-fx-text-fill: yellow;"
                                                        + "-fx-background-color: green;"
                                                        + "-fx-background-radius: 50;"
                                                        + "-fx-border-color: orange;"
                                                        + "-fx-border-radius: 50;"
                                                        + "-fx-padding: 15");
                                                backButton.setOnMouseEntered(e -> {
                                                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                            + "-fx-text-fill: yellow;"
                                                            + "-fx-background-color: silver;"
                                                            + "-fx-background-radius: 50;"
                                                            + "-fx-border-color: black;"
                                                            + "-fx-border-radius: 50;"
                                                            + "-fx-padding: 15");
                                                });
                                                backButton.setOnMouseExited(e -> {
                                                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                            + "-fx-text-fill: yellow;"
                                                            + "-fx-background-color: green;"
                                                            + "-fx-background-radius: 50;"
                                                            + "-fx-border-color: orange;"
                                                            + "-fx-border-radius: 50;"
                                                            + "-fx-padding: 15");
                                                });
                                                NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                        + "-fx-text-fill: yellow;"
                                                        + "-fx-background-color: green;"
                                                        + "-fx-background-radius: 50;"
                                                        + "-fx-border-color: orange;"
                                                        + "-fx-border-radius: 50;"
                                                        + "-fx-padding: 15");
                                                NextButton.setOnMouseEntered(e -> {
                                                    NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                            + "-fx-text-fill: yellow;"
                                                            + "-fx-background-color: silver;"
                                                            + "-fx-background-radius: 50;"
                                                            + "-fx-border-color: black;"
                                                            + "-fx-border-radius: 50;"
                                                            + "-fx-padding: 15");
                                                });
                                                NextButton.setOnMouseExited(e -> {
                                                    NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                            + "-fx-text-fill: yellow;"
                                                            + "-fx-background-color: green;"
                                                            + "-fx-background-radius: 50;"
                                                            + "-fx-border-color: orange;"
                                                            + "-fx-border-radius: 50;"
                                                            + "-fx-padding: 15");
                                                });
                                                Pane pane2 = new Pane();
                                                Text txt1 = new Text("  High Level Tips :");
                                                txt1.setFill(Color.DARKGREEN);
                                                txt1.setStroke(Color.GREEN);
                                                txt1.setFont(Font.font("Snap ITC", FontWeight.BOLD, 30));
                                                pane2.getChildren().add(txt1);
                                                VBox vb = new VBox(25);
                                                Text txt2 = new Text("        When \"Score<1000\" : Red Apple begin to appear . ");
                                                txt2.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                Text txt3 = new Text("        When \"Score>1000\" : Brown Apple begin to appear also .");
                                                txt3.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                Text txt4 = new Text("        When \"Score>2000\" : Golden Apple begin to appear also .");
                                                txt4.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                Text txt5 = new Text("        When \"Score>3000\" : Explosive Load begin to appear also .");
                                                txt5.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                Text txt6 = new Text("       \"Golden Apples\" rare to appear .");
                                                txt6.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                Text txt7 = new Text("        Reflection in this level \"Not available\" .");
                                                txt7.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                vb.getChildren().addAll(txt2, txt3, txt4, txt5, txt6, txt7);
                                                VBox vb1 = new VBox(60);
                                                vb1.getChildren().addAll(txt1, vb);
                                                Pane pa = new Pane();
                                                Image image2 = new Image(getClass().getResourceAsStream("/images/Background2.jpg"));
                                                ImageView IV2 = new ImageView(image2);
                                                pa.getChildren().add(IV2);
                                                VBox vb2 = new VBox(60);
                                                vb2.getChildren().addAll(pa, vb1, Buttons);
                                                Scene HighLevel = new Scene(vb2, 750, 500);
                                                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                                HighLevel.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
                                                    if (e.getCode() == KeyCode.O) {
                                                        if (isSoundPlaying) {
                                                            stopSound();
                                                        } else {
                                                            playSound();
                                                        }
                                                    }
                                                });
                                                primaryStage.setScene(HighLevel);
                                                backButton.setOnAction(e -> {
                                                    Sound.ClickSound();
                                                    primaryStage.setScene(MiddleLevel);
                                                });
/////////////                   Hard Level tips
                                                NextButton.setOnAction(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        Sound.ClickSound();
                                                        Button backButton = new Button("Back");
                                                        Button NextButton = new Button("Next");
                                                        HBox Buttons = new HBox(10);
                                                        Buttons.getChildren().addAll(backButton, NextButton);
                                                        backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                                + "-fx-text-fill: yellow;"
                                                                + "-fx-background-color: green;"
                                                                + "-fx-background-radius: 50;"
                                                                + "-fx-border-color: orange;"
                                                                + "-fx-border-radius: 50;"
                                                                + "-fx-padding: 15");
                                                        backButton.setOnMouseEntered(e -> {
                                                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                                    + "-fx-text-fill: yellow;"
                                                                    + "-fx-background-color: silver;"
                                                                    + "-fx-background-radius: 50;"
                                                                    + "-fx-border-color: black;"
                                                                    + "-fx-border-radius: 50;"
                                                                    + "-fx-padding: 15");
                                                        });
                                                        backButton.setOnMouseExited(e -> {
                                                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                                    + "-fx-text-fill: yellow;"
                                                                    + "-fx-background-color: green;"
                                                                    + "-fx-background-radius: 50;"
                                                                    + "-fx-border-color: orange;"
                                                                    + "-fx-border-radius: 50;"
                                                                    + "-fx-padding: 15");
                                                        });
                                                        NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                                + "-fx-text-fill: yellow;"
                                                                + "-fx-background-color: green;"
                                                                + "-fx-background-radius: 50;"
                                                                + "-fx-border-color: orange;"
                                                                + "-fx-border-radius: 50;"
                                                                + "-fx-padding: 15");
                                                        NextButton.setOnMouseEntered(e -> {
                                                            NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                                    + "-fx-text-fill: yellow;"
                                                                    + "-fx-background-color: silver;"
                                                                    + "-fx-background-radius: 50;"
                                                                    + "-fx-border-color: black;"
                                                                    + "-fx-border-radius: 50;"
                                                                    + "-fx-padding: 15");
                                                        });
                                                        NextButton.setOnMouseExited(e -> {
                                                            NextButton.setStyle("-fx-font: bold 12px Adobe ;"
                                                                    + "-fx-text-fill: yellow;"
                                                                    + "-fx-background-color: green;"
                                                                    + "-fx-background-radius: 50;"
                                                                    + "-fx-border-color: orange;"
                                                                    + "-fx-border-radius: 50;"
                                                                    + "-fx-padding: 15");
                                                        });
                                                        Pane pane2 = new Pane();
                                                        Text txt1 = new Text("  Hard Level Tips :");
                                                        txt1.setFill(Color.DARKGREEN);
                                                        txt1.setStroke(Color.GREEN);
                                                        txt1.setFont(Font.font("Snap ITC", FontWeight.BOLD, 30));
                                                        pane2.getChildren().add(txt1);
                                                        VBox vb = new VBox(25);
                                                        Text txt2 = new Text("        When \"Score<1000\" : Red Apple begin to appear . ");
                                                        txt2.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                        Text txt3 = new Text("        When \"Score>1000\" : Brown Apple begin to appear also .");
                                                        txt3.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                        Text txt4 = new Text("        When \"Score>2000\" : Golden Apple begin to appear also .");
                                                        txt4.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                        Text txt5 = new Text("        When \"Score>3000\" : Bomb Load begin to appear also .");
                                                        txt5.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                        Text txt6 = new Text("        When \"Score>4000\" : Explosive Load begin to appear also .");
                                                        txt6.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                        Text txt7 = new Text("       \"Golden Apples\" rare to appear .");
                                                        txt7.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                        Text txt8 = new Text("        Reflection in this level \"Not available\" and Complicated.");
                                                        txt8.setFont(Font.font("Snap ITC", FontWeight.BOLD, 13));
                                                        vb.getChildren().addAll(txt2, txt3, txt4, txt5, txt6, txt7, txt8);
                                                        VBox vb1 = new VBox(50);
                                                        vb1.getChildren().addAll(txt1, vb);
                                                        Pane pa = new Pane();
                                                        Image image2 = new Image(getClass().getResourceAsStream("/images/Background2.jpg"));
                                                        ImageView IV2 = new ImageView(image2);
                                                        pa.getChildren().add(IV2);
                                                        VBox vb2 = new VBox(45);
                                                        vb2.getChildren().addAll(pa, vb1, Buttons);
                                                        Scene HardLevel = new Scene(vb2, 750, 500);
                                                        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                                        HardLevel.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
                                                            if (e.getCode() == KeyCode.O) {
                                                                if (isSoundPlaying) {
                                                                    stopSound();
                                                                } else {
                                                                    playSound();
                                                                }
                                                            }
                                                        });
                                                        primaryStage.setScene(HardLevel);
                                                        backButton.setOnAction(e -> {
                                                            Sound.ClickSound();
                                                            primaryStage.setScene(HighLevel);
                                                        });
                                                        NextButton.setOnAction(e -> {
                                                            Sound.ClickSound();
                                                            primaryStage.setScene(HowToPlayScene);
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

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
