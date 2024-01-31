package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm extends SubsystemBase {
    private ServoEx twist_Right; //Declare right arm
    private ServoEx twist_Left; //Declare left arm

    public Arm (HardwareMap hardwareMap){
        // Servos IDs
        twist_Right = new SimpleServo(hardwareMap, "twist_Right", -0.5, 0.5);
        twist_Left = new SimpleServo(hardwareMap, "twist_Left", -0.5, 0.5);
    }

    public double ArmPosition(double ArmAnglePosition) {
        twist_Right.rotateByAngle(ArmAnglePosition);
        twist_Left.rotateByAngle(ArmAnglePosition*-1);

        return ArmAnglePosition;
    }
}
