package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveOdometry;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class Chassis extends SubsystemBase {
    // Motors Declaration
    private DcMotorEx right_Drive;
    private DcMotorEx left_Drive;

    // Cm per tick constant
    private final double M_PER_TICK = 1.0  / 54000.0 * 9.0 * Math.PI;
    static final double TRACKWIDTH = 1;

    private DifferentialDriveOdometry diffOdom;

    private IMU imu;
    // Odometry variables
    //private DifferentialDriveOdometry odometry;

    private int leftOffset = 0, rightOffset = 0;


    public Chassis(HardwareMap hardwareMap) {
        // Motor ID
        right_Drive = (DcMotorEx) hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = (DcMotorEx) hardwareMap.get(DcMotor.class, "left_Drive");

        // Invert one motor
        right_Drive.setDirection(DcMotor.Direction.FORWARD);
        left_Drive.setDirection(DcMotor.Direction.REVERSE);

        // Odometry initialization
        diffOdom = new DifferentialDriveOdometry(new Rotation2d());
        imu = hardwareMap.get(IMU.class, "imu");


        IMU.Parameters imuParameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.FORWARD, RevHubOrientationOnRobot.UsbFacingDirection.UP)
        );

        imu.initialize(imuParameters);

        imu.resetYaw();

    }

     //Set Speed Function
    public void setSpeed(double linearSpeed, double angularSpeed){
        right_Drive.setPower(linearSpeed + angularSpeed);
        left_Drive.setPower(linearSpeed - angularSpeed);
    }

     //Get Right Distance (Position)
    public double rightDistance() {
        return (right_Drive.getCurrentPosition() - rightOffset) * M_PER_TICK;
    }

     //Get Left Distance (Position)
    public double leftDistance(){
        return (left_Drive.getCurrentPosition() - leftOffset) * M_PER_TICK;
    }

    public void resetPose(Pose2d pose) {
        leftOffset = left_Drive.getCurrentPosition();
        rightOffset = right_Drive.getCurrentPosition();
        diffOdom.resetPosition(pose, getIMUHeading());
    }

    public Pose2d getPose() {
        return diffOdom.getPoseMeters();
    }

    @Override
    public void periodic() {
        diffOdom.update(getIMUHeading(), leftDistance(), rightDistance());
    }

    private Rotation2d getIMUHeading(){
        YawPitchRollAngles robotOrientation;
        robotOrientation = imu.getRobotYawPitchRollAngles();

        return Rotation2d.fromDegrees(robotOrientation.getYaw(AngleUnit.DEGREES));
    }
}




