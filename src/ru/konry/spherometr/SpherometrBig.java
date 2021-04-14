package ru.konry.spherometr;

import ru.konry.spherometr.parametrs.SurfaceClearance;
import ru.konry.spherometr.parametrs.SurfaceRadius;
import ru.konry.spherometr.parametrs.SurfaceType;


public class SpherometrBig
{
    public enum SpherBigData {

        RING_1(45.0473, 3.158),
        RING_2(74.9673, 3.159),
        RING_3(109.9832, 3.157),
        RING_4(149.982, 3.160);

        public final double ringRadius;
        public final double ballRadius;
        SpherBigData(double ringRadius, double ballRadius) {
            this.ringRadius = ringRadius;
            this.ballRadius = ballRadius;
        }
    }

    double ringRadius;
    double ballRadius;
    RadiusCalculator radiusCalculator;
    ClearanceCalculator clearanceCalculator;
    SurfaceType type;

    public SpherometrBig(int ringNumber, SurfaceClearance measure, SurfaceType type) {
        initializeSpherometrParametrs(ringNumber);
        this.type = type;
        radiusCalculator = new RadiusCalculator(
                measure.clearance, ringRadius, ballRadius
        );
    }

    public SpherometrBig(int ringNumber, SurfaceRadius measure, SurfaceType type) {
        initializeSpherometrParametrs(ringNumber);
        this.type = type;
        clearanceCalculator = new ClearanceCalculator(
                measure.radius, ringRadius, ballRadius
        );
    }

    public double calculate() {
        double result;
        if(type == SurfaceType.CONCAVE) {
            result = clearanceCalculator.calcConcave();
        } else {
            result = clearanceCalculator.calcConvex();
        }
        return result;
    }

    private void initializeSpherometrParametrs(int ringNumber) {
        SpherBigData sphereType = SpherBigData.values()[ringNumber - 1];
        ringRadius = sphereType.ringRadius;
        ballRadius = sphereType.ballRadius;
    }
}
