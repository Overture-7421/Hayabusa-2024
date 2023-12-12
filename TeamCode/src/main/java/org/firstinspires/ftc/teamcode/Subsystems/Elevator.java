package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevator {
    // Motors Declaration
    private DcMotorEx left_Elevator;
    private DcMotorEx right_Elevator;

    public Elevator(HardwareMap hardwareMap) {
        right_Elevator = hardwareMap.get(DcMotorEx.class, "right_Elevator");
        left_Elevator = hardwareMap.get(DcMotorEx.class, "left_Elevator");
    }

    public void ElevatorVoltage(double ElevatorMotorsSpeed) {
        right_Elevator.setPower(ElevatorMotorsSpeed);
        left_Elevator.setPower(ElevatorMotorsSpeed);
    }
}
