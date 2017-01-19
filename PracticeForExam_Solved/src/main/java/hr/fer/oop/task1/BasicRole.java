package hr.fer.oop.task1;

public class BasicRole implements Role {

	private String resource;
	private Action action;

	public BasicRole(String resource, Action action) {
		if(resource == null || action == null)
			throw new IllegalArgumentException();
		
		this.resource = resource;
		this.action = action;
	}

	/* (non-Javadoc)
	 * @see hr.fer.oop.task1.Matchable#matches(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean matches(String resource, Action action) {
		if(resource == null || action == null)
			throw new IllegalArgumentException();
		return this.resource.equals(resource) && this.action == action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
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
		BasicRole other = (BasicRole) obj;
		if (action != other.action)
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		return true;
	}
}
