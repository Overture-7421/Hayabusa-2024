package org.firstinspires.ftc.teamcode.AutonomousCommands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.ElevatorMove;
import org.firstinspires.ftc.teamcode.Commands.MoveArm;
import org.firstinspires.ftc.teamcode.Commands.MoveClaw;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

public class Drop_pixels extends SequentialCommandGroup {

    public Drop_pixels(Elevator elevator, Arm arm, Claw claw) {
        addCommands(
                new ElevatorMove(elevator,1),
                new MoveArm(arm,1),
                new MoveClaw(claw,1),
                new MoveClaw(claw,0),
                new MoveArm(arm,0),
                new ElevatorMove(elevator,0)
        );
    }
}