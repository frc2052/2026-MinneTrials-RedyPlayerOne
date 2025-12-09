package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Shooter extends SubsystemBase {
   private VictorSPX top_motor = new VictorSPX(4);
   private VictorSPX bottom_motor = new VictorSPX(5);
   public Shooter(){
      top_motor.configFactoryDefault();
      bottom_motor.configFactoryDefault();
   }

   
   public void shoot(double speed){
    top_motor.set(VictorSPXControlMode.PercentOutput,speed);
    bottom_motor.set(VictorSPXControlMode.PercentOutput,speed);
   }
   public void shootStop(){
      top_motor.set(VictorSPXControlMode.PercentOutput,0);
      bottom_motor.set(VictorSPXControlMode.PercentOutput,0);
   }

}
