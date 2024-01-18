package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;


public class MoveChassis extends CommandBase {
    private Chassis chassis;
    private Gamepad driverGamepad;


    public MoveChassis(Chassis subsystem, Gamepad driverGamepad) {
        this.driverGamepad = driverGamepad;
        chassis = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
         double right;
         double left;


        chassis.setSpeed(driverGamepad.right_stick_x, driverGamepad.left_stick_y);
    }

    @Override
    public void end(boolean interrupted) {
        band.Voltage(0);
    }

}