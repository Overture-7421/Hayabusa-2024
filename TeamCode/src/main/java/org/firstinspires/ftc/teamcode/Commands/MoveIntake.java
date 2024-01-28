package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Intake;


public class MoveIntake extends CommandBase {
    private Intake intake;
    private double voltage;

    public MoveIntake(Intake subsystem, double voltage) {
        this.voltage = voltage;
        intake = subsystem;
        addRequirements(intake);
    }

    @Override
    public void initialize(){
        intake.Voltage(voltage);
    }

    @Override
    public void end(boolean interrupted) {
        intake.Voltage(0);
    }

}