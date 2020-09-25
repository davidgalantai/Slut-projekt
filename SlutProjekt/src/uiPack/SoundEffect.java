package uiPack;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {

	Clip clip;

	public void setFile(String soundFileName) { // a try catch block sets the file so it can be played after.

		try {
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		} catch (Exception e) {

		}
	}

	public void play() {
		 
		clip.start(); //plays the sounds
		
	}

	public void stop() {

		clip.stop();
		
	}

	    

	}

