package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/*
@Autonomous //(name = "DistanceCalculations", group = "Autonomous")


public class DistanceCalculations extends LinearOpMode{
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private static final double WHEEL_DIAMETER_INCHES = 3.54; // Diameter of the wheel
    private static final double WHEEL_CIRCUMFERENCE = (WHEEL_DIAMETER_INCHES * Math.PI); // 11.1212
    private static final double DISTANCE_INCHES = 11.1212; // One Rotation
    private static final double TOTAL_REVS = DISTANCE_INCHES/WHEEL_CIRCUMFERENCE;


    public void runOpMode() throws InterruptedException {

        // Initialize hardware
        leftMotor = hardwareMap.get(DcMotor.class, "left_Drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_Drive");

        // Set motor directions
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the start button to be pressed
        waitForStart();

        // Move the robot forward using encoders
        leftMotor.setPower(0.3);
        rightMotor.setPower(0.3);
        sleep(945);

        // Stop the robot
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(5000);
    }
}

*/