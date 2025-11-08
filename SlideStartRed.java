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
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Slide Start Red")
public class SlideStartRed extends LinearOpMode {

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
    private DcMotor firing_wheel;
    private CRServo loading_wheel_left;
    private CRServo loading_wheel_right;
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
            move(-0.6, -0.6, 0.6, 0.6);
        } else if (direction == Backward) {
            move(0.6, 0.616, -0.6, -0.616);
        }
    }

    public void Strafe(Direction direction) {
        if (direction == Left) {
            move(-0.6, -0.54, -0.6, -0.54);
        } else if (direction == Right) {
            move(0.6, 0.6, 0.6, 0.6);
        }
    }

    public void Turn(Direction direction) {
        if (direction == Left) {
            move(0.4, -0.4, -0.4, 0.4);
        } else if (direction == Right) {
            move(-0.4, 0.4, 0.4, -0.4);
        }
    }
    
    public void Fire() {
        loading_wheel_left.setPower(0.5);
        loading_wheel_right.setPower(0.5);
        firing_wheel.setPower(1.00);
        sleep(1500);
        firing_wheel.setPower(0);
        loading_wheel_left.setPower(0);
        loading_wheel_right.setPower(0);
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
        loading_wheel_left = hardwareMap.get(CRServo.class, "loading_wheel_left");
        loading_wheel_right = hardwareMap.get(CRServo.class, "loading_wheel_right");
        ControlHub_VoltageSensor = hardwareMap.get(VoltageSensor.class, "Control Hub");

        waitForStart();
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Move(Backward);
        sleep(1000);
        rest();
        sleep(400);
        Turn(Right);
        sleep(650);
        rest();
        sleep(300);
        /*for (int i = 0; i <= 3; i++) {
            firing_wheel.setPower(1);
            sleep(500);
            firing_wheel.setPower(0);
            sleep(200);
        }*/
        sleep(100);
        Turn(Left);
        sleep(480);
        Move(Backward);
        sleep(2050);
        rest();
        sleep(400);
        Strafe(Left);
        sleep(2900);
        rest();
        sleep(300);
        Move(Backward);
        sleep(500);
        rest();
        sleep(300);
        Strafe(Left);
        sleep(1400);
        rest();
        sleep(3000);
        Strafe(Right);
        sleep(1100);
        Move(Forward);
        sleep(600);
        rest();
        sleep(300);
        Strafe(Right);
        sleep(2500);
        rest();
        sleep(200);
        Move(Forward);
        sleep(2050);
        rest();
        Turn(Right);
        sleep(400);
        rest();
        sleep(200);
        /*for (int i = 0; i <= 3; i++) {
            firing_wheel.setPower(1);
            sleep(500);
            firing_wheel.setPower(0);
            sleep(200);
        }*/
        sleep(100);
        Strafe(Right);
        sleep(600);
        rest();
    }
}

