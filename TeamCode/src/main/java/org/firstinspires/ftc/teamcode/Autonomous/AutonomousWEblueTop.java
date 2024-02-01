package org.firstinspires.ftc.teamcode.Autonomous;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.arcrobotics.ftclib.trajectory.TrajectoryConfig;
import com.arcrobotics.ftclib.trajectory.TrajectoryGenerator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonomousCommands.SpitPixels;
import org.firstinspires.ftc.teamcode.Commands.RamseteCommand;
import org.firstinspires.ftc.teamcode.Commands.ScoreOnBackdrop;
import org.firstinspires.ftc.teamcode.Commands.StowAll;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

import java.util.Arrays;

@Autonomous
public class  AutonomousWEblueTop extends LinearOpMode {
    Chassis chassis;
    Band band;
    Intake intake;
    Claw claw;
    Arm arm;
    Elevator elevator;


    @Override
    public void runOpMode() throws InterruptedException {
        chassis = new Chassis(hardwareMap);
        band = new Band(hardwareMap);
        intake = new Intake(hardwareMap);
        claw = new Claw(hardwareMap);
        arm = new Arm(hardwareMap);
        elevator = new Elevator(hardwareMap);

        TrajectoryConfig blueWETopConfig = new TrajectoryConfig(0.8, 0.8);
        blueWETopConfig.setReversed(true);
        Trajectory blueWETop = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0,0,Rotation2d.fromDegrees(0)),
                        new Pose2d(-0.9,-1.04,Rotation2d.fromDegrees(90))), blueWETopConfig
                );



        SequentialCommandGroup testCommandGroup = new SequentialCommandGroup(
                new RamseteCommand(chassis, blueWETop),
                new WaitCommand(2000),
                new ScoreOnBackdrop(elevator,arm,claw),
                new StowAll(elevator, arm, claw)
        );

        waitForStart();

        chassis.resetPose(blueWETop.getInitialPose());

        CommandScheduler.getInstance().schedule(testCommandGroup);

        while (opModeIsActive ()){
            CommandScheduler.getInstance().run();

            Pose2d pose = chassis.getPose();

            telemetry.addData("X", pose.getX());
            telemetry.addData("Y", pose.getY());
            telemetry.addData("Heading", pose.getRotation().getDegrees());
            telemetry.update();


        }
    }
}
