package org.firstinspires.ftc.teamcode.AutonomousCommands;

import com.acmerobotics.dashboard.canvas.Rotation;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ProfiledPIDController;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

import java.util.concurrent.TimeUnit;

public class TurnToAngle extends CommandBase {
    private Chassis chassis;
    private PIDController pidController;
    private TrapezoidProfile profile;
    private Rotation2d targetHeading;

    private Timing.Timer timer;
    public TurnToAngle(Chassis chassis, Rotation2d targetHeading){
        this.chassis = chassis;
        this.targetHeading = targetHeading;

        pidController = new PIDController(1.0, 0.0, 0.0);
    }

    @Override
    public void initialize() {
        pidController.setTolerance(3);
        TrapezoidProfile.State targetState = new TrapezoidProfile.State(targetHeading.getDegrees(), 0);
        TrapezoidProfile.State currentState = new TrapezoidProfile.State(chassis.getPose().getRotation().getDegrees(), 0);
        profile = new TrapezoidProfile(new TrapezoidProfile.Constraints(0.25, 0.5), targetState, currentState);
        timer = new Timing.Timer((long) profile.totalTime() * 1000, TimeUnit.MILLISECONDS);
        timer.start();
    }

    @Override
    public void execute() {
        double angularVel = pidController.calculate(chassis.getPose().getRotation().getDegrees(), profile.calculate(timer.elapsedTime() / 1000.0).position);
        chassis.setSpeed(0.0, angularVel);
    }

    @Override
    public void end(boolean interrupted){
        chassis.setSpeed(0.0, 0.0);
    }

    @Override
    public boolean isFinished(){
        return timer.done();
    }
}
