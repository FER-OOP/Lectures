package hr.fer.oop.task1;

public class AllResourcesRole implements Role {

    private Action action;

    public AllResourcesRole(Action action) {
        this.action = action;
    }

    @Override
    public boolean matches(String resource, Action action) {
        return this.action == action;
    }

    @Override
    public int hashCode() {
        return action.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AllResourcesRole) {
            AllResourcesRole other = (AllResourcesRole) obj;
            return action == other.action;
        }

        return false;
    }
}
