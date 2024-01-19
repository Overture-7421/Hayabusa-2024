package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


// Mechanisms Import
import org.firstinspires.ftc.teamcode.Commands.MoveBand;
import org.firstinspires.ftc.teamcode.Commands.MoveChassis;
import org.firstinspires.ftc.teamcode.Commands.MoveIntake;
import org.firstinspires.ftc.teamcode.Commands.MoveShooter;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;



import org.firstinspires.ftc.teamcode.Commands.ClawMove;


//Controllers import
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.command.button.Button;


import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;


@TeleOp
public class MainSystem extends LinearOpMode {
    Chassis chassis;
    Band band;
    Elevator elevator;
    Claw claw;
    Intake intake;
    Shooter shooter;
    GamepadEx driverOp;
    GamepadEx toolOp;

    @Override
    public void runOpMode() {
        chassis     = new Chassis(hardwareMap);     // Create an instance of Chassis
        elevator    = new Elevator(hardwareMap);    // Create an instance of Elevator
        intake      = new Intake(hardwareMap);      // Create an instance of Intake
        band        = new Band(hardwareMap);        // Create an instance of Band
        claw        = new Claw(hardwareMap);        // Create an instance of Claw
        shooter     = new Shooter(hardwareMap);     // Create an instance of Shooter
        driverOp    = new GamepadEx(gamepad1);      // Create an instance of DriverGamepad
        toolOp      = new GamepadEx(gamepad2);      // Create an instance of OperatorGamepad

        //Claw will open and close
        Button buttonX = toolOp.getGamepadButton(GamepadKeys.Button.X);
        buttonX.whenPressed(new ClawMove(claw,1,0));
        buttonX.whenReleased(new ClawMove(claw,0,0));

        Button buttonY = toolOp.getGamepadButton(GamepadKeys.Button.Y);
        buttonY.whenPressed(new ClawMove(claw,3,0));
        buttonY.whenReleased(new ClawMove(claw,0,0));

        shooter     = new Shooter(hardwareMap);     // Create an instance of Shooter
        driverOp    = new GamepadEx(gamepad1);         // Create an instance of DriverGamepad
        toolOp      = new GamepadEx(gamepad2);           //Create an instance of Opa

         // Intake and Band in
        Button buttonA = driverOp.getGamepadButton(GamepadKeys.Button.A);
        buttonA.whileHeld(new MoveIntake(intake,1));
        buttonA.whileHeld(new MoveBand(band,-1));

        // Intake and Band out
        Button buttonB = driverOp.getGamepadButton(GamepadKeys.Button.B);
        buttonB.whileHeld(new MoveIntake(intake,-1));
        buttonB.whileHeld(new MoveBand(band,1));

        // Chassis Movement
        chassis.setDefaultCommand(new MoveChassis(chassis,gamepad1));

        // Shooter
        Button rightBumper = toolOp.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER);
        rightBumper.whileHeld(new MoveShooter(shooter,1));

        waitForStart();


        while (opModeIsActive()) {
            CommandScheduler.getInstance().run();

            // -- TELEMETRY -- //
            telemetry.addData("Status", "Enabled.");

            // Distance per side in CM
            //telemetry.addData("RightDistance", chassis.rightDistance());
            //telemetry.addData("LeftDistance", chassis.leftDistance());


            // Update Telemetry
            telemetry.update();
        }
    }
}