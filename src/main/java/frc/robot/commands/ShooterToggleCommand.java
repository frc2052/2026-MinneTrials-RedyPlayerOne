// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterToggleCommand extends Command {
  private final ShooterSubsystem shooterSubsystem;

  public ShooterToggleCommand(ShooterSubsystem shooterSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (!shooterSubsystem.getShooterRunning()){
      System.out.println("shooter1"+shooterSubsystem.getShooterRunning());
      shooterSubsystem.setSpeed(ShooterConstants.TOP_SHOOTER_SPEED, -ShooterConstants.BOTTOM_SHOOTER_SPEED);
    }else{
      System.out.println("shooter2"+shooterSubsystem.getShooterRunning());
        shooterSubsystem.stopMotor();
    }
      System.out.println("shooter3"+shooterSubsystem.getShooterRunning());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
