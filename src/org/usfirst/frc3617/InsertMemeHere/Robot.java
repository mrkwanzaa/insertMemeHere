package org.usfirst.frc3617.InsertMemeHere;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc3617.InsertMemeHere.RobotMap;
import org.usfirst.frc3617.InsertMemeHere.commands.AutonomousCommand;
import org.usfirst.frc3617.InsertMemeHere.commands.Driver;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static RobotDrive myRobot;
    public static int autoMode = 1;
    //moved from RobotMap

	
	AutonomousCommand AutonomousCommand = new AutonomousCommand();
	Driver Driver = new Driver();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        CameraServer.getInstance().startAutomaticCapture();
   RobotMap.driveStick = new Joystick(0);
    	RobotMap.gunnerStick = new Joystick(1);
    	myRobot = new RobotDrive(8,3);//change to 2
    }
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
        myRobot.setSafetyEnabled(false);
    	AutonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
		Scheduler.getInstance().run();
    }
    /*
	*/
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	myRobot.setSafetyEnabled(true);
    	Driver.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }

}
