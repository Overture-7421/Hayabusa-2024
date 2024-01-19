package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm extends SubsystemBase {
    private Servo twist_Right; //Declare right arm
    private Servo twist_Left; //Declare left arm

    public Arm (HardwareMap hardwareMap) {
        // Servos IDs
        twist_Right = hardwareMap.get(Servo.class, "twist_Right");
        twist_Left = hardwareMap.get(Servo.class, "twist_Left");
        // Reverse the reversed Servo
        twist_Right.setDirection(Servo.Direction.FORWARD);
        twist_Left.setDirection(Servo.Direction.REVERSE);
    }

    public void ArmPosition(double ArmAnglePos) {
        twist_Right.setPosition(ArmAnglePos);
        twist_Left.setPosition(ArmAnglePos);
    }
//    public void ArmPosition(double ArmAnglePos) {
}
