/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.JoystickCommand;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.PWMVictorSPX;
//import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.redlineSub;

public class Robot extends TimedRobot {
  // private Command m_autonomousCommand;

  //private RobotContainer m_robotContainer;

  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();

  // Joystick tanımlama
  public static Joystick joystickLogitech = new Joystick(0);

  // Axis değerlerini okuma
  public double rawleftY = joystickLogitech.getRawAxis(2);
  public double rawrightX = joystickLogitech.getRawAxis(4);

  private final JoystickCommand joystickKomutu = new JoystickCommand(rawrightX, rawleftY);

  @Override
  public void robotInit() { // Robot çalıştığında burası çalışır

    // RobotContainer ayarlaması
    //m_robotContainer = new RobotContainer();
    m_subsystem = new ExampleSubsystem();

    m_subsystem.EncoderBaslat();

  }

  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() { // Otonom başladığı zaman arka arkaya sürekli çalışır.

    m_subsystem.RobotDrive();
  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {

    JoystickUse();
    redlineSub.startRedlineTeleop();
  }

  public Command JoystickUse()
  {
    return joystickKomutu;
  }

}
