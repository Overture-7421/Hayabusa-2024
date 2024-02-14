package org.firstinspires.ftc.teamcode.AutonomousCommands;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.ElevatorMove;
import org.firstinspires.ftc.teamcode.Commands.MoveArm;
import org.firstinspires.ftc.teamcode.Commands.MoveClaw;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

public class DropPixels extends SequentialCommandGroup {

    public DropPixels(Elevator elevator, Arm arm, Claw claw) {
        addCommands(
                new MoveClaw(claw, 0.60),
                new ParallelCommandGroup(new MoveClaw(claw, 1), new ElevatorMove(elevator,0.30)),
                new MoveArm(arm,0.3)
                //new MoveClaw(claw,-1)
        );
    }
}