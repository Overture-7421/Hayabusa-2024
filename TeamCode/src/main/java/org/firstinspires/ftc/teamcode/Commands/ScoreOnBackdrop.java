package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

public class ScoreOnBackdrop extends SequentialCommandGroup {

    public ScoreOnBackdrop(Elevator elevator, Arm arm, Claw claw) {
        addCommands(
                new MoveClaw(claw, 0.56),
                new ParallelCommandGroup(new MoveClaw(claw, 1), new ElevatorMove(elevator,0.15)),
                new MoveArm(arm,100),
                new MoveClaw(claw, -1)

        );
    }
}