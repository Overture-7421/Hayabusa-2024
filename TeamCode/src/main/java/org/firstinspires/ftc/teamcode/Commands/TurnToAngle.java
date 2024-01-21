package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.Controllers.FRCPIDController;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

import java.util.concurrent.TimeUnit;

public class TurnToAngle extends CommandBase {
    private final Chassis chassis;
    private final FRCPIDController pidController;

    private TrapezoidProfile profile;
    private final Rotation2d targetHeading;

    private Timing.Timer timer;
    public TurnToAngle(Chassis chassis, Rotation2d targetHeading){
        this.chassis = chassis;
        this.targetHeading = targetHeading;

        pidController = new FRCPIDController(0.01, 0.0, 0.0);
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        pidController.setTolerance(3);
        pidController.enableContinuousInput(-180.0, 180.0);
        double targetDegrees = targetHeading.getDegrees();
        double currentDegrees = chassis.getPose().getRotation().getDegrees();

        TrapezoidProfile.State targetState = new TrapezoidProfile.State(targetDegrees, 0);
        TrapezoidProfile.State currentState = new TrapezoidProfile.State(currentDegrees, 0);

        profile = new TrapezoidProfile(new TrapezoidProfile.Constraints(90, 180), targetState, currentState);

        timer = new Timing.Timer((long) profile.totalTime() * 1000, TimeUnit.MILLISECONDS);
        timer.start();
    }

    @Override
    public void execute() {
        double currentDegrees = chassis.getPose().getRotation().getDegrees();
        TrapezoidProfile.State targetState = profile.calculate(timer.elapsedTime() / 1000.0);

        double angularVel = pidController.calculate(currentDegrees, targetState.position);
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
