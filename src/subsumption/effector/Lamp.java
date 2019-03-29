package subsumption.effector;

import lejos.hardware.Button;
import subsumption.Wish;

class Lamp extends Effector {
	@Override
	public void accept(Wish command) {
		switch (command) {
		case LEDGREEN:
			Button.LEDPattern(1);
			break;
		case LEDOFF:
			Button.LEDPattern(0);
			break;
		case LEDORANGE:
			Button.LEDPattern(3);
			break;
		case LEDRED:
			Button.LEDPattern(2);
			break;
		default: // not my command
			break;
		}
	}
}