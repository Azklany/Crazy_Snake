package crazysnake;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartPlayingScene {

    private AudioClip backgroundMusic;
    private boolean isSoundPlaying;
    Button btn1;
    Scene basicscene;
    LowLevelShapes LLS;
    MiddleLevelShapes MLS;
    MiddleLevelShapes MLS2;
    HighLevelShapes HiLS;
    HardLevelShapes HaLS;
    HardLevelShapes HaLS2;
    Audio Sound = new Audio();

    public StartPlayingScene(Button btn1, Scene basicscene, LowLevelShapes LLS, MiddleLevelShapes MLS, MiddleLevelShapes MLS2, HighLevelShapes HiLS, HardLevelShapes HaLS, HardLevelShapes HaLS2) {
        this.btn1 = btn1;
        this.basicscene = basicscene;
        this.LLS = LLS;
        this.MLS = MLS;
        this.MLS2 = MLS2;
        this.HiLS = HiLS;
        this.HaLS = HaLS;
        this.HaLS2 = HaLS2;
    }

    public void StartPlayingScene(Stage primaryStage) {

        // start playing
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Sound.ClickSound();
                Pane pane1 = new Pane();
                Image image = new Image(getClass().getResourceAsStream("/images/Background3.jpg"));
                ImageView IV = new ImageView(image);
                pane1.getChildren().add(IV);
                Text txt = new Text("     Choose Level :");
                txt.setFill(Color.rgb(100, 200, 50, 1));
                txt.setStroke(Color.BLACK);
                txt.setFont(Font.font("Snap ITC", FontWeight.BOLD, 40));
                VBox VB = new VBox(30);
                Button LowButton = new Button("   Low Level   ");
                Button MiddleButton = new Button("Middle Level");
                Button HighButton = new Button("  High Level  ");
                Button HardButton = new Button("  Hard Level  ");
                Button backButton = new Button("Back");
                VB.setAlignment(Pos.CENTER);
                VB.getChildren().addAll(LowButton, MiddleButton, HighButton, HardButton);
                LowButton.setStyle("-fx-font: bold 15px Adobe ;"
                        + "-fx-font-family: 'Goudy Old Style';"
                        + "-fx-text-fill: yellow;"
                        + "-fx-background-color: DARKTURQUOISE;"
                        + "-fx-background-radius: 50;"
                        + "-fx-border-color: green;"
                        + "-fx-border-radius:50;"
                        + "-fx-padding:15;");
                MiddleButton.setStyle("-fx-font: bold 15px Adobe ;"
                        + "-fx-font-family: 'Goudy Old Style';"
                        + "-fx-text-fill: yellow;"
                        + "-fx-background-color: DARKTURQUOISE;"
                        + "-fx-background-radius: 50;"
                        + "-fx-border-color: green;"
                        + "-fx-border-radius: 50;"
                        + "-fx-padding: 15;");
                HighButton.setStyle("-fx-font: bold 15px Adobe ;"
                        + "-fx-font-family: 'Goudy Old Style';"
                        + "-fx-text-fill: yellow;"
                        + "-fx-background-color: DARKTURQUOISE;"
                        + "-fx-background-radius: 50;"
                        + "-fx-border-color: green;"
                        + "-fx-border-radius: 50;"
                        + "-fx-padding: 15;");
                HardButton.setStyle("-fx-font: bold 15px Adobe ;"
                        + "-fx-font-family: 'Goudy Old Style';"
                        + "-fx-text-fill: yellow;"
                        + "-fx-background-color: DARKTURQUOISE;"
                        + "-fx-background-radius: 50;"
                        + "-fx-border-color: green;"
                        + "-fx-border-radius: 50;"
                        + "-fx-padding: 15;");
                backButton.setStyle("-fx-font: bold 12px Adobe ;"
                        + "-fx-text-fill: yellow;"
                        + "-fx-background-color: DARKTURQUOISE;"
                        + "-fx-background-radius: 50;"
                        + "-fx-border-color: green;"
                        + "-fx-border-radius: 50;"
                        + "-fx-padding: 12;");
                LowButton.setOnMouseEntered(event -> {
                    LowButton.setStyle("-fx-font: bold 17px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: silver;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: black;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                LowButton.setOnMouseExited(event -> {
                    LowButton.setStyle("-fx-font: bold 15px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: DARKTURQUOISE;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: green;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                MiddleButton.setOnMouseEntered(event -> {
                    MiddleButton.setStyle("-fx-font: bold 17px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: silver;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: black;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                MiddleButton.setOnMouseExited(event -> {
                    MiddleButton.setStyle("-fx-font: bold 15px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: DARKTURQUOISE;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: green;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                HighButton.setOnMouseEntered(event -> {
                    HighButton.setStyle("-fx-font: bold 17px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: silver;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: black;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                HighButton.setOnMouseExited(event -> {
                    HighButton.setStyle("-fx-font: bold 15px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: DARKTURQUOISE;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: green;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                HardButton.setOnMouseEntered(event -> {
                    HardButton.setStyle("-fx-font: bold 17px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: silver;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: black;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                HardButton.setOnMouseExited(event -> {
                    HardButton.setStyle("-fx-font: bold 15px Adobe ;"
                            + "-fx-font-family: 'Goudy Old Style';"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: DARKTURQUOISE;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: green;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 15;");
                });
                backButton.setOnMouseEntered(event -> {
                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: silver;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: black;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 12;");
                });
                backButton.setOnMouseExited(event -> {
                    backButton.setStyle("-fx-font: bold 12px Adobe ;"
                            + "-fx-text-fill: yellow;"
                            + "-fx-background-color: DARKTURQUOISE;"
                            + "-fx-background-radius: 50;"
                            + "-fx-border-color: green;"
                            + "-fx-border-radius: 50;"
                            + "-fx-padding: 12;");
                });
                VBox vb2 = new VBox(45);
                vb2.getChildren().addAll(txt, VB, backButton);

                VBox vb3 = new VBox(20);
                vb3.getChildren().addAll(pane1, vb2);
                Scene StartPlayingScene = new Scene(vb3, 750, 500);
                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                StartPlayingScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.O) {
                        if (isSoundPlaying) {
                            stopSound();
                        } else {
                            playSound();
                        }
                    }
                });
                primaryStage.setTitle("Crazy Snake");
                primaryStage.setScene(StartPlayingScene);
                primaryStage.show();

                backButton.setOnAction(event -> {
                    Sound.ClickSound();
                    primaryStage.setScene(basicscene);
                });
/////////// low level  button              
                LowButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent evevt) {
                        Sound.ClickSound();
                        //1
                        LLS.timeline.play();
                        LLS.resetGame();
                        // مكان الرسم
                        Pane bp = new Pane();
                        Button backButton = new Button("Back");
                        Button resetButton = new Button("Reset");
                        HBox hb = new HBox(5);
                        hb.getChildren().addAll(backButton, resetButton);
                        bp.getChildren().addAll(hb);
                        backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: CADETBLUE;"
                                + "-fx-background-radius: 10;"
                                + "-fx-border-color: black;"
                                + "-fx-border-radius: 10;"
                                + "-fx-padding: 2;");
                        backButton.setOnMouseEntered(event -> {
                            backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });
                        backButton.setOnMouseExited(event -> {
                            backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: CADETBLUE;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });
                        resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: CADETBLUE;"
                                + "-fx-background-radius: 10;"
                                + "-fx-border-color: black;"
                                + "-fx-border-radius: 10;"
                                + "-fx-padding: 2;");
                        resetButton.setOnMouseEntered(event -> {
                            resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });
                        resetButton.setOnMouseExited(event -> {
                            resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: CADETBLUE;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });

                        // back button
                        backButton.setOnAction(event -> {
                            Sound.ClickSound();
                            LLS.resetGame();
                            LLS.timeline.stop();
                            primaryStage.setScene(StartPlayingScene);
                        });
                        resetButton.setOnAction(event -> {
                            Sound.ClickSound();
                            LLS.timeline.play();
                            LLS.resetGame();
                        });

                        Canvas canvas = new Canvas(750, 500);
                        GraphicsContext Graphics = canvas.getGraphicsContext2D();
                        Pane pane = new Pane();
                        pane.setStyle("-fx-background-color: black;");
                        pane.getChildren().add(canvas);

                        Line line1 = new Line(563, 75, 750, 75);
                        line1.setStrokeWidth(4);
                        line1.setStroke(Color.CADETBLUE);

                        Line line2 = new Line(563, 330, 750, 330);
                        line2.setStrokeWidth(4);
                        line2.setStroke(Color.CADETBLUE);

                        Rectangle rect1 = new Rectangle(2, 2, 750, 500);
                        rect1.setStroke(Color.CADETBLUE);
                        rect1.setStrokeWidth(4);
                        rect1.setFill(Color.TRANSPARENT);

                        Rectangle rect2 = new Rectangle(20, 20, 540, 460);
                        rect2.setStroke(Color.CADETBLUE);
                        rect2.setStrokeWidth(4);
                        rect2.setFill(Color.TRANSPARENT);

                        pane.getChildren().addAll(line1, line2, rect1, rect2, bp);

                        Scene gameScene = new Scene(pane);
                        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                            if (event.getCode() == KeyCode.O) {
                                if (isSoundPlaying) {
                                    stopSound();
                                } else {
                                    playSound();
                                }
                            }
                        });
                        primaryStage.setScene(gameScene);

                        LLS.timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
                            LLS.LowLevelShapes(Graphics);
                        }));

                        LLS.timeline.setCycleCount(Timeline.INDEFINITE);
                        LLS.timeline.play();

                        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                            switch (event.getCode()) {
                                //space ما يتم تنفيذه عند الضغط على الزر
                                case Q:
                                    LLS.handleQKey();
                                    break;
                                //D ما يتم تنفيذه عند الضغط على الزر
                                case D:
                                    LLS.handleDKey();
                                    break;
                                //A ما يتم تنفيذه عند الضغط على الزر
                                case A:
                                    LLS.handleAKey();
                                    break;
                                //W ما يتم تنفيذه عند الضغط على الزر
                                case W:
                                    LLS.handleWKey();
                                    break;
                                //S ما يتم تنفيذه عند الضغط على الزر
                                case S:
                                    LLS.handleSKey();
                                    break;
                                case E:
                                    LLS.handleEKey();
                                    break;
                                case R:
                                    LLS.handleRKey();
                                    break;
                            }
                        });
                    }
                });
