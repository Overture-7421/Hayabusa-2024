package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    // Motor Declaration
    private Servo Shoot_Servo;

    public Shooter (HardwareMap hardwareMap){
        Shoot_Servo = hardwareMap.get(Servo.class, "shoot_Servo");
    }

    public void ShooterVoltage(double ShooterMotorPosition) {
       Shoot_Servo.setPosition(ShooterMotorPosition);
    }
}
