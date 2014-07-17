package it.scompo.checktest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import it.scompo.checktest.exceptions.AlreadyExistentObjectTest;
import it.scompo.checktest.exceptions.MissingIdException;
import it.scompo.checktest.exceptions.ObjectTestNotFoundException;

public class ObjectContainerImpl implements ObjectContainer {

	private Map<Long, ObjectTest> data = new LinkedHashMap<Long, ObjectTest>();

	public ObjectTest getObjectById(Long id) throws ObjectTestNotFoundException {
		if (!data.containsKey(id)) {
			throw new ObjectTestNotFoundException();
		}
		return data.get(id);
	}

	public ObjectTest getObjectByFields(String dato1, String dato2)
			throws ObjectTestNotFoundException {

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
		return res;
	}

	public void addObject(ObjectTest object) throws AlreadyExistentObjectTest,
			MissingIdException {

		if (object.getId() == null) {
			throw new MissingIdException();
		}

		if (data.containsKey(object.getId())) {
			throw new AlreadyExistentObjectTest();
		}

		data.put(object.getId(), object);

	}

}
