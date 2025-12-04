// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous.modes;

import frc.robot.autonomous.common.AutoBase;

//BOTH RED AND BLUE ALLIANCE 
public class PopcornAuto2 extends AutoBase{
    public PopcornAuto2() {
          super();
          
      }
  
      public void init()  {
        //TBD estimated values 
            addCommands(moveSetDistanceBackwards(0.5,0.5));
            addCommands(shooter(4.5));   
            addCommands(moveSetDistanceForward(0.5,0.5));
          }
}
