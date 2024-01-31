package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;

import java.util.concurrent.TimeUnit;

public class MoveArm extends CommandBase {
    private Arm arm;
    private double ArmAnglePosition;
    private Timing.Timer timer;

    public MoveArm(Arm subsystem, double ArmAnglePosition){
        this.ArmAnglePosition = ArmAnglePosition;
        arm = subsystem;
        timer = new Timing.Timer(2, TimeUnit.SECONDS);
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        arm.ArmPosition(ArmAnglePosition);
        timer.start();
    }

    @Override
    public boolean isFinished() {
        return timer.done();
    }
}
