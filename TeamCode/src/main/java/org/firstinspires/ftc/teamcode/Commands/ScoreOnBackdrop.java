package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

public class ScoreOnBackdrop extends SequentialCommandGroup {

    public ScoreOnBackdrop(Elevator elevator, Arm arm, Claw claw) {
        addCommands(
                new ElevatorMove(elevator, 0.15).withTimeout(3000),
                new MoveArm(arm,100),
                new MoveClaw(claw, -1),
                new WaitCommand(1000)
        );
    }
}