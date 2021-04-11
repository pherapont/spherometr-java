package ru.konry.spherometr;

import ru.konry.spherometr.parametrs.*;

public class Calculator {

	private final double ringRadius;
	private final double ballRadius;

	public Calculator(SpherSmallData ssd) {
		this.ringRadius = ssd.ringRadius;
		this.ballRadius = ssd.ballRadius;
	}

	public Calculator(SpherBigData sbd) {
		this.ringRadius = sbd.ringRadius;
		this.ballRadius = sbd.ballRadius;
	}

	public SurfaceRadius calcConvex(SurfaceClearance sc) {
		double term_1 = ringRadius * ringRadius / sc.clearance;
		double term_2 = sc.clearance / 2;
		double res = term_1 + term_2 - ballRadius;
		return new SurfaceRadius(res);
	}

	public SurfaceClearance calcConvex(SurfaceRadius sr) {
		double tmpSum = sr.radius + ballRadius;
		double rootExp = tmpSum * tmpSum - ringRadius * ringRadius;
		double res = tmpSum - Math.sqrt(rootExp);
		return new SurfaceClearance(res);
	}

	public double calcConcave(SurfaceClearance sc) {
		double term_1 = ringRadius * ringRadius / sc.clearance;
		double term_2 = sc.clearance / 2;
		double res = term_1 + term_2 + ballRadius;
		return res;
	}

	public double calcConcave(SurfaceRadius sr) {
		double tmpDif = sr.radius - ballRadius;
		double rootExp = tmpDif * tmpDif - ringRadius * ringRadius;
		double res = tmpDif - Math.sqrt(rootExp);
		return res;
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator(SpherBigData.RING_1);
		SurfaceRadius rConvex = calculator.calcConvex(new SurfaceClearance(1.24));
		System.out.println("Тестовое вычисление выпуклого радиуса: " + rConvex.radius);
		SurfaceClearance cConvex = calculator.calcConvex(new SurfaceRadius(100));
		System.out.println("Тестовое вычисление выпуклой стрелки: " + cConvex.clearance);
	}
}