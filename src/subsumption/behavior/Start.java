package subsumption.behavior;

import lejos.hardware.Button;
import subsumption.Wish;
import subsumption.arbitrator.Arbitrator;

public class Start extends Behavior {
	public Start(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Button);
	}

	@Override
	public void run() {
		sendWish(Wish.LEDORANGE);
		
		while (getReadingValue() != Button.ID_ENTER);

		sendWish(Wish.NOTHING);
	}
}