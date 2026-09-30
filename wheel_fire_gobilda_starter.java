package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name="Fair Demo")
public class Fair extends LinearOpMode {

    // todo: write your code here

    public static class Direction {

    }

    Direction Left = new Direction();
    Direction Right = new Direction();
    Direction Forward = new Direction();
    Direction Backward = new Direction();

    private DcMotor back_right;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor front_left;
    private DcMotor firing_motor;
    private Servo left_wheel;
    private Servo right_wheel;
    private DcMotor intake_motor;
    private VoltageSensor ControlHub_VoltageSensor;

    public void rest() {
        back_left.setPower(0);
        front_right.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
    }

    public void move(double wheel1, double wheel2, double wheel3, double wheel4) {
        back_left.setPower(wheel1 * 10 / ControlHub_VoltageSensor.getVoltage());
        front_right.setPower(wheel2 * 10 / ControlHub_VoltageSensor.getVoltage());
        front_left.setPower(wheel3 * 10 / ControlHub_VoltageSensor.getVoltage());
        back_right.setPower(wheel4 * 10 / ControlHub_VoltageSensor.getVoltage());
    }

    public void Move(Direction direction) {
        if (direction == Forward) {
            move(0.6, 0.586, -0.6, -0.586);
        } else if (direction == Backward) {
            move(-0.6, -0.586, 0.6, 0.586);
        }
    }

    public void Strafe(Direction direction) {
        if (direction == Left) {
            move(0.6, 0.54, 0.6, 0.54);
        } else if (direction == Right) {
            move(-0.6, -0.6, -0.6, -0.6);
        }
    }

    public void Turn(Direction direction) {
        if (direction == Left) {
            move(0.3, -0.3, -0.3, 0.3);
        } else if (direction == Right) {
            move(-0.1, 0.1, 0.1, -0.1);
        }
    }
    
    public void Load() {
        //left_wheel.setPower(-1);
        //right_wheel.setPower(1);
        intake_motor.setPower(1);
    }
  
    public void FixMain() {
        firing_motor.setPower(-0.67);
    } 
  
    public void FixSide() {
        //gate_left.setPosition(0);
        //gate_right.setPosition(0);
    }
  
    public void KillFire() {
        //firing_wheel.setPower(0);
    }
    
    public void fire() {
        //firing_wheel.setPower(0.74 / 14 * ControlHub_VoltageSensor.getVoltage());
    }


    /**
     * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
     * Comment Blocks show where to place Initialization code (runs once, after touching the
     * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
     * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
     * Stopped).
     */
    public void runOpMode() {
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        firing_motor = hardwareMap.get(DcMotor.class, "firing_wheel");
        left_wheel = hardwareMap.get(Servo.class, "gate_left");
        right_wheel = hardwareMap.get(Servo.class, "gate_right");
        ControlHub_VoltageSensor = hardwareMap.get(VoltageSensor.class, "Control Hub");

        waitForStart();
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        firing_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_wheel.setDirection(Servo.Direction.REVERSE);
        
        Turn(Left);
        sleep(15000);
        rest();
    }
}
