package nl.jchmb.math.number;

public interface Field<T> {
	public T add(T x, T y);
	public T subtract(T x, T y);
	public T multiply(T x, T y);
	public T pow(T x, T y);
	public T sqrt(T x);
	public T divide(T x, T y);
	public T negate(T x);
	public T zero();
	public T identity();
}
