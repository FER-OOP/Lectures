package hr.fer.oop.task1;

public class Main {

    public static void main(String[] args) {
        User student = new User();
        student.addRole(new BasicRole("2Y/OOP", Action.READ));
        System.out.println(student.hasMatchingRole("2Y/OOP", Action.READ)); // true
        System.out.println(student.hasMatchingRole("3Y/ILJ", Action.READ)); // false

        User professor = new User();
        Group year2 = new Group();
        year2.addRole(new StartWithRole("2Y/", Action.WRITE));
        professor.addGroup(year2);
        System.out.println(professor.hasMatchingRole("2Y/OOP", Action.WRITE)); // true 
        System.out.println(professor.hasMatchingRole("2Y/OOP", Action.READ)); // false

        User dean = new User();
        Group all = new Group();
        all.addRole(new AllResourcesRole(Action.ADMINISTER));
        dean.addGroup(all);
        System.out.println(dean.hasMatchingRole("2Y/OOP", Action.ADMINISTER)); // true 
        System.out.println(dean.hasMatchingRole("3Y/ILJ", Action.ADMINISTER)); // true 
        System.out.println(dean.hasMatchingRole("3Y/ILJ", Action.WRITE)); // false 
    }
}
