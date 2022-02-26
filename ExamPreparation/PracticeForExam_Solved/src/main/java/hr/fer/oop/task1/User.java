package hr.fer.oop.task1;

import java.util.HashSet;
import java.util.Set;

public class User implements MatchingRole {

    private String name;
    private Set<Role> roles;
    private Set<Group> groups;

    public User() {
        roles = new HashSet<>();
        groups = new HashSet<>();
    }

    public User(String name) {
        this.name = name;
        roles = new HashSet<>();
        groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }

    public boolean hasMatchingRole(String resource, Action action) {
        for (Role role : roles) {
            if (role.matches(resource, action)) {
                return true;
            }
        }

        for (Group groupe : groups) {
            if (groupe.hasMatchingRole(resource, action)) {
                return true;
            }
        }

        return false;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

}
