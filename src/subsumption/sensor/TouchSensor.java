package subsumption.sensor;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.BaseSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import subsumption.behavior.Behavior;
import subsumption.behavior.Reading;

public class TouchSensor extends SubSensor
{
	SampleProvider touch1;
	
	public TouchSensor(Behavior[] behaviors) {
		super(behaviors, Reading.Touch);
		
		SensorModes sensor1 = new EV3TouchSensor(SensorPort.S1);
		touch1 = sensor1.getMode("Touch");
	}
	
    public void run()
    {
    	while(true){
    		
    		float pressed = 0;
    		float sample[] = new float[touch1.sampleSize()];
    		touch1.fetchSample(sample, 0);
    		pressed = sample[0];
    		
	    	
	    	if (pressed == 1) {
	    		send((int) pressed);
	    		//System.out.println("Sensordistance: "+newDistance);
	    	} else {
	    		send(0);
	    	}
    	}

    }
}