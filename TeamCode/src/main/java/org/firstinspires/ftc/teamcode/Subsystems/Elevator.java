package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Elevator {
    // Motors Declaration
    private DcMotor elevatorMotor;

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor = hardwareMap.get(DcMotor.class, "elevatorMotor");
        elevatorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // Set the motor mode as needed
    }

    public void ElevatorVoltage(double ElevatorMotorsSpeed) {
        elevatorMotor.setPower(ElevatorMotorsSpeed);
    }
}
