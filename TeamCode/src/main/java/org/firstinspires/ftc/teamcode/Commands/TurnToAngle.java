package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;

import org.firstinspires.ftc.teamcode.Controllers.FRCProfiledPIDController;
import org.firstinspires.ftc.teamcode.Controllers.FRCTrapezoidProfile;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

public class TurnToAngle extends CommandBase {
    private final Chassis chassis;
    private final FRCProfiledPIDController pidController;
    private final Rotation2d targetHeading;

    public TurnToAngle(Chassis chassis, Rotation2d targetHeading){
        this.chassis = chassis;
        this.targetHeading = targetHeading;

        pidController = new FRCProfiledPIDController(0.1, 0.0, 0, new FRCTrapezoidProfile.Constraints(520, 300));
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        pidController.setTolerance(3);
        pidController.enableContinuousInput(-180.0, 180.0);

        double targetDegrees = targetHeading.getDegrees();
        double currentDegrees = chassis.getPose().getRotation().getDegrees();

        pidController.reset(currentDegrees, 0.0);
        pidController.setGoal(targetDegrees);
    }

    @Override
    public void execute() {
        double currentDegrees = chassis.getPose().getRotation().getDegrees();

        double angularVel = pidController.calculate(currentDegrees);
        chassis.setSpeed(0.0, angularVel);
    }

    @Override
    public void end(boolean interrupted){
        chassis.setSpeed(0.0, 0.0);
    }

    @Override
    public boolean isFinished(){
        double currentDegrees = chassis.getPose().getRotation().getDegrees();
        double targetDegrees = targetHeading.getDegrees();
        return Math.abs(targetDegrees - currentDegrees) < 3;
    }
}
