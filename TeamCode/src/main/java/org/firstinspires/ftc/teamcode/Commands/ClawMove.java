package org.firstinspires.ftc.teamcode.Commands;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.util.Timing;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.concurrent.TimeUnit;

public class ClawMove extends CommandBase {

    private Claw claw;
    private double ClawMotorPosition;
    private double ArmAnglePos;
    private Timing.Timer timer;




    public ClawMove(Claw subsystem, double ClawMotorPosition, double ArmAnglePos) {
        claw = subsystem;
        this.ClawMotorPosition = ClawMotorPosition;
        this.ArmAnglePos = ArmAnglePos;
        timer = new Timing.Timer(2, TimeUnit.SECONDS);
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        claw.ClawVoltage(ClawMotorPosition);
        claw.ArmVoltage(ArmAnglePos);
        timer.start();
    }


    @Override
    public boolean isFinished() {
        return timer.done();
    }
}


