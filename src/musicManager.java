import java.io.File;

import javax.sound.sampled.*;


public class musicManager {
	static Clip megaman;
	public static void maintheme()
	{

		try {
			megaman = AudioSystem.getClip();
			megaman.open(AudioSystem.getAudioInputStream(new File(
					"resources/megaman.wav")));
			System.out
					.println("Attempting to play resources/megaman.wav...");
		} catch (Exception e) {

		}
		megaman.loop(Clip.LOOP_CONTINUOUSLY);
	}

}
