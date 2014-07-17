package it.scompo.checktest;

import it.scompo.checktest.exceptions.BadListException;
import it.scompo.checktest.exceptions.MyExceptions;
import it.scompo.checktest.exceptions.ObjectTestNotFoundException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OperationCheckImpl implements OperationCheck {
	
	final static Logger LOGGER = LogManager.getLogger(OperationCheckImpl.class);

	private ObjectContainer container;

	public OperationCheckImpl(ObjectContainer container) {
		this.container = container;
	}

	public void checkOperation(List<ObjectTest> objectsToTest, ObjectTest obj)
			throws MyExceptions {

		LOGGER.info("Called checkOperation with objectsToTest: {}, obj: {}", objectsToTest, obj);
		
		Map<Long, ObjectTest> objectTestFromContainer = null;

		ObjectTest single = null;

		objectTestFromContainer = getMapFromList(objectsToTest);

		try {
			single = container
					.getObjectByFields(obj.getDato1(), obj.getDato2());
		} catch (ObjectTestNotFoundException e) {
			LOGGER.debug("The new object it's not present!");
		}

		if (single != null) {
			
			if (!objectTestFromContainer.containsKey(single.getId())) {
				throw new BadListException(messageNotPresent);
			}
		}
		
		LOGGER.debug("Check completed succesfully!");

	}

	public Map<Long, ObjectTest> getMapFromList(List<ObjectTest> objectsToTest)
			throws ObjectTestNotFoundException, BadListException {
		
		LOGGER.info("Called getMapFromList with objectsToTest: {}", objectsToTest);

		Map<Long, ObjectTest> res = new LinkedHashMap<Long, ObjectTest>();

		for (ObjectTest objectTest : objectsToTest) {

			ObjectTest obj = container.getObjectById(objectTest.getId());
			
			if (!res.containsKey(obj.getId())) {
				
				LOGGER.debug("The object it's present for the first time, adding it.");
				res.put(obj.getId(), obj);
				
			}else {
				
				throw new BadListException(messageDuplicate);
			}
		}
		
		LOGGER.debug("Returning: {}", res);
		return res;
	}

}
