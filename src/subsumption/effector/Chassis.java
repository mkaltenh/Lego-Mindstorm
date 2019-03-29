package subsumption.effector;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import subsumption.Wish;

public class Chassis extends Effector {
	final RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
	final RegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

	public Chassis() {
		//motorA.setSpeed(100);
		//motorD.setSpeed(100);
	}

	@Override
	public void accept(Wish command) {
		if (command == Wish.FORWARD) {
			motorA.setSpeed((int)(motorA.getMaxSpeed()*0.30));
			motorD.setSpeed((int)(motorD.getMaxSpeed()*0.30));
			motorA.forward();
			motorD.forward();
		} else if (command == Wish.STOP) {
			motorA.stop();
			motorD.stop();
		} else if (command == Wish.TURNLEFT) {
			motorA.setSpeed((int)(motorA.getMaxSpeed()*0.30));
			motorD.setSpeed((int)(motorD.getMaxSpeed()*0.20));
			motorA.forward();
			motorD.forward();
		} else if (command == Wish.TURNRIGHT) {
			motorA.setSpeed((int)(motorA.getMaxSpeed()*0.20));
			motorD.setSpeed((int)(motorD.getMaxSpeed()*0.30));
			motorA.forward();
			motorD.forward();
		} else if (command == Wish.ROTATECW) {
			motorA.forward();
			motorD.backward();
		} else if (command == Wish.ROTATECCW) {
			motorA.backward();
			motorD.forward();
		} else if (command == Wish.BACKWARDS){
			motorA.setSpeed((int)(motorA.getMaxSpeed()*0.50));
			motorD.setSpeed((int)(motorD.getMaxSpeed()*0.50));
			motorA.backward();
			motorD.backward();
		} else if (command == Wish.ROTATE){
			motorA.rotate(-45);
			motorD.rotate(45);
			motorA.waitComplete(); 
			motorD.waitComplete();
		}
	}
}