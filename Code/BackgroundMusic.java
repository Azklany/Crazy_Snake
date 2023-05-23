
package crazysnake;

import javafx.scene.media.AudioClip;


public class BackgroundMusic {
    private AudioClip backgroundMusic;
    
    
    
    
       public void start (){
        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
           Play();
    }
        public void stop (){
        backgroundMusic = new AudioClip(getClass().getResource("LobbySound.wav").toString());
           stopp();
    }
       private void stopp(){
        
        backgroundMusic.stop();
    }
           private  void Play (){
        backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
        backgroundMusic.play();
    }
}
