package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class DriveTrain extends SubsystemBase {
    
    private final WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(0);
    private final WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(1);

    private final DifferentialDrive m_diffDrive =
      new DifferentialDrive(m_leftMotor::set, m_rightMotor::set);

    public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
        m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
        m_diffDrive.feed();
      }

}
