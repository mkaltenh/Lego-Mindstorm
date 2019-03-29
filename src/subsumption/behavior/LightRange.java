package subsumption.behavior;


public class LightRange {
	private static int maxVal;
	private static int minVal;
	private static int threshold = 0;
	private static Object monitor = new Object();

	public static void set(int min, int max, int threshold) {
		LightRange.minVal = min;
		LightRange.maxVal = max;
		LightRange.threshold = threshold;
		synchronized(monitor) {
			monitor.notifyAll();
		}
	}

	public static int getMaxVal() {
		waitAndReturnThreshold();
		return maxVal;
	}

	public static int getMinVal() {
		waitAndReturnThreshold();
		return minVal;
	}

	public static int getThreshold() {
		waitAndReturnThreshold();
		return threshold;
	}
	
	public static int waitAndReturnThreshold() {
		synchronized(monitor) {
			while (threshold == 0)
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return threshold;
		}
	}
	
	
}
