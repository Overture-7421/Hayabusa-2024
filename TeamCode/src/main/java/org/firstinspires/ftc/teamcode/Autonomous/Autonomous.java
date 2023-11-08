package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Gamepad;

@Autonomous
public class Autonomous {
    private DcMotor left_Drive;
    private DcMotor right_Drive;
    waitForStart();

    left_Drive.setPower(0.5);
    right_Drive.setPower(-0.5);
    sleep(500);
    left_Drive.setPower(0);
    right_Drive.setPower(0);



}