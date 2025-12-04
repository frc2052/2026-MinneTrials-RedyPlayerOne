// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public Intake() {}
  private WPI_TalonSRX roller_motor = new WPI_TalonSRX(2);//maybe 6 instead
  private WPI_TalonSRX winch_motor = new WPI_TalonSRX(3);


  public void roller(double roller_speed){
      roller_motor.set(roller_speed);
  }
  public void winch(double winch_speed){
    winch_motor.set(winch_speed);
  }
}
