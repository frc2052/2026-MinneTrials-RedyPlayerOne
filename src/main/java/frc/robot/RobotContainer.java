// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.IntakePopcornCommand;
import frc.robot.commands.WinchDownCommand;
import frc.robot.commands.WinchUpCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem(); 
  private final Joystick joystick1 = new Joystick(0);
  private final Joystick joystick2 = new Joystick(1);
  
  public RobotContainer() {
    configureBindings();
  }
  private void configureBindings() {
    drivetrain.setDefaultCommand(
      new ArcadeDriveCommand(drivetrain, joystick1::getX, joystick1::getY
      )
    );
    // JoystickButton popcornIntake = new JoystickButton(joystick1, 1);
    // popcornIntake.whileTrue(new IntakePopcornCommand(intake));
    JoystickButton winchUp = new JoystickButton(joystick1, 3);
    winchUp.whileTrue(new WinchUpCommand(intake));
    JoystickButton winchDown = new JoystickButton(joystick1, 4);
    winchDown.whileTrue(new WinchDownCommand(intake));
    
    JoystickButton shoot = new JoystickButton(joystick1, 1);
    shoot.whileTrue(new ShooterCommand(shooter));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  //   return Autos.exampleAuto(m_exampleSubsystem);
  // }
}
