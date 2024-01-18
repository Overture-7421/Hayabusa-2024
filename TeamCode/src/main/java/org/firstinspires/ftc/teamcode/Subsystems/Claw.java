package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw extends SubsystemBase {

    // Motor Declaration
    private Servo grab_RightServo; // Declare left claw servo
    private Servo grab_LeftServo; //Declare right claw servo
    private Servo twist_Right; //Declare right arm
    private Servo twist_Left; //Declare left arm

    public Claw (HardwareMap hardwareMap) {
        // Servos IDs
        grab_RightServo = hardwareMap.get(Servo.class, "grab_RightServo");
        grab_LeftServo = hardwareMap.get(Servo.class, "grab_LeftServo");
        twist_Right = hardwareMap.get(Servo.class, "twist_Right");
        twist_Left = hardwareMap.get(Servo.class, "twist_Left");
        // Reverse the reversed Servo
        grab_RightServo.setDirection(Servo.Direction.FORWARD);
        grab_LeftServo.setDirection(Servo.Direction.REVERSE);
        twist_Right.setDirection(Servo.Direction.FORWARD);
        twist_Left.setDirection(Servo.Direction.REVERSE);
    }

    public void ClawVoltage(double ClawMotorPosition) {
        // Set the position of servos using Main System values
        grab_RightServo.setPosition(ClawMotorPosition);
        grab_LeftServo.setPosition(ClawMotorPosition);

    }

    public void ArmVoltage(double ArmAnglePos) {
        twist_Right.setPosition(ArmAnglePos);
        twist_Left.setPosition(ArmAnglePos);
    }

}
