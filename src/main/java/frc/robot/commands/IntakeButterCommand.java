// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeButterCommand extends Command {
  /** Creates a new Practe. */
  private final Intake m_butter;
    public IntakeButterCommand(Intake m_butter){
        // m_butter = new Intake()
        this.m_butter =  m_butter;
        addRequirements(m_butter);
    }
    public void PickUp(){
        m_butter.Intaking(0.1);
    }
    public void StopPickup(){
        m_butter.Intaking(0);
    }
    public void SpitItOut(){
        m_butter.Intaking(-0.1);
    }
    public void ArmUp(){
        m_butter.IntakeUpDown(0.1);
    }
    public void StopArm(){
        m_butter.IntakeUpDown(0);
    }
    public void ArmDown(){
        m_butter.IntakeUpDown(-0.1);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
