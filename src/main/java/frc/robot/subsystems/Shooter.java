// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Shooter extends SubsystemBase{
  private WPI_VictorSPX top_motor = new WPI_VictorSPX(4);
  private WPI_VictorSPX bottom_motor = new WPI_VictorSPX(5);


  public void shoot(double top_speed, double bottom_speed){
    top_motor.set(top_speed);
    bottom_motor.set(bottom_speed);
  }

}