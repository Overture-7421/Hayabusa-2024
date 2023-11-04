package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;


@TeleOp
public class MainSystem extends LinearOpMode {

    @Override
    public void runOpMode() {
        Chassis chassis = new Chassis();
        Elevator elevator = new Elevator();
        waitForStart();

    }
}
