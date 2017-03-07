package triangle;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Triple {

	private final BigDecimal a;
	private final BigDecimal b;
	private final BigDecimal c;
	/**
	 * This is the max size of a side that the porgrams works with.
	 */
	static final BigDecimal MAX_ALLOWED_LENGTH = BigDecimal.valueOf(Double.parseDouble("1E100"));

	Stream<BigDecimal> itemsStream = null;

	Triple(BigDecimal a, BigDecimal b, BigDecimal c) {
		this.a = a;
		this.b = b;
		this.c = c;
		itemsStream = Stream.of(a, b, c);
	}

	public String triangleType() {

		if (!isWithinRange()) {
			return Error.NOT_IN_RANGE.name();
		}

		Boolean isTriangle = canEvaluateToTriangle();

		if (!isTriangle) {
			return Error.NO_TRIANGLE.name();
		}

		String[] types = { Type.EQUIL.name(), Type.ISO.name(), Type.SCA.name() };

		int size = (int) Stream.of(a, b, c).distinct().count();

		return types[size - 1];
	}

	/**
	 * @return true if elemts are within ranges and triangle invariant is
	 *         respected
	 */
	protected boolean canEvaluateToTriangle() {

		boolean isValid = a.add(b).compareTo(c) == 1;
		if (!isValid) {
			return false;
		}
		isValid = a.add(c).compareTo(b) == 1;
		if (!isValid) {
			return false;
		}

		isValid = b.add(c).compareTo(a) == 1;

		return isValid;
	}

	/**
	 * @return true if the length each element should be positive and less of a
	 *         maximum allowed limit
	 */
	protected boolean isWithinRange() {
		long count = itemsStream.filter(e -> e.compareTo(BigDecimal.ZERO) == 1)
				.filter(e -> MAX_ALLOWED_LENGTH.compareTo(e) == 1).count();

		return count == 3;
	}

	public enum Type {
		EQUIL("Equilateral"), ISO("isosceles"), SCA("scalene");

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
				"The Length each element should be positive and less of " + MAX_ALLOWED_LENGTH);

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
