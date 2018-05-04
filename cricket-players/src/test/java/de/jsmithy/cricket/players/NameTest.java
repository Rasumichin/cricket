package de.jsmithy.cricket.players;

import static org.junit.Assert.*;

import java.io.Serializable;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test case for the domain attribute 'Name' of a player.
 * 
 * @author Erik
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NameTest {

	@Test
	public void testNewInstance_with_name_value() {
		String name = "Phil Taylor";
		
		Name sut = Name.newInstance(name);
		
		assertNotNull("Instance has not been created!", sut);
	}

	@Test
	public void testToString_with_name_value() {
		String expected = "Phil Taylor";
		Name sut = Name.newInstance(expected);
		
		String actual = sut.toString();
		
		assertEquals("String representation is not correct!", expected, actual);
	}
	
	@Test
	public void testIsEmpty_with_name_value() {
		String name = "Phil Taylor";
		Name sut = Name.newInstance(name);
		
		boolean condition = sut.isEmpty();
		
		assertFalse("Name with value must not be empty!", condition);
	}
	
	@Test
	public void testEquals_when_true() {
		Name nameA = Name.newInstance("Phil Taylor");
		Name nameB = Name.newInstance("Phil Taylor");
		
		assertEquals("Instances are not equal!", nameA, nameB);
	}

	@Test
	public void testEquals_when_false() {
		Name nameA = Name.newInstance("Phil Taylor");
		Name nameB = Name.newInstance("Wayne Mardle");
		
		assertNotEquals("Instances are equal!", nameA, nameB);
	}

	@Test
	public void testIsSerializable() {
		String name = "Phil Taylor";
		Name sut = Name.newInstance(name);
		
		boolean condition = sut instanceof Serializable;
		
		assertTrue("Instance is not serializable!", condition);
	}
}
