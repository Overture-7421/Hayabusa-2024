package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Claw extends SubsystemBase {

    // Motor Declaration
    private ServoEx grab_RightServo; // Declare left claw servo
    private ServoEx grab_LeftServo; //Declare right claw servo

    public Claw (HardwareMap hardwareMap) {
        //Servos IDs
        grab_RightServo = new SimpleServo(hardwareMap, "grab_RightServo", 0, 1);
        grab_LeftServo = new SimpleServo(hardwareMap, "grab_LeftServo", 0, 1);

        // Reverse the reversed Servo
        grab_RightServo.setInverted(false);
        grab_LeftServo.setInverted(true);

        grab_LeftServo.setRange(0, 1);
        grab_RightServo.setRange(0, 1);

    }

    public void ClawPosition(double ClawMotorPosition) {
        // Set the position of servos using Main System values
       grab_RightServo.setPosition(ClawMotorPosition);
       grab_LeftServo.setPosition(ClawMotorPosition);

    }

}
