// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DrivetrainConstants;
import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;

public class DrivetrainSubsystem extends SubsystemBase {
    private final WPI_TalonSRX leftMotor = new WPI_TalonSRX(DrivetrainConstants.LEFT_MOTOR_ID);
    private final WPI_TalonSRX rightMotor = new WPI_TalonSRX(DrivetrainConstants.RIGHT_MOTOR_ID);

    // AHRS navxGyro;
    private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
    final DifferentialDriveOdometry odometry;
    public AHRS navxGyro;
  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    navxGyro = new AHRS(NavXComType.kMXP_SPI);
    navxGyro.enableLogging(true);
    navxGyro.zeroYaw();
    odometry = new DifferentialDriveOdometry(navxGyro.getRotation2d(), distanceToMeters(leftMotor.getSelectedSensorPosition()), distanceToMeters(rightMotor.getSelectedSensorPosition())); 

    leftMotor.configFactoryDefault();
    rightMotor.configFactoryDefault();

    leftMotor.setNeutralMode(NeutralMode.Brake);
    rightMotor.setNeutralMode(NeutralMode.Brake);

    leftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, DrivetrainConstants.VELOCITY_CONTROL_SLOT, DrivetrainConstants.CAN_TIMEOUT);
    rightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, DrivetrainConstants.VELOCITY_CONTROL_SLOT, DrivetrainConstants.CAN_TIMEOUT);
  }
  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
    drive.feed();
  }
  public void arcadeDrive(double fwd, double rot) {
    drive.arcadeDrive(fwd, rot);
    drive.feed();
  }
  public void tankDriveVolts(double leftVoltage, double rightVoltage){
    leftMotor.setVoltage(leftVoltage);
    rightMotor.setVoltage(rightVoltage);
    drive.feed();
  }

  public Pose2d getPose(){
    return odometry.getPoseMeters();
  }

  public void resetOdometry(Pose2d pose){
    odometry.resetPose(pose);
  }

  public DifferentialDriveWheelSpeeds getWheelSpeeds(){
    return new DifferentialDriveWheelSpeeds(distanceToMeters(leftMotor.getSelectedSensorVelocity()),distanceToMeters(rightMotor.getSelectedSensorVelocity()));
  }
  public void stop() {
    drive.stopMotor();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler 
   odometry.update(navxGyro.getRotation2d(), distanceToMeters(leftMotor.getSelectedSensorPosition()), distanceToMeters(rightMotor.getSelectedSensorPosition())); 
  }

  public double distanceToMeters(double position){
    double distance = (position / Constants.DrivetrainConstants.ticksPerRot) * (Constants.DrivetrainConstants.driveWheelCircumM);
    return distance;
  }
  
}
