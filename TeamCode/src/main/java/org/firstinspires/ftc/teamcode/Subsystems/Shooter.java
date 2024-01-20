package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter extends SubsystemBase {
    // Motor Declaration
    private ServoEx Shoot_Servo;

    public Shooter (HardwareMap hardwareMap){
        Shoot_Servo = new SimpleServo(hardwareMap, "Shoot_Servo", 0, 1);
    }

    public void Position(double ShooterMotorPosition) {
       Shoot_Servo.setPosition(ShooterMotorPosition);
    }
}
