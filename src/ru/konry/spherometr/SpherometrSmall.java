package ru.konry.spherometr;

import ru.konry.spherometr.parametrs.SurfaceClearance;
import ru.konry.spherometr.parametrs.SurfaceRadius;
import ru.konry.spherometr.parametrs.SurfaceType;

public class SpherometrSmall
{
    public enum SpherSmallData {

        RING_1(59.9797, 4.725),
        RING_2(42.504, 5.15),
        RING_3(29.964, 4.345),
        RING_4(21.2656, 3.153),
        RING_5(15.0073, 2.375),
        RING_7(7.477, 1.17);

        public final double ringRadius;
        public final double ballRadius;

        SpherSmallData(double ringRadius, double ballRadius) {
            this.ringRadius = ringRadius;
            this.ballRadius = ballRadius;
        }
    }

    double ringRadius;
    double ballRadius;
    RadiusCalculator radiusCalculator;
    ClearanceCalculator clearanceCalculator;
    SurfaceType type;

    public SpherometrSmall(int ringNumber, SurfaceClearance measure, SurfaceType type) {
        SpherSmallData sphereType = SpherSmallData.values()[ringNumber - 1];
        ringRadius = sphereType.ringRadius;
        ballRadius = sphereType.ballRadius;
        this.type = type;
        radiusCalculator = new RadiusCalculator(
                measure.clearance, ringRadius, ballRadius
        );
    }

    public SpherometrSmall(int ringNumber, SurfaceRadius measure, SurfaceType type) {
        SpherSmallData sphereType = SpherSmallData.values()[ringNumber - 1];
        ringRadius = sphereType.ringRadius;
        ballRadius = sphereType.ballRadius;
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
}
