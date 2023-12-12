package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    // Motor Declaration
    private DcMotor intake;

    public Intake(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class, "intake");
    }

    // Set Intake Voltage Function
    public void IntakeVoltage (double IntakeMotorSpeed){
        intake.setPower(IntakeMotorSpeed);
    }
}
