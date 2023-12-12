package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {

    // Motor Declaration
    private Servo grab_RightServo;
    private Servo grab_LeftServo;

    public Claw (HardwareMap hardwareMap){
        grab_RightServo = hardwareMap.get(Servo.class, "grab_RightServo");
        grab_LeftServo = hardwareMap.get(Servo.class, "grab_LeftServo");
    }

    public void ClawVoltage(double ClawMotorPosition) {
        grab_RightServo.setPosition(ClawMotorPosition);
        grab_LeftServo.setPosition(ClawMotorPosition);
    }
}
