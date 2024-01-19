package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw extends SubsystemBase {

    // Motor Declaration
    private Servo grab_RightServo; // Declare left claw servo
    private Servo grab_LeftServo; //Declare right claw servo

    public Claw (HardwareMap hardwareMap) {
        // Servos IDs
        grab_RightServo = hardwareMap.get(Servo.class, "grab_RightServo");
        grab_LeftServo = hardwareMap.get(Servo.class, "grab_LeftServo");
        // Reverse the reversed Servo
        grab_RightServo.setDirection(Servo.Direction.FORWARD);
        grab_LeftServo.setDirection(Servo.Direction.REVERSE);
    }

    public void ClawPosition(double ClawMotorPosition) {
        // Set the position of servos using Main System values
        grab_RightServo.setPosition(ClawMotorPosition);
        grab_LeftServo.setPosition(ClawMotorPosition);

    }

}
