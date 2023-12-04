package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.Autonomous.AutonomousCommands;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

@Autonomous
public class Autonomous_One extends LinearOpMode {
    private DcMotor right_Drive;
    private DcMotor left_Drive;

    AutonomousCommands autonomousCommands;





    @Override
    public void runOpMode() throws InterruptedException {
        right_Drive = hardwareMap.get(DcMotor.class, "right_Drive");
        left_Drive = hardwareMap.get(DcMotor.class, "left_Drive");

        autonomousCommands = new AutonomousCommands();
        waitForStart();


        // Red case 1, red spot, team prop in middle spike mark
            //Detectar en donde está el team prop (en este caso en el spike mark del centro)

            autonomousCommands.turnLeft90();

        /* backward1FT();
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
            fullStop(); //Se estaciona y se apaga */


        //Red case 2
        //Team prop en spike mark derecho

        //Detectar ubicacion de team prop en la derecha






    }


}
