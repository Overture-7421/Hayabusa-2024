package org.firstinspires.ftc.teamcode.commands;


import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

public class ElevatorMove extends CommandBase {

    private Elevator elevator;
    private double voltage;

    //Este double va a ser parte del calculo para saber que tanto se tiene que extender
    private double elevatorTimeToExtend;
    private final double extendedHeight = 15; //Valor no final
    private final double nonExtendedHeight = 0;
    private double elevatorHeight;



    public ElevatorMove(Elevator subsystem, double elevatorHeight) {
        this.elevatorHeight = elevatorHeight;
        elevator = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        elevator.ElevatorHeight(elevatorHeight);
        elevator.ElevatorHeight(elevatorHeight);
    }

    @Override
    public boolean isFinished() {
        return true;
    }




}
