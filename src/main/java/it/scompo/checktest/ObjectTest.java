package it.scompo.checktest;

/**
 * Test object!
 * 
 * @author mscomparin
 *
 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectTest other = (ObjectTest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectTest [id=" + id + ", dato1=" + dato1 + ", dato2=" + dato2
				+ "]";
	}

}
