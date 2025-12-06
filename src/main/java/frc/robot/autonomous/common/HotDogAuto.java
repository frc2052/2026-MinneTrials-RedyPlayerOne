// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous.common;

import static edu.wpi.first.units.Units.Meters;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class HotDogAuto extends SequentialCommandGroup {
  /** Creates a new auto. */
  DrivetrainSubsystem drive;
  ShooterSubsystem shooterSubsystem;

  public HotDogAuto(DrivetrainSubsystem drive, ShooterSubsystem shooterSubsystem){
    this.drive = drive;
    this.shooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive,shooterSubsystem);
    addCommands(new InstantCommand(() -> System.out.println("======== RUNNING HOT DOG AUTO")),
    new DriveDistanceCommand(drive,1,0.0,Meters.of(1)),
    new ShooterCommand(shooterSubsystem).withTimeout(4)
    );

  }
}
