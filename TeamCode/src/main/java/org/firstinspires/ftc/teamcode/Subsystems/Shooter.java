package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {

    private Servo Shoot_Servo;

    private Gamepad operatorGamepad;

    public Shooter (HardwareMap hardwareMap, Gamepad operatorGamepad) {
        this.operatorGamepad = operatorGamepad;

        Shoot_Servo = hardwareMap.get(Servo.class, "Shoot_Servo");

    }
    public void shooterLoop(){
        if (operatorGamepad.left_stick_button) {
            Shoot_Servo.setPosition(1);
        }   else {
            Shoot_Servo.setPosition(0);
        }

    }
}