///////////// middle button
                MiddleButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Sound.ClickSound();
                        MLS.resetGame();
                        Pane pane1 = new Pane();
                        Image image = new Image(getClass().getResourceAsStream("/images/Background3.jpg"));
                        ImageView IV = new ImageView(image);
                        pane1.getChildren().add(IV);
                        Text txt = new Text("     Middle Level :");
                        txt.setFill(Color.rgb(100, 200, 50, 1));
                        txt.setStroke(Color.BLACK);
                        txt.setFont(Font.font("Snap ITC", FontWeight.BOLD, 40));
                        VBox VB = new VBox(45);
                        Button Type1Button = new Button("Type 1");
                        Button Type2Button = new Button("Type 2");
                        Button backButton = new Button("Back");
                        VB.setAlignment(Pos.CENTER);
                        VB.getChildren().addAll(Type1Button, Type2Button);
                        Type1Button.setStyle("-fx-font: bold 15px Adobe ;"
                                + "-fx-font-family: 'Goudy Old Style';"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: DARKTURQUOISE;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: green;"
                                + "-fx-border-radius:50;"
                                + "-fx-padding:15;");
                        Type2Button.setStyle("-fx-font: bold 15px Adobe ;"
                                + "-fx-font-family: 'Goudy Old Style';"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: DARKTURQUOISE;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: green;"
                                + "-fx-border-radius: 50;"
                                + "-fx-padding: 15;");
                        backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: DARKTURQUOISE;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: green;"
                                + "-fx-border-radius: 50;"
                                + "-fx-padding: 12;");
                        Type1Button.setOnMouseEntered(event -> {
                            Type1Button.setStyle("-fx-font: bold 17px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        Type1Button.setOnMouseExited(event -> {
                            Type1Button.setStyle("-fx-font: bold 15px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: DARKTURQUOISE;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: green;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        Type2Button.setOnMouseEntered(event -> {
                            Type2Button.setStyle("-fx-font: bold 17px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        Type2Button.setOnMouseExited(event -> {
                            Type2Button.setStyle("-fx-font: bold 15px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: DARKTURQUOISE;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: green;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        HighButton.setOnMouseEntered(event -> {
                            HighButton.setStyle("-fx-font: bold 17px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        backButton.setOnMouseEntered(event -> {
                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 12;");
                        });
                        backButton.setOnMouseExited(event -> {
                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: DARKTURQUOISE;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: green;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 12;");
                        });
                        VBox vb2 = new VBox(110);
                        vb2.getChildren().addAll(txt, VB, backButton);

                        VBox vb3 = new VBox(20);
                        vb3.getChildren().addAll(pane1, vb2);
                        Scene MiddleTypesScene = new Scene(vb3, 750, 500);
                        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                        MiddleTypesScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                            if (event.getCode() == KeyCode.O) {
                                if (isSoundPlaying) {
                                    stopSound();
                                } else {
                                    playSound();
                                }
                            }
                        });
                        primaryStage.setTitle("Crazy Snake");
                        primaryStage.setScene(MiddleTypesScene);
                        primaryStage.show();
                        backButton.setOnAction(event -> {
                            Sound.ClickSound();
                            MLS.resetGame();
                            MLS.timeline.stop();
                            primaryStage.setScene(StartPlayingScene);
                        });
                        // middle type 1
                        Type1Button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                Sound.ClickSound();
                                MLS.resetGame();
                                MLS.timeline.play();
                                Pane bp = new Pane();
                                Button backButton = new Button("Back");
                                Button resetButton = new Button("Reset");
                                HBox hb = new HBox(5);
                                hb.getChildren().addAll(backButton, resetButton);
                                bp.getChildren().addAll(hb);
                                backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: green;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                backButton.setOnMouseEntered(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                backButton.setOnMouseExited(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: green;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: green;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                resetButton.setOnMouseEntered(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setOnMouseExited(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: green;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                // back button
                                backButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    MLS.resetGame();
                                    MLS.timeline.stop();
                                    primaryStage.setScene(MiddleTypesScene);
                                });
                                resetButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    MLS.timeline.play();
                                    MLS.resetGame();
                                });
                                Canvas canvas = new Canvas(750, 500);
                                GraphicsContext Graphics = canvas.getGraphicsContext2D();
                                Pane pane = new Pane();
                                pane.setStyle("-fx-background-color: black;");
                                pane.getChildren().add(canvas);
                                Line line1 = new Line(563, 75, 750, 75);
                                line1.setStrokeWidth(4);
                                line1.setStroke(Color.rgb(20, 200, 20, .8));
                                Line line2 = new Line(563, 330, 750, 330);
                                line2.setStrokeWidth(4);
                                line2.setStroke(Color.rgb(20, 200, 20, .8));
                                Line line3 = new Line(23, 23, 560, 23);
                                line3.setStrokeWidth(6);
                                line3.setStroke(Color.rgb(175, 250, 175, 1));
                                Line line4 = new Line(21, 478, 560, 478);
                                line4.setStrokeWidth(8);
                                line4.setStroke(Color.rgb(175, 250, 175, 1));
                                Rectangle rect1 = new Rectangle(2, 2, 750, 500);
                                rect1.setStroke(Color.rgb(20, 200, 20, .8));
                                rect1.setStrokeWidth(6);
                                rect1.setFill(Color.TRANSPARENT);
                                Rectangle rect2 = new Rectangle(20, 20, 540, 460);
                                rect2.setStroke(Color.rgb(20, 200, 20, .8));
                                rect2.setStrokeWidth(4);
                                rect2.setFill(Color.TRANSPARENT);
                                pane.getChildren().addAll(line1, line2, line3, line4, rect1, rect2, bp);

                                Scene gameScene = new Scene(pane);
                                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                gameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                                    if (event.getCode() == KeyCode.O) {
                                        if (isSoundPlaying) {
                                            stopSound();
                                        } else {
                                            playSound();
                                        }
                                    }
                                });
                                primaryStage.setScene(gameScene);
                                MLS.timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
                                    MLS.MiddleLevelShapes(Graphics);
                                }));
                                MLS.timeline.setCycleCount(Timeline.INDEFINITE);
                                MLS.timeline.play();
                                gameScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                                    switch (event.getCode()) {
                                        //space ما يتم تنفيذه عند الضغط على الزر
                                        case Q:
                                            MLS.handleQKey();
                                            break;
                                        //D ما يتم تنفيذه عند الضغط على الزر
                                        case D:
                                            MLS.handleDKey();
                                            break;
                                        //A ما يتم تنفيذه عند الضغط على الزر
                                        case A:
                                            MLS.handleAKey();
                                            break;
                                        //W ما يتم تنفيذه عند الضغط على الزر
                                        case W:
                                            MLS.handleWKey();
                                            break;
                                        //S ما يتم تنفيذه عند الضغط على الزر
                                        case S:
                                            MLS.handleSKey();
                                            break;
                                        case E:
                                            MLS.handleEKey();
                                            break;
                                        case R:
                                            MLS.handleRKey();
                                            break;
                                    }
                                });
                            }
                            // middle type 2 
                        });
                        Type2Button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                Sound.ClickSound();
                                MLS2.resetGame();
                                MLS2.timeline.play();
                                Pane bp = new Pane();
                                Button backButton = new Button("Back");
                                Button resetButton = new Button("Reset");
                                HBox hb = new HBox(5);
                                hb.getChildren().addAll(backButton, resetButton);
                                bp.getChildren().addAll(hb);
                                backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: green;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                backButton.setOnMouseEntered(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                backButton.setOnMouseExited(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: green;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: green;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                resetButton.setOnMouseEntered(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setOnMouseExited(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: green;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                // back button
                                backButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    MLS2.resetGame();
                                    MLS2.timeline.stop();
                                    primaryStage.setScene(MiddleTypesScene);
                                });
                                resetButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    MLS2.timeline.play();
                                    MLS2.resetGame();
                                });
                                Canvas canvas = new Canvas(750, 500);
                                GraphicsContext Graphics = canvas.getGraphicsContext2D();
                                Pane pane = new Pane();
                                pane.setStyle("-fx-background-color: black;");
                                pane.getChildren().add(canvas);
                                Line line1 = new Line(563, 75, 750, 75);
                                line1.setStrokeWidth(4);
                                line1.setStroke(Color.rgb(20, 200, 20, .8));

                                Line line2 = new Line(563, 330, 750, 330);
                                line2.setStrokeWidth(4);
                                line2.setStroke(Color.rgb(20, 200, 20, .8));

                                Line line3 = new Line(23, 23, 23, 475);
                                line3.setStrokeWidth(6);
                                line3.setStroke(Color.rgb(175, 250, 175, 1));

                                Line line4 = new Line(556, 24, 556, 476);
                                line4.setStrokeWidth(4);
                                line4.setStroke(Color.rgb(175, 250, 175, 1));

                                Rectangle rect1 = new Rectangle(2, 2, 750, 500);
                                rect1.setStroke(Color.rgb(20, 200, 20, .8));
                                rect1.setStrokeWidth(6);
                                rect1.setFill(Color.TRANSPARENT);
                                Rectangle rect2 = new Rectangle(20, 20, 540, 460);
                                rect2.setStroke(Color.rgb(20, 200, 20, .8));
                                rect2.setStrokeWidth(4);
                                rect2.setFill(Color.TRANSPARENT);
                                pane.getChildren().addAll(line1, line2, line3, line4, rect1, rect2, bp);

                                Scene gameScene = new Scene(pane);
                                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                gameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                                    if (event.getCode() == KeyCode.O) {
                                        if (isSoundPlaying) {
                                            stopSound();
                                        } else {
                                            playSound();
                                        }
                                    }
                                });
                                primaryStage.setScene(gameScene);
                                MLS2.timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
                                    MLS2.MiddleLevelShapes2(Graphics);
                                }));
                                MLS2.timeline.setCycleCount(Timeline.INDEFINITE);
                                MLS2.timeline.play();
                                gameScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                                    switch (event.getCode()) {
                                        //space ما يتم تنفيذه عند الضغط على الزر
                                        case Q:
                                            MLS2.handleQKey();
                                            break;
                                        //D ما يتم تنفيذه عند الضغط على الزر
                                        case D:
                                            MLS2.handleDKey();
                                            break;
                                        //A ما يتم تنفيذه عند الضغط على الزر
                                        case A:
                                            MLS2.handleAKey();
                                            break;
                                        //W ما يتم تنفيذه عند الضغط على الزر
                                        case W:
                                            MLS2.handleWKey();
                                            break;
                                        //S ما يتم تنفيذه عند الضغط على الزر
                                        case S:
                                            MLS2.handleSKey();
                                            break;
                                        case E:
                                            MLS2.handleEKey();
                                            break;
                                        case R:
                                            MLS2.handleRKey();
                                            break;
                                    }
                                });
                            }
                        });
                    }
                });
