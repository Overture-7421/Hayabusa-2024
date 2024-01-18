package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Shooter;


public class MoveShooter extends CommandBase {
    private Shooter shooter;
    private double position;

    public MoveShooter(Shooter subsystem, double position) {
        this.position = position;
        shooter = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){
        shooter.Position(position);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.Position(0);
    }

}