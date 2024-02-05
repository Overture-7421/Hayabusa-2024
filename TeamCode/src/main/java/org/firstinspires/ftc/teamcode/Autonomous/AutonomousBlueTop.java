package org.firstinspires.ftc.teamcode.Autonomous;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.arcrobotics.ftclib.trajectory.TrajectoryConfig;
import com.arcrobotics.ftclib.trajectory.TrajectoryGenerator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonomousCommands.BandAndIntake;
import org.firstinspires.ftc.teamcode.AutonomousCommands.SpitPixels;
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
public class  AutonomousBlueTop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        CommandScheduler.getInstance().cancelAll();
        CommandScheduler.getInstance().reset();

        Chassis chassis = new Chassis(hardwareMap);
        Band band = new Band(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        Claw claw = new Claw(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        Elevator elevator = new Elevator(hardwareMap);

        Trajectory blueTop = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0,0,Rotation2d.fromDegrees(0)),
                        new Pose2d(0.8,0,Rotation2d.fromDegrees(0)),
                        new Pose2d(1.4,0.88,Rotation2d.fromDegrees(90))),

                        new TrajectoryConfig(0.8, 0.8));

        Trajectory pickUpPixels = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(1.4,0.88, Rotation2d.fromDegrees(-90)),
                        new Pose2d(0.55,-0.6,Rotation2d.fromDegrees(-90)),
                        new Pose2d(0.50 ,-2, Rotation2d.fromDegrees(-90))),

                new TrajectoryConfig(0.8,0.8));

        Trajectory returnToParking = TrajectoryGenerator.generateTrajectory(Arrays.asList(
                        new Pose2d(0.42 ,-2.3, Rotation2d.fromDegrees(90)),
                        new Pose2d(0.5,1, Rotation2d.fromDegrees(90)),
                        new Pose2d(1,0.5, Rotation2d.fromDegrees(90))),
                        //new Pose2d(1.4,1, Rotation2d.fromDegrees(0)),
                        //new Pose2d(1.4,0.8995,Rotation2d.fromDegrees(90))),
                new TrajectoryConfig(0.8,0.8));

        SequentialCommandGroup testCommandGroup = new SequentialCommandGroup(
                        new RamseteCommand(chassis, blueTop),
                        new SpitPixels(band, intake).withTimeout(4500)
                        /*new TurnToAngle(chassis, Rotation2d.fromDegrees(-90)),
                        new RamseteCommand(chassis, pickUpPixels),
                        new BandAndIntake(band, intake).withTimeout(4500),
                        new TurnToAngle(chassis, Rotation2d.fromDegrees(90)),
                        new RamseteCommand(chassis, returnToParking)*/
        );

        waitForStart();

        chassis.resetPose(blueTop.getInitialPose());

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
