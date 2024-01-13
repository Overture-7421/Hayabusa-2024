package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Elevator {
    // Motors Declaration
    private DcMotor elevatorMotor1;
    private DcMotor elevatorMotor2;

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor1 = hardwareMap.get(DcMotor.class, "elevatorMotor1");
        elevatorMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // Set the motor mode as needed

        elevatorMotor2 = hardwareMap.get(DcMotor.class, "elevatorMotor2");
        elevatorMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // Set the motor mode as needed
    }

    public void ElevatorVoltage(double ElevatorMotorsSpeed) {
        elevatorMotor1.setPower(ElevatorMotorsSpeed);
        elevatorMotor2.setPower(ElevatorMotorsSpeed);

    }
}
