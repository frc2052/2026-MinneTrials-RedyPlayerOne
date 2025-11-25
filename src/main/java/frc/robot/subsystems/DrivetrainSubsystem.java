// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.Pigeon2;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    private final WPI_TalonSRX leftMotor = new WPI_TalonSRX(DrivetrainConstants.LEFT_MOTOR_ID);
    private final WPI_TalonSRX rightMotor = new WPI_TalonSRX(DrivetrainConstants.RIGHT_MOTOR_ID);
    private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
