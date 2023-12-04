package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis {

    private DcMotor right_Drive;
    private DcMotor left_Drive;

    private Gamepad driverGamepad;

    public Chassis(HardwareMap hardwareMap, Gamepad driverGamepad) {
        this.driverGamepad = driverGamepad;

        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");
    }

    public void chassisLoop() {
        float x = driverGamepad.right_stick_x;
        float y = -driverGamepad.left_stick_y;

        if (driverGamepad.left_bumper) {
            right_Drive.setPower(0.3*(x + y));
            left_Drive.setPower(0.3*(x - y));
        } else {
            right_Drive.setPower(y + x);
            left_Drive.setPower(x - y);
        }
    }
}



