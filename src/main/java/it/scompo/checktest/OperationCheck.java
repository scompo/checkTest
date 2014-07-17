package it.scompo.checktest;

import it.scompo.checktest.exceptions.BadListException;

import java.util.List;

public interface OperationCheck {

	void checkOperation(List<ObjectTest> objectsToTest, ObjectTest obj)
			throws BadListException;
}
