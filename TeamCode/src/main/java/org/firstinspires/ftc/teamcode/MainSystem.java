package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.button.Button;
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
import org.firstinspires.ftc.teamcode.AutonomousCommands.DropPixels;
import org.firstinspires.ftc.teamcode.Commands.StowAll;
import org.firstinspires.ftc.teamcode.Commands.ScoreOnBackdrop;

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


    @Override
    public void runOpMode() {
        CommandScheduler.getInstance().cancelAll();
        CommandScheduler.getInstance().reset();

        Chassis chassis     = new Chassis(hardwareMap);     // Create an instance of Chassis
        Elevator elevator   = new Elevator(hardwareMap);    // Create an instance of Elevator
        Intake intake       = new Intake(hardwareMap);      // Create an instance of Intake
        Band band           = new Band(hardwareMap);        // Create an instance of Band
        Claw claw           = new Claw(hardwareMap);        // Create an instance of Claw
        Shooter shooter     = new Shooter(hardwareMap);     // Create an instance of Shooter
        Arm arm             = new Arm(hardwareMap);         // Create an instance of Arm
        GamepadEx driverOp  = new GamepadEx(gamepad1);      // Create an instance of DriverGamepad
        GamepadEx toolOp    = new GamepadEx(gamepad2);      // Create an instance of OperatorGamepad

        // -- CHASSIS MOVEMENT -- //
        chassis.setDefaultCommand(new MoveChassis(chassis,gamepad1));

        // ------------------ TESTING ------------------ //
            // -- TEST CLAW MOVEMENT -- //
                Button operatorButtonY= toolOp.getGamepadButton(GamepadKeys.Button.Y);
                operatorButtonY.whenHeld(new MoveClaw(claw,-1));
                operatorButtonY.whenReleased(new MoveClaw(claw,0.56));

                // -- TEST ARM MOVEMENT -- //
                Button operatorDpadRight= toolOp.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT);
                operatorDpadRight.whileHeld(new MoveArm(arm,100));

                Button operatorDpadLeft= toolOp.getGamepadButton(GamepadKeys.Button.DPAD_LEFT);
                operatorDpadLeft.whileHeld(new MoveArm(arm,0));

                // -- TEST ELEVATOR MOVEMENT -- //
                Button operatorButtonDPadUp= toolOp.getGamepadButton(GamepadKeys.Button.DPAD_UP);
                operatorButtonDPadUp.whenPressed(new ElevatorMove(elevator, 0.15));

                Button operatorButtonDPadDown= toolOp.getGamepadButton(GamepadKeys.Button.DPAD_DOWN);
                operatorButtonDPadDown.whenPressed(new ElevatorMove(elevator, 0));
        // ------------------ TESTING ------------------ //


        // -- DRIVER INTAKE AND BAND IN -- //
        Button driverRightBumper = driverOp.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER);
        driverRightBumper.whileHeld(new MoveIntake(intake,1));
        driverRightBumper.whileHeld(new MoveBand(band,1));

        // -- DRIVER INTAKE AND BAND OUT -- //
        Button driverLeftBumper = driverOp.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER);
        driverLeftBumper.whileHeld(new MoveIntake(intake,-1));
        driverLeftBumper.whileHeld(new MoveBand(band,-1));

        // -- OPERATOR SCORE ON BACKDROP COMMAND -- //
            // -- SCORE ON BACKDROP -- //
            Button rightBumper = toolOp.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER);
            rightBumper.whenPressed(new ScoreOnBackdrop(elevator, arm, claw));

            // -- STOW ALL -- //
            Button leftBumper = toolOp.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER);
            leftBumper.whenPressed(new StowAll(elevator, arm, claw));
        // -- OPERATOR SCORE ON BACKDROP COMMAND -- //


        // -- PLANE SHOOTER -- //
        Button buttonX= toolOp.getGamepadButton(GamepadKeys.Button.X);
        buttonX.whileHeld(new MoveShooter(shooter,1));
        buttonX.whenReleased(new MoveShooter(shooter,0));

        waitForStart();
        chassis.resetPose(new Pose2d(0,0, Rotation2d.fromDegrees(0)));
        CommandScheduler.getInstance().schedule(new MoveClaw(claw, -1));

        while (opModeIsActive()) {
            CommandScheduler.getInstance().run();
            Pose2d pose = chassis.getPose();

            // -- ODOMETRY TELEMETRY -- //
            telemetry.addData("X", pose.getX());
            telemetry.addData("Y", pose.getY());
            telemetry.addData("Heading", pose.getRotation().getDegrees());

            telemetry.addData("RightDistance", chassis.rightDistance());
            telemetry.addData("LeftDistance", chassis.leftDistance());

            // -- ELEVATOR TELEMETRY -- //
            telemetry.addData("Elevator Height", elevator.getHeight());

            // -- UPDATE TELEMETRY -- //
            telemetry.update();
        }
    }
}