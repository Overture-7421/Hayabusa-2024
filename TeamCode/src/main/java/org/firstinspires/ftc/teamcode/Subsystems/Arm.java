package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {

    private Servo arm_Servo;

    private Gamepad operatorGamepad;

    public Arm(HardwareMap hardwareMap, Gamepad operatorGamepad){
        this.operatorGamepad = operatorGamepad;

        arm_Servo = hardwareMap.get(Servo.class, "arm_Servo");

    }

    public void armLoop(){
        if (operatorGamepad.left_bumper) {
            arm_Servo.setPosition(1);
        }   else if (operatorGamepad.right_bumper) {
            arm_Servo.setPosition(0);
        }
    }

}
