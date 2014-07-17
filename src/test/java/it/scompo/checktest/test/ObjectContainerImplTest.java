package it.scompo.checktest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static it.scompo.checktest.test.TestConstants.*;
import it.scompo.checktest.ObjectContainer;
import it.scompo.checktest.ObjectContainerImpl;
import it.scompo.checktest.ObjectTest;
import it.scompo.checktest.exceptions.AlreadyExistentObjectTest;
import it.scompo.checktest.exceptions.MissingIdException;
import it.scompo.checktest.exceptions.MyExceptions;
import it.scompo.checktest.exceptions.ObjectTestNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObjectContainerImplTest {

	final static Logger LOGGER = LogManager
			.getLogger(ObjectContainerImplTest.class);

	private static ObjectTest obj1 = null;
	private static ObjectTest obj2 = null;

	private ObjectContainer container = null;

	@Before
	public void setUp() throws Exception {

		container = new ObjectContainerImpl();

		obj1 = new ObjectTest(TEST_ID_1, TEST_DATO_1_1, TEST_DATO_2_1);
		obj2 = new ObjectTest(TEST_ID_2, TEST_DATO_1_2, TEST_DATO_2_2);
	}

	@After
	public void tearDown() throws Exception {

		container = null;

		obj1 = null;
		obj2 = null;
	}

	@Test
	public void testAddObjectOk() throws MyExceptions {

		ObjectTest res = null;

		try {
			container.addObject(obj1);
			container.addObject(obj2);
		} catch (MyExceptions e) {
			fail("Exception: " + e);
		}

		res = container.getObjectById(obj1.getId());

		assertNotNull(res);
		assertEquals(obj1, res);

		res = container.getObjectById(obj2.getId());

		assertNotNull(res);
		assertEquals(obj2, res);
		LOGGER.debug(PASSED_MESSAGE);
		
	}

	@Test
	public void testAddObjectNoId() throws MyExceptions {

		ObjectTest object = null;

		object = new ObjectTest();

		try {
			container.addObject(object);
			fail(EXCEPTION_NOT_THROWN_MESSAGE);
		} catch (MissingIdException e) {
			LOGGER.debug(PASSED_EXCEPTION_THROWN_MESSAGE, e);
		}
	}

	@Test
	public void testAddObjectAlreadyExistent() throws MyExceptions {

		container.addObject(obj1);

		try {
			container.addObject(obj1);
			fail(EXCEPTION_NOT_THROWN_MESSAGE);
		} catch (AlreadyExistentObjectTest e) {
			LOGGER.debug(PASSED_EXCEPTION_THROWN_MESSAGE, e);
		}
	}

	@Test
	public void testGetObjectByIdOk() throws MyExceptions {

		ObjectTest res = null;

		container.addObject(obj1);
		container.addObject(obj2);

		try {
			res = container.getObjectById(obj1.getId());
		} catch (MyExceptions e) {
			fail("Exception: " + e);
		}

		assertNotNull(res);
		assertEquals(obj1, res);
		
		res = null;

		try {
			res = container.getObjectById(obj2.getId());
		} catch (MyExceptions e) {
			fail("Exception: " + e);
		}

		assertNotNull(res);
		assertEquals(obj2, res);
		LOGGER.debug(PASSED_MESSAGE);
	}

	@Test
	public void testGetObjectByIdNotPresent() throws MyExceptions {

		container.addObject(obj1);

		try {
			container.getObjectById(obj2.getId());
			fail(EXCEPTION_NOT_THROWN_MESSAGE);
		} catch (ObjectTestNotFoundException e) {
			LOGGER.debug(PASSED_EXCEPTION_THROWN_MESSAGE, e);
		}
	}

	@Test
	public void testGetObjectByFieldsOk() throws MyExceptions {

		ObjectTest res = null;

		container.addObject(obj1);
		container.addObject(obj2);

		try {
			res = container.getObjectByFields(obj1.getDato1(), obj1.getDato2());
		} catch (MyExceptions e) {
			fail("Exception: " + e);
		}

		assertNotNull(res);
		assertEquals(obj1, res);
		
		res = null;

		try {
			res = container.getObjectByFields(obj2.getDato1(), obj2.getDato2());
		} catch (MyExceptions e) {
			fail("Exception: " + e);
		}

		assertNotNull(res);
		assertEquals(obj2, res);
		LOGGER.debug(PASSED_MESSAGE);
	}

	@Test
	public void testGetObjectByFieldsNotPresent() throws MyExceptions {

		container.addObject(obj1);

		try {
			container.getObjectByFields(obj2.getDato1(), obj2.getDato2());
			fail(EXCEPTION_NOT_THROWN_MESSAGE);
		} catch (ObjectTestNotFoundException e) {
			LOGGER.debug(PASSED_EXCEPTION_THROWN_MESSAGE, e);
		}
	}

}
