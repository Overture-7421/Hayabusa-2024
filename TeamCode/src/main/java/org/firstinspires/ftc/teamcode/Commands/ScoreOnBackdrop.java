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
                new ElevatorMove(elevator, 0.15),
                new WaitCommand(1000),
                //new ParallelCommandGroup(new MoveClaw(claw, -1),  new ElevatorMove(elevator,0.15)),
                new MoveArm(arm,100),
                new WaitCommand(5000),
                new MoveClaw(claw, 0.56)
        );
    }
}