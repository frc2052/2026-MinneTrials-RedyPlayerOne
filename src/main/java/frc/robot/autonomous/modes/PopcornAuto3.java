// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous.modes;

import frc.robot.autonomous.common.AutoBase;

//BOTH RED AND BLUE ALLIANCE 
public class PopcornAuto3 extends AutoBase{
    public PopcornAuto3() {
          super();
          
      }
  
      public void init()  {
        //TBD estimated values 
        addCommands(moveSetDistanceForward(0.8,0.5));
        addCommands(turnToAngle(90,0.5));
        addCommands(shooter(1.0));   
        addCommands(turnToAngle(0,0.5));
          }
}
