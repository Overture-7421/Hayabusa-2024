package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotor intake;

    private Gamepad driverGamepad;
    public Intake(HardwareMap hardwareMap, Gamepad driverGamepad) {
        this.driverGamepad = driverGamepad;

        intake = hardwareMap.get(DcMotor.class, "intake");

    }

    public void intakeLoop() {
        if(driverGamepad.left_bumper) {
            intake.setPower(1);
        } else if (driverGamepad.right_bumper) {
            intake.setPower(0);
        }
    }

}
