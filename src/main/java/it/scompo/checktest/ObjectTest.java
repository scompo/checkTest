package it.scompo.checktest;

public class ObjectTest {

	/**
	 * @param id
	 * @param dato1
	 * @param dato2
	 */
	public ObjectTest(Long id, String dato1, String dato2) {
		this.id = id;
		this.dato1 = dato1;
		this.dato2 = dato2;
	}

	/**
	 * 
	 */
	public ObjectTest() {

		this(null, null, null);
	}

	private Long id;
	private String dato1;
	private String dato2;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dato1
	 */
	public String getDato1() {
		return dato1;
	}

	/**
	 * @param dato1
	 *            the dato1 to set
	 */
	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	/**
	 * @return the dato2
	 */
	public String getDato2() {
		return dato2;
	}

	/**
	 * @param dato2
	 *            the dato2 to set
	 */
	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}

}
