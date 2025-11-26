// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous.common;

import java.util.List;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.IntakePopcornCommand;
import frc.robot.commands.IntakeWinchCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.PathPlannerPath;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public abstract class AutoBase extends SequentialCommandGroup {

  private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();

  public AutoBase(){
    AutoBuilder.configureRamsete(
      drivetrain::getPose,
      drivetrain::resetOdometry,
      drivetrain::getWheelSpeeds,
      drivetrain::tankDriveVolts,
      drivetrain 
      );
      addRequirements(drivetrain,intake,shooter);
  }

  public Command followPath(String path){
    return AutoBuilder.followPath(PathPlannerPath.fromPathFile(path));
  }

  public Command intakePopcorn (){
    return new IntakePopcornCommand(intake).withTimeout(0);
  }

  public Command intakeButter (){
    return new IntakePopcornCommand(intake).withTimeout(0);
  }

  public Command shooter(){
    return new ShooterCommand(shooter).withTimeout(0);
  }

  public Command winchUp(){
    addCommands(new InstantCommand(()-> intake.setMoveUp(true)));
    return new IntakeWinchCommand(intake).withTimeout(0);
  }

  public Command winchDown(){
    addCommands(new InstantCommand(()-> intake.setMoveUp(false)));
    return new IntakeWinchCommand(intake).withTimeout(0);
  }

  
}
