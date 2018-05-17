package de.jsmithy.cricket.players;

import static org.junit.Assert.*;

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
}
