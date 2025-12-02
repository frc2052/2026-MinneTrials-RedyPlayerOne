// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public Intake() {}
  private WPI_TalonSRX roller_motor_top = new WPI_TalonSRX(6);
  private WPI_TalonSRX roller_motor_bottom = new WPI_TalonSRX(2);
  private WPI_TalonSRX winch_motor = new WPI_TalonSRX(3);


  public void roller(double top_roller_speed,double bottom_roller_speed){
      roller_motor_top.set(top_roller_speed);
      roller_motor_bottom.set(bottom_roller_speed);
  }
  public void winch(double winch_speed){
    winch_motor.set(winch_speed);
  }
}
