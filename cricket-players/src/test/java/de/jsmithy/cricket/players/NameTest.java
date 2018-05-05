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
	public void testNewInstance() {
		String name = "Phil Taylor";
		
		Name sut = Name.newInstance(name);
		
		assertNotNull("Instance has not been created!", sut);
	}

	@Test
	public void testNewInstance_with_null_value() {
		Name sut = Name.newInstance(null);
		
		assertNotNull("Instance has not been created!", sut);
	}

	@Test
	public void testToString() {
		String expected = "Phil Taylor";
		Name sut = Name.newInstance(expected);
		
		String actual = sut.toString();
		
		assertEquals("String representation is not correct!", expected, actual);
	}
	
	@Test
	public void testToString_with_null_value() {
		String expected = "";
		Name sut = Name.newInstance(null);
		
		String actual = sut.toString();
		
		assertEquals("String representation is not correct!", expected, actual);
	}
	
	@Test
	public void testToString_with_spaces_value() {
		String justSpaces = "   ";
		String expected = "";
		Name sut = Name.newInstance(justSpaces);
		
		String actual = sut.toString();
		
		assertEquals("String representation is not correct!", expected, actual);
	}
	
	@Test
	public void testIsEmpty() {
		String name = "Phil Taylor";
		Name sut = Name.newInstance(name);
		
		boolean condition = sut.isEmpty();
		
		assertFalse("Name with value must not be empty!", condition);
	}
	
	@Test
	public void testIsEmpty_with_null_value() {
		Name sut = Name.newInstance(null);
		
		boolean condition = sut.isEmpty();
		
		assertTrue("Name without a value must be empty!", condition);
	}
	
	@Test
	public void testIsEmpty_with_spaces_value() {
		String justSpaces = "   ";
		Name sut = Name.newInstance(justSpaces);
		
		boolean condition = sut.isEmpty();
		
		assertTrue("Name without a value must be empty!", condition);
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
	public void testEquals_compare_same_object() {
		Name name = Name.newInstance("Phil Taylor");
		
		assertEquals("Instances are not equal!", name, name);
	}

	@Test
	public void testEquals_compare_with_null() {
		Name name = Name.newInstance("Phil Taylor");
		
		boolean condition = name.equals(null);
		
		assertFalse("Instances must not be equal!", condition);
	}

	@Test
	public void testEquals_compare_with_different_type() {
		Name name = Name.newInstance("Phil Taylor");
		Integer someInteger = Integer.valueOf(24);
		
		boolean condition = name.equals(someInteger);
		
		assertFalse("Instances must not be equal!", condition);
	}

	@Test
	public void testIsSerializable() {
		String name = "Phil Taylor";
		Name sut = Name.newInstance(name);
		
		boolean condition = sut instanceof Serializable;
		
		assertTrue("Instance is not serializable!", condition);
	}

	@Test
	public void testIsSerializable_with_null_value() {
		Name sut = Name.newInstance(null);
		
		boolean condition = sut instanceof Serializable;
		
		assertTrue("Instance is not serializable!", condition);
	}
	
	@Test
	public void testHashCode() {
		Name name = Name.newInstance("Phil Taylor");
		Integer expected = Integer.valueOf(-1710469401);
		
		Integer actual = Integer.valueOf(name.hashCode());
		
		assertEquals("Hash code is not correct!", expected, actual);
	}
}
