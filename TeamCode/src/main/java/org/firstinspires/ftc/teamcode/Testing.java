package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

@Autonomous(name="Testing")
public class Testing extends LinearOpMode {
    DcMotor TopLeft;
    DcMotor TopRight;
    DcMotor BottomLeft;
    DcMotor BottomRight;
    AnalogInput ranger;
    Servo Light;


    @Override
    public void runOpMode() throws InterruptedException
    {
        TopLeft = hardwareMap.get(DcMotor.class, "leftFront");
        TopRight = hardwareMap.get(DcMotor.class, "rightFront");
        BottomLeft = hardwareMap.get(DcMotor.class, "leftBack");
        BottomRight = hardwareMap.get(DcMotor.class, "rightBack");
        TopLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        Light = hardwareMap.get(Servo.class, "RGB");


        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();
        telemetry.addData("Mode", "running");
        telemetry.update();
        double Voltage = ((ranger.getVoltage() * 48.7) - 4.9);

        if(Voltage >= 20) {
            TopLeft.setPower(0.5);
            TopRight.setPower(0.5);
            BottomLeft.setPower(0.5);
            BottomRight.setPower(0.5);
            Light.setPosition(0.500);
            sleep(5000);


        } else {
            Light.setPosition(0.277);

            TopLeft.setPower(0);
            TopRight.setPower(0);
            BottomLeft.setPower(0);
            BottomRight.setPower(0);
            sleep(250);
//        TopLeft.setPower(0.5);
//        TopRight.setPower(0.5);
//        BottomLeft.setPower(0.5);
//        BottomRight.setPower(0.5);
//        Light.setPosition(0.333);
//        sleep(10000);
                }}}