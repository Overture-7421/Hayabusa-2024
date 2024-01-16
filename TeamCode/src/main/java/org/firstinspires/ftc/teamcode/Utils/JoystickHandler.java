package org.firstinspires.ftc.teamcode.Utils;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

public class JoystickHandler {
    private static final double DEADZONE = 0.15;  // Set your deadzone threshold
    private static final double EXPONENTIAL_GAIN = 0.15;  // Set your exponential gain

    public static double handleJoystickInput(double axisValue) {
        if (Math.abs(axisValue) < DEADZONE) {
            axisValue = 0.0;
        } else {
            axisValue = Math.copySign(Math.pow(axisValue, EXPONENTIAL_GAIN), axisValue);
        }

        return axisValue;
    }


}
