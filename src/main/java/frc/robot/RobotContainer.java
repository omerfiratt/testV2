/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.redlineSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//import edu.wpi.first.wpilibj.TimedRobot;


public class RobotContainer {
  
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final redlineSub redlineSub = frc.robot.subsystems.redlineSub.getInstance();
  public static final PWMVictorSPX redline = new PWMVictorSPX(Constants.redline);

  public RobotContainer() {

    configureButtonBindings();
  }


  private void configureButtonBindings() {

    JoystickButton redlinestarter= new JoystickButton(Robot.joystickLogitech, Constants.buton); redlinestarter.whenPressed(redlineSub.startRedline()); redlinestarter.whenReleased(redlineSub.stopRedline());

  }


 
  public Command getAutonomousCommand() {

    return m_autoCommand;
  }

}
