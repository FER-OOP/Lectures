package hr.fer.oop.task1;

public class StartWithRole implements Role {

	private String startResource;
	private Action action;

	public StartWithRole(String startResource, Action action) {
		if(startResource == null || action == null)
			throw new IllegalArgumentException();
		
		this.startResource = startResource;
		this.action = action;
	}

	@Override
	public boolean matches(String resource, Action action) {
		if(resource == null || action == null)
			throw new IllegalArgumentException();
		
		return resource.startsWith(startResource) && this.action == action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((startResource == null) ? 0 : startResource.hashCode());
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
		StartWithRole other = (StartWithRole) obj;
		if (action != other.action)
			return false;
		if (startResource == null) {
			if (other.startResource != null)
				return false;
		} else if (!startResource.equals(other.startResource))
			return false;
		return true;
	}
}
