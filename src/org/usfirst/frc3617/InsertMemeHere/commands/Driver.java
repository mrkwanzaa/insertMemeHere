/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3617.InsertMemeHere.commands;
import org.usfirst.frc3617.InsertMemeHere.Robot;
import org.usfirst.frc3617.InsertMemeHere.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Thayer
 */public class Driver extends Command {
	int angle = 0;  
	JoystickButton gArm;
	JoystickButton RobotUp;	
	private JoystickButton climbMotor;
	
	public Driver(){

		// Use requires() here to declare subsystem dependencies
	}
	
	// Called just before this Command runs the first time
	protected void initialize(){
	  //RobotMap.anglePlate.reset();
      gArm = new JoystickButton(RobotMap.gunnerStick, RobotMap.armMotor);
	  RobotUp = new JoystickButton(RobotMap.gunnerStick, RobotMap.climbMotor);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute(){
		
	    Robot.myRobot.arcadeDrive(-RobotMap.driveStick.getY(), RobotMap.driveStick.getX());
	    /*if(RobotMap.anglePlate.get() > angle)
	    {
	    	RobotMap.arm.set(0.2);
	    }
	    else
	    {
	    	RobotMap.arm.set(-0.5);
	    }*/
	    RobotMap.armExtend.set(RobotMap.gunnerStick.getY());
	    if (RobotMap.clawGrab.get() == true){
	    	RobotMap.claw.set(0.4);
	    	}
		else if(RobotMap.clawOut.get() == true){
	    	RobotMap.claw.set(-0.4);
	      }
	    else{
	    	RobotMap.claw.set(0);
	        }
	    if(RobotMap.armIn.get())
	      {
	    	RobotMap.armExtend.set(-0.3);
	      }
	    else if(RobotMap.armOut.get())
	      {
	    	RobotMap.armExtend.set(0.3);
	      }
	    else
	      {
	    	RobotMap.armExtend.set(0);
	    }
	    if(RobotMap.armUp.get())
	    {
	    	angle += 10;
	    }
	    else if(RobotMap.armDown.get())
	    {
	    	if(angle>10)
	    		angle -= 10;
	    }
    	}
	
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished(){
		return false;
	}
	 
	// Called once after isFinished returns true
	protected void end(){
	Robot.myRobot.arcadeDrive(0,0);
     RobotMap.arm.set(0);
     RobotMap.armExtend.set(0);
     RobotMap.claw.set(0);
     RobotMap.climber.set(0);
     RobotMap.arm.set(0);
     angle = 0;
     //   RobotMap.upMotor.set(0);
	//    RobotMap.pullUp.set(0);
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted(){
	
	}

	public JoystickButton getClimbMotor() {
		return climbMotor;
	}

	public void setClimbMotor(JoystickButton climbMotor) {
		this.climbMotor = climbMotor;
	}

}
