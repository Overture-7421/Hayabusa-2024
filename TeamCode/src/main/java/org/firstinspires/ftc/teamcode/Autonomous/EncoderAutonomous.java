package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "EncoderAutonomous", group = "Autonomous")
public class EncoderAutonomous extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    // Constants
    private static final double COUNTS_PER_MOTOR_REV = 425;  // Encoder counts per revolution
    private static final double WHEEL_DIAMETER_INCHES = 3.5; // Diameter of the wheel
    private static final double COUNTS_PER_INCH = COUNTS_PER_MOTOR_REV / (WHEEL_DIAMETER_INCHES * Math.PI);

    // Distance to travel in inches
    //12 in = 1 ft
    private static final double DISTANCE_INCHES = 12.0;

    @Override
    public void runOpMode() {
        // Initialize hardware
        leftMotor = hardwareMap.get(DcMotor.class, "left_Drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_Drive");

        // Set motor directions
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        // Reset encoders and set mode
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the start button to be pressed
        waitForStart();

        // Move the robot forward using encoders
        encoderDrive(0.7, DISTANCE_INCHES, DISTANCE_INCHES, 5.0);

        // Stop the robot
        stopRobot();
    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeout) {
        int newLeftTarget;
        int newRightTarget;

        // Determine new target position
        newLeftTarget = leftMotor.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
        newRightTarget = rightMotor.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);

        // Set target positions
        leftMotor.setTargetPosition(newLeftTarget);
        rightMotor.setTargetPosition(newRightTarget);

        // Turn on RUN_TO_POSITION
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Set speed
        leftMotor.setPower(speed);
        rightMotor.setPower(speed);

        // Continue until both motors reach the target position or timeout
        long startTime = System.currentTimeMillis();
        while (opModeIsActive() &&
                (System.currentTimeMillis() - startTime < timeout * 1000) &&
                (leftMotor.isBusy() || rightMotor.isBusy())) {
            // Wait for the motors to reach the target position
            idle();
        }

        // Stop the motors
        stopRobot();

        // Turn off RUN_TO_POSITION
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    private void stopRobot() {
        // Stop both motors
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
