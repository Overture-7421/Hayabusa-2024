package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ProfiledPIDController;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevator extends SubsystemBase {
    // Motors Declaration
    private DcMotorEx elevatorMotor1;
    private DcMotorEx elevatorMotor2;
    private ProfiledPIDController elevatorMotor1PID;
    private ProfiledPIDController elevatorMotor2PID;

    public static final double COUNTS_PER_REVOLUTION = 288;
    public static final double ELEVATOR_WINCH_CIRCUMFERENCE = 0.10868277; // In Meters

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor1 = (DcMotorEx) hardwareMap.get(DcMotor.class, "elevatorMotor1");
        elevatorMotor2 = (DcMotorEx) hardwareMap.get(DcMotor.class, "elevatorMotor2");

        elevatorMotor1PID = new ProfiledPIDController(0.1, 0.001, 0.0, new TrapezoidProfile.Constraints(10.0, 10.0));
        elevatorMotor2PID = new ProfiledPIDController(0.1, 0.001, 0.0, new TrapezoidProfile.Constraints(10.0, 10.0));

        elevatorMotor1.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        elevatorMotor2.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        elevatorMotor1.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        elevatorMotor2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    private double elevatorMotor1getCurrentHeight() {
        double elevatorMotor1Ticks = elevatorMotor1.getCurrentPosition();
        double elevatorMotor1CurrentHeight = elevatorMotor1Ticks / COUNTS_PER_REVOLUTION * ELEVATOR_WINCH_CIRCUMFERENCE;

        return elevatorMotor1CurrentHeight;
    }

    private double elevatorMotor2getCurrentHeight() {
        double elevatorMotor2Ticks = elevatorMotor2.getCurrentPosition();
        double elevatorMotor2CurrentHeight = elevatorMotor2Ticks / COUNTS_PER_REVOLUTION * ELEVATOR_WINCH_CIRCUMFERENCE;

        return elevatorMotor2CurrentHeight;
    }

    public double getHeight() {
        double elevatorMotor1Height = elevatorMotor1getCurrentHeight();
        double elevatorMotor2Height = elevatorMotor2getCurrentHeight();

        return (elevatorMotor1Height + elevatorMotor2Height) / 2.0;
    }

    public void setGoal(double goalHeight) {
        elevatorMotor1PID.reset(elevatorMotor1getCurrentHeight());
        elevatorMotor2PID.reset(elevatorMotor2getCurrentHeight());

        elevatorMotor1PID.setGoal(goalHeight);
        elevatorMotor2PID.setGoal(goalHeight);
    }

    @Override
    public void periodic() {
        double outputMotor1 = elevatorMotor1PID.calculate(elevatorMotor1getCurrentHeight());
        double outputMotor2 = elevatorMotor2PID.calculate(elevatorMotor2getCurrentHeight());

        elevatorMotor1.setPower(outputMotor1);
        elevatorMotor2.setPower(outputMotor2);
    }

}
