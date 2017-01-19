package hr.fer.oop.task1;

public class AllResourcesRole implements Role {
	private Action action;

	public AllResourcesRole(Action action) {
		if(action == null)
			throw new IllegalArgumentException();
		this.action = action;
	}

	@Override
	public boolean matches(String resource, Action action) {
		if(resource == null || action == null)
			throw new IllegalArgumentException();
		return this.action == action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
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
		AllResourcesRole other = (AllResourcesRole) obj;
		if (action != other.action)
			return false;
		return true;
	}

}
