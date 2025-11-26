package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Shooter extends SubsystemBase {
   private WPI_TalonSRX top_motor = new WPI_TalonSRX(4);
   private WPI_TalonSRX bottom_motor = new WPI_TalonSRX(5);
   public Shooter(){
      top_motor.configFactoryDefault();
      bottom_motor.configFactoryDefault();
   }

   
   public void ShooterTop( double speed){
    top_motor.set(speed);
   }
    public void ShooterBottom(double speed){
     bottom_motor.set(speed);
    }

}
