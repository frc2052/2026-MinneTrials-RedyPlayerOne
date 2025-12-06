// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static edu.wpi.first.units.Units.Meters;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.units.Unit;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveDistanceCommand extends Command {
  private DrivetrainSubsystem drive;
  private double fwd;
  private double rot;
  private Distance distance;
  /** Creates a new DriveDistanceCommand. */
  public DriveDistanceCommand(DrivetrainSubsystem drive,double fwd, double rot, Distance distance) {
    this.fwd = fwd;
    this.rot = rot;
    this.distance = distance;
    this.drive = drive;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetOdometry(new Pose2d(new Translation2d(0,0),drive.getPose().getRotation()));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    new ArcadeDriveCommand(drive, ()-> fwd, ()-> rot);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    new ArcadeDriveCommand(drive, ()-> 0.0, ()-> 0.0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return drive.getPose().getX() >= distance.in(Meters) ;
  }
}
