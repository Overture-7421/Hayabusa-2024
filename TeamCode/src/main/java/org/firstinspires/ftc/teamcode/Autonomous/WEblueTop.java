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

import org.firstinspires.ftc.teamcode.Commands.RamseteCommand;
import org.firstinspires.ftc.teamcode.Commands.ScoreOnBackdrop;
import org.firstinspires.ftc.teamcode.Commands.StowAll;
import org.firstinspires.ftc.teamcode.Commands.TurnToAngle;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

import java.util.Arrays;

@Autonomous
public class WEblueTop extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        /*Chassis chassis;
        Band band;
        Intake intake;
        Claw claw;
        Arm arm;
        Elevator elevator;*/

        CommandScheduler.getInstance().cancelAll();
        CommandScheduler.getInstance().reset();

        Chassis chassis = new Chassis(hardwareMap);
        Band band = new Band(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        Claw claw = new Claw(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        Elevator elevator = new Elevator(hardwareMap);

        TrajectoryConfig blueWETopConfig = new TrajectoryConfig(0.5, 0.5);
        blueWETopConfig.setReversed(true);
        Trajectory blueWETop = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0,0,Rotation2d.fromDegrees(0)),
                        new Pose2d(-0.9,-1.04,Rotation2d.fromDegrees(90))), blueWETopConfig
                );
        TrajectoryConfig GoPixelConfig = new TrajectoryConfig(0.7, 0.7);
        GoPixelConfig.setReversed(true);
        Trajectory GoPixel = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(-0.9,-1.04, Rotation2d.fromDegrees(0)),
                        new Pose2d(-1.2,-1.04, Rotation2d.fromDegrees(0)),
                        //new Pose2d(-0.6,1, Rotation2d.fromDegrees(-90)),
                        new Pose2d(-1.2,1.5, Rotation2d.fromDegrees(-90))), GoPixelConfig );

        TrajectoryConfig GoElevatorConfig = new TrajectoryConfig(0.7, 0.7);
        GoElevatorConfig.setReversed(true);
        Trajectory GoElevator = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                new Pose2d(-0.4,1.8, Rotation2d.fromDegrees(90)),
                new Pose2d(-0.5,1, Rotation2d.fromDegrees(90)),
                new Pose2d(-0.9,-1.04, Rotation2d.fromDegrees(90))), GoElevatorConfig );

        TrajectoryConfig GoPark = new TrajectoryConfig(0.5, 0.5);
        GoPark.setReversed(true);
        Trajectory blueweTop = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(-0.9,-1.04, Rotation2d.fromDegrees(180)),
                        //new Pose2d(0,0,Rotation2d.fromDegrees(180)),
                        new Pose2d(0.12,-1.5, Rotation2d.fromDegrees(90))), GoPark
);

        SequentialCommandGroup testCommandGroup = new SequentialCommandGroup(
                new RamseteCommand(chassis, blueWETop),
                 new ScoreOnBackdrop(elevator, arm, claw),
                new WaitCommand(1000),
                new StowAll(elevator, arm, claw),
                new WaitCommand(1000),
                /*new TurnToAngle(chassis, Rotation2d.fromDegrees(0)),
                new RamseteCommand(chassis, GoPixel),
                new TurnToAngle(chassis, Rotation2d.fromDegrees(90)),
                new GrabPixels(band, intake).withTimeout(4500),
                new RamseteCommand(chassis, GoElevator),*/
                new TurnToAngle(chassis, Rotation2d.fromDegrees(180)),
                new RamseteCommand(chassis, blueweTop)
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