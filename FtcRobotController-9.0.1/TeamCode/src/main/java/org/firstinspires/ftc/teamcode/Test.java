package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Test extends LinearOpMode {
    private DcMotor left_Drive;
    private DcMotor right_Drive;

    private DcMotorEx left_Elevator;
    private DcMotorEx right_Elevator;

    @Override
    public void runOpMode() {
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Elevator = hardwareMap.get(DcMotorEx.class, "left_Elevator");
        right_Elevator = hardwareMap.get(DcMotorEx.class, "right_Elevator");

        telemetry.addData ("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()){
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}