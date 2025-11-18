package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class Intake {
    
    private WPI_TalonSRX rollor_motor = new WPI_TalonSRX(0);
    private WPI_TalonSRX winch_motor = new WPI_TalonSRX(1);


}
