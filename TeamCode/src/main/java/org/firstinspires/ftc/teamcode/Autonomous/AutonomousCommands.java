package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "EncoderAutonomous", group = "Autonomous")
public class AutonomousCommands extends LinearOpMode {

    private DcMotor left_Drive;
    private DcMotor right_Drive;

    // Constants
    private static final double COUNTS_PER_MOTOR_REV = 470;  // Encoder counts per revolution
    private static final double WHEEL_DIAMETER_INCHES = 3.5; // Diameter of the wheel
    private static final double COUNTS_PER_INCH = COUNTS_PER_MOTOR_REV / (WHEEL_DIAMETER_INCHES * Math.PI);

    // Distance to travel in inches
    //12 in = 1 ft
    private static final double DISTANCE_INCHES = 12.0;

    @Override
    public void runOpMode() {
        // Initialize hardware
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");

        // Set motor directions
        left_Drive.setDirection(DcMotor.Direction.REVERSE);
        right_Drive.setDirection(DcMotor.Direction.FORWARD);

        // Reset encoders and set mode
        left_Drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_Drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the start button to be pressed
        waitForStart();

        // Move the robot forward using encoders
        //Max speed = 0.5
        encoderDrive(0.50, DISTANCE_INCHES, DISTANCE_INCHES, 5.0);

        // Stop the robot
        stopRobot();
    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeout) {
        int newLeftTarget;
        int newRightTarget;

        // Determine new target position
        newLeftTarget = left_Drive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
        newRightTarget = right_Drive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);

        // Set target positions
        left_Drive.setTargetPosition(newLeftTarget);
        right_Drive.setTargetPosition(newRightTarget);

        // Turn on RUN_TO_POSITION
        left_Drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_Drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Set speed
        left_Drive.setPower(speed);
        right_Drive.setPower(speed);

        // Continue until both motors reach the target position or timeout
        long startTime = System.currentTimeMillis();
        while (opModeIsActive() &&
                (System.currentTimeMillis() - startTime < timeout * 1000) &&
                (left_Drive.isBusy() || right_Drive.isBusy())) {
            // Wait for the motors to reach the target position
            idle();
        }

        // Stop the motors
        stopRobot();

        // Turn off RUN_TO_POSITION
        left_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    private void stopRobot() {
        // Stop both motors
        left_Drive.setPower(0);
        right_Drive.setPower(0);
    }

    public void turnLeft90() {
        // Adjust power and time based on your robot's characteristics
        right_Drive.setPower(0.5);
        left_Drive.setPower(-0.5);
        // Adjust the sleep time based on experimentation
        sleep(1000);
        stopMotors();
    }

    public void turnRight90() {
        // Adjust power and time based on your robot's characteristics
        right_Drive.setPower(-0.5);
        left_Drive.setPower(0.5);
        // Adjust the sleep time based on experimentation
        sleep(1000);
        stopMotors();
    }

    public void stopMotors() {
        right_Drive.setPower(0);
        left_Drive.setPower(0);
    }
}

