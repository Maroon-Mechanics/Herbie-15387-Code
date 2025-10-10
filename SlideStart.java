package sixSeven;


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

@Autonomous(name = "Slide Start")
public class sixSeven extends LinearOpMode {
  
  private DcMotor back_right;
  private DcMotor front_right;
  private DcMotor back_left;
  private DcMotor front_left;
  private VoltageSensor ControlHub_VoltageSensor;
  public void rest() {
    back_left.setPower(0);
    front_right.setPower(0);
    front_left.setPower(0);
    back_right.setPower(0);
  }
  public void move(double wheel1, double wheel2, double wheel3, double wheel4) {
    back_left.setPower(wheel1*10 / ControlHub_VoltageSensor.getVoltage());
    front_right.setPower(wheel2*10 / ControlHub_VoltageSensor.getVoltage());
    front_left.setPower(wheel3*10 / ControlHub_VoltageSensor.getVoltage());
    back_right.setPower(wheel4*10 / ControlHub_VoltageSensor.getVoltage());
  }
  public void ppG() {
    move(-0.5,-0.5,-0.5,-0.5);
    sleep(500);
    rest();
    move(-0.5,0.5,-0.5,0.5);
    sleep(250);
    rest();
    sleep(200);
  }
  public void pGp() {
    move(-0.5,-0.5,-0.5,-0.5);
    sleep(1000);
    rest();
    move(-0.5,0.5,-0.5,0.5);
    sleep(250);
    rest();
    sleep(200);
  }
  public void gPP(){
    move(-0.5,-0.5,-0.5,-0.5);
    sleep(1500);
    rest();
    move(-0.5,0.5,-0.5,0.5);
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
    fire_wheel1 = hardwareMap.get(DcMotor.class, "fire_wheel_left");
    fire_wheel2 = hardwareMap.get(DcMotor.class, "fire_wheel_top");
    fire_wheel3 = hardwareMap.get(DcMotor.class, "fire_wheel_left");
    pickup_wheel1 = hardwareMap.get(DcServo.class, "pickup_wheel_left");
    pickup_wheel2 = hardwareMap.get(DcServo.class, "pickup_wheel_right");
    ControlHub_VoltageSensor = hardwareMap.get(VoltageSensor.class, "Control Hub");
    
    waitForStart();
    back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    move(-0.5,-0.5,-0.5,-0.5);
    sleep(500);
    rest();
    sleep(200);
    move(-0.5,0.5,0.5,-0.5);
    sleep(750);
    rest();
    sleep(200);
    move(0.5,-0.5,-0.5,0.5);
    sleep(500);
    rest();
    sleep(200);
    move(-0.5,0.5,-0.5,0.5);
    sleep(125);
    rest();
    sleep(200);
    move(0.5,0.5,0.5,0.5);
    sleep(200);
    rest();
    sleep(200);
    //put sensor code here "sensorScan();"
    //if (id == 21) {}
    ppG();
