package triangle;

import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTests {

	public void testEquilateral() {
		String actual = new Triple(getSide("4"), getSide("4"), getSide("4")).triangleType();

		Assert.assertThat(actual, equalTo(Triple.Type.EQUIL.name()));
	}

	@Test
	public void testIsoscel() {
		String actual = new Triple(getSide("4"), getSide("4"), getSide("5")).triangleType();

		Assert.assertThat(actual, equalTo(Triple.Type.ISO.name()));
	}

	/**
	 * Equal sides put in another order.
	 */
	@Test
	public void testIsoscel2() {

		String actual = new Triple(getSide("5"), getSide("4"), getSide("4")).triangleType();

		Assert.assertThat(actual, equalTo(Triple.Type.ISO.name()));
	}

	/**
	 * Equal sides put in another order.
	 */
	@Test
	public void testIsoscel3() {

		String actual = new Triple(getSide("4"), getSide("5"), getSide("4")).triangleType();
		Assert.assertThat(actual, equalTo(Triple.Type.ISO.name()));
	}

	@Test
	public void testAllZeroTriangle() {

		String actual = new Triple(getSide("0"), getSide("0"), getSide("0")).triangleType();

		Assert.assertThat(actual, equalTo(Triple.Error.NOT_IN_RANGE.name()));
	}

	@Test
	public void testTwoInputsAreZeroTriangle() {

		String actual = new Triple(getSide("1"), getSide("0"), getSide("0")).triangleType();
		Assert.assertThat(actual, equalTo(Triple.Error.NOT_IN_RANGE.name()));
	}

	/**
	 * The degenerate case of the triangle inequality theorem is when the sum of
	 * the lengths of any two sides of a triangle is equal to the length of the
	 * third side
	 */
	@Test
	public void testDegenerateTriangle() {

		String actual = new Triple(getSide("1"), getSide("2"), getSide("3")).triangleType();
		Assert.assertThat(actual, equalTo(Triple.Error.NO_TRIANGLE.name()));
	}

	@Test
	public void testScalene() {

		String actual = new Triple(getSide("4"), getSide("2"), getSide("3")).triangleType();
		Assert.assertThat(actual, equalTo(Triple.Type.SCA.name()));
	}

	/**
	 * Non integer input values
	 *
	 */
	@Test
	public void testScaleneNonIntegerInput() {

		String actual = new Triple(getSide("2.6"), getSide("3.6"), getSide("5.5")).triangleType();
		Assert.assertThat(actual, equalTo(Triple.Type.SCA.name()));
	}

	/**
	 * Validation classes and members have a MAx acceptable limit for the value
	 * of the sides of the triangle
	 */
	@Test
	public void testTooLargeSideLength() {
		BigDecimal c = Triple.MAX_ALLOWED_LENGTH.add(new BigDecimal("1"));

		String actual = new Triple(getSide("1"), getSide("2"), c).triangleType();

		Assert.assertThat(actual, equalTo(Triple.Error.NOT_IN_RANGE.name()));
	}

	@Test
	public void testOneSideNegative() {

		String actual = new Triple(getSide("-1"), getSide("1"), getSide("1")).triangleType();
		Assert.assertThat(actual, equalTo(Triple.Error.NOT_IN_RANGE.name()));
	}

	private BigDecimal getSide(String stringVal) {
		return new BigDecimal(stringVal);
	}

}