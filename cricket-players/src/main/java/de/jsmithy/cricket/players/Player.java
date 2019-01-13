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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String result = getNickName().isPresent() ? String.format(getName().toString() + " - %s", getNickName().get()) : getName().toString();
		
		return result;
	}
}
