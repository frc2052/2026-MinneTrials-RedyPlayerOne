// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
private final Joystick m_controller = new Joystick(0);
private final DriveTrain m_driveTrain = new DriveTrain();
private final Shooter m_Shooter = new Shooter();
private final Intake m_Intake = new Intake();

public Command getArcadeDriveCommand() {
   return new ArcadeDrive(
    m_driveTrain, () -> -m_controller.getRawAxis(1), () -> -m_controller.getRawAxis(5));

    
}

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
m_driveTrain.setDefaultCommand(getArcadeDriveCommand());
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());


    JoystickButton joystickAButton = new JoystickButton(m_controller, 1);
    joystickAButton
        .onTrue(new InstantCommand(() -> m_Shooter.shoot(), m_Shooter))
        .onFalse(new InstantCommand(() -> m_Shooter.shoot(), m_Shooter));


double roller_speed = 0.1;

      
    JoystickButton joystickRollerIn = new JoystickButton(m_controller, 3);
    joystickRollerIn
        .onTrue(new InstantCommand(() -> m_Intake.roller(roller_speed), m_Intake))
        .onFalse(new InstantCommand(() -> m_Intake.roller(0.0), m_Intake));
 
        JoystickButton joystickRollerOut = new JoystickButton(m_controller, 5);
        joystickRollerOut
            .onTrue(new InstantCommand(() -> m_Intake.roller(-roller_speed), m_Intake))
            .onFalse(new InstantCommand(() -> m_Intake.roller(0.0), m_Intake));

            double winch_speed = 0.1;


            JoystickButton joystickWinchUp = new JoystickButton(m_controller,6);
    joystickWinchUp
        .onTrue(new InstantCommand(() -> m_Intake.winch(0.0), m_Intake))
        .onFalse(new InstantCommand(() -> m_Intake.winch(0.0), m_Intake));



            JoystickButton joystickWinchDown = new JoystickButton(m_controller, 4);
    joystickWinchDown
        .onTrue(new InstantCommand(() -> m_Intake.winch(0.0), m_Intake))
        .onFalse(new InstantCommand(() -> m_Intake.winch(0.0), m_Intake));




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
}
