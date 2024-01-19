package org.firstinspires.ftc.teamcode.AutonomousCommands;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Commands.MoveChassis;
import org.firstinspires.ftc.teamcode.Commands.MoveIntake;
import org.firstinspires.ftc.teamcode.Commands.MoveBand;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class ForwardWhileIntake extends ParallelCommandGroup {

    Chassis chassis;
    Intake intake;
    Band band;
    private static final double INCHES = 3.0;
    private static final double SPEED = 0.5;

    public ForwardWhileIntake()
    {
        chassis     = new Chassis(hardwareMap);
        intake     = new Intake(hardwareMap);
        band     = new Band(hardwareMap);

//        addCommands(
//        intake.setDefaultCommand(new MoveIntake(intake, 1)),
//                band.setDefaultCommand(new MoveBand(band, 1)),
//               // chassis.setDefaultCommand(new MoveChassis(chassis, 1))
//
//
//                );
        addRequirements();
    }

}