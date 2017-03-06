package triangle;

import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TriangleTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testIsoscel() {
		String actual = new Triple(getSide("4"), getSide("4"), getSide("5")).triangleType();

		Assert.assertThat(actual, equalTo("ISO"));
	}

	/**
	 * Equal sides put in another order.
	 */
	@Test
	public void testIsoscel2() {

		String actual = new Triple(getSide("5"), getSide("4"), getSide("4")).triangleType();

		Assert.assertThat(actual, equalTo("ISO"));
	}

	/**
	 * Equal sides put in another order.
	 */
	@Test
	public void testIsoscel3() {

		String actual = new Triple(getSide("4"), getSide("5"), getSide("4")).triangleType();
		Assert.assertThat(actual, equalTo("ISO"));
	}

	@Test
	public void testAllZeroTriangle() {

		String actual = new Triple(getSide("0"), getSide("0"), getSide("0")).triangleType();

		Assert.assertThat(actual, equalTo("NO_TRIANGLE"));
	}

	@Test
	public void testTwoInputsAreZeroTriangle() {

		String actual = new Triple(getSide("1"), getSide("0"), getSide("0")).triangleType();
		Assert.assertThat(actual, equalTo("NO_TRIANGLE"));
	}

	/**
	 * The degenerate case of the triangle inequality theorem is when the sum of
	 * the lengths of any two sides of a triangle is equal to the length of the
	 * third side
	 */
	@Test
	public void testDegenerateTriangle() {

		String actual = new Triple(getSide("1"), getSide("2"), getSide("3")).triangleType();
		Assert.assertThat(actual, equalTo("NO_TRIANGLE"));
	}

	@Test
	public void testScalene() {

		String actual = new Triple(getSide("4"), getSide("2"), getSide("3")).triangleType();
		Assert.assertThat(actual, equalTo("SCA"));
	}

	/**
	 * Non integer input values
	 *
	 */
	@Test
	public void testScaleneNonIntegerInput() {

		String actual = new Triple(getSide("2.6"), getSide("3.6"), getSide("5.5")).triangleType();
		Assert.assertThat(actual, equalTo("SCA"));
	}

	/**
	 * Validation classes and members have a MAx acceptable liit for the value
	 * of the sides of the triangle
	 */
	@Test
	public void testTooLargeSideLength() {
		BigDecimal c = new BigDecimal(Double.parseDouble("2E30"));

		String actual = new Triple(getSide("1"), getSide("2"), c).triangleType();

		Assert.assertThat(actual, equalTo("NO_TRIANGLE"));
	}

	@Test
	public void testOneSideNegative() {

		String actual = new Triple(getSide("-1"), getSide("1"), getSide("1")).triangleType();
		Assert.assertThat(actual, equalTo("NO_TRIANGLE"));
	}

	private BigDecimal getSide(String stringVal) {
		return new BigDecimal(stringVal);
	}
	// public void java8ValidTests() {
	//
	// Boolean isTriangle;
	// isTriangle = ValidTriangleFunction.myFunction.apply(new BigDecimal(2),
	// new BigDecimal(4), new BigDecimal(5));
	// System.out.println(isTriangle);
	// isTriangle = ValidTriangleFunction.myFunction.apply(new BigDecimal(2),
	// new BigDecimal(4), new BigDecimal(9));
	// System.out.println(isTriangle);
	// }

}