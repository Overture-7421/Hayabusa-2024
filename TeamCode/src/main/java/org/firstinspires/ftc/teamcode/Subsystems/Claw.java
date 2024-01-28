package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw extends SubsystemBase {

    // Motor Declaration
    private ServoEx grab_RightServo; // Declare left claw servo
    private ServoEx grab_LeftServo; //Declare right claw servo

    public Claw (HardwareMap hardwareMap) {
        //Servos IDs
        grab_RightServo = new SimpleServo(hardwareMap, "grab_RightServo", 0, 0.5);
        grab_LeftServo = new SimpleServo(hardwareMap, "grab_LeftServo", 0, 0.5);
        grab_LeftServo.setInverted(true);
    }

    public void ClawPosition(double ClawMotorPosition) {
        // Set the position of servos using Main System values
       grab_RightServo.setPosition(ClawMotorPosition);
       grab_LeftServo.setPosition(ClawMotorPosition);

    }

}
