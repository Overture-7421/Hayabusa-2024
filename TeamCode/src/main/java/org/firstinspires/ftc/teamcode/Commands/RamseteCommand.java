package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.controller.wpilibcontroller.RamseteController;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.arcrobotics.ftclib.util.Timing.Timer;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

import java.util.concurrent.TimeUnit;

public class RamseteCommand extends CommandBase {
    private Chassis chassis;
    private RamseteController controller;
    private Trajectory trajectory;
    private Timer timer;

    public RamseteCommand(Chassis chassis, Trajectory trajectory) {
        this.chassis = chassis;
        this.trajectory = trajectory;

        controller = new RamseteController(2.0, 0.7);
        timer = new Timer((long) trajectory.getTotalTimeSeconds() * 1000, TimeUnit.MILLISECONDS);
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        timer.start();
       chassis.resetPose(trajectory.getInitialPose());
    }

    @Override
    public void execute() {
        Trajectory.State desiredState = trajectory.sample(timer.elapsedTime() / 1000.0);
        ChassisSpeeds desiredSpeeds = controller.calculate(chassis.getPose(), desiredState);
        chassis.setSpeed(desiredSpeeds.vxMetersPerSecond, desiredSpeeds.omegaRadiansPerSecond);
    }

    @Override
    public void end(boolean interrupted) {
        chassis.setSpeed(0,0);
    }

    @Override
    public boolean isFinished(){
        return timer.done();
    }


}
