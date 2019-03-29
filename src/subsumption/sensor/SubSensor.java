package subsumption.sensor;

import subsumption.behavior.Behavior;
import subsumption.behavior.Reading;

public abstract class SubSensor extends Thread {
	private final Behavior[] behaviors;
	private final Reading type;

	public SubSensor(Behavior[] behaviors, Reading type) {
		this.behaviors = behaviors;
		this.type = type;
		setDaemon(true);
	}

	void send(int value) {
		// System.out.println("sending type " + type + ", value=  " + value);
		for (Behavior behavior : behaviors)
			behavior.accept(type, value);
	}

	public static SubSensor make(String typeName, Behavior[] behaviors) {
		switch (typeName) {
		case "ButtonSensor":
			return new ButtonSensor(behaviors);
		case "LightSensor":
			return new LightSensor(behaviors);
		case "UltraSensor":
			return new UltraSensor(behaviors);
		case "TouchSensor":
			return new TouchSensor(behaviors);
		default:
			new RuntimeException("unbekannter Sensortyp: " + typeName);
			return null;
		}
	}
	
	public void close() {
		
	}
}