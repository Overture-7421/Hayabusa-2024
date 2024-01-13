package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Elevator {
    // Motors Declaration
    private DcMotorEx elevatorMotor1;
    private DcMotorEx elevatorMotor2;

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor1 = hardwareMap.get(DcMotorEx.class, "elevatorMotor1");
        elevatorMotor2 = hardwareMap.get(DcMotorEx.class, "elevatorMotor2");
    }

    public void ElevatorVoltage(double ElevatorMotorsSpeed) {
        elevatorMotor1.setPower(ElevatorMotorsSpeed);
        elevatorMotor2.setPower(ElevatorMotorsSpeed);
    }
}
