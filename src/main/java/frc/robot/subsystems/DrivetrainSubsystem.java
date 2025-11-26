// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;
// import edu.wpi.first.wpilibj.interfaces.Gyro;
// import com.kauailabs.navx.frc.AHRS;

public class DrivetrainSubsystem extends SubsystemBase {
    private final WPI_TalonSRX leftMotor = new WPI_TalonSRX(DrivetrainConstants.LEFT_MOTOR_ID);
    private final WPI_TalonSRX rightMotor = new WPI_TalonSRX(DrivetrainConstants.RIGHT_MOTOR_ID);

    // AHRS navxGyro;
    private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
    private final DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(null, null, null);
  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    // navxGyro = new AHRS(SPI.Port.kMXP); // TODO: need SPI port? yep
    // navxGyro.enableLogging(true);
    // navxGyro.zeroYaw();
    leftMotor.configFactoryDefault();
    rightMotor.configFactoryDefault();

    leftMotor.setNeutralMode(NeutralMode.Brake);
    rightMotor.setNeutralMode(NeutralMode.Brake);

    leftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, DrivetrainConstants.VELOCITY_CONTROL_SLOT, DrivetrainConstants.CAN_TIMEOUT);
    rightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, DrivetrainConstants.VELOCITY_CONTROL_SLOT, DrivetrainConstants.CAN_TIMEOUT);
  }
  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
  public void arcadeDrive(double fwd, double rot) {
    drive.arcadeDrive(fwd, rot);
  }
  public void stop() {
    drive.stopMotor();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
