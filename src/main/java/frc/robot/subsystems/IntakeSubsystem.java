// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

public class IntakeSubsystem extends SubsystemBase {
  private final WPI_TalonSRX rollerMotor = new WPI_TalonSRX(IntakeConstants.ROLLER_MOTOR_ID);
  private final VictorSPX winchMotor = new VictorSPX(IntakeConstants.WINCH_MOTOR_ID);
  public IntakeSubsystem() {
    rollerMotor.configFactoryDefault();
    winchMotor.configFactoryDefault();
    winchMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setIntakeSpeed(double speed) {
    rollerMotor.set(speed);
  }

  public void stopRoller() {
    rollerMotor.stopMotor();
  }

  public void setWinchSpeed(double speed) {
    winchMotor.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void stopWinch() {
    winchMotor.set(VictorSPXControlMode.PercentOutput, 0);
  }
}
