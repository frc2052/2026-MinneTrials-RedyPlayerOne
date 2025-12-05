// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous.modes;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.autonomous.common.AutoBase;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

/** Add your docs here. */
public class BackUpAuto extends AutoBase {
  public BackUpAuto() {
        super();
        
    }

    public void init() {
         addCommands( new ArcadeDriveCommand(new DrivetrainSubsystem(),()-> 0.5,()-> 0.0).withSetTimeout(1.0));
    }

    
}
