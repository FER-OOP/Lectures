package hr.fer.oop.task1;

import java.util.Objects;

public class BasicRole implements Role {

    private String resource;
    private Action action;

    public BasicRole(String resource, Action action) {
        this.resource = resource;
        this.action = action;
    }

    @Override
    public boolean matches(String resource, Action action) {
        return Objects.equals(this.resource, resource) && this.action == action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, resource);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BasicRole) {
            BasicRole other = (BasicRole) obj;
            return Objects.equals(resource, other.resource)
                    && action == other.action;
        }

        return false;
    }
}
