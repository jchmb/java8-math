package nl.jchmb.math.number;

public class DoubleField implements Field<Double> {
	public static final double ZERO = 0.0d;
	public static final double IDENTITY = 1.0d;
	public static final DoubleField INSTANCE = new DoubleField();
	
	@Override
	public Double add(Double x, Double y) {
		return x + y;
	}

	@Override
	public Double subtract(Double x, Double y) {
		return x - y;
	}

	@Override
	public Double multiply(Double x, Double y) {
		return x * y;
	}

	@Override
	public Double pow(Double x, Double y) {
		return Math.pow(x, y);
	}

	@Override
	public Double divide(Double x, Double y) {
		return x / y;
	}

	@Override
	public Double negate(Double x) {
		return -x;
	}

	@Override
	public Double zero() {
		return ZERO;
	}

	@Override
	public Double identity() {
		return IDENTITY;
	}

	@Override
	public Double sqrt(Double x) {
		return Math.sqrt(x);
	}

}
