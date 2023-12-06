package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor intake;
    private Gamepad driverGamepad;
    private  Gamepad operatorGamepad;

    public Intake(HardwareMap hardwareMap, Gamepad operatorGamepad) {
        this.operatorGamepad = operatorGamepad;

        intake = hardwareMap.get(DcMotor.class, "intake");
    }

    public void intakeLoop() {
        if(operatorGamepad.a) {
            intake.setPower(-1);
        } else if (operatorGamepad.b) {
            intake.setPower(1);
        } else{
            intake.setPower(0);
        }
    }

}
