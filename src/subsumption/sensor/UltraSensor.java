package subsumption.sensor;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.BaseSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import subsumption.behavior.Behavior;
import subsumption.behavior.Reading;

public class UltraSensor extends SubSensor
{
	float distance = 10;
	SampleProvider ultrasonic;
	
	public UltraSensor(Behavior[] behaviors) {
		super(behaviors, Reading.Distance);
		
		SensorModes sensor3 = new EV3UltrasonicSensor(SensorPort.S3);
		ultrasonic = sensor3.getMode("Distance");
	}
	
    public void run()
    {
    	while(true){
    		
	    	float sample[] = new float[ultrasonic.sampleSize()];
		
	    	ultrasonic.fetchSample(sample, 0);
	    	float newDistance = sample[0] * 100;
	    	
	    	if (newDistance != distance) {
	    		send((int) newDistance);
	    		distance = newDistance;
	    		//System.out.println("Sensordistance: "+newDistance);
	    	}
    	}

    }
}