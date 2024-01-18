package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Shooter;


public class MoveShooter extends CommandBase {
    private Shooter shooter;
    private double voltage;

    public MoveShooter(Shooter subsystem, double voltage) {
        this.voltage = voltage;
        shooter = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){
        shooter.Voltage(voltage);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.Voltage(0);
    }

}