package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name = "DistanceCalculations", group = "Autonomous")
public class DistanceCalculations extends LinearOpMode{

    public HardwareMap hardwareMap;
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    private static final double WHEEL_DIAMETER_INCHES = 3.54; // Diameter of the wheel
    private static final double WHEEL_CIRCUMFERENCE = (WHEEL_DIAMETER_INCHES * Math.PI); // 11.1212
    private static final double DISTANCE_INCHES = 11.1212; // 2 ft = 24.0
    private static final double TOTAL_REVS = DISTANCE_INCHES/WHEEL_CIRCUMFERENCE;


    public void runOpMode() {
        // Initialize hardware
        leftMotor = hardwareMap.get(DcMotor.class, "left_Drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_Drive");

        // Set motor directions
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        // Reset encoders and set mode
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the start button to be pressed
        waitForStart();

        // Move the robot forward using encoders
        leftMotor.setPower(1);
        rightMotor.setPower(-1);
        sleep(5000);

        // Stop the robot
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sleep(5000);    }

}
