// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous.modes;

import frc.robot.autonomous.common.AutoBase;

/** Add your docs here. */
public class ButterAuto extends AutoBase {
        public ButterAuto() {
              super();
              
          }
      
          public void init() {
              addCommands(moveSetDistanceForward(1,0.5));
              addCommands(winchUp(0.4)); // will be changed
              addCommands(outtakeButter(0.2));
              addCommands(moveSetDistanceBackwards(0.2,0.5));
              addCommands(turnToAngle(90,0.5));
              addCommands(shooter(1));                 
            }
      
}
