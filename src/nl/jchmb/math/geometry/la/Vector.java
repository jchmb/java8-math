package nl.jchmb.math.geometry.la;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nl.jchmb.math.number.DoubleField;
import nl.jchmb.math.number.Field;

/**
 * Vector representation in linear algebra.
 * @param <T>
 */
public class Vector<T> {
	private Field<T> field;
	private List<T> values;
	
	public Vector(Field<T> field, List<T> values) {
		this.field = field;
		this.values = values;
	}
	
	/**
	 * Count the dimensions. This is NOT the length.
	 * 
	 * @return
	 */
	public int dimensions() {
		return values.size();
	}
	
	private Vector<T> binaryOperation(Vector<T> that, BinaryOperator<T> operator) {
		return new Vector<T>(
				field,
				IntStream.range(0, dimensions())
					.mapToObj(
							i -> operator.apply(this.values.get(i), that.values.get(i))
					)
					.collect(Collectors.toList())
		);
	}
	
	/**
	 * Add another vector to this vector.
	 * 
	 * @param that
	 * @return
	 */
	public Vector<T> add(Vector<T> that) {
		return binaryOperation(that, field::add);
	}
	
	/**
	 * Subtract another vector from this vector.
	 * 
	 * @param that
	 * @return
	 */
	public Vector<T> subtract(Vector<T> that) {
		return binaryOperation(that, field::subtract);
	}
	
	/**
	 * Compute the contraction with another vector. This is the same as the dot product.
	 * 
	 * @param that
	 * @return
	 */
	public T contract(Vector<T> that) {
		return IntStream.range(0, dimensions())
				.mapToObj(i -> field.multiply(this.values.get(i), this.values.get(i)))
				.reduce(
						field.identity(),
						field::add
				);
	}
	
	/**
	 * Get the length of this vector.
	 * 
	 * @return
	 */
	public T length() {
		return field.sqrt(contract(this));
	}
	
	/**
	 * Negate this vector, i.e., get its additive inverse.
	 * 
	 * @return
	 */
	public Vector<T> negate() {
		return createNew(
				values.stream()
					.map(value -> field.negate(value))
					.collect(Collectors.toList())
		);
	}
	
	/**
	 * Scale this vector with the given multiplier.
	 * 
	 * @param multiplier
	 * @return
	 */
	public Vector<T> scale(T multiplier) {
		return createNew(
				values.stream()
					.map(value -> field.multiply(value, multiplier))
					.collect(Collectors.toList())
		);
	}
	
	/**
	 * Create a new vector based on the same field with the given values.
	 * 
	 * @param values
	 * @return
	 */
	public Vector<T> createNew(List<T> values) {
		return new Vector<T>(field, values);
	}
	
	/**
	 * Create a double vector from the given values.
	 * 
	 * @param values
	 * @return
	 */
	public static Vector<Double> ofDouble(List<Double> values) {
		return new Vector<Double>(DoubleField.INSTANCE, values);
	}
	
	public static Vector<Double> ofDouble(Double[] values) {
		return ofDouble(Arrays.asList(values));
	}
	
	public static Vector<Double> of(double x, double y) {
		return ofDouble(new Double[]{x, y});
	}
	
	public static Vector<Double> of(double x, double y, double z) {
		return ofDouble(new Double[]{x, y, z});
	}
}
