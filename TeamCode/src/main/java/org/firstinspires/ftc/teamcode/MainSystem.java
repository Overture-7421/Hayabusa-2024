package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

@TeleOp
public class MainSystem extends LinearOpMode {

    Chassis chassis;
    Elevator elevator;

    private Gamepad driverGamepad;
    private Gamepad operatorGamepad;

    @Override
    public void runOpMode() {
        driverGamepad = gamepad1;
        operatorGamepad = gamepad2;

        chassis = new Chassis(hardwareMap, driverGamepad); // Create an instance of Chassis
        elevator = new Elevator(hardwareMap, operatorGamepad); // Create an instance of Elevator

        waitForStart();

        while (opModeIsActive()) {
            chassis.chassisLoop();
            elevator.elevatorLoop();
            telemetry.addData("Status", "Go");
            telemetry.update();
        }
    }
}


