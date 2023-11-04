package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Elevator {

    private DcMotorEx left_Elevator;
    private DcMotorEx right_Elevator;

    public void declarationElevator () {
        left_Elevator = hardwareMap.get(DcMotorEx.class, "left_Elevator");
        right_Elevator = hardwareMap.get(DcMotorEx.class, "right_Elevator");
    }

    public void loopElevator() {
       if (gamepad2.a) {
                left_Elevator.setPower(0.5);
                right_Elevator.setPower(-0.5);
            } else if (gamepad2.b) {
                left_Elevator.setPower(-0.5);
                right_Elevator.setPower((0.5));
            } else {
                left_Elevator.setPower(0);
                right_Elevator.setPower(0);
            }
    }
}



