package org.firstinspires.ftc.teamcode;



import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;


// Mechanisms Import
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;


import org.firstinspires.ftc.teamcode.Commands.ClawMove;


//Controllers import
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.command.button.Button;


@TeleOp
public class MainSystem extends LinearOpMode {
    Chassis chassis;
    Intake intake;
    Band band;
    Elevator elevator;
    Claw claw;
    //Shooter shooter;

    private Gamepad driverGamepad;
    private Gamepad operatorGamepad;

    @Override
    public void runOpMode() {

        GamepadEx toolOp = new GamepadEx(gamepad2);
        driverGamepad = gamepad1;
        //operatorGamepad = gamepad2;

        chassis     = new Chassis(hardwareMap);     // Create an instance of Chassis
        elevator    = new Elevator(hardwareMap);    // Create an instance of Elevator
        intake      = new Intake(hardwareMap);      // Create an instance of Intake
        band        = new Band(hardwareMap);        // Create an instance of Band
        claw        = new Claw(hardwareMap);        // Create an instance of Claw
        //shooter     = new Shooter(hardwareMap);     // Create an instance of Shooter

        //Claw will open and close
        Button buttonA = toolOp.getGamepadButton(GamepadKeys.Button.A);
        buttonA.whenPressed(new ClawMove(claw,1,0));
        buttonA.whenReleased(new ClawMove(claw,0,0));

        Button buttonB = toolOp.getGamepadButton(GamepadKeys.Button.B);
        buttonB.whenPressed(new ClawMove(claw,3,0));
        buttonB.whenReleased(new ClawMove(claw,0,0));



        waitForStart();

        while (opModeIsActive()) {
            // -- TELEMETRY -- //

            telemetry.addData("Status", "Enabled.");

            // Velocities
            telemetry.addData("LinearVel", -driverGamepad.left_stick_y);
            telemetry.addData("AngularVel", -driverGamepad.right_stick_x);

            // Distance per side in CM
            //telemetry.addData("RightDistance", chassis.rightDistance());
            //telemetry.addData("LeftDistance", chassis.leftDistance());


            // Update Telemetry
            telemetry.update();
        }
    }
}