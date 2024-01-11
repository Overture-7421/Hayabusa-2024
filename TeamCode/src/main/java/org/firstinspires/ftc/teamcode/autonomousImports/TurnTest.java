package org.firstinspires.ftc.teamcode.autonomousImports;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.autonomousImports.TwoWheelTrackingLocalizer;
import org.firstinspires.ftc.teamcode.autonomousImports.SampleTankDrive;

/*
 * This is a simple routine to test turning capabilities.
 */
@Config
@Autonomous(group = "drive")
public class TurnTest extends LinearOpMode {
    public static double ANGLE = 90; // deg

    @Override
    public void runOpMode() throws InterruptedException {
        SampleTankDrive drive = new SampleTankDrive(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;

        TwoWheelTrackingLocalizer(HardwareMap hardwareMap, SampleTankDrive drive);
        //drive.turn(Math.toRadians(ANGLE));
    }
}