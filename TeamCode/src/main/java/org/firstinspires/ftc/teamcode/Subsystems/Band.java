package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Band {

    private DcMotorEx belt_Spin;

    private Gamepad operatorGamepad;

    public Band (HardwareMap hardwareMap, Gamepad operatorGamepad) {
        this.operatorGamepad = operatorGamepad;

        belt_Spin = hardwareMap.get(DcMotorEx.class, "belt_Spin");

    }
    public void bandLoop() {
        belt_Spin.setPower(1);

        if(operatorGamepad.dpad_down) {
            belt_Spin.setPower(-1);
        } else if (operatorGamepad.dpad_left) {
            belt_Spin.setPower(0);
        } else {
            belt_Spin.setPower(1);
        }
    }

}
