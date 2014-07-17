package it.scompo.checktest;

import it.scompo.checktest.exceptions.MyExceptions;

import java.util.List;

public interface OperationCheck {
	
	public static final String messageDuplicate = "Already Present!";
	public static final String messageNotPresent = "Not present in list!";
	
	void checkOperation(List<ObjectTest> objectsToTest, ObjectTest obj)
			throws MyExceptions;
}
