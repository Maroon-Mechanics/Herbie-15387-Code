package SlideStart;


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
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.VoltageSensor;

@Autonomous(name = "Slide Start Red")
public class SlideStartRed extends LinearOpMode {

    public static class Direction {

    }

    Direction Left = new Direction();
    Direction Right = new Direction();


    private DcMotor back_right;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor front_left;
    private DcMotor firing_wheel;
    private VoltageSensor ControlHub_VoltageSensor;

    public void rest() {
        back_left.setPower(0);
        front_right.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
    }

    public void move(double wheel1, double wheel2, double wheel3, double wheel4) {
        back_left.setPower(wheel1 * 10 / ControlHub_VoltageSensor.getVoltage());
        front_right.setPower(-1 * wheel2 * 10 / ControlHub_VoltageSensor.getVoltage());
        front_left.setPower(wheel3 * 10 / ControlHub_VoltageSensor.getVoltage());
        back_right.setPower(wheel4 * 10 / ControlHub_VoltageSensor.getVoltage());
    }

    public void Strafe(double wheel1, double wheel2, double wheel3, double wheel4, Direction direction) {
        if (direction == Left) {
            move(-1 * wheel1, -1 *wheel2, wheel3, wheel4);
        } else if (direction == Right) {
            move(wheel1, wheel2, -1 * wheel3, -1 * wheel4);
        }
    }

    public void Turn(double wheel1, double wheel2, double wheel3, double wheel4, Direction direction) {
        if (direction == Left) {
            move(-1 * wheel1, wheel2, -1 * wheel3, wheel4);
        } else if (direction == Right) {
            move(wheel1, -1 * wheel2, wheel3, -1 * wheel4);
        }
    }

    public void ppG() {
        move(-0.5, -0.5, -0.5, -0.5);
        sleep(500);
        rest();
        move(-0.5, 0.5, -0.5, 0.5);
        sleep(250);
        rest();
        sleep(200);
    }

    public void pGp() {
        move(-0.5, -0.5, -0.5, -0.5);
        sleep(1000);
        rest();
        move(-0.5, 0.5, -0.5, 0.5);
        sleep(250);
        rest();
        sleep(200);
    }

    public void gPP() {
        move(-0.5, -0.5, -0.5, -0.5);
        sleep(1500);
        rest();
        move(-0.5, 0.5, -0.5, 0.5);
        sleep(250);
        rest();
        sleep(200);
    }

    /**
     * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
     * Comment Blocks show where to place Initialization code (runs once, after touching the
     * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
     * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
     * Stopped).
     */
    @Override
    public void runOpMode() {
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        firing_wheel = hardwareMap.get(DcMotor.class, "firing_wheel");
        ControlHub_VoltageSensor = hardwareMap.get(VoltageSensor.class, "Control Hub");

        waitForStart();
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        move(0.8, 0.8, -0.8, -0.8);
        sleep(1200);
        rest();
        sleep(200);
        Turn(0.6, 0.6, 0.6, 0.6, Right);
        sleep(400);
        rest();
        sleep(200);
        for (int i = 0; i <= 3; i++) {
            firing_wheel.setPower(1);
            sleep(500);
            firing_wheel.setPower(0);
            sleep(200);
        }
        sleep(100);
        Turn(0.6, 0.6, 0.6, 0.6, Left);
        sleep(400);
        move(0.8, 0.8, 0.8, 0.8);
        sleep(2200);
        rest();
        sleep(200);
        Strafe(0.6, 0.6, 0.6, 0.6, Right);
        sleep(800);
        rest();
        sleep(1800);
        Strafe(0.6, 0.6, 0.6, 0.6, Left);
        sleep(800);
        rest();
        sleep(200);
        move(0.8, 0.8, 0.8, 0.8);
        sleep(2200);
        rest();
        Turn(0.6, 0.6, 0.6, 0.6, Right);
        sleep(400);
        rest();
        sleep(200);
        for (int i = 0; i <= 3; i++) {
            firing_wheel.setPower(1);
            sleep(500);
            firing_wheel.setPower(0);
            sleep(200);
        }
        sleep(100);
        Strafe(0.5, 0.5, 0.5, 0.5, Right);
        sleep(300);
        rest();
    }
}
