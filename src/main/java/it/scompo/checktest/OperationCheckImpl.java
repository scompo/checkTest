package it.scompo.checktest;

import it.scompo.checktest.exceptions.BadListException;
import it.scompo.checktest.exceptions.MyExceptions;
import it.scompo.checktest.exceptions.ObjectTestNotFoundException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OperationCheckImpl implements OperationCheck {

	private ObjectContainer container;

	public OperationCheckImpl(ObjectContainer container) {
		this.container = container;
	}

	public void checkOperation(List<ObjectTest> objectsToTest, ObjectTest obj)
			throws MyExceptions {

		Map<Long, ObjectTest> objectTestFromContainer = null;

		ObjectTest single = null;

		objectTestFromContainer = getMapFromList(objectsToTest);

		try {
			single = container
					.getObjectByFields(obj.getDato1(), obj.getDato2());
		} catch (ObjectTestNotFoundException e) {
			System.err.println("great it's not present!");
		}

		if (single != null) {
			
			if (!objectTestFromContainer.containsKey(single.getId())) {
				throw new BadListException(messageNotPresent);
			}
		}

	}

	public Map<Long, ObjectTest> getMapFromList(List<ObjectTest> objectsToTest)
			throws ObjectTestNotFoundException, BadListException {

		Map<Long, ObjectTest> res = new LinkedHashMap<Long, ObjectTest>();

		for (ObjectTest objectTest : objectsToTest) {

			ObjectTest obj = container.getObjectById(objectTest.getId());
			
			if (!res.containsKey(obj.getId())) {
				res.put(obj.getId(), obj);
				
			}else {
				
				throw new BadListException(messageDuplicate);
			}
		}

		return res;
	}

}
