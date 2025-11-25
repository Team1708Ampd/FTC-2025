package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="ChaChaSlide")
public class ChaChaSlide extends LinearOpMode {
    DcMotor TopLeft;
    DcMotor TopRight;
    DcMotor BottomLeft;
    DcMotor BottomRight;

    @Override
    public void runOpMode() throws InterruptedException {
        TopLeft = hardwareMap.get(DcMotor.class, "leftFront");
        TopRight = hardwareMap.get(DcMotor.class, "rightFront");
        BottomLeft = hardwareMap.get(DcMotor.class, "leftBack");
        BottomRight = hardwareMap.get(DcMotor.class, "rightBack");
        BottomRight.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();


        TopLeft.setPower(-0.5);
        TopRight.setPower(0.5);
        BottomLeft.setPower(0.5);
        BottomRight.setPower(-0.5);

        sleep(3000); //slide to the left

        TopLeft.setPower(0.5);
        TopRight.setPower(-0.5);
        BottomLeft.setPower(-0.5);
        BottomRight.setPower(0.5);

        sleep(3000); //slide to the right

        TopLeft.setPower(-0.5);
        TopRight.setPower(0.5);
        BottomLeft.setPower(-0.5);
        BottomRight.setPower(0.5);

        sleep(300); //right? stomp

        TopLeft.setPower(0.5);
        TopRight.setPower(-0.5);
        BottomLeft.setPower(0.5);
        BottomRight.setPower(-0.5);

        sleep(300); //left stomp

//        TopLeft.setPower(0.5);
//        TopRight.setPower(0.5);
//        BottomLeft.setPower(0.5);
//        BottomRight.setPower(0.5);
//
//        sleep(3000); //right? stomp
        TopLeft.setPower(0);
        TopRight.setPower(0);
        BottomLeft.setPower(0);
        BottomRight.setPower(0);

    }}