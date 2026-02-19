package at.technikum.flipper.abstractfactory;

public class FlipperDisplay {
	private DisplayFactory factory;
	
	public FlipperDisplay(DisplayFactory factory) {
		this.factory = factory;
	}
	
	public void setFactory(DisplayFactory factory) {
		this.factory = factory;
	}
	
	public void showPressStart() {
		System.out.println(factory.pressStart());
	}
	
	public void showGameOver() {
		System.out.println(factory.gameOver());
	}
	
	public void showBall(int ball) {
		System.out.println(factory.ball(ball));
	}
	
	public void showCredits(int credit) {
		System.out.println(factory.credits(credit));
	}
	
	public void showGameStart() {
		System.out.println(factory.gameStart());
	}
	
	public void showGameRunning() {
		System.out.println(factory.gameRunning());
	}
	
	public void showRandomHits() {
		System.out.println(factory.randomHits());
	}
	
	public void showResetElements() {
		System.out.println(factory.resetElements());
	}
	
	public void showBonusGame() {
		System.out.println(factory.bonusGame());
	}
	
	public void showBonusPoints() {
		System.out.println(factory.bonusPoints());
	}
	

}
