package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

@TeleOp
public class MainSystem extends LinearOpMode {
    Chassis chassis;
    //Intake intake;
    //Band band;
    //Claw claw;
    //Elevator elevator;
    //Shooter shooter

    private Gamepad driverGamepad;
    private Gamepad operatorGamepad;

    @Override
    public void runOpMode() {
        driverGamepad = gamepad1;
        operatorGamepad = gamepad2;

        chassis     = new Chassis(hardwareMap);     // Create an instance of Chassis
        //intake      = new Intake(hardwareMap, driverGamepad);      // Create an instance of Intake
        //band        = new Band(hardwareMap, operatorGamepad);      // Create an instance of Band
        //claw        = new Claw(hardwareMap, operatorGamepad);      // Create an instance of Claw
        //elevator    = new Elevator(hardwareMap, operatorGamepad);  // Create an instance of Elevator
        //shooter     = new Shooter(hardwareMap, operatorGamepad);   // Create an instance of Shooter

        waitForStart();

        while (opModeIsActive()) {

            // Chassis
            chassis.setSpeed(-driverGamepad.left_stick_y, -driverGamepad.right_stick_x);

            // Intake

            // Band

            // Claw

            // Elevator

            // Shooter


            // -- TELEMETRY -- //

            telemetry.addData("Status", "Enabled.");

            // Velocities
            telemetry.addData("LinearVel", -driverGamepad.left_stick_y);
            telemetry.addData("AngularVel", -driverGamepad.right_stick_x);

            // Distance per side in CM
            telemetry.addData("RightDistance", chassis.rightDistance());
            telemetry.addData("LeftDistance", chassis.leftDistance());

            // Update Telemetry
            telemetry.update();

        }
    }
}


