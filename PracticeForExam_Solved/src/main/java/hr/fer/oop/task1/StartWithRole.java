package hr.fer.oop.task1;

import java.util.Objects;

public class StartWithRole implements Role {

    private String startResource;
    private Action action;

    public StartWithRole(String startResource, Action action) {
        this.startResource = startResource;
        this.action = action;
    }

    @Override
    public boolean matches(String resource, Action action) {
        if (resource != null) {
            return resource.startsWith(startResource) && this.action == action;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, startResource);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StartWithRole) {
            StartWithRole other = (StartWithRole) obj;
            return Objects.equals(startResource, other.startResource)
                    && action == other.action;
        }

        return false;
    }
}
