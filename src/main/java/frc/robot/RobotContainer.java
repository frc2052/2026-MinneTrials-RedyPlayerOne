// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeButterCommand;
import frc.robot.commands.IntakePopcornCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.WinchDown;
import frc.robot.commands.WinchUp;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Winch;
import frc.robot.commands.ArcadeDrive;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain drivetrain = new DriveTrain();
  private final Shooter m_shooter = new Shooter();
  private final Intake m_intake = new Intake();
  private final Winch winch = new Winch(); 
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final Joystick joystick = new Joystick(0);
  private final Joystick joystick1= new Joystick(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }
  private void configureBindings() {
    drivetrain.setDefaultCommand(getArcadeDriveCommand());
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
     JoystickButton intakePopcorn = new JoystickButton(joystick, 1);
     intakePopcorn
        .whileTrue(new IntakePopcornCommand(m_intake));
        
      JoystickButton shootPopcorn = new JoystickButton(joystick1,1);
      shootPopcorn
        .whileTrue(new ShooterCommand(m_shooter));
      JoystickButton winchUp= new JoystickButton(joystick, 3);
        winchUp 
          .whileTrue(new WinchUp(winch));
      JoystickButton winchDown = new JoystickButton( joystick, 4);
        winchDown
            .whileTrue( new WinchDown(winch));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
  public Command getArcadeDriveCommand() {
    return new ArcadeDrive(
        drivetrain, () -> -joystick.getRawAxis(1), () -> -joystick1.getRawAxis(1));
  }
}
