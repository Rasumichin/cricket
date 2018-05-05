package de.jsmithy.cricket.players;

import java.io.Serializable;

/**
 * Player's Name domain attribute. A name may consist of a first name, a surname or both.
 * <li>Use the factory method {@link #newInstance(String)} to create instances.</li>
 * <li>Supports the "NullObject" pattern.</li>
 * 
 * @author Erik
 *
 */
public class Name implements Serializable {
	private static final long serialVersionUID = 1140989109643131931L;

	private String value;
	
	private Name() {
	}

	private Name(String name) {
		value = name;
	}

	public static Name newInstance(String name) {
		if ((name == null) || (name.trim().isEmpty())) {
			return NameNullObject.instance();
		}
		
		return new Name(name);
	}

	public boolean isEmpty() {
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Name other = (Name) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value;
	}
	
	static final class NameNullObject extends Name {
		private static final long serialVersionUID = 6747770967547423198L;
		
		private static final NameNullObject SINGLETON = new NameNullObject();
		
		private static NameNullObject instance() {
			return SINGLETON;
		}
		
		@Override
		public boolean isEmpty() {
			return true;
		}
		
		@Override
		public String toString() {
			return "";
		}
	}
}
