package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class driveCom extends Command {
  public driveCom() {
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.driveTrain.drive(Robot.OI.xbox);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveTrain.driveStop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
