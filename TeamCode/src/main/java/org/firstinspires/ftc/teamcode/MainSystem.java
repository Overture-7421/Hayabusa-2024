package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

// Mechanisms Import
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;

@TeleOp
public class MainSystem extends LinearOpMode {
    Chassis chassis;
    Elevator elevator;
    Intake intake;
    Band band;
    Claw claw;
    Shooter shooter;

    private Gamepad driverGamepad;
    private Gamepad operatorGamepad;

    @Override
    public void runOpMode() {
        driverGamepad = gamepad1;
        operatorGamepad = gamepad2;

        chassis     = new Chassis(hardwareMap);     // Create an instance of Chassis
        elevator    = new Elevator(hardwareMap);    // Create an instance of Elevator
        intake      = new Intake(hardwareMap);      // Create an instance of Intake
        band        = new Band(hardwareMap);        // Create an instance of Band
        claw        = new Claw(hardwareMap);        // Create an instance of Claw
        shooter     = new Shooter(hardwareMap);     // Create an instance of Shooter

        waitForStart();

        while (opModeIsActive()) {
            // Chassis
                chassis.setSpeed(-driverGamepad.left_stick_y, -driverGamepad.right_stick_x);
                    //SlowMode
                    if (driverGamepad.left_bumper) {
                        chassis.setSpeed(-driverGamepad.left_stick_y * 0.3,
                                -driverGamepad.right_stick_x*0.3);
                    } else {
                        chassis.setSpeed(-driverGamepad.left_stick_y, -driverGamepad.right_stick_x);
                    }

            // Elevator
                if (operatorGamepad.right_bumper) {
                    elevator.ElevatorVoltage(1); // Voltage TBD
                } else if (operatorGamepad.left_bumper) {
                    elevator.ElevatorVoltage(-1); // Voltage TBD
                } else {
                    elevator.ElevatorVoltage(0);
                }


            // Intake
                if(operatorGamepad.right_stick_button){
                    intake.IntakeVoltage(1); // Voltage Pendant to Adjust
                } else if (operatorGamepad.left_stick_button) {
                    intake.IntakeVoltage(-1); // Voltage Pendant to Adjust
                }
                else{
                    intake.IntakeVoltage(0);
                }

            // Band
                if (operatorGamepad.dpad_up) {
                    band.BandVoltage(1); // Voltage Pendant to Adjust
                } else if (operatorGamepad.dpad_down) {
                    band.BandVoltage(-1); // Voltage Pendant to Adjust
                } else{
                    band.BandVoltage(0); // Voltage Pendant to Adjust
                }

            // Claw
                if (operatorGamepad.x) {
                    claw.ClawVoltage(1); // Voltage Pendant to Adjust

                }
                else if(operatorGamepad.y) {
                    claw.ClawVoltage(0); // Voltage Pendant to Adjust
                }

            // Shooter
                if (driverGamepad.right_bumper) {
                    shooter.ShooterVoltage(1); // Voltage Pendant to Adjust
                }   else {
                    shooter.ShooterVoltage(0); // Voltage Pendant to Adjust
                }


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


