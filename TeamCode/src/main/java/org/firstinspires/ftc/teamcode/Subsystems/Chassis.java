package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis {
    // Motors Declaration
    private DcMotor right_Drive;
    private DcMotor left_Drive;

    // Cm per tick constant
    private final double CM_PER_TICK = 1.0  / 540.0 * 9.0 * Math.PI;


    // Odometry variables
    private DifferentialDriveOdometry odometry;


    public Chassis(HardwareMap hardwareMap) {
        // Motor ID
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");

        // Invert one motor
        right_Drive.setDirection(DcMotor.Direction.REVERSE);
        left_Drive.setDirection(DcMotor.Direction.FORWARD);

        // Odometry initialization
        odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getGyroHeading()), new Pose2d());
    }

    // Set Speed Function
    public void setSpeed(double linearSpeed, double angularSpeed){
        right_Drive.setPower(linearSpeed + angularSpeed);
        left_Drive.setPower(linearSpeed - angularSpeed);
    }

    // Get Right Distance (Position)
    public double rightDistance(){
        return right_Drive.getCurrentPosition() * CM_PER_TICK;
    }

    // Get Left Distance (Position)
    public double leftDistance(){
        return left_Drive.getCurrentPosition() * CM_PER_TICK;
    }

    // -- KINEMATICS -- //
        DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(17.662201 / 254.0);
        DifferentialDriveWheelSpeeds wheelSpeeds =
                new DifferentialDriveWheelSpeeds(2.0, 3.0);

        // Convert to chassis speeds.
        ChassisSpeeds chassisSpeeds = kinematics.toChassisSpeeds(wheelSpeeds);

        // Linear velocity
        double linearVelocity = chassisSpeeds.vxMetersPerSecond;

        // Angular velocity
        double angularVelocity = chassisSpeeds.omegaRadiansPerSecond;


        // -- ODOMETRY -- //
        private double getGyroHeading() {

            return getGyroHeading();
        }
}
}


