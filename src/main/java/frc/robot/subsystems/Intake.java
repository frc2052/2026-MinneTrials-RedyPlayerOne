package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class Intake extends SubsystemBase {
    
    private WPI_TalonSRX roller_motor_top = new WPI_TalonSRX(6);
    private WPI_TalonSRX roller_motor_bottom = new WPI_TalonSRX(2);
    private WPI_TalonSRX winch_motor = new WPI_TalonSRX(3);

public void roller( double roller_motor_speed_top, double roller_motor_speed_bottom){
roller_motor_top.set(roller_motor_speed_top);
roller_motor_bottom.set(roller_motor_speed_bottom);


}
public void winch(double winch_speed){

    winch_motor.set(winch_speed);
}

}





