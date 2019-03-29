package subsumption.behavior;

import subsumption.Wish;
import subsumption.arbitrator.Arbitrator;

public class Follower extends Behavior {
	public Follower(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Brightness);
	}

	@Override
	public void run() {
		LightRange.getThreshold();
		
		sendWish(Wish.LEDRED);
		int brightness;
		int threshold = LightRange.getThreshold();
		
		while(true) {
			brightness = getReadingValue();
			
			if (brightness > threshold) {
				System.out.println("Links");
				sendWish(Wish.TURNLEFT);
			} else {
				System.out.println("Rechts");
				sendWish(Wish.TURNRIGHT);
			}
		}

	}
}