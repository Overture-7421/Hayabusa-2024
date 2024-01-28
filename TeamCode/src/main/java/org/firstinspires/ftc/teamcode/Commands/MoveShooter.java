package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.util.Timing;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Shooter;

import java.util.concurrent.TimeUnit;


public class MoveShooter extends CommandBase {
    private Shooter shooter;
    private double position;

    private Timing.Timer timer;

    public MoveShooter(Shooter subsystem, double position) {
        this.position = position;
        shooter = subsystem;
        timer = new Timing.Timer(2, TimeUnit.SECONDS);
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){
        shooter.Position(position);
        timer.start();
    }

    @Override
    public boolean isFinished() {
        return timer.done();
    }
}