package de.jsmithy.cricket.players;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test case for the domain type 'Player'.
 * 
 * @author Erik
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerTest {

	@Test
	public void testNewInstance() {
		Name name = Name.newInstance("Wayne Mardle");
		
		Player sut = Player.newInstance(name);
		
		assertNotNull("Instance has not been created!", sut);
	}

	@Test(expected=NullPointerException.class)
	public void testNewInstance_with_null_value() {
		Player.newInstance(null);
	}

	@Test
	public void testGetName() {
		Name expected = Name.newInstance("Wayne Mardle");
		Player sut = Player.newInstance(expected);
		
		Name actual = sut.getName();
		
		assertEquals("<name> has not been set!", expected, actual);
	}
	
	@Test
	public void testGetNickName_default_is_empty() {
		Player sut = Player.newInstance(Name.newInstance("Some name"));
		Optional<Name> expected = Optional.empty();
		
		Optional<Name> actual = sut.getNickName();
		
		assertEquals("Default <nickName> is not correct!", expected, actual);
	}
	
	@Test
	public void testSetNickName() {
		Player sut = Player.newInstance(Name.newInstance("Some name"));
		Name expected = Name.newInstance("Nick");
		
		sut.setNickName(expected);
		
		Optional<Name> nickName = sut.getNickName();
		Name actual = nickName.isPresent() ? nickName.get() : null;
		assertEquals("Setting <nickName> was not correct!", expected, actual);
	}
	
	@Test
	public void testToString() {
		String expected = "Wayne Mardle";
		Player sut = Player.newInstance(Name.newInstance(expected));
		
		String actual = sut.toString();
		
		assertEquals("String representation is not correct!", expected, actual);
	}

	
	@Test
	public void testToString_with_nickName_present() {
		String name = "Wayne Mardle";
		Player sut = Player.newInstance(Name.newInstance(name));
		sut.setNickName(Name.newInstance("Hawaii 5.0.1"));
		String expected = "Wayne Mardle - Hawaii 5.0.1";
		
		String actual = sut.toString();
		
		assertEquals("String representation is not correct!", expected, actual);
	}
	
	@Test
	public void testEquals_both_has_same_name() {
		String name = "Phil Taylor";
		Player sut = Player.newInstance(Name.newInstance(name));
		Player otherPlayer = Player.newInstance(Name.newInstance(name));
		
		boolean condition = sut.equals(otherPlayer);
		
		assertTrue("Players are not equal!", condition);
	}
}
