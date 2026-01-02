package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.AnalogInput;


@TeleOp(name = "DriveCode")
    public class DriveCode extends LinearOpMode {
        DcMotor TopLeft;
        DcMotor TopRight;
        DcMotor BottomLeft;
        DcMotor BottomRight;
        DcMotor upperIntake;
        DcMotor lowerIntake;
        DcMotor leftShooter;
        DcMotor rightShooter;
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


            upperIntake = hardwareMap.get(DcMotor.class, "upperIntake");
            lowerIntake = hardwareMap.get(DcMotor.class,"lowerIntake");
            leftShooter = hardwareMap.get(DcMotor.class,"leftShooter");
            rightShooter = hardwareMap.get(DcMotor.class,"rightShooter");
            leftShooter.setDirection(DcMotorSimple.Direction.REVERSE);



            ranger = hardwareMap.get(AnalogInput.class, "ranger");
            Light = hardwareMap.get(Servo.class, "RGB");
            double Voltage = ((ranger.getVoltage() * 48.7) - 4.9);

            waitForStart();
            while (
                    opModeIsActive())
             {
                if(gamepad1.a){
                    lowerIntake.setDirection(DcMotorSimple.Direction.FORWARD);
                    lowerIntake.setPower(1);


                }else if(gamepad1.right_bumper){
                    lowerIntake.setDirection(DcMotorSimple.Direction.REVERSE);
                    lowerIntake.setPower(1);
                }
                else{
                    lowerIntake.setPower(0);

                }

                if(gamepad1.y /*&& Voltage<7*/){ //"beam break" stop
                    lowerIntake.setPower(1);
                    upperIntake.setPower(1);
                    Light.setPosition(0.333);
                } else {
                    upperIntake.setPower(0);
                }
                 if(gamepad2.y){ //Copilot Shooter 75%
                     leftShooter.setPower(.75);
                     rightShooter.setPower(.75);
                 } else {
                     leftShooter.setPower(0);
                     rightShooter.setPower(0);
                 }
                 if(gamepad2.a){ //Copilot Shooter 50%
                     leftShooter.setPower(.5);
                     rightShooter.setPower(.5);
                 } else {
                     leftShooter.setPower(0);
                     rightShooter.setPower(0);
                 }

                 if(gamepad2.right_bumper && leftShooter.getPowerFloat() && rightShooter.getPowerFloat()) {
                     Light.setPosition(.555);
                     upperIntake.setPower(1);
                     lowerIntake.setPower(1);
                 }


                     // send the info back to driver station using telemetry function.
                     telemetry.addData("Raw Voltage", ranger.getVoltage());

                 //telemetry.addData("Inch 15DEG 0-1 Mode: ", (ranger.getVoltage()*32.5)-2.6);
                 telemetry.addData("Inch 20DEG 0-0 Mode: ", (ranger.getVoltage()*48.7)-4.9);
                 //telemetry.addData("Inch 27DEG 1-0 Mode: ", (ranger.getVoltage()*78.1)-10.2);


                 telemetry.update();

                 double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
                 double x = gamepad1.left_stick_x * 1.1; // test Counteract imperfect strafing
                 double rx = -gamepad1.right_stick_x; //testing neg value to fix turning

                 double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
                 double frontLeftPower = (y + x + rx) / denominator;
                 double backLeftPower = (y - x + rx) / denominator;
                 double frontRightPower = (y - x - rx) / denominator;
                 double backRightPower = (y + x - rx) / denominator;

                 double max = Math.abs(frontLeftPower);
                 if (Math.abs(backLeftPower) > max) max = Math.abs(backLeftPower);
                 if (Math.abs(frontRightPower) > max) max = Math.abs(frontRightPower);
                 if (Math.abs(backRightPower) > max) max = Math.abs(backRightPower);

                 if (max > 1.0) {
                     frontLeftPower /= max;
                     backLeftPower /= max;
                     frontRightPower /= max;
                     backRightPower /= max;
                 }


                 TopLeft.setPower(frontLeftPower);
                 TopRight.setPower(backLeftPower);
                 BottomLeft.setPower(frontRightPower);
                 BottomRight.setPower(backRightPower);
                 Light.setPosition(0.333);

                }
            {



                

        {




    }}}}



