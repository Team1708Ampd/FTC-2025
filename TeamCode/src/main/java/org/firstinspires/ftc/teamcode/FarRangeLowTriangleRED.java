package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="FarRangeLowTriangleRED")
public class FarRangeLowTriangleRED extends LinearOpMode {
    DcMotor TopLeft;
    DcMotor TopRight;
    DcMotor BottomLeft;
    DcMotor BottomRight;
    AnalogInput ranger;
    Servo Light;
    DcMotor upperIntake;
    DcMotor lowerIntake;
    DcMotor leftShooter;
    DcMotor rightShooter;





    @Override
    public void runOpMode() throws InterruptedException
    {
        TopLeft = hardwareMap.get(DcMotor.class,"leftFront");
        TopRight = hardwareMap.get(DcMotor.class, "rightFront");
        BottomLeft = hardwareMap.get(DcMotor.class, "leftBack");
        BottomRight = hardwareMap.get(DcMotor.class, "rightBack");
        TopLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        upperIntake = hardwareMap.get(DcMotor.class, "upperIntake");
        lowerIntake = hardwareMap.get(DcMotor.class,"lowerIntake");
        leftShooter = hardwareMap.get(DcMotor.class,"leftShooter");
        rightShooter = hardwareMap.get(DcMotor.class,"rightShooter");
        leftShooter.setDirection(DcMotorSimple.Direction.REVERSE);



        ranger = hardwareMap.get(AnalogInput.class, "ranger");
        Light = hardwareMap.get(Servo.class, "RGB");
        double Voltage = ((ranger.getVoltage() * 48.7) - 4.9);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();
        while(opModeIsActive()) {

            Light.setPosition(.277);
            leftShooter.setPower(.68);
            rightShooter.setPower(.68);
            sleep(5000); //spool shooter
            upperIntake.setPower(.8);
            lowerIntake.setPower(.8);
            sleep(400); // ball 1 testing shoot times
            upperIntake.setPower(0);
            lowerIntake.setPower(0);
            sleep(1500);
            upperIntake.setPower(.8);
            lowerIntake.setPower(.8);
            sleep(400); // ball 1 testing shoot times
            upperIntake.setPower(0);
            lowerIntake.setPower(0);
            sleep(1500);
            upperIntake.setPower(.8);
            lowerIntake.setPower(.8);
            sleep(950); // ball 1 testing shoot times
            upperIntake.setPower(0);
            lowerIntake.setPower(0);
            sleep(500);

            leftShooter.setPower(0);
            rightShooter.setPower(0);

            drive(0.5);
            lowerIntake.setPower(1);
            upperIntake.setPower(1);
            sleep(500);
            drive(0);
            sleep(250);
            turn("right", 0.5);
            sleep(400); //375/400
            drive(-0.5);
            sleep(250); //test
            drive(0);
            sleep(100);
            drive(0.5);
            while((ranger.getVoltage()*48.7)-4.9 > 3) {
                //keep intake on
            }
            upperIntake.setPower(0);
            leftShooter.setPower(0.68);
            rightShooter.setPower(0.68);
            sleep(400);
            drive(0);
            lowerIntake.setPower(0);
            sleep(150);
            drive(-0.5);
            sleep(900);
            drive(0);
            turn("left", 0.5);
            sleep(600);
            drive(-0.5);
            sleep(1050);
            drive(0);
            sleep(1000);
            upperIntake.setPower(1);
            sleep(500);
            upperIntake.setPower(0);
            sleep(1000);
            upperIntake.setPower(1);
            sleep(500); //testing
            upperIntake.setPower(0);
            lowerIntake.setPower(0);
            leftShooter.setPower(0);
            rightShooter.setPower(0);
            drive(0);
        }}

    public void drive(double speed) {
        TopLeft.setPower(speed);
        TopRight.setPower(speed);
        BottomRight.setPower(speed);
        BottomLeft.setPower(speed);
    }

    public void turn(String direction, double speed) {
        if(direction.equals("right")) {
            TopLeft.setPower(speed);
            BottomLeft.setPower(speed);
            TopRight.setPower(-speed);
            BottomRight.setPower(-speed);
        } else {
            TopLeft.setPower(-speed);
            BottomLeft.setPower(-speed);
            TopRight.setPower(speed);
            BottomRight.setPower(speed);
        }
    }

}

