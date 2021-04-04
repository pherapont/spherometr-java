package ru.konry.spherometr.parametrs;

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
