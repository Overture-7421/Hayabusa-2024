package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Autonomous.EncoderAutonomous;

public class AutonomousCommands {

    private DcMotor right_Drive;
    private DcMotor left_Drive;


    // Constructor to initialize motors
    public AutonomousCommands(DcMotor right_Drive, DcMotor left_Drive) {
        this.right_Drive = right_Drive;
        this.left_Drive = left_Drive;
    }

    public void turnLeft90() {
        // Adjust power and time based on your robot's characteristics
        right_Drive.setPower(0);
        left_Drive.setPower(-0.5);
        // Adjust the sleep time based on experimentation
        sleep(1000);
        stopMotors();
    }

    public void stopMotors() {
        right_Drive.setPower(0);
        left_Drive.setPower(0);
    }

    /*
    public void forward4f() {


            EncoderAutonomous.encoderDrive(0.5, 12, 12, 5.0);


    }


     */

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
