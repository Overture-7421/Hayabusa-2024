package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;


@TeleOp
public class MainSystem extends LinearOpMode {

    Chassis chassis = new Obj;
    Elevator elevator = new Obj;

    @Override
    public static void Main() {
        waitForStart();
            chassis.chassisLoop();
            elevator.elevatorLoop();
            telemetry.addData("Status", "Go");
    }
}
