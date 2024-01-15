package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveWheelSpeeds;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveKinematics;
import org.firstinspires.ftc.teamcode.Utils.JoystickHandler;

public class Chassis {
    // Motors Declaration
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

    public Chassis(HardwareMap hardwareMap) {
        // Motor ID
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");

        // Invert one motor
        right_Drive.setDirection(DcMotor.Direction.REVERSE);
        left_Drive.setDirection(DcMotor.Direction.FORWARD);
    }

    // Set Speed Function
    public void setSpeed(double linearSpeed, double angularSpeed) {
        right_Drive.setPower(linearSpeed + angularSpeed);
        left_Drive.setPower(linearSpeed - angularSpeed);
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
        DifferentialDriveKinematics kinematics =
                new DifferentialDriveKinematics(15.0 / 254.0);

        ChassisSpeeds chassisSpeeds = new ChassisSpeeds(2.0, 0, 1.0);

        DifferentialDriveWheelSpeeds wheelSpeeds =
                kinematics.toWheelSpeeds(chassisSpeeds);

        double leftVelocity = wheelSpeeds.leftMetersPerSecond;

        double rightVelocity = wheelSpeeds.rightMetersPerSecond;

    // -- ODOMETRY -- //



}


