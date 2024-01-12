package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveKinematics;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.DifferentialDriveWheelSpeeds;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.List;

public class Chassis {
    // Motors Declaration
    private DcMotor right_Drive;
    private DcMotor left_Drive;

    // Cm per tick constant

    private final double IN_PER_TICK = 1.0  / 540.0 * 3.54 * Math.PI;

    public Chassis(HardwareMap hardwareMap) {
        // Motor ID
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");

        // Invert one motor
        right_Drive.setDirection(DcMotor.Direction.REVERSE);
        left_Drive.setDirection(DcMotor.Direction.FORWARD);
    }

    // Set Speed Function
    public void setSpeed(double linearVelocity, double angularVelocity) {
        this.linearVelocity = linearVelocity;
        this.angularVelocity = angularVelocity;
        right_Drive.setPower(linearVelocity + angularVelocity);
        left_Drive.setPower(linearVelocity - angularVelocity);
    }

    // Get Right Distance (Position)
    public double rightDistance() { return right_Drive.getCurrentPosition() * IN_PER_TICK; }


    // Get Left Distance (Position)
    public double leftDistance(){
        return left_Drive.getCurrentPosition() * IN_PER_TICK;
    }

    // -- ODOMETRY -- //
        // Creating my kinematics object: track width of 15 inches
        DifferentialDriveKinematics kinematics =
                new DifferentialDriveKinematics(17.662201 / 254.0);
        // Example differential drive wheel speeds: 2 meters per second
        // for the left side, 3 meters per second for the right side.
        DifferentialDriveWheelSpeeds wheelSpeeds =
                new DifferentialDriveWheelSpeeds(2.0, 3.0);
        // Convert to chassis speeds.
        ChassisSpeeds chassisSpeeds = kinematics.toChassisSpeeds(wheelSpeeds);
        // Linear velocity
        double linearVelocity = chassisSpeeds.vxMetersPerSecond;
        // Angular velocity
        double angularVelocity = chassisSpeeds.omegaRadiansPerSecond;
    }




