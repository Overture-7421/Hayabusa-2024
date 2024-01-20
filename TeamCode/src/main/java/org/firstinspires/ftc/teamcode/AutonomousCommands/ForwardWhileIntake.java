package org.firstinspires.ftc.teamcode.AutonomousCommands;

import com.arcrobotics.ftclib.command.ParallelRaceGroup;

import org.firstinspires.ftc.teamcode.Commands.ChassisPaths;
import org.firstinspires.ftc.teamcode.Commands.MoveIntake;
import org.firstinspires.ftc.teamcode.Commands.MoveBand;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class ForwardWhileIntake extends ParallelRaceGroup {

    public ForwardWhileIntake(Chassis chassis, Intake intake, Band band) {
        addCommands(
                new ChassisPaths(chassis, 0, 0.5).withTimeout(5000),
                new MoveIntake(intake, 1),
                new MoveBand(band, 1)
        );
    }
}