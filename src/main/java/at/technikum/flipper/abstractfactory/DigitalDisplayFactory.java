package at.technikum.flipper.abstractfactory;

public class DigitalDisplayFactory implements DisplayFactory {
	
	@Override
	public String pressStart() {
		return """
+-+-+-+-+-+-+-+-+-+-+-+
|P|R|E|S|S| |S|T|A|R|T|
+-+-+-+-+-+-+-+-+-+-+-+
""";
	}
	
	@Override
	public String gameOver() {
		return """
+-+-+-+-+ +-+-+-+-+
|G|A|M|E| |O|V|E|R|
+-+-+-+-+ +-+-+-+-+
""";
	}
	
	@Override
	public String ball(int ball) {
		return """
+-+-+-+-+ +-+
|B|A|L|L| |%d|
+-+-+-+-+ +-+
""".formatted(ball);
	}
	
	@Override
	public String credits(int credit) {
		String word = (credit == 1) ? "CREDIT" : "CREDITS";
		return """
+-+ +-+-+-+-+-+-+-+ +-+-+-+-+
|%d| |%s| |L|E|F|T|
+-+ +-+-+-+-+-+-+-+ +-+-+-+-+
""".formatted(credit, toBox(word));
	}
	
	@Override
	public String gameStart() {
		return """
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|F|L|I|P|P|E|R| |G|A|M|E| |S|T|A|R|T|
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
""";
	}
	
	@Override
	public String gameRunning() {
		return """
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|G|A|M|E| |R|U|N|N|I|N|G|
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
""";
	}
	
	@Override
	public String randomHits() {
		return """
+-+-+-+-+-+-+-+-+-+-+-+
|R|A|N|D|O|M| |H|I|T|S|
+-+-+-+-+-+-+-+-+-+-+-+
""";
	}
	
	@Override
	public String resetElements() {
		return """
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|R|E|S|E|T| |E|L|E|M|E|N|T|S|
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
""";
	}
	
	@Override
	public String bonusGame() {
		return """
+-+-+-+-+-+ +-+-+-+-+-+
|B|O|N|U|S| |G|A|M|E|
+-+-+-+-+-+ +-+-+-+-+-+
""";
	}
	
	@Override
	public String bonusPoints() {
		return """
+-+-+-+-+-+ +-+-+-+-+-+-+-+
|B|O|N|U|S| |P|O|I|N|T|S|
+-+-+-+-+-+ +-+-+-+-+-+-+-+
""";
	}
	
	private String toBox(String text) {
		return text.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.reduce((a, b) -> a + "|" + b)
				.orElse("");
	}
}