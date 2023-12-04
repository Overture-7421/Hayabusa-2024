package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;

@Autonomous
public class Autonomous_One extends LinearOpMode{
    private DcMotor right_Drive;
    private DcMotor left_Drive;

    void turnRight90() {
        right_Drive.setPower(0.5);
        left_Drive.setPower(-0.5);
        sleep(625);
    }

    void turnLeft90() {
        right_Drive.setPower(-0.5);
        left_Drive.setPower(0.5);
        sleep(625);
    }

    void turn180() {
        right_Drive.setPower(-0.5);
        left_Drive.setPower(0.5);
        sleep(1313);
    }

    void forward2FT() {
        right_Drive.setPower(1);
        left_Drive.setPower(1);
        sleep(245);
    }

    void forward1FT() {
        right_Drive.setPower(1);
        left_Drive.setPower(1);
        sleep((long) 122.5);
    }

    void forwardHalfFT() {
        right_Drive.setPower(1);
        left_Drive.setPower(1);
        sleep((long) 183.75);
    }

    void backwardHalfFT() {
        right_Drive.setPower(-1);
        left_Drive.setPower(-1);
        sleep((long) 183.75);
    }

    void backward1FT() {
        right_Drive.setPower(-1);
        left_Drive.setPower(-1);
        sleep((long)122.5);
    }

    void slow2FTForward() {
        right_Drive.setPower(0.5);
        left_Drive.setPower(0.5);
        sleep(490);
    }

    void fullStop() {
        right_Drive.setPower(0);
        left_Drive.setPower(0);
        sleep(1000);
    }


    @Override
    public void runOpMode() {
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");
        left_Drive.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        // Red case 1, red spot, team prop in middle spike mark
            //Detectar en donde está el team prop (en este caso en el spike mark del centro)
            backward1FT();
            backward1FT();
            fullStop();
            sleep(1000); // Expulsa un pixel
            forward2FT(); // Se aleja
            turnLeft90(); // Voltea a ver el backdrop
            fullStop(); //Detecta que april tag usar para poner el pixel que queda
            // forwardHalfFT();
            slow2FTForward(); //Llega al backdrop
            fullStop();
            sleep(2000); //Pone pixel en backdrop
            backward1FT(); // Se retira del backdrop
            turnRight90();
            forward1FT(); //Se aleja hacia la derecha
            turnLeft90();
            forwardHalfFT(); // Llega al backstage
            fullStop(); //Se estaciona y se apaga


        //Red case 2
        //Team prop en spike mark derecho

        //Detectar ubicacion de team prop en la derecha






    }


}
