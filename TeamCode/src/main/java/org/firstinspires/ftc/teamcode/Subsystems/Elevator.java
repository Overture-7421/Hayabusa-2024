package org.firstinspires.ftc.teamcode.Subsystems;
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

    public void ElevatorHeight(double elevatorHeight) {
        //elevatorHeight.set...();

    }
}
