package crazysnake;

import java.util.LinkedList;
import java.util.Random;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HardLevelShapes {

    ReadandWriteHighScore HaL = new ReadandWriteHighScore();
    // حيز ظهور الثعبان
    final int[] boardX = new int[500];
    final int[] boardY = new int[500];

    // لتحديد موقع راس و جسد الثعبان بالكامل حتى يتم مقارنته بموقع الطعام بعد ذلك
    LinkedList<SnakePosition> snake = new LinkedList();

    //الاتجاهات الاربعه للثعبان
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    // اوجه الثعبان الاربعه
    Image RightFace = new Image(getClass().getResourceAsStream("/images/RightFace.png"));
    Image LeftFace = new Image(getClass().getResourceAsStream("/images/LeftFace.png"));
    Image UpFace = new Image(getClass().getResourceAsStream("/images/UpFace.png"));
    Image DownFace = new Image(getClass().getResourceAsStream("/images/DownFace.png"));

    //جسم الثعبان
    Image SnakeBody = new Image(getClass().getResourceAsStream("/images/SnakeBody.png"));

    // انواع الطعام المتاحه للثعبان
    Image goodfruitImage = new Image(getClass().getResourceAsStream("/images/goodfruits.png"));
    Image badfruitImage = new Image(getClass().getResourceAsStream("/images/badfruits.png"));
    Image goldenfruitImage = new Image(getClass().getResourceAsStream("/images/goldenfruits.png"));
    Image explosiveloadImage = new Image(getClass().getResourceAsStream("/images/explosiveload.png"));
    Image bombImage = new Image(getClass().getResourceAsStream("/images/Bomb.png"));

    //الطول الابتدائى للثعبان
    int lengthOfSnake = 2;

    Timeline timeline = new Timeline();

    // اختبار حركه الثعبان
    int moves = 0;

    int CurrentScore = 0;
    int fruitEaten = 0;
    int scoreReverseCounter = 200;
    double snakeSpeed = 1.05;

    // قراءه اعلى سكور يتم الوصول اليه
    int bestScore = HaL.HaLReadHighScore();

    //لانتاج اماكن عشوائيه لظهور الطعام 
    Random random = new Random();

    // هنا قمنا بتحديد مكان أول طعام سيظهر في اللعبة قبل أن يبدأ المستخدم باللعب, و جعلناه يظهر تحت الأفعى
    int goodxPos = random.nextInt(11);
    int goodyPos = 5 + random.nextInt(12);
    int badxPos = random.nextInt(11);
    int badyPos = 5 + random.nextInt(12);
    int goldxPos = random.nextInt(11);
    int goldyPos = 5 + random.nextInt(12);
    int ELxPos = random.nextInt(11);
    int ELyPos = 5 + random.nextInt(12);
    int bombxPos = random.nextInt(11);
    int bombyPos = 5 + random.nextInt(12);

    boolean isGameOver = false;

    public void HardLevelShapes(GraphicsContext Graphics) {

        // اماكن ظهور التفاح الاحمر
        // 11
        int[] fruitXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        //17
        int[] fruitYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اماكن ظهور التفاح البنى
        int[] badfruitXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] badfruitYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اماكن ظهور التفاح الذهبى
        int[] goldfruitXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] goldfruitYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اماكن ظهور التفاح المفرقعات
        int[] ELXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] ELYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        //bomb اماكن ظهور التفاح ال 
        int[] bombXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] bombYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اول موضع لظهور الثعبان و القيمه الابتدائيه للعداد
        if (moves == 0) {
            boardX[1] = 60;
            boardX[0] = 80;

            boardY[1] = 100;
            boardY[0] = 100;

            scoreReverseCounter = 200;
            timeline.play();
        }

        // المقارنه بين الاسكور الحالى واقصى اسكور تم الوصول اليه
        if (CurrentScore > bestScore) {
            bestScore = CurrentScore;
        }
        if (CurrentScore > 0) {
            for (int i = 10; i >= 1; i--) {
                if (CurrentScore > i * 1000) {
                    timeline.setRate(i * 0.05 + snakeSpeed);
                    break;
                }
            }
        }

        // ScreenInterFace عرض المواصفات
        HardLScreenInterFace SI = new HardLScreenInterFace(CurrentScore, fruitEaten, scoreReverseCounter, bestScore);
        SI.Show(Graphics);

        // الاتجاه الافتراضئ للثعبان
        Graphics.drawImage(RightFace, boardX[0], boardY[0]);

        // تجديد موضع الثعبان 
        snake.clear();

        // رسم اتجاهات التعبان
        for (int i = 0; i < lengthOfSnake; i++) {
            if (i == 0 && left) {
                Graphics.drawImage(LeftFace, boardX[i], boardY[i]);
            } else if (i == 0 && right) {
                Graphics.drawImage(RightFace, boardX[i], boardY[i]);
            } else if (i == 0 && up) {
                Graphics.drawImage(UpFace, boardX[i], boardY[i]);
            } else if (i == 0 && down) {
                Graphics.drawImage(DownFace, boardX[i], boardY[i]);
            } else if (i != 0) {
                Graphics.drawImage(SnakeBody, boardX[i], boardY[i]);
            }

            // snake  تخرين موقع الثعبان ف 
            snake.add(new SnakePosition(boardX[i], boardY[i]));
        }

        // معدل البونص واقل مقدار له
        if (scoreReverseCounter != 50) {
            scoreReverseCounter--;
        }

        // التأكد اذا لمس راس الثعبان جسده ام لا
        for (int i = 1; i < lengthOfSnake; i++) {
            //  عندما يلمس رأس الأفعى جسدها سيتم جعل أول دائرة موجودة خلف الرأس تمثل رأس الأفعى حتى لا يظهر رأسها فوق جسدها
            if (boardX[i] == boardX[0] && boardY[i] == boardY[0]) {
                if (right) {
                    Graphics.drawImage(RightFace, boardX[1], boardY[1]);
                } else if (left) {
                    Graphics.drawImage(LeftFace, boardX[1], boardY[1]);
                } else if (up) {
                    Graphics.drawImage(UpFace, boardX[1], boardY[1]);
                } else if (down) {
                    Graphics.drawImage(DownFace, boardX[1], boardY[1]);
                }

                GameOver(Graphics);
            }
        }
        /*
        ً    When Current Score < 1000
         */
        // عندما يتساوى موقع كل من الطعام وراس االثعبان يتم اعاده تعيين المتغيرات حسب نوع الطعام
        // GoodFruits
        if ((fruitXPos[goodxPos] == boardX[0]) && fruitYPos[goodyPos] == boardY[0]) {
            CurrentScore += scoreReverseCounter;
            scoreReverseCounter = 200;
            fruitEaten++;
            lengthOfSnake++;
            Audio GFA = new Audio();
            GFA.SoundGoodFruits();
        }

        // التأكد من موضع كل من االثعبان والطعام
        for (int i = 0; i < snake.size(); i++) {
            // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
            if (snake.get(i).boardX == fruitXPos[goodxPos] && snake.get(i).boardY == fruitYPos[goodyPos]) {
                goodxPos = random.nextInt(11);
                goodyPos = random.nextInt(17);
            }
        }
        // عرض الطعام
        Graphics.drawImage(goodfruitImage, fruitXPos[goodxPos], fruitYPos[goodyPos]);

        /*
ً            When Current Score > 1000
         */
        //BadFruits
        if (CurrentScore > 1000) {
            Graphics.drawImage(badfruitImage, badfruitXPos[badxPos], badfruitYPos[badyPos]);
            if ((badfruitXPos[badxPos] == boardX[0]) && badfruitYPos[badyPos] == boardY[0]) {
                CurrentScore -= scoreReverseCounter;
                scoreReverseCounter = 200;
                fruitEaten--;
                lengthOfSnake--;
                Audio BFA = new Audio();
                BFA.SoundBadFruits();
            }
            for (int i = 0; i < snake.size(); i++) {
                // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
                if (snake.get(i).boardX == badfruitXPos[badxPos] && snake.get(i).boardY == badfruitYPos[badyPos]) {
                    badxPos = random.nextInt(11);
                    badyPos = random.nextInt(17);
                }
            }
        }
        // GoldenFruits
        if ((CurrentScore > 2000 && CurrentScore < 2200) || (CurrentScore > 3000 && CurrentScore < 3200) || (CurrentScore > 4000 && CurrentScore < 4200) || (CurrentScore > 5000 && CurrentScore < 5200) || (CurrentScore > 6000 && CurrentScore < 6200) || (CurrentScore > 7000 && CurrentScore < 7200) || (CurrentScore > 8000 && CurrentScore < 8200) || (CurrentScore > 9000 && CurrentScore < 9200)) {
            Graphics.drawImage(goldenfruitImage, goldfruitXPos[goldxPos], goldfruitYPos[goldyPos]);
            if ((goldfruitXPos[goldxPos] == boardX[0]) && goldfruitYPos[goldyPos] == boardY[0]) {
                CurrentScore += scoreReverseCounter * 2;
                scoreReverseCounter = 200;
                fruitEaten += 1;
                lengthOfSnake += 1;
                Audio GFA = new Audio();
                GFA.SoundGoldenFruits();
            }
            for (int i = 0; i < snake.size(); i++) {
                // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
                if (snake.get(i).boardX == goldfruitXPos[goldxPos] && snake.get(i).boardY == goldfruitYPos[goldyPos]) {
                    goldxPos = random.nextInt(11);
                    goldyPos = random.nextInt(17);
                }
            }
        }
        // bomb
        if (CurrentScore > 3000) {
            Graphics.drawImage(bombImage, bombXPos[bombxPos], bombYPos[badyPos]);
            if ((bombXPos[bombxPos] == boardX[0]) && bombYPos[badyPos] == boardY[0]) {
                CurrentScore = 0;
                scoreReverseCounter = 200;
                fruitEaten = 0;
                lengthOfSnake = 2;
                Audio BL = new Audio();
                BL.BombLoad();
            }
            for (int i = 0; i < snake.size(); i++) {
                // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
                if (snake.get(i).boardX == goldfruitXPos[goldxPos] && snake.get(i).boardY == goldfruitYPos[goldyPos]) {
                    goldxPos = random.nextInt(11);
                    goldyPos = random.nextInt(17);
                }
            }
        }
        // explosive load
        if (CurrentScore > 4000) {
            Graphics.drawImage(explosiveloadImage, ELXPos[ELxPos], ELYPos[ELyPos]);
            if ((ELXPos[ELxPos] == boardX[0]) && ELYPos[ELyPos] == boardY[0]) {
                GameOver(Graphics);
            }
        }

        //  انعكاس الثعبان
        if (right) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardY[i + 1] = boardY[i];
            }

            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardX[i] = boardX[i] + 20;
                } else {
                    boardX[i] = boardX[i - 1];
                }

                if (boardX[i] > 540) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 155 && boardY[i] <= 165))) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 330 && boardY[i] <= 340))) {
                    GameOver(Graphics);
                }

            }
        } else if (left) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardY[i + 1] = boardY[i];
            }

            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardX[i] = boardX[i] - 20;
                } else {
                    boardX[i] = boardX[i - 1];
                }

                if (boardX[i] < 20) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 155 && boardY[i] <= 165))) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 330 && boardY[i] <= 340))) {
                    GameOver(Graphics);
                }
            }
        } else if (up) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardX[i + 1] = boardX[i];
            }

            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardY[i] = boardY[i] - 20;
                } else {
                    boardY[i] = boardY[i - 1];
                }

                if (boardY[i] < 20) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 155 && boardY[i] <= 165))) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 330 && boardY[i] <= 340))) {
                    GameOver(Graphics);
                }
            }
        } else if (down) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardX[i + 1] = boardX[i];
            }

            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardY[i] = boardY[i] + 20;
                } else {
                    boardY[i] = boardY[i - 1];
                }

                if (boardY[i] > 460) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 155 && boardY[i] <= 165))) {
                    GameOver(Graphics);
                } else if (((boardX[i] <= 440 && boardX[i] >= 120) && (boardY[i] >= 330 && boardY[i] <= 340))) {
                    GameOver(Graphics);
                }
            }
        }

    }

    public void HardLevelShapes2(GraphicsContext Graphics) {

        // اماكن ظهور التفاح الاحمر
        // 11
        int[] fruitXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        //17
        int[] fruitYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اماكن ظهور التفاح البنى
        int[] badfruitXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] badfruitYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اماكن ظهور التفاح الذهبى
        int[] goldfruitXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] goldfruitYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اماكن ظهور التفاح المفرقعات
        int[] ELXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] ELYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        //bomb اماكن ظهور التفاح ال 
        int[] bombXPos = {20, 40, 60, 80, 100, 160, 460, 480, 500, 520, 540};
        int[] bombYPos = {20, 40, 60, 100, 120, 200, 220, 240, 260, 280, 300, 360, 380, 400, 420, 440, 460};

        // اول موضع لظهور الثعبان و القيمه الابتدائيه للعداد
        if (moves == 0) {
            boardX[1] = 60;
            boardX[0] = 80;

            boardY[1] = 100;
            boardY[0] = 100;

            scoreReverseCounter = 200;
            timeline.play();
        }

        // المقارنه بين الاسكور الحالى واقصى اسكور تم الوصول اليه
        if (CurrentScore > bestScore) {
            bestScore = CurrentScore;
        }
        if (CurrentScore > 0) {
            for (int i = 10; i >= 1; i--) {
                if (CurrentScore > i * 1000) {
                    timeline.setRate(i * 0.05 + snakeSpeed);
                    break;
                }
            }
        }

        // ScreenInterFace عرض المواصفات
        HardLScreenInterFace SI = new HardLScreenInterFace(CurrentScore, fruitEaten, scoreReverseCounter, bestScore);
        SI.Show(Graphics);

        // الاتجاه الافتراضئ للثعبان
        Graphics.drawImage(RightFace, boardX[0], boardY[0]);

        // تجديد موضع الثعبان 
        snake.clear();

        // رسم اتجاهات التعبان
        for (int i = 0; i < lengthOfSnake; i++) {
            if (i == 0 && left) {
                Graphics.drawImage(LeftFace, boardX[i], boardY[i]);
            } else if (i == 0 && right) {
                Graphics.drawImage(RightFace, boardX[i], boardY[i]);
            } else if (i == 0 && up) {
                Graphics.drawImage(UpFace, boardX[i], boardY[i]);
            } else if (i == 0 && down) {
                Graphics.drawImage(DownFace, boardX[i], boardY[i]);
            } else if (i != 0) {
                Graphics.drawImage(SnakeBody, boardX[i], boardY[i]);
            }

            // snake  تخرين موقع الثعبان ف 
            snake.add(new SnakePosition(boardX[i], boardY[i]));
        }

        // معدل البونص واقل مقدار له
        if (scoreReverseCounter != 50) {
            scoreReverseCounter--;
        }

        // التأكد اذا لمس راس الثعبان جسده ام لا
        for (int i = 1; i < lengthOfSnake; i++) {
            //  عندما يلمس رأس الأفعى جسدها سيتم جعل أول دائرة موجودة خلف الرأس تمثل رأس الأفعى حتى لا يظهر رأسها فوق جسدها
            if (boardX[i] == boardX[0] && boardY[i] == boardY[0]) {
                if (right) {
                    Graphics.drawImage(RightFace, boardX[1], boardY[1]);
                } else if (left) {
                    Graphics.drawImage(LeftFace, boardX[1], boardY[1]);
                } else if (up) {
                    Graphics.drawImage(UpFace, boardX[1], boardY[1]);
                } else if (down) {
                    Graphics.drawImage(DownFace, boardX[1], boardY[1]);
                }

                GameOver(Graphics);
            }
        }
        /*
        ً    When Current Score < 1000
         */
        // عندما يتساوى موقع كل من الطعام وراس االثعبان يتم اعاده تعيين المتغيرات حسب نوع الطعام
        // GoodFruits
        if ((fruitXPos[goodxPos] == boardX[0]) && fruitYPos[goodyPos] == boardY[0]) {
            CurrentScore += scoreReverseCounter;
            scoreReverseCounter = 200;
            fruitEaten++;
            lengthOfSnake++;
            Audio GFA = new Audio();
            GFA.SoundGoodFruits();
        }

        // التأكد من موضع كل من االثعبان والطعام
        for (int i = 0; i < snake.size(); i++) {
            // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
            if (snake.get(i).boardX == fruitXPos[goodxPos] && snake.get(i).boardY == fruitYPos[goodyPos]) {
                goodxPos = random.nextInt(11);
                goodyPos = random.nextInt(17);
            }
        }
        // عرض الطعام
        Graphics.drawImage(goodfruitImage, fruitXPos[goodxPos], fruitYPos[goodyPos]);

        /*
ً            When Current Score > 1000
         */
        //BadFruits
        if (CurrentScore > 1000) {
            Graphics.drawImage(badfruitImage, badfruitXPos[badxPos], badfruitYPos[badyPos]);
            if ((badfruitXPos[badxPos] == boardX[0]) && badfruitYPos[badyPos] == boardY[0]) {
                CurrentScore -= scoreReverseCounter;
                scoreReverseCounter = 200;
                fruitEaten--;
                lengthOfSnake--;
                Audio BFA = new Audio();
                BFA.SoundBadFruits();
            }
            for (int i = 0; i < snake.size(); i++) {
                // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
                if (snake.get(i).boardX == badfruitXPos[badxPos] && snake.get(i).boardY == badfruitYPos[badyPos]) {
                    badxPos = random.nextInt(11);
                    badyPos = random.nextInt(17);
                }
            }
        }
        // GoldenFruits
        if ((CurrentScore > 2000 && CurrentScore < 2200) || (CurrentScore > 3000 && CurrentScore < 3200) || (CurrentScore > 4000 && CurrentScore < 4200) || (CurrentScore > 5000 && CurrentScore < 5200) || (CurrentScore > 6000 && CurrentScore < 6200) || (CurrentScore > 7000 && CurrentScore < 7200) || (CurrentScore > 8000 && CurrentScore < 8200) || (CurrentScore > 9000 && CurrentScore < 9200)) {
            Graphics.drawImage(goldenfruitImage, goldfruitXPos[goldxPos], goldfruitYPos[goldyPos]);
            if ((goldfruitXPos[goldxPos] == boardX[0]) && goldfruitYPos[goldyPos] == boardY[0]) {
                CurrentScore += scoreReverseCounter * 2;
                scoreReverseCounter = 200;
                fruitEaten += 1;
                lengthOfSnake += 1;
                Audio GFA = new Audio();
                GFA.SoundGoldenFruits();
            }
            for (int i = 0; i < snake.size(); i++) {
                // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
                if (snake.get(i).boardX == goldfruitXPos[goldxPos] && snake.get(i).boardY == goldfruitYPos[goldyPos]) {
                    goldxPos = random.nextInt(11);
                    goldyPos = random.nextInt(17);
                }
            }
        }
        // bomb
        if (CurrentScore > 3000) {
            Graphics.drawImage(bombImage, bombXPos[bombxPos], bombYPos[badyPos]);
            if ((bombXPos[bombxPos] == boardX[0]) && bombYPos[badyPos] == boardY[0]) {
                CurrentScore = 0;
                scoreReverseCounter = 200;
                fruitEaten = 0;
                lengthOfSnake = 2;
                Audio BL = new Audio();
                BL.BombLoad();
            }
            for (int i = 0; i < snake.size(); i++) {
                // اذا تساوى موقع كل من راس الثعبان و الطعام يتم تغيير موقع الطعام الى مكان عشوائى
                if (snake.get(i).boardX == goldfruitXPos[goldxPos] && snake.get(i).boardY == goldfruitYPos[goldyPos]) {
                    goldxPos = random.nextInt(11);
                    goldyPos = random.nextInt(17);
                }
            }
        }
        // explosive load
        if (CurrentScore > 4000) {
            Graphics.drawImage(explosiveloadImage, ELXPos[ELxPos], ELYPos[ELyPos]);
            if ((ELXPos[ELxPos] == boardX[0]) && ELYPos[ELyPos] == boardY[0]) {
                GameOver(Graphics);
            }
        }

        //  انعكاس الثعبان
        if (right) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardY[i + 1] = boardY[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardX[i] = boardX[i] + 20;
                } else {
                    boardX[i] = boardX[i - 1];
                }
                if ((boardX[i] >= 180 && boardX[i] <= 190) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if ((boardX[i] >= 360 && boardX[i] <= 370) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if (boardX[i] > 540) {
                    GameOver(Graphics);
                }

            }
            
        } else if (left) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardY[i + 1] = boardY[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardX[i] = boardX[i] - 20;
                } else {
                    boardX[i] = boardX[i - 1];
                }
                if ((boardX[i] >= 180 && boardX[i] <= 190) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if ((boardX[i] >= 360 && boardX[i] <= 370) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if (boardX[i] < 20) {
                    GameOver(Graphics);
                }
            }
            
        } else if (up) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardX[i + 1] = boardX[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardY[i] = boardY[i] - 20;
                } else {
                    boardY[i] = boardY[i - 1];
                }
                if ((boardX[i] >= 180 && boardX[i] <= 190) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if ((boardX[i] >= 360 && boardX[i] <= 370) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if (boardY[i] < 20) {
                    GameOver(Graphics);
                }
            }
            
        } else if (down) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                boardX[i + 1] = boardX[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    boardY[i] = boardY[i] + 20;
                } else {
                    boardY[i] = boardY[i - 1];
                }
                if ((boardX[i] >= 180 && boardX[i] <= 190) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if ((boardX[i] >= 360 && boardX[i] <= 370) && (boardY[i] >= 80 && boardY[i] <= 410)) {
                    GameOver(Graphics);
                } else if (boardY[i] > 460) {
                    GameOver(Graphics);
                }
            }
        }

    }

    public void handleQKey() {
        // توقيف اللعب اذا كانت متفعله
        if (timeline.getStatus() == Timeline.Status.RUNNING && !isGameOver) {
            timeline.stop();
            // استكمال اللعب اذا كانت متوقفهً
        } else if (timeline.getStatus() != Timeline.Status.RUNNING && !isGameOver) {
            timeline.play();
            // اعاده اللعب من جديد اذا خسر الاعب
        } else if (timeline.getStatus() != Timeline.Status.RUNNING && isGameOver) {
            resetGame();
            timeline.play();
        }
    }

    public void handleEKey() {
        snakeSpeed += .02;
        timeline.setRate(snakeSpeed);
    }

    public void handleRKey() {
        snakeSpeed -= .02;
        timeline.setRate(snakeSpeed);
    }

    public void handleDKey() {
        moves++;
        right = true;
        // التأكد اولا ان الثعبان لا يتحرك جهه الشمال
        if (!left) {
            right = true;
        } else {
            right = false;
            left = true;
        }
        up = false;
        down = false;
    }

    public void handleAKey() {
        moves++;
        left = true;
        // التأكد اولا ان الثعبان لا يتحرك جهه اليمين
        if (!right) {
            left = true;
        } else {
            left = false;
            right = true;
        }
        up = false;
        down = false;
    }

    public void handleWKey() {
        moves++;
        up = true;
        // التأكد اولا ان الثعبان لا يتحرك جهه الاسفل
        if (!down) {
            up = true;
        } else {
            up = false;
            down = true;
        }
        left = false;
        right = false;
    }

    public void handleSKey() {
        moves++;
        down = true;
        // التأكد اولا ان الثعبان لا يتحرك جهه الاعلى
        if (!up) {
            down = true;
        } else {
            up = true;
            down = false;
        }
        left = false;
        right = false;
    }

    public void resetGame() {
        moves = 0;
        lengthOfSnake = 2;
        fruitEaten = 0;
        CurrentScore = 0;
        timeline.setRate(1);
        snakeSpeed = 1;
        right = true;
        left = false;
        up = false;
        down = false;
        isGameOver = false;
        int goodxPos = random.nextInt(22);
        int goodyPos = 5 + random.nextInt(17);
    }

    public void GameOver(GraphicsContext Graphics) {

        isGameOver = true;
        Audio GOA = new Audio();
        GOA.SoundGameOver();
        timeline.stop();
        Graphics.setFill(Color.RED);
        Graphics.setFont(Font.font("Monotype Corsiva", FontWeight.EXTRA_BOLD, 50));
        Graphics.fillText("Game Over", 180, 240);

        Graphics.setFill(Color.BROWN);
        Graphics.setFont(Font.font("Monotype Corsiva", FontWeight.EXTRA_BOLD, 20));
        Graphics.fillText("Press Q To Restart", 215, 280);

        // كتابه اعلى اسكور وصل اليه الاعب
        HaL.HaLWriteHighScore(CurrentScore, bestScore);
    }

}
