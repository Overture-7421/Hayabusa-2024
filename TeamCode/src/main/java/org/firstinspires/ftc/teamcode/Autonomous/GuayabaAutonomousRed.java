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
import org.firstinspires.ftc.teamcode.Commands.TurnToAngle;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

import java.util.Arrays;

@Autonomous
public class GuayabaAutonomousRed extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        CommandScheduler.getInstance().cancelAll();
        CommandScheduler.getInstance().reset();

        Chassis chassis = new Chassis(hardwareMap);
        Band band = new Band(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        Claw claw = new Claw(hardwareMap);
        Elevator elevator = new Elevator(hardwareMap);

        Trajectory basicCenter = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                        new Pose2d(0.7, 0, Rotation2d.fromDegrees(0))),
                        new TrajectoryConfig(1, 0.8));

        Trajectory GoplaceOnBackdrop = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0.7, 0, Rotation2d.fromDegrees(-90)),
                        new Pose2d(0.8, -0.8995, Rotation2d.fromDegrees(0))),
                        new TrajectoryConfig(1, 0.8));


        TrajectoryConfig redWETopConfig = new TrajectoryConfig(0.5, 0.5);
        redWETopConfig.setReversed(true);
        Trajectory GetCloser = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                new Pose2d(-0.8,0.8995,Rotation2d.fromDegrees(-90)),
                new Pose2d(-0.8,0.91,Rotation2d.fromDegrees(0))), redWETopConfig);

        Trajectory GoPark = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0.8, -0.8995, Rotation2d.fromDegrees(180)),
                        new Pose2d(0.15, -0.8995, Rotation2d.fromDegrees(180))),
                        new TrajectoryConfig(1, 0.8));

        Trajectory GoPark2 = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0.15, -0.8995, Rotation2d.fromDegrees(180)),
                        new Pose2d(0.15, -1, Rotation2d.fromDegrees(180))),
                new TrajectoryConfig(0.6, 0.4));

        SequentialCommandGroup testCommandGroup = new SequentialCommandGroup(
                new RamseteCommand(chassis, basicCenter),
                new SpitPixels(band, intake).withTimeout(4500),
                new TurnToAngle(chassis, Rotation2d.fromDegrees(-90)),
                new RamseteCommand(chassis, GoplaceOnBackdrop),
                new TurnToAngle(chassis, Rotation2d.fromDegrees(90)),
                new RamseteCommand(chassis, GetCloser),
                new ScoreOnBackdrop(elevator, arm, claw),
                new WaitCommand(1000),
                new StowAll(elevator, arm, claw),
                new TurnToAngle(chassis, Rotation2d.fromDegrees(180)),
                new RamseteCommand(chassis, GoPark),
                new TurnToAngle(chassis, Rotation2d.fromDegrees(-90)),
                new RamseteCommand(chassis, GoPark2)

                );

                waitForStart();

        chassis.resetPose(basicCenter.getInitialPose());

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
