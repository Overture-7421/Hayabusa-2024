package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Utils.JoystickHandler;


public class MoveChassis extends CommandBase {
    private final Chassis chassis;
    private final Gamepad driverGamepad;


    public MoveChassis(Chassis subsystem, Gamepad driverGamepad) {
        this.driverGamepad = driverGamepad;
        chassis = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
         double right = -driverGamepad.right_stick_x;
         double left = -driverGamepad.left_stick_y;

        right = JoystickHandler.handleJoystickInput(right);
        left = JoystickHandler.handleJoystickInput(left);


        chassis.setSpeed(left/2.5, right/2.5);
    }
}