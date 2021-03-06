package it.scompo.checktest.test;

import static org.junit.Assert.*;
import static it.scompo.checktest.test.TestConstants.*;
import it.scompo.checktest.ObjectContainer;
import it.scompo.checktest.ObjectContainerImpl;
import it.scompo.checktest.ObjectTest;
import it.scompo.checktest.OperationCheck;
import it.scompo.checktest.OperationCheckImpl;
import it.scompo.checktest.exceptions.BadListException;
import it.scompo.checktest.exceptions.MyExceptions;
import it.scompo.checktest.exceptions.ObjectTestNotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OperationCheckImplTest {

	final static Logger LOGGER = LogManager
			.getLogger(OperationCheckImplTest.class);

	private ObjectContainer container = null;

	private ObjectTest object1 = null;
	private ObjectTest object2 = null;
	private ObjectTest object3 = null;

	private OperationCheck checker = null;

	@Before
	public void setUp() throws Exception {

		container = new ObjectContainerImpl();

		object1 = new ObjectTest(TEST_ID_1, TEST_DATO_1_1, TEST_DATO_2_1);
		object2 = new ObjectTest(TEST_ID_2, TEST_DATO_1_2, TEST_DATO_2_2);
		object3 = new ObjectTest(TEST_ID_3, TEST_DATO_1_3, TEST_DATO_2_3);

		container.addObject(object1);
		container.addObject(object2);
		container.addObject(object3);

		checker = new OperationCheckImpl(container);

	}

	@After
	public void tearDown() throws Exception {

		object1 = null;
		object2 = null;
		object3 = null;

		container = null;

		checker = null;
	}

	@Test
	public void testCheckOperationOkNotExistentInList() {

		List<ObjectTest> list = null;
		ObjectTest single = null;

		list = new ArrayList<ObjectTest>();
		list.add(object1);
		list.add(object2);

		single = new ObjectTest(ID_NOT_EXISTENT_IN_DATASET,
				DATO_1_NOT_EXISTENT_IN_DATASET, DATO_2_NOT_EXISTENT_IN_DATASET);

		try {
			checker.checkOperation(list, single);
		} catch (MyExceptions e) {
			fail("Exception: " + e);
		}
		
		LOGGER.debug(PASSED_MESSAGE);

	}

	@Test
	public void testCheckOperationOk1ExistentInList() {

		List<ObjectTest> list = null;
		ObjectTest single = null;

		list = new ArrayList<ObjectTest>();
		list.add(object1);
		list.add(object2);

		single = object1;

		try {
			checker.checkOperation(list, single);
		} catch (MyExceptions e) {
			fail("Exception: " + e);
		}
		
		LOGGER.debug(PASSED_MESSAGE);
	}

	@Test
	public void testCheckOperationKo1ExistentOutList() throws MyExceptions {

		List<ObjectTest> list = null;
		ObjectTest single = null;

		list = new ArrayList<ObjectTest>();
		list.add(object1);
		list.add(object2);

		single = object3;

		try {
			checker.checkOperation(list, single);
			fail(EXCEPTION_NOT_THROWN_MESSAGE);
		} catch (BadListException e) {
			assertEquals(OperationCheck.messageNotPresent ,e.getMessage());
			LOGGER.info(PASSED_EXCEPTION_THROWN_MESSAGE, e.getClass());
		}
	}

	@Test
	public void testCheckOperationKoNonPresentInList() throws MyExceptions {

		List<ObjectTest> list = null;
		ObjectTest single = null;

		ObjectTest notExistentObject = new ObjectTest(
				ID_NOT_EXISTENT_IN_DATASET, DATO_1_NOT_EXISTENT_IN_DATASET,
				DATO_2_NOT_EXISTENT_IN_DATASET);

		list = new ArrayList<ObjectTest>();
		list.add(object1);
		list.add(object2);
		list.add(notExistentObject);

		single = object3;

		try {
			checker.checkOperation(list, single);
			fail(EXCEPTION_NOT_THROWN_MESSAGE);
		} catch (ObjectTestNotFoundException e) {
			LOGGER.info(PASSED_EXCEPTION_THROWN_MESSAGE, e.getClass());
		}
	}

	@Test
	public void testCheckOperationKoMoreThan1ExistentInList() throws MyExceptions {

		List<ObjectTest> list = null;
		ObjectTest single = null;

		list = new ArrayList<ObjectTest>();

		list.add(object1);
		list.add(object2);
		list.add(object2);

		single = object3;

		try {
			checker.checkOperation(list, single);
			fail(EXCEPTION_NOT_THROWN_MESSAGE);
		} catch (BadListException e) {
			assertEquals(OperationCheck.messageDuplicate ,e.getMessage());
			LOGGER.info(PASSED_EXCEPTION_THROWN_MESSAGE, e.getClass());
		}
	}

}
