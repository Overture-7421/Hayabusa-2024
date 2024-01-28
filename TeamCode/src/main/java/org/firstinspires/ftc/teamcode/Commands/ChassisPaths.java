package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

import java.util.concurrent.TimeUnit;


public class ChassisPaths extends CommandBase {
    private final Chassis chassis;
    private double angularVel;
    private double linearVel;


    public ChassisPaths(Chassis subsystem, double angularVel, double linearVel) {
        this.angularVel = angularVel;
        this.linearVel = linearVel;
        chassis = subsystem;

        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        chassis.setSpeed(linearVel, angularVel);
    }

    @Override
    public void end(boolean interrupted) {
        chassis.setSpeed(0, 0);
    }
}