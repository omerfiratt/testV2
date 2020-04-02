/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
import frc.robot.subsystems.ExampleSubsystem;


public class JoystickCommand extends CommandBase {

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public double m_Rspeed,m_Lspeed;

  public JoystickCommand(double rightSpeed, double leftSpeed) {

    m_Lspeed = leftSpeed;
    m_Rspeed = rightSpeed;
    // Use requires() here to declare subsystem dependencies

  }

  @Override
  public void initialize() {
    m_exampleSubsystem.JoystickleSurme(m_Lspeed, m_Rspeed);
  }

  @Override
  public void execute() {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
