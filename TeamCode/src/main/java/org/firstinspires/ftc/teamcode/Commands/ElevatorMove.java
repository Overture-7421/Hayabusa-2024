package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;

import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

public class ElevatorMove extends CommandBase {

    private final Elevator elevator;
    private final double targetHeight;

    public ElevatorMove(Elevator elevator, double targetHeight) {
        this.elevator = elevator;
        this.targetHeight = targetHeight;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        elevator.setGoal(targetHeight);
    }


    @Override
    public boolean isFinished() {
        double currentHeight = elevator.getHeight();
        return Math.abs(targetHeight - currentHeight) < 0.05;
    }
}
