package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

import java.sql.Time;
import java.util.concurrent.TimeUnit;


public class ChassisPaths extends CommandBase {
    private final Chassis chassis;
    private Timing.Timer timer;
    private long remainingTime;
    private double right;
    private double left;


    public ChassisPaths(Chassis subsystem, Time time ) {
        timer = new Timing.Timer(5, TimeUnit.SECONDS);
        chassis = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        timer.start();

        while (remainingTime > 0) {
            right = 1;
            left = 1;
            return;
        }


        chassis.setSpeed(left, right);
    }
}