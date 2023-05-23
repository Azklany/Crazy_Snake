
package crazysnake;


public class IsReflection {
    
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    int lengthOfSnake;
     int[] boardX = new int[500];
     int[] boardY = new int[500];
    
    
    public IsReflection(boolean left,boolean right,boolean up,boolean down,int lengthOfSnake,int[] boardX,int[] boardY) {
        this.boardX=boardX;
        this.boardY=boardY;
        this.down=down;
        this.left=left;
        this.right=right;
        this.up=up;
        this.lengthOfSnake=lengthOfSnake;      
    }
    
    public void Reflection(){
        
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
                    boardX[i] = 20;
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
                    boardX[i] = 540;
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
                    boardY[i] = 460;
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
                    boardY[i] = 20;
                }
            }
        }

        
        
    }
}
    
       