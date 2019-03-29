package subsumption.behavior;

import lejos.hardware.Button;
import subsumption.Wish;
import subsumption.arbitrator.Arbitrator;

public class Go extends Behavior {
	public Go(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Button);
	}

	@Override
	public void run() {
		int button = getReadingValue();
		while (button != Button.ID_ENTER) {
			System.out.println("Go got:" + button);
			button = getReadingValue();
		}
		sendWish(Wish.FORWARD);
	}
}