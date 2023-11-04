package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Chassis {

    private DcMotor left_Drive;
    private DcMotor right_Drive;

    public void declarationChassis() {
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
    }

    public void loopChassis() {
        float x = -gamepad1.left_stick_y;
        float y = -gamepad1.right_stick_x;
        right_Drive.setPower(y-x);
        left_Drive.setPower(x+y);

    }

}
