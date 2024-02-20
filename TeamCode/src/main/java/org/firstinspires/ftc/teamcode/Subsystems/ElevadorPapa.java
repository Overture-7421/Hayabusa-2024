package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class ElevadorPapa extends LinearOpMode {

    private DcMotorEx elevatorMotor1;
    private DcMotorEx elevatorMotor2;

    @Override
    public void runOpMode() throws InterruptedException {
        elevatorMotor1 = (DcMotorEx) hardwareMap.get(DcMotor.class, "elevatorMotor1");
        elevatorMotor2 = (DcMotorEx) hardwareMap.get(DcMotor.class, "elevatorMotor2");

        waitForStart();

        while (opModeIsActive()) {
            if(gamepad1.left_bumper) {
                elevatorMotor1.setPower(1);
                elevatorMotor2.setPower(-1);
            } else if(gamepad1.right_bumper) {
                elevatorMotor1.setPower(-1);
                elevatorMotor2.setPower(1);
            } else {
                elevatorMotor1.setPower(0);
                elevatorMotor2.setPower(0);
            }
        }

    }
}
