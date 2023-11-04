package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class  Test extends LinearOpMode {
    private DcMotor left_Drive;
    private DcMotor right_Drive;

    @Override
    public void runOpMode(){
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");

        telemetry.addData ("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()){
            telemetry.addData("Status", "Running");
            telemetry.update();

            float x = -gamepad1.left_stick_y;
            float y = -gamepad1.left_stick_x;

            right_Drive.setPower(y-x);
            left_Drive.setPower(x+y);

        }
    }
}