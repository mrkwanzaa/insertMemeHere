// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3617.InsertMemeHere.commands;

import org.usfirst.frc3617.InsertMemeHere.Robot;
import org.usfirst.frc3617.InsertMemeHere.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousCommand extends Command {
private boolean finished;
 
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
  
finished = false;
if(RobotMap.gunnerStick.getRawAxis(3) >= 0.5){
	if(RobotMap.driveStick.getRawAxis(3) >= 0.5){
		Robot.autoMode = 1;
		}
	else if(RobotMap.driveStick.getRawAxis(3) <= 0.5){
		Robot.autoMode = 2;
	    }
	}
else if(RobotMap.gunnerStick.getRawAxis(3) <= 0.5){
	if(RobotMap.driveStick.getRawAxis(3) >= 0.5){
		Robot.autoMode = 3;
		}
	else if(RobotMap.driveStick.getRawAxis(3) <= 0.5){
		Robot.autoMode = 4;
	    }
	}
//start mode 1
if(Robot.autoMode == 1){
	Robot.myRobot.drive(0.6, 0.0); 	// drive forwards half speed
	Timer.delay(2.6);
	Robot.myRobot.drive(0.0, 0.0); 	// stop robot
}
//end mode 1
//start mode 2
if(Robot.autoMode == 2){
	
}	// stop robot
	  
	
//end mode 2
//start mode 3
if(Robot.autoMode == 3){
	 
}
//end mode 3
//start mode 4
if(Robot.autoMode == 4){

}
//end mode 4
else{
	Robot.myRobot.drive(0, 0);
}
finished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isFinished())
    		Robot.myRobot.drive(0, 0);
           }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.myRobot.drive(0.0, 0.0);
    	RobotMap.arm.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
