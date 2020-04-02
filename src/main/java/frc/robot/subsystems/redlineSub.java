/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
//import frc.robot.Robot;
//import frc.robot.RobotContainer;
//import frc.robot.RobotContainer;


public class redlineSub extends SubsystemBase {
 

  private static PWMVictorSPX redline = new PWMVictorSPX(Constants.redline);


  private static redlineSub INSTANCE = new redlineSub();

  public static redlineSub getInstance() {

    if (INSTANCE == null) {

      synchronized (redlineSub.class) {

        if (INSTANCE == null) {
                INSTANCE = new redlineSub();
            }
        }
    }
    return INSTANCE;
}

  public redlineSub() {

  }


  @Override
  public void periodic() {

  }

  public Command startRedline() {
    redline.set(0.75);
    return null;

  }

  static public Command startRedlineTeleop() {
    redline.set(0.75);
    return null;
  }

  public Command stopRedline(){
    redline.set(0);
    return null;
  }

}
