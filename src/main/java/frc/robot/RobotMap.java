package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {
  
  //Using these names is useful for future, more advanced
  //programs. It allows you to keep track of which controller
  //is "leading", or "following", the other.
  public static WPI_TalonSRX leftMaster; 
  public static WPI_VictorSPX leftSlave;

  public static WPI_TalonSRX rightMaster;
  public static WPI_VictorSPX rightSlave;

  public static SpeedControllerGroup leftGearBox;
  public static SpeedControllerGroup rightGearBox;

  public static DifferentialDrive finalDrive;

  public static void init(){

    leftMaster = new WPI_TalonSRX(1); //This number (1),(2),(3),(4) is what identifies the controller on the CAN network.
    leftSlave = new WPI_VictorSPX(2); //You can set this in the RoboRIO webpage by connecting to the robot
                                      //through the radio and typing 10.56.38.2 into INTERNET EXPLORER, 
                                      //or through USB using the IP 172.22.11.2 into the same browser.
                                      //You may need adminstrative privilages, so the login is admin/no password
                                      //DO NOT CHANGE THE PASSWORD WITHOUT TELLING SOMEONE FIRST. LEAVE BLANK.
    leftSlave.follow(leftMaster); //This allows the slave to follow the master, as stated in the first comment.

    rightMaster = new WPI_TalonSRX(3);
    rightSlave = new WPI_VictorSPX(4);
    rightSlave.follow(rightMaster); //Once again, this allows the slave to follow the master.

    leftGearBox = new SpeedControllerGroup(leftMaster, leftSlave);    //Create the gearboxes for the final drive.
    rightGearBox = new SpeedControllerGroup(rightMaster, rightSlave);

    finalDrive = new DifferentialDrive(leftGearBox, rightGearBox);  //The final drive.
  }
}
