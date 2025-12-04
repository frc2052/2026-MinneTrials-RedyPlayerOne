package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class Intake extends SubsystemBase {
    
    private WPI_TalonSRX roller_motor = new WPI_TalonSRX(2);
    private WPI_TalonSRX winch_motor = new WPI_TalonSRX(3);

public void roller( double roller_motor_speed){
roller_motor.set(roller_motor_speed);


}
public void winch(double winch_speed){

    winch_motor.set(winch_speed);
}

}





