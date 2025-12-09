// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakePopcornCommand extends Command {
  /** Creates a new Practce. */

    private final Intake m_Popcorn;

    public IntakePopcornCommand (Intake m_Popcorn){
       // m_Popcorn = new Intake();
        this.m_Popcorn = m_Popcorn;
        addRequirements(m_Popcorn);
  
    }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Popcorn.Intaking(0.1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Popcorn.Intaking(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
