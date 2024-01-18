package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Band;


public class MoveBand extends CommandBase {
    private Band band;
    private double voltage;


    public MoveBand(Band subsystem, double voltage) {
        this.voltage = voltage;
        band = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){
        band.Voltage(voltage);
    }

    @Override
    public void end(boolean interrupted) {
        band.Voltage(0);
    }

}