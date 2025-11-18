// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();


  // Assumes a gamepad plugged into channel 0
  private final Joystick m_controllerLeft = new Joystick(0);
  private final Joystick m_controllerRight = new Joystick(1);

  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  public Command getTankDriveCommand() {
    return new TankDrive(
        m_drivetrain, () -> -m_controllerLeft.getRawAxis(1), () -> -m_controllerRight.getRawAxis(1));

  }}
  
 


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  

  /**
   * Creates a DriveDistance command.
   *
   * @param speed The speed at which to drive.
   * @param distance The distance to drive in inches.
   * @param drivetrain The drivetrain subsystem.
   * @return A new DriveDistance command.
   */
 
  

