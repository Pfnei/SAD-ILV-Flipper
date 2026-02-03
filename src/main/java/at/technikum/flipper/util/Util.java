package at.technikum.flipper.util;

public class Util {
	
	public Util (){
	
	}
	 public static int randomInt (int lower, int upper){
		return (int) (Math.random() * (upper-lower+1) + lower);
	 }
	
}
