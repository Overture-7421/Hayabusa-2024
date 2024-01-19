package org.firstinspires.ftc.teamcode.commands;

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
    private Servo grab_RightServo;
    private Servo grab_LeftServo;
    private Servo twist_Right;
    private Servo twist_Left;
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
        grab_RightServo.setPosition(ClawMotorPosition);
        grab_LeftServo.setPosition(ClawMotorPosition);

        twist_Right.setPosition(ArmAnglePos);
        twist_Left.setPosition(ArmAnglePos);

        timer.start();
        telemetry.addData("Time elapsed", timer);
    }


    @Override
    public boolean isFinished() {
        return timer.done();
    }
}


