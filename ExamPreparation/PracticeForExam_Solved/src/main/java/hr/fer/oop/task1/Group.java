package hr.fer.oop.task1;

import java.util.HashSet;
import java.util.Set;

public class Group implements MatchingRole {

    private String name;
    private Set<Role> roles;

    public Group() {
        roles = new HashSet<>();
    }

    public Group(String name) {
        this.name = name;
        roles = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasMatchingRole(String resource, Action action) {
        for (Role role : roles) {
            if (role.matches(resource, action)) {
                return true;
            }
        }

        return false;
    }
}
