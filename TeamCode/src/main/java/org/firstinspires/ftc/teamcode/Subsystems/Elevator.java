package org.firstinspires.ftc.teamcode.Subsystems;

import org.firstinspires.ftc.teamcode.commands.ElevatorMove;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Elevator extends SubsystemBase {
    // Motors Declaration
    private DcMotorEx elevatorMotor1;
    private DcMotorEx elevatorMotor2;

    //private boolean ...

    public Elevator(HardwareMap hardwareMap) {
        elevatorMotor1 = hardwareMap.get(DcMotorEx.class, "elevatorMotor1");
        elevatorMotor2 = hardwareMap.get(DcMotorEx.class, "elevatorMotor2");
    }

   /*¨ public void ElevatorVoltageMotor1(double ElevatorMotorsSpeed) {
        elevatorMotor1.setPower(ElevatorMotorsSpeed);
    }

    public void ElevatorVoltageMotor2(double ElevatorMotorsSpeed) {
        elevatorMotor2.setPower(ElevatorMotorsSpeed);
    }*/

    public void ElevatorHeight(double elevatorHeight) {
        //elevatorHeight.set...();

    }
}
