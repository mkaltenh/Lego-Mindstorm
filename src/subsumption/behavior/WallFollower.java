package subsumption.behavior;

import subsumption.Wish;
import subsumption.arbitrator.Arbitrator;

public class WallFollower extends Behavior {
	public WallFollower(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Distance);
	}

	@Override
	public void run() {

		int distance;
		
		//System.out.println("Starte Wallfollower");
		//System.out.println("Starte Wallfollower...");
		
		while(true) {
			distance = getReadingValue();
			
			System.out.println("Distance: "+distance);
			
			if (distance < 6) {
				sendWish(Wish.TURNRIGHT);
			} else if (distance < 10) {
				sendWish(Wish.FORWARD);
				}
			else if (distance > 10){
				sendWish(Wish.TURNLEFT);
			}
			}
		}

	}
