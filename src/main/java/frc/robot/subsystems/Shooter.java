package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Shooter {

    private WPI_TalonSRX bottom_motor = new WPI_TalonSRX(0);
    private WPI_TalonSRX top_motor = new WPI_TalonSRX(1);

public void Shoot(double top, double bottom){

    top_motor.set(0.1);
    bottom_motor.set(-0.1);
}

}
