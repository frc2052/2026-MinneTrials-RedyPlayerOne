// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous.modes;

import frc.robot.autonomous.common.AutoBase;

/** Add your docs here. */
public class PopcornAuto4 extends AutoBase{
    public PopcornAuto4() {
          super();
          
      }
  
      public void init()  {
        //TBD estimated values 
            addCommands(moveSetDistanceForward(0.8,0.5));
            addCommands(turnToAngle(90,0.5));
            addCommands(moveSetDistanceBackwards(0.05, .5));
            addCommands(shooter(1.0));
            addCommands(moveSetDistanceForward(0.01, .5));
            addCommands(turnToAngle(0,0.5));
          }
}