//////  high button              
                HighButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Sound.ClickSound();
                        HiLS.resetGame();
                        HiLS.timeline.play();
                        // مكان الرسم
                        Pane bp = new Pane();
                        Button backButton = new Button("Back");
                        Button resetButton = new Button("Reset");
                        HBox hb = new HBox(5);
                        hb.getChildren().addAll(backButton, resetButton);
                        bp.getChildren().addAll(hb);
                        backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                + "-fx-text-fill: brown;"
                                + "-fx-background-color: yellow;"
                                + "-fx-background-radius: 10;"
                                + "-fx-border-color: black;"
                                + "-fx-border-radius: 10;"
                                + "-fx-padding: 2;");
                        backButton.setOnMouseEntered(event -> {
                            backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });
                        backButton.setOnMouseExited(event -> {
                            backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: brown;"
                                    + "-fx-background-color: yellow;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });
                        resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                + "-fx-text-fill: brown;"
                                + "-fx-background-color: yellow;"
                                + "-fx-background-radius: 10;"
                                + "-fx-border-color: black;"
                                + "-fx-border-radius: 10;"
                                + "-fx-padding: 2;");
                        resetButton.setOnMouseEntered(event -> {
                            resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });
                        resetButton.setOnMouseExited(event -> {
                            resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                    + "-fx-text-fill: brown;"
                                    + "-fx-background-color: yellow;"
                                    + "-fx-background-radius: 10;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 10;"
                                    + "-fx-padding: 2;");
                        });

                        // back button
                        backButton.setOnAction(event -> {
                            Sound.ClickSound();
                            HiLS.resetGame();
                            HiLS.timeline.stop();
                            primaryStage.setScene(StartPlayingScene);
                        });
                        resetButton.setOnAction(event -> {
                            Sound.ClickSound();
                            HiLS.timeline.play();
                            HiLS.resetGame();
                        });

                        Canvas canvas = new Canvas(750, 500);
                        GraphicsContext Graphics = canvas.getGraphicsContext2D();
                        Pane pane = new Pane();
                        pane.setStyle("-fx-background-color: black;");
                        pane.getChildren().add(canvas);

                        Line line1 = new Line(563, 75, 750, 75);
                        line1.setStrokeWidth(4);
                        line1.setStroke(Color.rgb(225, 225, 20, .8));

                        Line line2 = new Line(563, 330, 750, 330);
                        line2.setStrokeWidth(4);
                        line2.setStroke(Color.rgb(225, 225, 20, .8));

                        Rectangle rect1 = new Rectangle(2, 2, 750, 500);
                        rect1.setStroke(Color.rgb(225, 225, 20, .8));
                        rect1.setStrokeWidth(4);
                        rect1.setFill(Color.TRANSPARENT);

                        Rectangle rect2 = new Rectangle(20, 20, 540, 460);
                        rect2.setStroke(Color.rgb(225, 225, 20, .8));
                        rect2.setStrokeWidth(4);
                        rect2.setFill(Color.TRANSPARENT);

                        Rectangle rect3 = new Rectangle(20, 20, 540, 460);
                        rect3.setStroke(Color.rgb(250, 250, 175, 1));
                        rect3.setStrokeWidth(4);
                        rect3.setFill(Color.TRANSPARENT);

                        pane.getChildren().addAll(line1, line2, rect1, rect2, rect3, bp);

                        Scene gameScene = new Scene(pane);
                        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                            if (event.getCode() == KeyCode.O) {
                                if (isSoundPlaying) {
                                    stopSound();
                                } else {
                                    playSound();
                                }
                            }
                        });
                        primaryStage.setScene(gameScene);

                        HiLS.timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
                            HiLS.HighLevelShapes(Graphics);
                        }));

                        HiLS.timeline.setCycleCount(Timeline.INDEFINITE);
                        HiLS.timeline.play();

                        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                            switch (event.getCode()) {
                                //space ما يتم تنفيذه عند الضغط على الزر
                                case Q:
                                    HiLS.handleQKey();
                                    break;
                                //D ما يتم تنفيذه عند الضغط على الزر
                                case D:
                                    HiLS.handleDKey();
                                    break;
                                //A ما يتم تنفيذه عند الضغط على الزر
                                case A:
                                    HiLS.handleAKey();
                                    break;
                                //W ما يتم تنفيذه عند الضغط على الزر
                                case W:
                                    HiLS.handleWKey();
                                    break;
                                //S ما يتم تنفيذه عند الضغط على الزر
                                case S:
                                    HiLS.handleSKey();
                                    break;
                                case E:
                                    HiLS.handleEKey();
                                    break;
                                case R:
                                    HiLS.handleRKey();
                                    break;
                            }
                        });
                    }
                });
