package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {

    private Servo grab_LeftServo;
    private Servo grab_RightServo;

    private Gamepad operatorGamepad;

    public Claw (HardwareMap hardwareMap, Gamepad operatorGamepad) {
        this.operatorGamepad = operatorGamepad;

        grab_LeftServo = hardwareMap.get(Servo.class, "grab_RightServo");
        grab_RightServo = hardwareMap.get(Servo.class, "grab_LeftServo");

    }
    public void clawLoop() {

        if (operatorGamepad.x) {
            grab_RightServo.setPosition(1);
            grab_LeftServo.setPosition(1);
        }
        else if(operatorGamepad.y) {
            grab_RightServo.setPosition(0);
            grab_LeftServo.setPosition(0);
        }
    }

}
