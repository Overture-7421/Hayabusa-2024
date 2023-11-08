package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis {

    private DcMotor left_Drive;
    private DcMotor right_Drive;

    public Chassis(HardwareMap hardwareMap) {
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
    }

    public void chassisLoop() {
        float x;
        x = -gamepad1.left_stick_y;
        float y;
        y = -gamepad1.right_stick_x;
        right_Drive.setPower(y - x);
        left_Drive.setPower(x + y);
    }
}


