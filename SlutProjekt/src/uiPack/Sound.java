package uiPack;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sound {

	JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton soundButton, musicButton, greetingButton;
	String bellsound, greeting, houseMusic, musicOnOff;
	ButtonHandler bHandler = new ButtonHandler();
	SoundEffect se = new SoundEffect();
	Music music = new Music();

	public static void main(String[] args) {

		new Sound();
	}

	public Sound() {

		ImagePanel panel = new ImagePanel(new ImageIcon("programing.png").getImage()); // image file

		window = new JFrame(); // new window
		window.setSize(500, 250); // windows size
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null); // Layout position
		con = window.getContentPane();
		// window.getContentPane().setBackground(Color.DARK_GRAY);

		buttonPanel = new JPanel(); // new buttonPanel
		buttonPanel.setBounds(155, 80, 200, 100); // button positions
		con.add(buttonPanel);
		// buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setOpaque(false); // makes the border around the buttons transparent	
		
		greetingButton = new JButton("greetings"); // new button greeting
		greetingButton.addActionListener(bHandler);
		greetingButton.setActionCommand("greetingB");
		buttonPanel.add(greetingButton);

		soundButton = new JButton("bell"); // new button bell
		soundButton.addActionListener(bHandler);
		soundButton.setActionCommand("soundB");
		buttonPanel.add(soundButton);

		musicButton = new JButton("Music"); // new button music
		musicButton.addActionListener(bHandler);
		musicButton.setActionCommand("musicB");
		buttonPanel.add(musicButton);

		window.getContentPane().add(panel); // add the picture
		window.setVisible(true); // window and buttons appear

		greeting = "hello.wav"; // file imports
		bellsound = "bell.wav";
		houseMusic = "music.wav";

		musicOnOff = "off"; // in standard the music is off
	}

	public class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String clickedButton = event.getActionCommand(); // if button clicked get the sound

			switch (clickedButton) {
			case "soundB":
				
				se.setFile(bellsound); // set the sound and play it
				se.play();
				break; // break so the files don't play from the same button at the same time
				
			case "greetingB":
				se.setFile(greeting);
				se.play();
				break;
				
			case "musicB":

				if (musicOnOff.equals("off")) {  //if music is off and you press the button  set the file and play change the button to music on
					music.setFile(houseMusic);
					music.play();
					musicOnOff = "on";
					musicButton.setText("Music on");
				} else if (musicOnOff.equals("on")) {  //if music on and you press the button stop the music and change button text to music off
					music.stop();
					musicOnOff = "off";
					musicButton.setText("Music off");
				}

			}
		}

	}
}