package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    private Servo right_Twist;

    private Servo left_Twist;

    public Arm (HardwareMap hardwareMap) {

        left_Twist = hardwareMap.get(Servo.class, "leftTwist");
        right_Twist = hardwareMap.get(Servo.class, "rightTwist");

        left_Twist.setDirection(Servo.Direction.FORWARD);
        right_Twist.setDirection(Servo.Direction.REVERSE);

    }

    public void ArmVoltage(double ArmMotorPosition) {

        left_Twist.setPosition(ArmMotorPosition);
        right_Twist.setPosition(ArmMotorPosition);
    }



}
