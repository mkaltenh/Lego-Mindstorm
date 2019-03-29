package subsumption.behavior;

import subsumption.Wish;
import subsumption.arbitrator.Arbitrator;

public class Calibrator extends Behavior {

	private int minVal, maxVal;
	private int threshold;
	// private static Object monitor = new Object();

	public Calibrator(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Brightness);
	}

	@Override
	public void run() {

		sendWish(Wish.LEDGREEN);
		sendWish(Wish.ROTATECW);
		watchLight(750);
		sendWish(Wish.ROTATECCW);
		watchLight(1500);
		threshold = (maxVal - minVal) / 2;

		LightRange.set(minVal, maxVal, threshold);
		
		sendWish(Wish.NOTHING);
	}

	private void watchLight(int millis) {
		Long startTime = System.currentTimeMillis();
		int currentVal;
		minVal = 1000;
		maxVal = 0;

		while (System.currentTimeMillis() < (startTime + millis)) {
			currentVal = getReadingValue();
			if (currentVal < minVal)
				minVal = currentVal;

			if (currentVal > maxVal)
				maxVal = currentVal;
		}
	}
}