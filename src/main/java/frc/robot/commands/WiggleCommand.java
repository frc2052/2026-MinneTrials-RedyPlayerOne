// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class WiggleCommand extends SequentialCommandGroup {
  /** Creates a new WiggleCommand. */
  public IntakeSubsystem intake;
  public WiggleCommand(IntakeSubsystem intake) {
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addCommands(new SequentialCommandGroup(
      new InstantCommand(() -> intake.setIntakeSpeed(0.7)),
      new WinchDownCommand(intake).withTimeout(.25),
      new WinchUpCommand(intake).withTimeout(.8),
      new WaitCommand(.8),
      new InstantCommand(() -> System.out.println("finished command cycoe"))
    ));
  }
}
