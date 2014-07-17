package it.scompo.checktest;

public interface ObjectContainer {

	ObjectTest getObjectById(Long id);
	
	ObjectTest getObjectByFields(String dato1, String dato2);
}
