package hr.fer.oop.swing.example5;

import java.util.LinkedList;
import java.util.List;

import hr.fer.oop.swing.example4.UserData;
import hr.fer.oop.swing.example4.UserData.EmailType;

public class UserDataFactory {
  public static List<UserData> getData() {
    List<UserData> data = new LinkedList<UserData>();

    data.add(createUserData("Pero", "Perić", true, EmailType.DAILY, "Unska 3",
        10000, "Zagreb"));
    data.add(createUserData("Ana", "Štefok", true, EmailType.MONTHLY,
        "Jadranska 65", 10000, "Zagreb"));
    data.add(createUserData("Maja", "Brlek", false, null, "Slavonska 34",
        21000, "Split"));
    data.add(createUserData("Ivan", "Babić", true, EmailType.WEEKLY,
        "Zagorska 32", 31000, "Osijek"));
    data.add(createUserData("Petra", "Horvat", false, null, "Dubrovačka 212",
        51000, "Rijeka"));

    return data;
  }

  private static UserData createUserData(String firstName, String lastName,
      boolean receiveEmails, EmailType emailType, String street,
      int postalCode, String city) {
    UserData userData = new UserData();

    userData.setFirstName(firstName);
    userData.setLastName(lastName);
    userData.setReceiveEmails(receiveEmails);
    if (receiveEmails) {
      userData.setEmailType(emailType);
    }
    userData.setStreet(street);
    userData.setPostalCode(postalCode);
    userData.setCity(city);

    return userData;
  }
}
