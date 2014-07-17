package it.scompo.checktest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.scompo.checktest.exceptions.AlreadyExistentObjectTest;
import it.scompo.checktest.exceptions.MissingIdException;
import it.scompo.checktest.exceptions.ObjectTestNotFoundException;

public class ObjectContainerImpl implements ObjectContainer {

	final static Logger LOGGER = LogManager
			.getLogger(ObjectContainerImpl.class);

	private Map<Long, ObjectTest> data = new LinkedHashMap<Long, ObjectTest>();

	public ObjectTest getObjectById(Long id) throws ObjectTestNotFoundException {

		LOGGER.info("Called getObjectById with id: {}", id);

		ObjectTest res = null;

		if (!data.containsKey(id)) {
			throw new ObjectTestNotFoundException();
		}

		res = data.get(id);

		LOGGER.debug("Returning: {}", res);
		return res;
	}

	public ObjectTest getObjectByFields(String dato1, String dato2)
			throws ObjectTestNotFoundException {

		LOGGER.info("Called getObjectByFields with dato1: {}, dato2: {}",
				dato1, dato2);

		ObjectTest res = null;

		for (Entry<Long, ObjectTest> element : data.entrySet()) {

			ObjectTest value = element.getValue();

			if (value.getDato1().equals(dato1)
					&& value.getDato2().equals(dato2)) {
				res = value;
				break;
			}

		}
		if (res == null) {
			throw new ObjectTestNotFoundException();
		}

		LOGGER.debug("Returning: {}", res);
		return res;
	}

	public void addObject(ObjectTest object) throws AlreadyExistentObjectTest,
			MissingIdException {

		LOGGER.info("Called addObject with addObject: {}", object);

		if (object.getId() == null) {
			throw new MissingIdException();
		}

		if (data.containsKey(object.getId())) {
			throw new AlreadyExistentObjectTest();
		}

		data.put(object.getId(), object);

	}

}
