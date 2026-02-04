package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

public class PlaySoundCommand implements Command {
	private String soundFile;
	
	public PlaySoundCommand(String soundFile) {
		this.soundFile = soundFile;
	}
	
	@Override
	public void execute(Flipper flipper) {
		System.out.println("Spiele Sound: " + soundFile);
		// AudioPlayer.play(soundFile);
	}
	

}
