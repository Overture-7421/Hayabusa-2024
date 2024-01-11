package org.firstinspires.ftc.teamcode.autonomousImports.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.autonomousImports.SampleTankDrive;
import org.firstinspires.ftc.teamcode.autonomousImports.localizers.TwoWheelTrackingLocalizer;

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

        drive.turn(Math.toRadians(ANGLE));


        if (isStopRequested()) return;



    }
}