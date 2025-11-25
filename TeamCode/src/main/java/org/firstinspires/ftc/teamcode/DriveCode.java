package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;


    @TeleOp(name = "DriveCode")
    public class DriveCode extends LinearOpMode {
        DcMotor TopLeft;
        DcMotor TopRight;
        DcMotor BottomLeft;
        DcMotor BottomRight;
        DcMotor IntakeMotor;
        DcMotor LeftOuttake;
        DcMotor RightOuttake;
        DcMotor Climber;
        AnalogInput ranger;
        Servo Light;

        @Override
        public void runOpMode() throws InterruptedException {
            TopLeft = hardwareMap.get(DcMotor.class,"leftFront");
            TopRight = hardwareMap.get(DcMotor.class, "rightFront");
            BottomLeft = hardwareMap.get(DcMotor.class, "leftBack");
            BottomRight = hardwareMap.get(DcMotor.class, "rightBack");
            TopLeft.setDirection(DcMotorSimple.Direction.REVERSE);
            BottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);

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

            waitForStart();
            while (
                    opModeIsActive())
             {
                if(gamepad1.a){
                    IntakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                    IntakeMotor.setPower(0.75);

                }else if(gamepad1.right_bumper){
                    IntakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                    IntakeMotor.setPower(0.75);
                }
                else{IntakeMotor.setPower(0);
                }

                if(gamepad1.y){
                    LeftOuttake.setPower(1);
                    RightOuttake.setPower(1);
                } else if (gamepad1.x) {
                    LeftOuttake.setPower(-0.75);
                    RightOuttake.setPower(-0.75);
                } else {
                    LeftOuttake.setPower(0);
                    RightOuttake.setPower(0);
                }

                 // send the info back to driver station using telemetry function.
                 telemetry.addData("Raw Voltage",    ranger.getVoltage());
                 //telemetry.addData("Inch 15DEG 0-1 Mode: ", (ranger.getVoltage()*32.5)-2.6);
                 telemetry.addData("Inch 20DEG 0-0 Mode: ", (ranger.getVoltage()*48.7)-4.9);
                 //telemetry.addData("Inch 27DEG 1-0 Mode: ", (ranger.getVoltage()*78.1)-10.2);


                 telemetry.update();

                 double y = -gamepad1.left_stick_y;
                 double x = gamepad1.right_stick_x * 1.1;
                 double rx = gamepad1.left_stick_x;

                 double denominator = Math.max(Math.abs(y)+Math.abs(x)+Math.abs(rx),1);
                 double frontLeftPower = (y+x+rx)/denominator;
                 double backLeftPower = (y-x+rx)/denominator;
                 double frontRightPower = (y-x-rx)/denominator;
                 double backRightPower = (y+x-rx)/denominator;
                 TopLeft.setPower(frontLeftPower);
                 TopRight.setPower(frontRightPower);
                 BottomLeft.setPower(backLeftPower);
                 BottomRight.setPower(backRightPower);
                 Light.setPosition(0.333);

                }
            {



                

        {




    }}}}



