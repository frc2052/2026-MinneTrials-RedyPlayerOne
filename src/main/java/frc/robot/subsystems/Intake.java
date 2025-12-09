package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final WPI_TalonSRX intakeRoller_motor = new WPI_TalonSRX(2);

    public Intake(){
        intakeRoller_motor.configFactoryDefault();
      
    }
    public void Intaking(double speed){
        intakeRoller_motor.set(speed);
    }
   

}