package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ElevatorMove;
import org.firstinspires.ftc.teamcode.Commands.MoveArm;
import org.firstinspires.ftc.teamcode.Commands.MoveClaw;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

public class StowAll extends SequentialCommandGroup {

    public StowAll(Elevator elevator, Arm arm, Claw claw) {
        addCommands(
                new WaitCommand(1000),
                new MoveClaw(claw,-120),
                new WaitCommand(2000),
                new MoveArm(arm,1),
                new ElevatorMove(elevator,0)
        );
    }
}
