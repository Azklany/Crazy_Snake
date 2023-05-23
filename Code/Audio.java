
package crazysnake;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Audio {
    
    // Audio
     public void SoundGoodFruits()
    {
        try{      
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("D:\\goodfruits.wav"));      
        AudioFormat format = stream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
        Clip clip = (Clip) AudioSystem.getLine(info);        
         clip.open(stream);      
         clip.start();    
    } catch (Exception e)
    {      
         e.printStackTrace();    
    }  
    }
    
    public void SoundBadFruits()
    {
        try{      
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("D:\\badfruits.wav"));      
        AudioFormat format = stream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
        Clip clip = (Clip) AudioSystem.getLine(info);        
         clip.open(stream);      
         clip.start();    
    } catch (Exception e)
    {      
         e.printStackTrace();    
    }  
    }
     public void SoundGoldenFruits()
    {
        try{      
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("D:\\goldenfruits.wav"));      
        AudioFormat format = stream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
        Clip clip = (Clip) AudioSystem.getLine(info);        
         clip.open(stream);      
         clip.start();    
    } catch (Exception e)
    {      
         e.printStackTrace();    
    }  
    }
     public void BombLoad()
    {
        try{      
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("D:\\bomb.wav"));      
        AudioFormat format = stream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
        Clip clip = (Clip) AudioSystem.getLine(info);        
         clip.open(stream);      
         clip.start();    
    } catch (Exception e)
    {      
         e.printStackTrace();    
    }  
    }
      public void SoundGameOver()
    {
        try{      
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("D:\\GameOver.wav"));      
        AudioFormat format = stream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
        Clip clip = (Clip) AudioSystem.getLine(info);        
         clip.open(stream);      
         clip.start();    
    } catch (Exception e)
    {      
         e.printStackTrace();    
    }  
    }
     
      public void ClickSound()
    {
        try{      
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("D:\\Sound.wav"));      
        AudioFormat format = stream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
        Clip clip = (Clip) AudioSystem.getLine(info);        
         clip.open(stream);      
         clip.start();    
    } catch (Exception e)
    {      
         e.printStackTrace();    
    }  
    }

    
}
