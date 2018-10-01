package de.jsmithy.cricket.players;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents a Player within a Cricket darts game.
 * 
 * @author Erik
 *
 */
public class Player {
	private Name name;
	private Name nickName;

	private Player() {
	}

	private Player(Name aName) {
		name = aName;
	}
	
	public static Player newInstance(Name aName) {
		Objects.requireNonNull(aName, "<aName> must not be 'null'.");
		
		return new Player(aName);
	}

	public Name getName() {
		return name;
	}

	public Optional<Name> getNickName() {
		return Optional.ofNullable(nickName);
	}

	public void setNickName(Name aNickName) {
		nickName = aNickName;
	}

	@Override
	public String toString() {
		String result = getNickName().isPresent() ? String.format(getName().toString() + " - %s", getNickName().get()) : getName().toString();
		
		return result;
	}
}
