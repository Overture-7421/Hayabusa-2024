package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm extends SubsystemBase {
    private ServoEx twist_Right; //Declare right arm
    private ServoEx twist_Left; //Declare left arm

    public Arm (HardwareMap hardwareMap) {
        // Reverse the reversed Servo
        twist_Left.setInverted(true);

        // Servos IDs
        twist_Right = new SimpleServo(hardwareMap, "twist_Right", 0, 1);
        twist_Left = new SimpleServo(hardwareMap, "twist_Left", 0, 1);
    }

    public void ArmPosition(double ArmAnglePos) {
        twist_Right.setPosition(ArmAnglePos);
        twist_Left.setPosition(ArmAnglePos);
    }
}
