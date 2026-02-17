package at.technikum.flipper.visitor;

import at.technikum.flipper.Flipper;
import at.technikum.flipper.element.*;
public class AdditionalPointsVisitor implements FlipperElementVisitor {
	
	private final Flipper flipper;
	private int total;
	
	public AdditionalPointsVisitor(Flipper flipper) {
		this.flipper = flipper;
		this.total = 0;
	}
	
	public int getTotal() {
		return total;
	}
	
	private int ballMultiplier() {
		return flipper.getRemainingBalls() + 1;
	}
	
	private int creditMultiplier() {
		int credits = flipper.getCredits();
		if (credits > 0) {return credits;}
		return 1;
	}
	
	
	
	@Override
	public void visit(Ramp ramp) {
		int m = ballMultiplier();
		int runs = ramp.getRuns();
		int addPoints = runs * 100 * m;
		total += addPoints;
		System.out.println("PointsVisitor: " + ramp.getName() + " zusätzlich: " + addPoints + " Total: " + total);
		
	}
	
	@Override
	public void visit(Light light) {
		int m =creditMultiplier();
		int addPoints = (light.isOn() ? 200 : 0) * m;
		total += addPoints;
		System.out.println("PointsVisitor: " + light.getName() + " zusätzlich: " + addPoints + " Total: " + total);
	}
	
	@Override
	public void visit(Bumper bumper) {
		int m = creditMultiplier();
		int addPoints = bumper.getHitCount() * 10 * m;
		total += addPoints;
		System.out.println("PointsVisitor: " + bumper.getName() + " zusätzlich: " + addPoints + " Total: " + total);

	}
	
	@Override
	public void visit(Hole hole) {
		int m = ballMultiplier();
		int addPoints = hole.getHitCount() * 30 * m;
		total += addPoints;
		System.out.println("PointsVisitor: " + hole.getName() + " zusätzlich: " + addPoints + " Total: " + total);
	}
	
	@Override
	public void visit(Target target) {
		int m = ballMultiplier();
		int addPoints = (target.isDown() ? 150 : 0) * m;
		total += addPoints;
		System.out.println("PointsVisitor: " + target.getName() + " zusätzlich: " + addPoints + " Total: " + total);
	}


}
