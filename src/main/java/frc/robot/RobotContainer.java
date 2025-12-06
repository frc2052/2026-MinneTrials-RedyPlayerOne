// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.autonomous.common.HotDogAuto;
import frc.robot.autonomous.modes.BackUpAuto;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.ShooterToggleCommand;
import frc.robot.commands.WiggleCommand;
import frc.robot.commands.IntakePopcornCommand;
import frc.robot.commands.WinchDownCommand;
import frc.robot.commands.WinchUpCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem(); 
  private final Joystick joystick1 = new Joystick(0);
  private final Joystick joystick2 = new Joystick(1);
  private final Joystick buttonPanel = new Joystick(2);
  
  public RobotContainer() {
    configureBindings();
  }
  private void configureBindings() {
    drivetrain.setDefaultCommand(
      new ArcadeDriveCommand(drivetrain, joystick1::getY, joystick2::getX
      ) //Comment 
    );
    JoystickButton popcornIntake = new JoystickButton(joystick1, 1);
    popcornIntake.whileTrue(new IntakePopcornCommand(intake));
    // JoystickButton winchUp = new JoystickButton(joystick2, 3);
    // winchUp.whileTrue(new WinchUpCommand(intake));
    // JoystickButton winchDown = new JoystickButton(joystick2, 4);
    // winchDown.whileTrue(new WinchDownCommand(intake));

    JoystickButton sWinchUp = new JoystickButton(buttonPanel, 3);
    sWinchUp.whileTrue(new WinchUpCommand(intake));
    JoystickButton sWinchDown = new JoystickButton(buttonPanel, 4);
    sWinchDown.whileTrue(new WinchDownCommand(intake));

    
    JoystickButton shoot = new JoystickButton(joystick2, 1);
    shoot.whileTrue(new ShooterCommand(shooter));
    // shoot.onFalse(new InstantCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    // An example command will be run in autonomous
    // return new ArcadeDriveCommand(drivetrain, ()-> 0.60, ()-> 0.0).withTimeout(1.3);// TODO: the robot is moving in the direction of the shooter
    
    
    // return new SequentialCommandGroup(
    //   new ArcadeDriveCommand(drivetrain, ()-> 0.50, ()->0.0).withTimeout(0.5), //4.5
    //   new WinchUpCommand(intake).withTimeout(.5),
    //   new ParallelCommandGroup(
    //     new ShooterCommand(shooter),
    //     new WiggleCommand(intake).repeatedly()
    //   ).withTimeout(5),
    //   new InstantCommand(() -> intake.stopRoller())
    //   );

    // AUTOS :

    // return new SequentialCommandGroup(
    //   new ArcadeDriveCommand(drivetrain, ()->0.5, ()-> 0.0).withTimeout(3),
    //   new WinchUpCommand(intake).withTimeout(.5),
    //   new ParallelCommandGroup(
    //     new ShooterCommand(shooter),
    //     new WiggleCommand(intake).repeatedly()
    //   ).withTimeout(5),
    //   new InstantCommand(() -> intake.stopRoller())
    //   );


    // return new SequentialCommandGroup(
    //   new ArcadeDriveCommand(drivetrain, ()-> 0.55, ()->0.0).withTimeout(6.5),
    //   new WinchUpCommand(intake).withTimeout(.5),
    //   new ParallelCommandGroup(
    //     new ShooterCommand(shooter),
    //     new WiggleCommand(intake).repeatedly()
    //   ).withTimeout(5),
    //   new InstantCommand(() -> intake.stopRoller())



    return new SequentialCommandGroup(
      new ArcadeDriveCommand(drivetrain, ()-> 0.55, ()->0.0).withTimeout(6.5),
      new ArcadeDriveCommand(drivetrain, ()-> -0.55, ()->0.0).withTimeout(.4),
      // new WinchUpCommand(intake).withTimeout(.5),
      new ParallelCommandGroup(
        new ShooterCommand(shooter),
        new InstantCommand(() -> intake.setIntakeSpeed(0.7)),
        new SequentialCommandGroup(
          new WaitCommand(3),
          new WinchDownCommand(intake).withTimeout(.5),
          new WinchUpCommand(intake).withTimeout(.5)
        )
      ).withTimeout(8),
      new InstantCommand(() -> intake.stopRoller())
    );

  }
}
