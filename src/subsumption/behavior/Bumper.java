package subsumption.behavior;

import subsumption.Wish;
import subsumption.arbitrator.Arbitrator;

public class Bumper extends Behavior {
	public Bumper(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Touch);
	}

	@Override
	public void run() {

		int pressed;
		
		//System.out.println("Starte Wallfollower");
		//System.out.println("Starte Wallfollower...");
		
		while(true) {
			pressed = getReadingValue();
			
			System.out.println("Bumper: "+pressed);
			
			if (pressed == 1) {

				sendWish(Wish.BACKWARDS);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				sendWish(Wish.ROTATE);
			}
			else{
				sendWish(Wish.NOTHING);
			}
		}
	}
	}
