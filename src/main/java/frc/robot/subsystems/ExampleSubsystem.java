/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Drive;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class ExampleSubsystem extends SubsystemBase {

  //Motorların tanımlanması
  Spark left_1 = new Spark(Drive.portMotorLeftBack);
  Spark left_2 = new Spark(Drive.portMotorLeftMiddle);
  Spark left_3 = new Spark(Drive.portMotorLeftFront);

  Spark right_1 = new Spark(Drive.portMotorRightBack);
  Spark right_2 = new Spark(Drive.portMotorRightMiddle);
  Spark right_3 = new Spark(Drive.portMotorRightFront);

  //Hız kontrol grubu sağ ve sol
  SpeedControllerGroup leftGroup = new SpeedControllerGroup(left_1, left_2, left_3);
  SpeedControllerGroup rightGroup = new SpeedControllerGroup(right_1, right_2, right_3);

  //Drive sistemi
  DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

  //Encoder tanımlaması
  private final Encoder encoder = new Encoder(0,1);

  public void JoystickleSurme(Double Left_Speed, Double Right_Speed)
  {
    drive.tankDrive(Left_Speed, Right_Speed);
  }


  public ExampleSubsystem() {

  }

  public void EncoderBaslat()
  {
    //Encoder başlatılması
    encoder.setDistancePerPulse(1./256.);
  }

  public void RobotDrive()
  {
    if(encoder.getDistance() < 10)
    {
      drive.tankDrive(1, 1); 
    }
    else
    {
      drive.stopMotor();
    }
  }


  @Override
  public void periodic() {
  }
}
