package org.firstinspires.ftc.teamcode.AutonomousCommands;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.MoveIntake;
import org.firstinspires.ftc.teamcode.Commands.MoveBand;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class BandAndIntake extends ParallelCommandGroup {

    public BandAndIntake(Band band, Intake intake) {
        addCommands(
                new MoveBand(band, 1),
                new MoveIntake(intake, 1));

    }
}