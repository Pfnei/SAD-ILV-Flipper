package at.technikum.flipper.abstractfactory;

public interface DisplayFactory {
	
	String pressStart();
	String gameOver();
	String ball(int ball);
	String credits(int credit);
	String gameStart();
	String gameRunning();
	String randomHits();
	String resetElements();
	String bonusGame();
	String bonusPoints();
}
