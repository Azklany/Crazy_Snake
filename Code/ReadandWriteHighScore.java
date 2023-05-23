
package crazysnake;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class ReadandWriteHighScore {
    int CurrentScore;
    int bestScore;
   
    
    public void LLWriteHighScore(int CurrentScore,int bestScore) {
        this.CurrentScore= CurrentScore;
        this.bestScore = bestScore;
        if (CurrentScore >= bestScore) {
            try {
                FileOutputStream fos = new FileOutputStream("./LowLevelHighScore.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                osw.write(bestScore + "");
                osw.flush();
                osw.close();
            } catch (IOException e) {
            }
        }
    }
    public int LLReadHighScore() {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("./LowLevelHighScore.txt"), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String str = "";
            int c;
            while ((c = br.read()) != -1) {
                if (Character.isDigit(c)) {
                    str += (char) c;
                }
            }
            if (str.equals("")) {
                str = "0";
            }

            br.close();
            return Integer.parseInt(str);
        } catch (IOException e) {
        }
        return 0;
    }
    public void MLWriteHighScore(int CurrentScore,int bestScore) {
        this.CurrentScore= CurrentScore;
        this.bestScore = bestScore;
        if (CurrentScore >= bestScore) {
            try {
                FileOutputStream fos = new FileOutputStream("./MiddelLevelHighScore.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                osw.write(bestScore + "");
                osw.flush();
                osw.close();
            } catch (IOException e) {
            }
        }
    }
    public int MLReadHighScore() {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("./MiddelLevelHighScore.txt"), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String str = "";
            int c;
            while ((c = br.read()) != -1) {
                if (Character.isDigit(c)) {
                    str += (char) c;
                }
            }
            if (str.equals("")) {
                str = "0";
            }

            br.close();
            return Integer.parseInt(str);
        } catch (IOException e) {
        }
        return 0;
    }
    public void HiLWriteHighScore(int CurrentScore,int bestScore) {
        this.CurrentScore= CurrentScore;
        this.bestScore = bestScore;
        if (CurrentScore >= bestScore) {
            try {
                FileOutputStream fos = new FileOutputStream("./HighLevelHighScore.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                osw.write(bestScore + "");
                osw.flush();
                osw.close();
            } catch (IOException e) {
            }
        }
    }
    public int HiLReadHighScore() {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("./HighLevelHighScore.txt"), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String str = "";
            int c;
            while ((c = br.read()) != -1) {
                if (Character.isDigit(c)) {
                    str += (char) c;
                }
            }
            if (str.equals("")) {
                str = "0";
            }

            br.close();
            return Integer.parseInt(str);
        } catch (IOException e) {
        }
        return 0;
    }
    public void HaLWriteHighScore(int CurrentScore,int bestScore) {
        this.CurrentScore= CurrentScore;
        this.bestScore = bestScore;
        if (CurrentScore >= bestScore) {
            try {
                FileOutputStream fos = new FileOutputStream("./HardLevelHighScore.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                osw.write(bestScore + "");
                osw.flush();
                osw.close();
            } catch (IOException e) {
            }
        }
    }
    public int HaLReadHighScore() {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("./HardLevelHighScore.txt"), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String str = "";
            int c;
            while ((c = br.read()) != -1) {
                if (Character.isDigit(c)) {
                    str += (char) c;
                }
            }
            if (str.equals("")) {
                str = "0";
            }

            br.close();
            return Integer.parseInt(str);
        } catch (IOException e) {
        }
        return 0;
    }
}
