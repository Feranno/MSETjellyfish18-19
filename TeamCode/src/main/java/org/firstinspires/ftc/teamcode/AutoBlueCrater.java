package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Feranno on 9/29/18.
 */
@Autonomous(name = "AutoBlueCrater")
public class AutoBlueCrater extends LinearOpMode {

    Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(this);
        robot.driveBase.composeTelemetry();
        robot.markerDispenser.setPosition(0.55);


        waitForStart();
        robot.driveBase.setHeadingToZero();

        //Start Auto
        //extend lift
        robot.Lift.ExtendingLift();

        //turn to prep position after extending lift
        robot.driveBase.VectorDistance(0.5, 500, 180);
        robot.driveBase.VectorDistance(1, 200, 270);
        robot.driveBase.VectorDistance(1, 300, 90);
        robot.driveBase.gyroToGo(320);

        //drive to the marker depot
        robot.driveBase.VectorDistance(1, 1500, 180);
        robot.driveBase.gyroToGo(0);
        robot.driveBase.VectorDistance(1, 3100, 180);
        robot.driveBase.gyroToGo(40);
        robot.driveBase.VectorDistance(1, 2800, 180);

        //dispense marker and drive to crater
        robot.driveBase.gyroToGo(0, 15, 0.5);
        robot.markerDispenser.setPosition(0);
        sleep(500);
        robot.driveBase.gyroToGo(40, 15, 0.5);
        robot.markerDispenser.setPosition(0.55);
        sleep(500);
        robot.driveBase.VectorDistance(1, 7600, 0);
        robot.Lift.DetractLift();

    }

}
