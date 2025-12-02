package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Shooter extends SubsystemBase {

    private WPI_TalonSRX bottom_motor = new WPI_TalonSRX(4);
    private WPI_TalonSRX top_motor = new WPI_TalonSRX(5);

    public void shoot(){
    top_motor.set(0.1);
    bottom_motor.set(-0.1);
}
}


