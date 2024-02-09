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
import org.firstinspires.ftc.teamcode.Commands.TurnToAngle;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Band;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

import java.util.Arrays;

@Autonomous
public class WEblueBottom extends LinearOpMode {
    Chassis chassis;
    Band band;
    Intake intake;
    Arm arm;
    Claw claw;
    Elevator elevator;

    @Override
    public void runOpMode() throws InterruptedException {

        CommandScheduler.getInstance().cancelAll();
        CommandScheduler.getInstance().reset();

        chassis = new Chassis(hardwareMap);
        band = new Band(hardwareMap);
        intake = new Intake(hardwareMap);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);

        Trajectory blueWEBottom = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                        new Pose2d(1,0, Rotation2d.fromDegrees(0)),
                        new Pose2d(1.3,1, Rotation2d.fromDegrees(90)),
                        new Pose2d(0.45,2.42, Rotation2d.fromDegrees(180))),
                new TrajectoryConfig(1, 0.8));

        Trajectory Park = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                new Pose2d(0.45,2.42, Rotation2d.fromDegrees(180)),
                new Pose2d(0.0,2.42, Rotation2d.fromDegrees(180))),
                //new Pose2d(0.135,1.4, Rotation2d.fromDegrees(90))),
        new TrajectoryConfig(1, 0.8));

        SequentialCommandGroup testCommandGroup = new SequentialCommandGroup(
                new RamseteCommand(chassis, blueWEBottom),
                new TurnToAngle(chassis, Rotation2d.fromDegrees(-90)),
                //new ScoreOnBackdrop(elevator,arm,claw),
                //new StowAll(elevator, arm, claw)
                new WaitCommand(1000),
                new TurnToAngle(chassis, Rotation2d.fromDegrees(180)),
                new RamseteCommand(chassis, Park)

        );

        waitForStart();

        chassis.resetPose(blueWEBottom.getInitialPose());

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
