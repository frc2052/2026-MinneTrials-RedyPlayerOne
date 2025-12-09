package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Winch extends SubsystemBase{
    private final VictorSPX intakeWinch_motor = new VictorSPX(3);
    public Winch(){
        intakeWinch_motor.configFactoryDefault();
    }
    
    public void moveWinch(double speed){
        intakeWinch_motor.set(VictorSPXControlMode.PercentOutput,speed);
    }

}