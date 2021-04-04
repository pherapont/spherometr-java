package ru.konry.spherometr.parametrs;

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
