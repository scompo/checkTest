package it.scompo.checktest;

import it.scompo.checktest.exceptions.BadListException;

import java.util.List;

public class OperationCheckImpl implements OperationCheck {

	private ObjectContainer container;

	public OperationCheckImpl(ObjectContainer container) {
		this.container = container;
	}

	public void checkOperation(List<ObjectTest> objectsToTest, ObjectTest obj)
			throws BadListException {
		throw new RuntimeException("Not implemented!");
	}

}
