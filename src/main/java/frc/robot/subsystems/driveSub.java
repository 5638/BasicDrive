/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.driveCom;

/**
 * Add your docs here.
 */
public class driveSub extends Subsystem {

  private final DifferentialDrive driveTrain = RobotMap.finalDrive;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new driveCom());
  }

  public void drive(Joystick xbox){
    driveTrain.arcadeDrive(xbox.getRawAxis(3) - xbox.getRawAxis(2), xbox.getRawAxis(0));
    //These axis values are taken from the controller. You can find these in the Driver Station
    //under the USB tab. These values are what I prefer, and the controls are: Right Trigger = Forward,
    //Left Trigger = Reverse, Left Analogue Stick = Rotate.
    //  I subtract 3 and 2 because they are the triggers. They are read independently, and the way they are 
    //read by the driverstation means this needs to be done.
  }

  public void driveStop(){
    driveTrain.arcadeDrive(0, 0); //This just sets the motors to 0, or stop.
  }
}
