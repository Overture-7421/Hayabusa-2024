package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;


@TeleOp
public class MainSystem extends LinearOpMode {

    Chassis chassis;
    Elevator elevator;

    @Override
    public void runOpMode() {
        chassis = new Chassis(hardwareMap); // Create an instance of Chassis
        elevator = new Elevator(); // Create an instance of Elevator

        waitForStart();

        while (opModeIsActive()) {
            chassis.chassisLoop();
            elevator.elevatorLoop();
            telemetry.addData("Status", "Go");
            telemetry.update();
        }
    }
}

