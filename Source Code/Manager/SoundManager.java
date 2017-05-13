package Manager;
import GameMemory.*;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Doga Zeynep Germen
 */
// The JavaFX library should be added to run the methods in this class.
public class SoundManager extends Manager {
    
    // How many tracks are available in the soundtrack folder????
    private static int SOUNDTRACK_LENGTH = 10;
    
    private MediaPlayer mediaPlayer;
    private Media curMedia;
    
    // Specifies the currently playing track no
    private int trackNo = 0;

    public SoundManager(Game game){
        super(game);
    }
    
    // Play the audio file
    /*public void playBGSound() {

        String track = "src/data/lotr_soundtrack/track" + trackNo + ".mp3";
        curMedia = new Media(new File(track).toURI().toString());
        mediaPlayer = new MediaPlayer(curMedia);
        mediaPlayer.setAutoPlay();
    }*/
    
    
    // Play the next audio file
    /*public void changeOST() {
        trackNo = (trackNo + 1) % SOUNDTRACK_LENGTH;
        String track = "src/data/lotr_soundtrack/track" + trackNo + ".mp3";
        curMedia = new Media(new File(track).toURI().toString());
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }*/
    
}
