package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.Utils.JoystickHandler.handleJoystickInput;

import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveWheelSpeeds;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveKinematics;
import org.firstinspires.ftc.teamcode.Utils.JoystickHandler;
import com.arcrobotics.ftclib.kinematics.DifferentialOdometry;


public class Chassis {
    // Motors Declaration

    JoystickHandler joystickHandler;
    private DcMotor right_Drive;
    private DcMotor left_Drive;

    // CM per tick constant
    private final double CM_PER_TICK = 1.0 / 540.0 * 9.0 * Math.PI;

    // Odometry
    private Pose2d m_poseMeters;

    private Rotation2d m_gyroOffset;
    private Rotation2d m_previousAngle;

    private double m_prevLeftDistance;
    private double m_prevRightDistance;

    private double LeftAxis;
    private double RightAxis;





    public Chassis(HardwareMap hardwareMap) {
        // Motor ID
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");

        // Invert one motor
        right_Drive.setDirection(DcMotor.Direction.REVERSE);
        left_Drive.setDirection(DcMotor.Direction.FORWARD);
    }



    // Get Right Distance (Position)
    public double rightDistance() {
        return right_Drive.getCurrentPosition() * CM_PER_TICK;
    }

    // Get Left Distance (Position)
    public double leftDistance() {
        return left_Drive.getCurrentPosition() * CM_PER_TICK;
    }

    // -- KINEMATICS -- //

    // Creating my kinematics object: track width of 15 inches
    DifferentialDriveKinematics kinematics =
            new DifferentialDriveKinematics(15.0 / 254.0);

    // Example differential drive wheel speeds: 2 meters per second
    // for the left side, 3 meters per second for the right side.
    DifferentialDriveWheelSpeeds wheelSpeeds =
            new DifferentialDriveWheelSpeeds(2.0, 3.0);

    // Convert to chassis speeds.
    ChassisSpeeds chassisSpeeds = kinematics.toChassisSpeeds(wheelSpeeds);


    // Set Speed Function
    public void setSpeed(double linearSpeed, double angularSpeed) {

        LeftAxis = linearSpeed - angularSpeed;
        RightAxis = linearSpeed + angularSpeed;

        handleJoystickInput(LeftAxis);
        handleJoystickInput(RightAxis);

        right_Drive.setPower(RightAxis);
        left_Drive.setPower(LeftAxis);
    }


    // -- ODOMETRY -- //

    DifferentialDriveOdometry m_odometry = new DifferentialDriveOdometry
            (
                    getGyroHeading(), new Pose2d(5.0, 13.5, new Rotation2d())
            );


}


