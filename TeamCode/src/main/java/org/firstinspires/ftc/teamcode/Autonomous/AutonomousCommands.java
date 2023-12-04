package org.firstinspires.ftc.teamcode.Autonomous;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;

public class AutonomousCommands {

    private DcMotor right_Drive;
    private DcMotor left_Drive;


    void turnLeft90() throws InterruptedException {
        right_Drive.setPower(-0.5);
        left_Drive.setPower(0.5);
        sleep(625);

    }

}

