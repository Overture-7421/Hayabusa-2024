package org.firstinspires.ftc.teamcode.Autonomous;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonomousCommands.ForwardWhileIntake;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

@Autonomous
public class AutonomousOne extends LinearOpMode {
Chassis chassis;
Band band;
Intake intake;
    @Override
    public void runOpMode() throws InterruptedException {
        chassis = new Chassis(hardwareMap);
        band = new Band(hardwareMap);
        intake = new Intake(hardwareMap);
        ForwardWhileIntake forwardWhileIntake = new ForwardWhileIntake(chassis, intake, band);

        waitForStart();
        CommandScheduler.getInstance().schedule(forwardWhileIntake);

        while (opModeIsActive ()){
            CommandScheduler.getInstance().run();
        }
    }
}
