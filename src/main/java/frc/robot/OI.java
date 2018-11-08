package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
  public Joystick xbox;

  public OI(){
    xbox = new Joystick(0);
  }

  public Joystick getxbox(){
    return xbox;
  }
}
