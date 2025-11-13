// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  public Drivetrain() {}
  public WPI_TalonSRX left_motor = new WPI_TalonSRX(0);
  public WPI_TalonSRX right_motor = new WPI_TalonSRX(1);
  
  public final DifferentialDrive differentDrive =
     new DifferentialDrive(left_motor::set, right_motor::set);

  
  public void drive(double left_speed, double right_speed) {
    differentDrive.drive(left_speed,right_speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
