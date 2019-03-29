package subsumption.sensor;

import lejos.hardware.Button;
import lejos.hardware.port.AnalogPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.NXTLightSensor;
import lejos.hardware.sensor.SensorModes;
import subsumption.behavior.Behavior;
import subsumption.behavior.Reading;

public class LightSensor extends SubSensor {
	
	private NXTLightSensor nxtLightSensor;
	
	public LightSensor(Behavior[] behaviors) {
		
		super(behaviors, Reading.Brightness);
		
		nxtLightSensor = new NXTLightSensor(SensorPort.S4);
		nxtLightSensor.setCurrentMode("Red");
	
	}

	public void run() {
		while (true) {
			 int sampleSize = nxtLightSensor.sampleSize();
		        float[] buffer = new float[sampleSize];     // Puffer fuer Samples
		        assert sampleSize == 1;                     // Samplesize ist 1

		        while(Button.readButtons() == 0) {          // weiter bis Button ...
		        	nxtLightSensor.fetchSample(buffer, 0);            // Sensor ablesen
		            int sample = (int)(1_000 * buffer[0]);  // Messwert skalieren
		            send(sample);
		            // Delay.msDelay(100);                     // kurze Pause
		        }
		        
			
		}
	}
}