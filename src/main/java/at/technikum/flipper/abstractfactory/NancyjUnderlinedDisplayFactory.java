package at.technikum.flipper.abstractfactory;

public class NancyjUnderlinedDisplayFactory implements DisplayFactory {
	
	@Override
	public String pressStart() {
		return """
 888888ba   888888ba   88888888b .d88888b  .d88888b     .d88888b  d888888P  .d888888   888888ba  d888888P
 88    `8b  88    `8b  88        88.    "' 88.    "'    88.    "'    88    d8'    88   88    `8b    88
a88aaaa8P' a88aaaa8P' a88aaaa    `Y88888b. `Y88888b.    `Y88888b.    88    88aaaaa88a a88aaaa8P'    88
 88         88   `8b.  88              `8b       `8b          `8b    88    88     88   88   `8b.    88
 88         88     88  88        d8'   .8P d8'   .8P    d8'   .8P    88    88     88   88     88    88
 dP         dP     dP  88888888P  Y88888P   Y88888P      Y88888P     dP    88     88   dP     dP    dP
oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
	
	@Override
	public String gameOver() {
		return """
 .88888.   .d888888  8888ba.88ba   88888888b     .88888.  dP     dP  88888888b  888888ba
d8'   `88 d8'    88  88  `8b  `8b  88           d8'   `8b 88     88  88         88    `8b
88        88aaaaa88a 88   88   88 a88aaaa       88     88 88    .8P a88aaaa    a88aaaa8P'
88   YP88 88     88  88   88   88  88           88     88 88    d8'  88         88   `8b.
Y8.   .88 88     88  88   88   88  88           Y8.   .8P 88  .d8P   88         88     88
 `88888'  88     88  dP   dP   dP  88888888P     `8888P'  888888'    88888888P  dP     dP
oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
	
	@Override
	public String ball(int ball) {
		return switch (ball) {
			case 1 -> """
 888888ba   .d888888  dP        dP           d88
 88    `8b d8'    88  88        88            88
a88aaaa8P' 88aaaaa88a 88        88            88
 88   `8b. 88     88  88        88            88
 88    .88 88     88  88        88            88
 88888888P 88     88  88888888P 88888888P    d88P
oooooooooooooooooooooooooooooooooooooooooooooooooo
""";
			case 2 -> """
 888888ba   .d888888  dP        dP           d8888b.
 88    `8b d8'    88  88        88               `88
a88aaaa8P' 88aaaaa88a 88        88           .aaadP'
 88   `8b. 88     88  88        88           88'
 88    .88 88     88  88        88           88.
 88888888P 88     88  88888888P 88888888P    Y88888P
ooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
			case 3 -> """
 888888ba   .d888888  dP        dP           d8888b.
 88    `8b d8'    88  88        88               `88
a88aaaa8P' 88aaaaa88a 88        88            aaad8'
 88   `8b. 88     88  88        88               `88
 88    .88 88     88  88        88               .88
 88888888P 88     88  88888888P 88888888P    d88888P
ooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
			default -> "";
		};
	}
	
	@Override
	public String credits(int credit) {
		return switch (credit) {
			case 0 -> """
 a8888a      a88888b.  888888ba   88888888b 888888ba  dP d888888P  a88P .d88888b  Y88o     dP         88888888b  88888888b d888888P
d8' ..8b    d8'   `88  88    `8b  88        88    `8b 88    88    d8'   88.    "'   `8b    88         88         88           88
88 .P 88    88        a88aaaa8P' a88aaaa    88     88 88    88    88    `Y88888b.    88    88        a88aaaa    a88aaaa       88
88 d' 88    88         88   `8b.  88        88     88 88    88    88          `8b    88    88         88         88           88
Y8'' .8P    Y8.   .88  88     88  88        88    .8P 88    88    Y8.   d8'   .8P   .8P    88         88         88           88
 Y8888P      Y88888P'  dP     dP  88888888P 8888888P  dP    dP     Y88b  Y88888P  d88Y     88888888P  88888888P  dP           dP
oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
			case 1 -> """
d88      a88888b.  888888ba   88888888b 888888ba  dP d888888P  a88P .d88888b  Y88o     dP         88888888b  88888888b d888888P
 88     d8'   `88  88    `8b  88        88    `8b 88    88    d8'   88.    "'   `8b    88         88         88           88
 88     88        a88aaaa8P' a88aaaa    88     88 88    88    88    `Y88888b.    88    88        a88aaaa    a88aaaa       88
 88     88         88   `8b.  88        88     88 88    88    88          `8b    88    88         88         88           88
 88     Y8.   .88  88     88  88        88    .8P 88    88    Y8.   d8'   .8P   .8P    88         88         88           88
d88P     Y88888P'  dP     dP  88888888P 8888888P  dP    dP     Y88b  Y88888P  d88Y     88888888P  88888888P  dP           dP
oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
			case 2 -> """
d8888b.     a88888b.  888888ba   88888888b 888888ba  dP d888888P  a88P .d88888b  Y88o     dP         88888888b  88888888b d888888P
    `88    d8'   `88  88    `8b  88        88    `8b 88    88    d8'   88.    "'   `8b    88         88         88           88
.aaadP'    88        a88aaaa8P' a88aaaa    88     88 88    88    88    `Y88888b.    88    88        a88aaaa    a88aaaa       88
88'        88         88   `8b.  88        88     88 88    88    88          `8b    88    88         88         88           88
88.        Y8.   .88  88     88  88        88    .8P 88    88    Y8.   d8'   .8P   .8P    88         88         88           88
Y88888P     Y88888P'  dP     dP  88888888P 8888888P  dP    dP     Y88b  Y88888P  d88Y     88888888P  88888888P  dP           dP
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
			case 3 -> """
d8888b.     a88888b.  888888ba   88888888b 888888ba  dP d888888P  a88P .d88888b  Y88o     dP         88888888b  88888888b d888888P
    `88    d8'   `88  88    `8b  88        88    `8b 88    88    d8'   88.    "'   `8b    88         88         88           88
 aaad8'    88        a88aaaa8P' a88aaaa    88     88 88    88    88    `Y88888b.    88    88        a88aaaa    a88aaaa       88
    `88    88         88   `8b.  88        88     88 88    88    88          `8b    88    88         88         88           88
    .88    Y8.   .88  88     88  88        88    .8P 88    88    Y8.   d8'   .8P   .8P    88         88         88           88
d88888P     Y88888P'  dP     dP  88888888P 8888888P  dP    dP     Y88b  Y88888P  d88Y     88888888P  88888888P  dP           dP
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
			default -> """
8b      d8888b.     a88888b.  888888ba   88888888b 888888ba  dP d888888P .d88888b     dP         88888888b  88888888b d888888P
`8b         `88    d8'   `88  88    `8b  88        88    `8b 88    88    88.    "'    88         88         88           88
 `8b     aaad8'    88        a88aaaa8P' a88aaaa    88     88 88    88    `Y88888b.    88        a88aaaa    a88aaaa       88
 .8P        `88    88         88   `8b.  88        88     88 88    88          `8b    88         88         88           88
.8P         .88    Y8.   .88  88     88  88        88    .8P 88    88    d8'   .8P    88         88         88           88
8P      d88888P     Y88888P'  dP     dP  88888888P 8888888P  dP    dP     Y88888P     88888888P  88888888P  dP           dP
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
		};
	}
	
	@Override
	public String gameStart() {
		return """
88888888b dP        dP  888888ba   888888ba   88888888b  888888ba      .88888.   .d888888  8888ba.88ba   88888888b    .d88888b  d888888P  .d888888   888888ba  d888888P
88        88        88  88    `8b  88    `8b  88         88    `8b    d8'   `88 d8'    88  88  `8b  `8b  88           88.    "'    88    d8'    88   88    `8b    88
a88aaaa   88        88 a88aaaa8P' a88aaaa8P' a88aaaa    a88aaaa8P'    88        88aaaaa88a 88   88   88 a88aaaa       `Y88888b.    88    88aaaaa88a a88aaaa8P'    88
88        88        88  88         88         88         88   `8b.    88   YP88 88     88  88   88   88  88                 `8b    88    88     88   88   `8b.    88
88        88        88  88         88         88         88     88    Y8.   .88 88     88  88   88   88  88           d8'   .8P    88    88     88   88     88    88
dP        88888888P dP  dP         dP         88888888P  dP     dP     `88888'  88     88  dP   dP   dP  88888888P     Y88888P     dP    88     88   dP     dP    dP
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
	
	@Override
	public String gameRunning() {
		return """
 .88888.   .d888888  8888ba.88ba   88888888b     888888ba  dP     dP 888888ba  888888ba  dP 888888ba   .88888.
d8'   `88 d8'    88  88  `8b  `8b  88            88    `8b 88     88 88    `8b 88    `8b 88 88    `8b d8'   `88
88        88aaaaa88a 88   88   88 a88aaaa       a88aaaa8P' 88     88 88     88 88     88 88 88     88 88
88   YP88 88     88  88   88   88  88            88   `8b. 88     88 88     88 88     88 88 88     88 88   YP88
Y8.   .88 88     88  88   88   88  88            88     88 Y8.   .8P 88     88 88     88 88 88     88 Y8.   .88
 `88888'  88     88  dP   dP   dP  88888888P     dP     dP `Y88888P' dP     dP dP     dP dP dP     dP  `88888'
oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
	
	@Override
	public String randomHits() {
		return """
 888888ba   .d888888  888888ba  888888ba   .88888.  8888ba.88ba     dP     dP  dP d888888P .d88888b
 88    `8b d8'    88  88    `8b 88    `8b d8'   `8b 88  `8b  `8b    88     88  88    88    88.    "'
a88aaaa8P' 88aaaaa88a 88     88 88     88 88     88 88   88   88    88aaaaa88a 88    88    `Y88888b.
 88   `8b. 88     88  88     88 88     88 88     88 88   88   88    88     88  88    88          `8b
 88     88 88     88  88     88 88    .8P Y8.   .8P 88   88   88    88     88  88    88    d8'   .8P
 dP     dP 88     88  dP     dP 8888888P   `8888P'  dP   dP   dP    dP     dP  dP    dP     Y88888P
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
	
	@Override
	public String resetElements() {
		return """
 888888ba   88888888b .d88888b   88888888b d888888P     88888888b dP         88888888b 8888ba.88ba   88888888b 888888ba  d888888P .d88888b
 88    `8b  88        88.    "'  88           88        88        88         88        88  `8b  `8b  88        88    `8b    88    88.    "'
a88aaaa8P' a88aaaa    `Y88888b. a88aaaa       88       a88aaaa    88        a88aaaa    88   88   88 a88aaaa    88     88    88    `Y88888b.
 88   `8b.  88              `8b  88           88        88        88         88        88   88   88  88        88     88    88          `8b
 88     88  88        d8'   .8P  88           88        88        88         88        88   88   88  88        88     88    88    d8'   .8P
 dP     dP  88888888P  Y88888P   88888888P    dP        88888888P 88888888P  88888888P dP   dP   dP  88888888P dP     dP    dP     Y88888P
oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
	
	@Override
	public String bonusGame() {
		return """
 888888ba   .88888.  888888ba  dP     dP .d88888b      .88888.   .d888888  8888ba.88ba   88888888b
 88    `8b d8'   `8b 88    `8b 88     88 88.    "'    d8'   `88 d8'    88  88  `8b  `8b  88
a88aaaa8P' 88     88 88     88 88     88 `Y88888b.    88        88aaaaa88a 88   88   88 a88aaaa
 88   `8b. 88     88 88     88 88     88       `8b    88   YP88 88     88  88   88   88  88
 88    .88 Y8.   .8P 88     88 Y8.   .8P d8'   .8P    Y8.   .88 88     88  88   88   88  88
 88888888P  `8888P'  dP     dP `Y88888P'  Y88888P      `88888'  88     88  dP   dP   dP  88888888P
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
	
	@Override
	public String bonusPoints() {
		return """
 888888ba   .88888.  888888ba  dP     dP .d88888b      888888ba   .88888.  dP 888888ba  d888888P .d88888b
 88    `8b d8'   `8b 88    `8b 88     88 88.    "'     88    `8b d8'   `8b 88 88    `8b    88    88.    "'
a88aaaa8P' 88     88 88     88 88     88 `Y88888b.    a88aaaa8P' 88     88 88 88     88    88    `Y88888b.
 88   `8b. 88     88 88     88 88     88       `8b     88        88     88 88 88     88    88          `8b
 88    .88 Y8.   .8P 88     88 Y8.   .8P d8'   .8P     88        Y8.   .8P 88 88     88    88    d8'   .8P
 88888888P  `8888P'  dP     dP `Y88888P'  Y88888P      dP         `8888P'  dP dP     dP    dP     Y88888P
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
""";
	}
}