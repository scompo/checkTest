package it.scompo.checktest;

import it.scompo.checktest.exceptions.AlreadyExistentObjectTest;
import it.scompo.checktest.exceptions.MissingIdException;
import it.scompo.checktest.exceptions.ObjectTestNotFoundException;

public interface ObjectContainer {

	ObjectTest getObjectById(Long id) throws ObjectTestNotFoundException;
	
	ObjectTest getObjectByFields(String dato1, String dato2) throws ObjectTestNotFoundException;
	
	void addObject(ObjectTest object) throws AlreadyExistentObjectTest, MissingIdException;
}
