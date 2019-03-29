package subsumption;

import lejos.hardware.Button;
import subsumption.arbitrator.Arbitrator;
import subsumption.behavior.Behavior;
import subsumption.effector.Effector;
import subsumption.sensor.SubSensor;

public class SubsumptionMain {
	public static void main(String... args) {
		Effector[] effectors = { Effector.make("Lamp"), Effector.make("Chassis") };
		Arbitrator arbitrator = new Arbitrator(effectors);
		// Array aller Verhalten
		// jedes Mal, wenn man eine Priority verwendet hat, hoch
		// fuer das nächste Verhalten.
		int priority = 1;
		Behavior[] behaviors = { 
				Behavior.make("Stop", arbitrator, priority++),
				Behavior.make("WallFollower", arbitrator, priority++),
				Behavior.make("Bumper", arbitrator, priority),
				Behavior.make("Killer", arbitrator, priority++),
				Behavior.make("Start", arbitrator, priority++)
				};
		
		// Konkrete Sensoren wie Lichtsensor oder ButtonSensor e
		// SubSensor.make("LightSensor", behaviors);
		SubSensor[] sensors = { 
				SubSensor.make("ButtonSensor", behaviors),
				SubSensor.make("LightSensor", behaviors),
				SubSensor.make("UltraSensor", behaviors),
				SubSensor.make("TouchSensor", behaviors)
				};
		
		// Starten aller Threads
		for (Behavior behavior : behaviors)
			behavior.start();
		for (SubSensor sensor : sensors)
			sensor.start();
		
		
	}
}