package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="BlueC1Edge")
public class BlueC1Edge extends LinearOpMode {
    DcMotor TopLeft;
    DcMotor TopRight;
    DcMotor BottomLeft;
    DcMotor BottomRight;
    AnalogInput ranger;
    Servo Light;
    DcMotor IntakeMotor;
    DcMotor LeftOuttake;
    DcMotor RightOuttake;
    DcMotor Climber;




    @Override
    public void runOpMode() throws InterruptedException
    {
        TopLeft = hardwareMap.get(DcMotor.class, "leftFront");
        TopRight = hardwareMap.get(DcMotor.class, "rightFront");
        BottomLeft = hardwareMap.get(DcMotor.class, "leftBack");
        BottomRight = hardwareMap.get(DcMotor.class, "rightBack");
        TopLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        TopLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        TopRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BottomLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BottomRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        IntakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        LeftOuttake = hardwareMap.get(DcMotor.class,"leftOuttake");
        RightOuttake = hardwareMap.get(DcMotor.class,"rightOuttake");
        Climber = hardwareMap.get(DcMotor.class,"climber");
        IntakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftOuttake.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftOuttake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightOuttake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



        ranger = hardwareMap.get(AnalogInput.class, "ranger");
        Light = hardwareMap.get(Servo.class, "RGB");


        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();
        while(opModeIsActive()) {
            double Voltage = ((ranger.getVoltage() * 48.7) - 4.9);
            LeftOuttake.setPower(0);
            RightOuttake.setPower(0);
            LeftOuttake.setPower(-1);
            RightOuttake.setPower(-1);
            sleep(250);

            LeftOuttake.setPower(-0.25);
            RightOuttake.setPower(-0.25);

            TopLeft.setPower(0.8);
            TopRight.setPower(0.7);
            BottomLeft.setPower(0.8);
            BottomRight.setPower(0.7);
            Light.setPosition(1.0);
            //lowerIntake.setPower(-1.0);
            //leftShooter.setPower(-1.0);
            sleep(1050); //forward

            TopLeft.setPower(-0.536);
            TopRight.setPower(0.469);
            sleep(625);

            TopLeft.setPower(0.8);
            TopRight.setPower(0.7);
            BottomLeft.setPower(0.8);
            BottomRight.setPower(0.7);
            sleep(410); //test value

            LeftOuttake.setPower(1.0);
            RightOuttake.setPower(1.0);
            sleep(250);

            TopLeft.setPower(0);
            TopRight.setPower(0);
            BottomLeft.setPower(0);
            BottomRight.setPower(0);
            LeftOuttake.setPower(0);
            RightOuttake.setPower(0);
            sleep(9999999);

//            TopLeft.setPower(0.5);
//            TopRight.setPower(-0.5);
//            BottomLeft.setPower(0.5);
//            BottomRight.setPower(-0.5);
//            Light.setPosition(1.0);
//            sleep(200);

//            upperIntake.setPower(0.75);
//            TopLeft.setPower(0.5);
//            TopRight.setPower(0.5);
//            BottomLeft.setPower(0.5);
//            BottomRight.setPower(0.5);
//            Light.setPosition(0.333);
//            sleep(200);




//                TopLeft.setPower(0.5);
//                TopRight.setPower(-0.5);
//                BottomLeft.setPower(0.5);
//                BottomRight.setPower(-0.5);
//                sleep(250); //spin around
//
//                TopLeft.setPower(0);
//                TopRight.setPower(0);
//                BottomLeft.setPower(0);
//                BottomRight.setPower(0);
//                sleep(250); //shoot

//                TopLeft.setPower(0.5);
//                TopRight.setPower(-0.5);
//                BottomLeft.setPower(0.5);
//                BottomRight.setPower(-0.5);
//                sleep(1000); //180 degree turn

//                TopLeft.setPower(0.5);
//                TopRight.setPower(0.5);
//                BottomLeft.setPower(0.5);
//                BottomRight.setPower(0.5);
//                sleep(800); //forward
            }


        }



//
//        TopLeft.setPower(0);
//        TopRight.setPower(0);
//        BottomLeft.setPower(0);
//        BottomRight.setPower(0);
//
//        sleep(500); //shoot time
//
//        TopLeft.setPower(0.5);
//        TopRight.setPower(0.5);
//        BottomLeft.setPower(0.5);
//        BottomRight.setPower(0.5);
//
//        sleep(800);
//
//        TopLeft.setPower(-0.5);
//        TopRight.setPower(0.5);
//        BottomLeft.setPower(0.5);
//        BottomRight.setPower(-0.5);
//
//        sleep(500); //slide to the (relative) left



//        TopLeft.setPower(0);
//        TopRight.setPower(0);
//        BottomLeft.setPower(0);
//        BottomRight.setPower(0.5);
//        sleep(4500);// backRight pivot

//        TopLeft.setPower(0.5);
//        TopRight.setPower(0.5);
//        BottomLeft.setPower(0.5);
//        BottomRight.setPower(0.5);
//        sleep(700); // Unintentional Gate Open

        /*TopLeft.setPower(0.5);
        TopRight.setPower(0.25);
        BottomLeft.setPower(0.5);
        BottomRight.setPower(0.25);

        sleep(2500);*/ //Tokyo Drifting

        /*TopLeft.setPower(0.5);
        TopRight.setPower(0.5);
        BottomLeft.setPower(0.5);
        BottomRight.setPower(0.5);

        sleep(2000)*/ //straight forward
    }

