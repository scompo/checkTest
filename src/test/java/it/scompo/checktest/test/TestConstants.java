/**
 * TestConstants.java
 */
package it.scompo.checktest.test;

/**
 * @author mscomparin
 *
 */
public abstract class TestConstants {
	
	private TestConstants(){
		
	}
	
	/**
	 * Exception thrown message.
	 */
	public static final String PASSED_EXCEPTION_THROWN_MESSAGE = "Passed, exception thrown: {}";
	
	/**
	 * Exception not thrown message.
	 */
	public static final String EXCEPTION_NOT_THROWN_MESSAGE = "Exception not thrown";

	/**
	 * Passed message.
	 */
	public static final String PASSED_MESSAGE = "Passed!";
	
	public static final Long TEST_ID_1 = 1l;
	public static final Long TEST_ID_2 = 2l;
	public static final Long TEST_ID_3 = 3l;

	public static final String TEST_DATO_1_1 = "dato1_1";
	public static final String TEST_DATO_2_1 = "dato2_1";
	public static final String TEST_DATO_1_2 = "dato1_2";
	public static final String TEST_DATO_2_2 = "dato2_2";
	public static final String TEST_DATO_1_3 = "dato1_3";
	public static final String TEST_DATO_2_3 = "dato2_3";
	public static final Long ID_NOT_EXISTENT_IN_DATASET = 4l;
	public static final String DATO_1_NOT_EXISTENT_IN_DATASET = "notex";
	public static final String DATO_2_NOT_EXISTENT_IN_DATASET = "notex2";
}
