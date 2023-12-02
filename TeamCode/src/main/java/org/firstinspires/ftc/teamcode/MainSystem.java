package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;

@TeleOp
public class MainSystem extends LinearOpMode {

    Arm arm;
   // Band band;
    Chassis chassis;
    Claw claw;
    Elevator elevator;
   // Intake intake;
    Shooter shooter;


    private Gamepad driverGamepad;
    private Gamepad operatorGamepad;

    @Override
    public void runOpMode() {
        driverGamepad = gamepad1;
        operatorGamepad = gamepad2;

        arm         = new Arm(hardwareMap, operatorGamepad);       // Create an instance of Arm
       // band        = new Band(hardwareMap, operatorGamepad);      // Create an instance of Band
        claw        = new Claw(hardwareMap, operatorGamepad);      // Create an instance of Claw
        chassis     = new Chassis(hardwareMap, driverGamepad);     // Create an instance of Chassis
        elevator    = new Elevator(hardwareMap, operatorGamepad);  // Create an instance of Elevator
      //  intake      = new Intake(hardwareMap, driverGamepad);      // Create an instance of Intake
        shooter     = new Shooter(hardwareMap, operatorGamepad);   // Create an instance of Shooter

        waitForStart();

        while (opModeIsActive()) {
            arm.armLoop();
           // band.bandLoop();
            chassis.chassisLoop();
            claw.clawLoop();
            elevator.elevatorLoop();
          //  intake.intakeLoop();
            shooter.shooterLoop();

            telemetry.addData("Status", "Go");
            telemetry.update();
        }
    }
}


