package triangle;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Triple {

	private final BigDecimal side1;
	private final BigDecimal side2;
	private final BigDecimal side3;
	/**
	 * This is the max size of a side that the porgrams works with.
	 */
	static final BigDecimal MAX_ALLOWED_LENGTH = BigDecimal.valueOf(Double.parseDouble("1E100"));

	Stream<BigDecimal> itemsStream = null;

	Triple(BigDecimal pSide1, BigDecimal pSide2, BigDecimal pSide3) {
		this.side1 = pSide1;
		this.side2 = pSide2;
		this.side3 = pSide3;
		itemsStream = Stream.of(side1, side2, side3);
	}

	/**
	 * Filters out bad input values and returns the type of triangle if any.
	 * 
	 * @return the type of triangle if any or a message if the values are not
	 *         compatible with a triangle
	 */
	public String triangleType() {

		if (isNotWithinRange()) {
			return Error.NOT_IN_RANGE.name();
		}

		Boolean isTriangle = canEvaluateToTriangle();

		if (!isTriangle) {
			return Error.NO_TRIANGLE.name();
		}

		String[] types = { Type.EQUIL.name(), Type.ISO.name(), Type.SCA.name() };

		int size = (int) Stream.of(side1, side2, side3).distinct().count();

		return types[size - 1];
	}

	/**
	 * @return true if triangle invariant is respected. Triangle invariant
	 *         states that the sum of two sides should be greater than the third
	 *         side.
	 */
	protected boolean canEvaluateToTriangle() {

		boolean isValid = side1.add(side2).compareTo(side3) == 1;
		if (!isValid) {
			return false;
		}
		isValid = side1.add(side3).compareTo(side2) == 1;
		if (!isValid) {
			return false;
		}

		isValid = side2.add(side3).compareTo(side1) == 1;

		return isValid;
	}

	/**
	 * @return true if the length of each element is positive and less of a
	 *         maximum allowed limit
	 */
	protected boolean isNotWithinRange() {
		long count = itemsStream.filter(e -> e.compareTo(BigDecimal.ZERO) == 1)
				.filter(e -> MAX_ALLOWED_LENGTH.compareTo(e) == 1).count();

		return count != 3;
	}

	public enum Type {
		EQUIL("Equilateral"), ISO("Isosceles"), SCA("Scalene");

		private final String msg;

		Type(String pMsg) {
			msg = pMsg;
		}

		@Override
		public String toString() {
			return msg;
		}
	}

	public enum Error {
		NO_TRIANGLE("The triangle invariant is not respected"), NOT_IN_RANGE(
				"The Length of each element should be positive and less of " + MAX_ALLOWED_LENGTH);

		private final String msg;

		Error(String pMsg) {
			msg = pMsg;
		}

		@Override
		public String toString() {
			return msg;
		}
	}
}
