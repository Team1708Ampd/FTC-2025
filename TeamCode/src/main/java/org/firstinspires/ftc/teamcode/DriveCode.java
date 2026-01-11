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
            while (opModeIsActive()) {
                double drive  = -gamepad1.left_stick_y;
                double strafe = gamepad1.left_stick_x;
                double turn  = gamepad1.right_stick_x;

                double[] speeds = {
                        (drive + strafe + turn),
                        (drive - strafe - turn),
                        (drive - strafe + turn),
                        (drive + strafe - turn)
                };

                double max = Math.abs(speeds[0]);
                for (double speed : speeds) {
                    if (max < Math.abs(speed)) max = Math.abs(speed);
                }

                if (max > 1) {
                    for (int i = 0; i < speeds.length; i++) speeds[i] /= max;
                }

                // apply the calculated values to the motors.
                TopLeft.setPower(speeds[0]);
                TopRight.setPower(speeds[1]);
                BottomLeft.setPower(speeds[2]);
                BottomRight.setPower(speeds[3]);

                if(gamepad1.left_bumper) /*a, HUNTER*/ {
                    lowerIntake.setPower(1);
                }else if(gamepad1.x){
                    lowerIntake.setPower(-1);
                    upperIntake.setPower(-1);
                }
                else{
                    lowerIntake.setPower(0);
                    upperIntake.setPower(0);
                }

                if(gamepad1.right_bumper /*b, HUNTER*/ && ((ranger.getVoltage()*48.7)-4.9) > 3){ //"beam break" stop
                    lowerIntake.setPower(1);
                    upperIntake.setPower(1);
                    Light.setPosition(0.333);
                } else {
                    upperIntake.setPower(0);
                }
                if(gamepad2.y){ //Copilot Shooter 70% *Testing
                    leftShooter.setPower(.7);
                    rightShooter.setPower(.7);
                } else if(gamepad2.a) { //Copilot Shooter 65% testing
                    leftShooter.setPower(.65);
                    rightShooter.setPower(.65);
                }
                    else if(gamepad2.x){ //Copilot Shooter 55% testing
                    leftShooter.setPower(.55);
                    rightShooter.setPower(.55);
                } else {
                    leftShooter.setPower(0);
                    rightShooter.setPower(0);
                }

                if(gamepad2.right_bumper) {
                    upperIntake.setPower(1);
                    lowerIntake.setPower(1);
                } else {
                    upperIntake.setPower(0);
                    lowerIntake.setPower(0);
                }

                if (upperIntake.getPower() > 0 && leftShooter.getPower() > 0) {
                    Light.setPosition(.555);
                }

                 // send the info back to driver station using telemetry function.
                telemetry.addData("Raw Voltage", ranger.getVoltage());

                 //telemetry.addData("Inch 15DEG 0-1 Mode: ", (ranger.getVoltage()*32.5)-2.6);
                 telemetry.addData("Inch 20DEG 0-0 Mode: ", (ranger.getVoltage()*48.7)-4.9);
                 //telemetry.addData("Inch 27DEG 1-0 Mode: ", (ranger.getVoltage()*78.1)-10.2);
                telemetry.update();
            }
        }
}



