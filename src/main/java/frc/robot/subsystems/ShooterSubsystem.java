// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
private final WPI_TalonSRX botShootMotor;
private final WPI_TalonSRX topShootMotor;
  public ShooterSubsystem() {
    botShootMotor = new WPI_TalonSRX(Constants.ShooterConstants.BOT_SHOOT_MOTOR_ID);
    botShootMotor.setNeutralMode(NeutralMode.Brake);
    botShootMotor.setInverted(true);
    topShootMotor = new WPI_TalonSRX(Constants.ShooterConstants.TOP_SHOOT_MOTOR_ID);
    topShootMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setSpeed(double speed){
    botShootMotor.set(ControlMode.PercentOutput, speed);
    topShootMotor.set(ControlMode.PercentOutput, speed);
  }
  public void stopMotor(){
    botShootMotor.stopMotor();
    topShootMotor.stopMotor();
  }
}
