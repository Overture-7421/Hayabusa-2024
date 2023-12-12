package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Band {
    // Motor Declaration
    private DcMotorEx belt_Spin;

    public Band (HardwareMap hardwareMap) {
        belt_Spin = hardwareMap.get(DcMotorEx.class, "belt_Spin");
    }

    public void BandVoltage(double BandMotorVoltage) {
        belt_Spin.setPower(BandMotorVoltage);
    }
}