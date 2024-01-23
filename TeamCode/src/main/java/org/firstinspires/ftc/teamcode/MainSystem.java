package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

// Commands Import
import org.firstinspires.ftc.teamcode.Commands.ElevatorMove;
import org.firstinspires.ftc.teamcode.Commands.MoveArm;
import org.firstinspires.ftc.teamcode.Commands.MoveBand;
import org.firstinspires.ftc.teamcode.Commands.MoveChassis;
import org.firstinspires.ftc.teamcode.Commands.MoveIntake;
import org.firstinspires.ftc.teamcode.Commands.MoveShooter;
import org.firstinspires.ftc.teamcode.Commands.MoveClaw;

// Subsystems Import
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Shooter;


@TeleOp
public class MainSystem extends LinearOpMode {
    Chassis chassis;
    Arm arm;
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
        arm         = new Arm(hardwareMap);         // Create an instance of Arm
        driverOp    = new GamepadEx(gamepad1);      // Create an instance of DriverGamepad
        toolOp      = new GamepadEx(gamepad2);      // Create an instance of OperatorGamepad

        //Claw will open/close
        Button buttonX = toolOp.getGamepadButton(GamepadKeys.Button.X);
        buttonX.whileHeld(new MoveClaw(claw,1));
        buttonX.whenReleased(new MoveClaw(claw, 0));

        // Arm change angle
        Button buttonY = toolOp.getGamepadButton(GamepadKeys.Button.Y);
        buttonY.whileHeld(new MoveArm(arm,1));
        buttonY.whenReleased(new MoveArm(arm,0));

         // Intake and Band in
        Button buttonA = toolOp.getGamepadButton(GamepadKeys.Button.A);
        buttonA.whileHeld(new MoveIntake(intake,1));
        buttonA.whileHeld(new MoveBand(band,-1));

        // Intake and Band out
        Button buttonB = toolOp.getGamepadButton(GamepadKeys.Button.B);
        buttonB.whileHeld(new MoveIntake(intake,-1));
        buttonB.whileHeld(new MoveBand(band,1));

        // Chassis Movement
        chassis.setDefaultCommand(new MoveChassis(chassis,gamepad1));

        // Shooter
        Button rightBumper = toolOp.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER);
        rightBumper.whileHeld(new MoveShooter(shooter,1));
        rightBumper.whenReleased(new MoveShooter(shooter,0));

        //Elevator
        Button Dpad_up = toolOp.getGamepadButton(GamepadKeys.Button.DPAD_UP);
        Dpad_up.whenPressed(new ElevatorMove(elevator,1));

        Button Dpad_down = toolOp.getGamepadButton(GamepadKeys.Button.DPAD_DOWN);
        Dpad_down.whenPressed(new ElevatorMove(elevator,0));


        waitForStart();

        chassis.resetPose(new Pose2d(0,0, Rotation2d.fromDegrees(0)));

        while (opModeIsActive()) {
            CommandScheduler.getInstance().run();


            Pose2d pose = chassis.getPose();

            // -- TELEMETRY -- //
            telemetry.addData("X", pose.getX());
            telemetry.addData("Y", pose.getY());
            telemetry.addData("Heading", pose.getRotation().getDegrees());

            // Distance per side in CM
            telemetry.addData("RightDistance", chassis.rightDistance());
            telemetry.addData("LeftDistance", chassis.leftDistance());


            // Update Telemetry
            telemetry.update();
        }
    }
}