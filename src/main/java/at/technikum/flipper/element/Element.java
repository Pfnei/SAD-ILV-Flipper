package at.technikum.flipper.element;


import at.technikum.flipper.Flipper;

public interface Element {
	int getId();
	String getType();
	void hit(Flipper flipper);
}

