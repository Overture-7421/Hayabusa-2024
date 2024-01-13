package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.List;

public class Chassis {
    // Motors Declaration
    private DcMotor right_Drive;
    private DcMotor left_Drive;

    // Cm per tick constant
    private final double CM_PER_TICK = 1.0  / 540.0 * 9.0 * Math.PI;

    public Chassis(HardwareMap hardwareMap) {
        // Motor ID
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");

        // Invert one motor
        right_Drive.setDirection(DcMotor.Direction.REVERSE);
        left_Drive.setDirection(DcMotor.Direction.FORWARD);
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

    // -- ODOMETRY -- //


}