/////////// hard button             
                HardButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        Sound.ClickSound();
                        Pane pane1 = new Pane();
                        Image image = new Image(getClass().getResourceAsStream("/images/Background3.jpg"));
                        ImageView IV = new ImageView(image);
                        pane1.getChildren().add(IV);
                        Text txt = new Text("     Hard Level :");
                        txt.setFill(Color.rgb(100, 200, 50, 1));
                        txt.setStroke(Color.BLACK);
                        txt.setFont(Font.font("Snap ITC", FontWeight.BOLD, 40));
                        VBox VB = new VBox(45);
                        Button Type1Button = new Button("Type 1");
                        Button Type2Button = new Button("Type 2");
                        Button backButton = new Button("Back");
                        VB.setAlignment(Pos.CENTER);
                        VB.getChildren().addAll(Type1Button, Type2Button);
                        Type1Button.setStyle("-fx-font: bold 15px Adobe ;"
                                + "-fx-font-family: 'Goudy Old Style';"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: DARKTURQUOISE;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: green;"
                                + "-fx-border-radius:50;"
                                + "-fx-padding:15;");
                        Type2Button.setStyle("-fx-font: bold 15px Adobe ;"
                                + "-fx-font-family: 'Goudy Old Style';"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: DARKTURQUOISE;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: green;"
                                + "-fx-border-radius: 50;"
                                + "-fx-padding: 15;");
                        backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                + "-fx-text-fill: yellow;"
                                + "-fx-background-color: DARKTURQUOISE;"
                                + "-fx-background-radius: 50;"
                                + "-fx-border-color: green;"
                                + "-fx-border-radius: 50;"
                                + "-fx-padding: 12;");
                        Type1Button.setOnMouseEntered(event -> {
                            Type1Button.setStyle("-fx-font: bold 17px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        Type1Button.setOnMouseExited(event -> {
                            Type1Button.setStyle("-fx-font: bold 15px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: DARKTURQUOISE;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: green;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        Type2Button.setOnMouseEntered(event -> {
                            Type2Button.setStyle("-fx-font: bold 17px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        Type2Button.setOnMouseExited(event -> {
                            Type2Button.setStyle("-fx-font: bold 15px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: DARKTURQUOISE;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: green;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        HighButton.setOnMouseEntered(event -> {
                            HighButton.setStyle("-fx-font: bold 17px Adobe ;"
                                    + "-fx-font-family: 'Goudy Old Style';"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 15;");
                        });
                        backButton.setOnMouseEntered(event -> {
                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: silver;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: black;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 12;");
                        });
                        backButton.setOnMouseExited(event -> {
                            backButton.setStyle("-fx-font: bold 12px Adobe ;"
                                    + "-fx-text-fill: yellow;"
                                    + "-fx-background-color: DARKTURQUOISE;"
                                    + "-fx-background-radius: 50;"
                                    + "-fx-border-color: green;"
                                    + "-fx-border-radius: 50;"
                                    + "-fx-padding: 12;");
                        });
                        VBox vb2 = new VBox(110);
                        vb2.getChildren().addAll(txt, VB, backButton);

                        VBox vb3 = new VBox(20);
                        vb3.getChildren().addAll(pane1, vb2);
                        Scene HardTypesScene = new Scene(vb3, 750, 500);
                        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                        HardTypesScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                            if (event.getCode() == KeyCode.O) {
                                if (isSoundPlaying) {
                                    stopSound();
                                } else {
                                    playSound();
                                }
                            }
                        });
                        primaryStage.setTitle("Crazy Snake");
                        primaryStage.setScene(HardTypesScene);
                        primaryStage.show();
                        backButton.setOnAction(event -> {
                            Sound.ClickSound();
                            HaLS.resetGame();
                            HaLS.timeline.stop();
                            primaryStage.setScene(StartPlayingScene);
                        });
                        ////// type 1 hard                    
                        Type1Button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                Sound.ClickSound();
                                HaLS.timeline.play();
                                HaLS.resetGame();
                                // مكان الرسم
                                // مستطيلين ف منتصف الشاشه
                                Rectangle r1 = new Rectangle(120, 165, 330, 10);
                                Rectangle r2 = new Rectangle(125, 345, 330, 10);
                                r1.setFill(Color.rgb(250, 175, 175, 1));
                                r1.setStroke(Color.rgb(250, 50, 50, 1));
                                r1.setStrokeWidth(2);
                                r2.setFill(Color.rgb(250, 175, 175, 1));
                                r2.setStroke(Color.rgb(250, 50, 50, 1));
                                r2.setStrokeWidth(2);

                                Pane bp = new Pane();
                                Button backButton = new Button("Back");
                                Button resetButton = new Button("Reset");
                                HBox hb = new HBox(5);
                                hb.getChildren().addAll(backButton, resetButton);
                                bp.getChildren().addAll(hb);
                                backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: red;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                backButton.setOnMouseEntered(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                backButton.setOnMouseExited(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: red;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: red;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                resetButton.setOnMouseEntered(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setOnMouseExited(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: red;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });

                                // back button
                                backButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    HaLS.resetGame();
                                    HaLS.timeline.stop();
                                    primaryStage.setScene(HardTypesScene);
                                });
                                resetButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    HaLS.resetGame();
                                    HaLS.timeline.play();
                                });

                                Canvas canvas = new Canvas(750, 500);
                                GraphicsContext Graphics = canvas.getGraphicsContext2D();
                                Pane pane = new Pane();
                                pane.setStyle("-fx-background-color: black;");
                                pane.getChildren().add(canvas);

                                Line line1 = new Line(563, 75, 750, 75);
                                line1.setStrokeWidth(4);
                                line1.setStroke(Color.rgb(250, 20, 20, 1));

                                Line line2 = new Line(563, 330, 750, 330);
                                line2.setStrokeWidth(4);
                                line2.setStroke(Color.rgb(250, 20, 20, 1));

                                Rectangle rect1 = new Rectangle(2, 2, 750, 500);
                                rect1.setStroke(Color.rgb(250, 20, 20, 1));
                                rect1.setStrokeWidth(4);
                                rect1.setFill(Color.TRANSPARENT);

                                Rectangle rect2 = new Rectangle(20, 20, 540, 460);
                                rect2.setStroke(Color.rgb(250, 20, 20, 1));
                                rect2.setStrokeWidth(4);
                                rect2.setFill(Color.TRANSPARENT);

                                Rectangle rect3 = new Rectangle(20, 20, 540, 460);
                                rect3.setStroke(Color.rgb(250, 175, 175, 1));
                                rect3.setStrokeWidth(4);
                                rect3.setFill(Color.TRANSPARENT);

                                pane.getChildren().addAll(line1, line2, rect1, rect2, rect3, bp, r1, r2);

                                Scene gameScene = new Scene(pane);
                                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                gameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                                    if (event.getCode() == KeyCode.O) {
                                        if (isSoundPlaying) {
                                            stopSound();
                                        } else {
                                            playSound();
                                        }
                                    }
                                });
                                primaryStage.setScene(gameScene);

                                HaLS.timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
                                    HaLS.HardLevelShapes(Graphics);
                                }));

                                HaLS.timeline.setCycleCount(Timeline.INDEFINITE);
                                HaLS.timeline.play();

                                gameScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                                    switch (event.getCode()) {
                                        //space ما يتم تنفيذه عند الضغط على الزر
                                        case Q:
                                            HaLS.handleQKey();
                                            break;
                                        //D ما يتم تنفيذه عند الضغط على الزر
                                        case D:
                                            HaLS.handleDKey();
                                            break;
                                        //A ما يتم تنفيذه عند الضغط على الزر
                                        case A:
                                            HaLS.handleAKey();
                                            break;
                                        //W ما يتم تنفيذه عند الضغط على الزر
                                        case W:
                                            HaLS.handleWKey();
                                            break;
                                        //S ما يتم تنفيذه عند الضغط على الزر
                                        case S:
                                            HaLS.handleSKey();
                                            break;
                                        case E:
                                            HaLS.handleEKey();
                                            break;
                                        case R:
                                            HaLS.handleRKey();
                                            break;
                                    }
                                });

                            }
                        });
                        //////  type 2 hard
                        Type2Button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                Sound.ClickSound();
                                HaLS2.timeline.play();
                                HaLS2.resetGame();
                                // مكان الرسم
                                // مستطيلين ف منتصف الشاشه
                                Rectangle r1 = new Rectangle(185, 82, 10, 335);
                                Rectangle r2 = new Rectangle(365, 82, 10, 335);
                                r1.setFill(Color.rgb(250, 175, 175, 1));
                                r1.setStroke(Color.rgb(250, 50, 50, 1));
                                r1.setStrokeWidth(2);
                                r2.setFill(Color.rgb(250, 175, 175, 1));
                                r2.setStroke(Color.rgb(250, 50, 50, 1));
                                r2.setStrokeWidth(2);

                                Pane bp = new Pane();
                                Button backButton = new Button("Back");
                                Button resetButton = new Button("Reset");
                                HBox hb = new HBox(5);
                                hb.getChildren().addAll(backButton, resetButton);
                                bp.getChildren().addAll(hb);
                                backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: red;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                backButton.setOnMouseEntered(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                backButton.setOnMouseExited(event -> {
                                    backButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: red;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                        + "-fx-text-fill: yellow;"
                                        + "-fx-background-color: red;"
                                        + "-fx-background-radius: 10;"
                                        + "-fx-border-color: black;"
                                        + "-fx-border-radius: 10;"
                                        + "-fx-padding: 2;");
                                resetButton.setOnMouseEntered(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: silver;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });
                                resetButton.setOnMouseExited(event -> {
                                    resetButton.setStyle("-fx-font: bold 10px Adobe ;"
                                            + "-fx-text-fill: yellow;"
                                            + "-fx-background-color: red;"
                                            + "-fx-background-radius: 10;"
                                            + "-fx-border-color: black;"
                                            + "-fx-border-radius: 10;"
                                            + "-fx-padding: 2;");
                                });

                                // back button
                                backButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    HaLS2.resetGame();
                                    HaLS2.timeline.stop();
                                    primaryStage.setScene(HardTypesScene);
                                });
                                resetButton.setOnAction(event -> {
                                    Sound.ClickSound();
                                    HaLS2.resetGame();
                                    HaLS2.timeline.play();
                                });

                                Canvas canvas = new Canvas(750, 500);
                                GraphicsContext Graphics = canvas.getGraphicsContext2D();
                                Pane pane = new Pane();
                                pane.setStyle("-fx-background-color: black;");
                                pane.getChildren().add(canvas);

                                Line line1 = new Line(563, 75, 750, 75);
                                line1.setStrokeWidth(4);
                                line1.setStroke(Color.rgb(250, 20, 20, 1));

                                Line line2 = new Line(563, 330, 750, 330);
                                line2.setStrokeWidth(4);
                                line2.setStroke(Color.rgb(250, 20, 20, 1));

                                Rectangle rect1 = new Rectangle(2, 2, 750, 500);
                                rect1.setStroke(Color.rgb(250, 20, 20, 1));
                                rect1.setStrokeWidth(4);
                                rect1.setFill(Color.TRANSPARENT);

                                Rectangle rect2 = new Rectangle(20, 20, 540, 460);
                                rect2.setStroke(Color.rgb(250, 20, 20, 1));
                                rect2.setStrokeWidth(4);
                                rect2.setFill(Color.TRANSPARENT);

                                Rectangle rect3 = new Rectangle(20, 20, 540, 460);
                                rect3.setStroke(Color.rgb(250, 175, 175, 1));
                                rect3.setStrokeWidth(4);
                                rect3.setFill(Color.TRANSPARENT);

                                pane.getChildren().addAll(line1, line2, rect1, rect2, rect3, bp, r1, r2);

                                Scene gameScene = new Scene(pane);
                                backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
                                gameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                                    if (event.getCode() == KeyCode.O) {
                                        if (isSoundPlaying) {
                                            stopSound();
                                        } else {
                                            playSound();
                                        }
                                    }
                                });
                                primaryStage.setScene(gameScene);

                                HaLS2.timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), event -> {
                                    HaLS2.HardLevelShapes2(Graphics);
                                }));

                                HaLS2.timeline.setCycleCount(Timeline.INDEFINITE);
                                HaLS2.timeline.play();

                                gameScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                                    switch (event.getCode()) {
                                        //space ما يتم تنفيذه عند الضغط على الزر
                                        case Q:
                                            HaLS2.handleQKey();
                                            break;
                                        //D ما يتم تنفيذه عند الضغط على الزر
                                        case D:
                                            HaLS2.handleDKey();
                                            break;
                                        //A ما يتم تنفيذه عند الضغط على الزر
                                        case A:
                                            HaLS2.handleAKey();
                                            break;
                                        //W ما يتم تنفيذه عند الضغط على الزر
                                        case W:
                                            HaLS2.handleWKey();
                                            break;
                                        //S ما يتم تنفيذه عند الضغط على الزر
                                        case S:
                                            HaLS2.handleSKey();
                                            break;
                                        case E:
                                            HaLS2.handleEKey();
                                            break;
                                        case R:
                                            HaLS2.handleRKey();
                                            break;
                                    }
                                });

                            }
                        });
                    }
                });
//////////////////////////////////////////////////////////////
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
