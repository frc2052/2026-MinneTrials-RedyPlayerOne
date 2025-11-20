package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Shooter {
   private WPI_TalonSRX top_motor = new WPI_TalonSRX(0);
   private WPI_TalonSRX bottom_motor = new WPI_TalonSRX(1);

   
   public void Shooting( double top, double bottom){
    top_motor.set(0.1);
    bottom_motor.set(0.1);
   }

}
