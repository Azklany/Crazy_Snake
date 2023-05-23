
package crazysnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class HighLScreenInterFace {
    
    int CurrentScore;
    int bestScore;
    int fruitEaten;
    int scoreReverseCounter;  


    public HighLScreenInterFace(int CurrentScore,int fruitEaten,int scoreReverseCounter,int bestScore) {
        this.CurrentScore=CurrentScore;
        this.fruitEaten=fruitEaten;
        this.scoreReverseCounter=scoreReverseCounter;
        this.bestScore=bestScore;
    }
    
    public void Show(GraphicsContext Graphics){
                // خلفيه اللعبه 
        Graphics.setFill(Color.rgb(20, 70, 70, .8));
        Graphics.fillRect(0, 0, 750, 500);
        Graphics.setFill(Color.rgb(150, 150, 20, .8));
        for (int i = 5; i <= 1000; i += 5) {
            for (int j = 5; j <= 1000; j += 5) {
                Graphics.fillRect(i, j, 15, 15);
            }
        }

        // خلفيه حيز ظهور الثعبان
        Graphics.setFill(Color.BLACK);
        Graphics.fillRect(20, 20, 540, 460);

        // اسم اللعبه
        Graphics.setFill(Color.rgb(250, 250, 90, 1));
        Graphics.setFont(Font.font("Snap ITC", FontWeight.BOLD, 26));
        Graphics.fillText("High Level", 575, 50);

        // قيمه البونص
        Graphics.setFill(Color.rgb(250, 250, 5, 1));
        Graphics.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        Graphics.fillText("+" + scoreReverseCounter, 720, 222);

        // نوع الخط
        Graphics.setFill(Color.MINTCREAM);
        Graphics.setFont(Font.font("Lucida Calligraphy", FontWeight.NORMAL, 18));

        //fruit eaten مواصفات   
        Graphics.fillText("Fruit Eaten", 594, 110);
        Graphics.fillRect(578, 120, 140, 30);
        Graphics.setFill(Color.rgb(130, 130, 20, .8));
        Graphics.fillRect(579, 121, 138, 28);
        Graphics.setFill(Color.MINTCREAM);
        Graphics.fillText(fruitEaten + "", 575 + (142 - new Text(fruitEaten + "").getLayoutBounds().getWidth()) / 2, 142);

        // Current Score مواصفات   
        Graphics.fillText("Current Score", 584, 190);
        Graphics.fillRect(578, 200, 140, 30);
        Graphics.setFill(Color.rgb(130, 130, 20, .8));
        Graphics.fillRect(579, 201, 138, 28);
        Graphics.setFill(Color.MINTCREAM);
        Graphics.fillText(CurrentScore + "", 575 + (142 - new Text(CurrentScore + "").getLayoutBounds().getWidth()) / 2, 222);

        // High Score مواصفات   
        Graphics.fillText("High Score", 594, 270);
        Graphics.fillRect(578, 280, 140, 30);
        Graphics.setFill(Color.rgb(130, 130, 20, .8));
        Graphics.fillRect(579, 281, 138, 28);
        Graphics.setFill(Color.MINTCREAM);
        Graphics.fillText(bestScore + "", 575 + (142 - new Text(bestScore + "").getLayoutBounds().getWidth()) / 2, 302);

        //tips مواصفات ال 
        Graphics.setFont(Font.font("Arial Black", FontWeight.BOLD, 16));
        Graphics.fillText("Tips :", 570, 360);
        Graphics.setFont(Font.font("Arial", FontWeight.NORMAL, 13));
        Graphics.setFill(Color.RED);
        Graphics.fillText("Red Apple: preferred", 570, 385);
        Graphics.setFill(Color.BROWN);
        Graphics.fillText("Brown Apple: Not preferred", 570, 410);
        Graphics.setFill(Color.GOLD);
        Graphics.fillText("Golden Apple:Much preferred", 570, 435);
        Graphics.setFill(Color.ORANGE);
        Graphics.fillText("ExplosiveLoad: End Game", 570, 460);
//        Graphics.setFill(Color.FIREBRICK);
//        Graphics.fillText("BombLoad: Lose Score", 570, 485);
        
    }
    
}
