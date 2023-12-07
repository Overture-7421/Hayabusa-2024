package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.Autonomous.AutonomousCommands;

@Autonomous
public class Autonomous_One extends LinearOpMode {
    private DcMotor right_Drive;
    private DcMotor left_Drive;
    AutonomousCommands autonomousCommands;

    public void runOpMode() throws InterruptedException {
        right_Drive = hardwareMap.dcMotor.get("right_Drive"); // Replace "right_drive" with your motor name
        left_Drive = hardwareMap.dcMotor.get("left_Drive");   // Replace "left_drive" with your motor name

        autonomousCommands = new AutonomousCommands(right_Drive, left_Drive);

        waitForStart();

            // RED CASE 1- Red spot, team prop in middle spike mark
            autonomousCommands.forward4ft();
            autonomousCommands.stopMotors();
            autonomousCommands.turnLeft90();
    }
}
