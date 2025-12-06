// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
private final VictorSPX topShootMotor;
private final VictorSPX bottomShootMotor;
private static boolean shooterRunning = false;

  public ShooterSubsystem() {
    topShootMotor = new VictorSPX(Constants.ShooterConstants.TOP_SHOOT_MOTOR_ID);
    topShootMotor.configFactoryDefault();
    topShootMotor.setNeutralMode(NeutralMode.Coast);
    topShootMotor.configFactoryDefault();

    bottomShootMotor = new VictorSPX(Constants.ShooterConstants.BOTTOM_SHOOT_MOTOR_ID);
    bottomShootMotor.configFactoryDefault();
    bottomShootMotor.setNeutralMode(NeutralMode.Coast);
    bottomShootMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double tSpeed, double bSpeed) {
    topShootMotor.set(ControlMode.PercentOutput, tSpeed);
    bottomShootMotor.set(ControlMode.PercentOutput, bSpeed);
    shooterRunning = true;
  }

  public void stopMotor() {
    topShootMotor.set(VictorSPXControlMode.PercentOutput, 0);
    bottomShootMotor.set(VictorSPXControlMode.PercentOutput, 0);
    shooterRunning = false;
  }
   
  public boolean getShooterRunning(){
    return shooterRunning;
  }

  public void setShooterRunning(boolean running){
    shooterRunning = running;
  }
}
