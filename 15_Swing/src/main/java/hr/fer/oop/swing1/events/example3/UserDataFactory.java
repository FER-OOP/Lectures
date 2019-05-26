package hr.fer.oop.swing1.events.example3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import hr.fer.oop.swing1.events.example2.UserData;
import hr.fer.oop.swing1.events.example2.UserData.EmailType;

public class UserDataFactory {
  public static Map<String, UserData> getData() {
	Map<String, UserData> data = new LinkedHashMap<>();    

    data.put(UUID.randomUUID().toString(), createUserData("Pero", "Perić", true, EmailType.DAILY, "Unska 3", 10000, "Zagreb"));
    data.put(UUID.randomUUID().toString(), createUserData("Ana", "Štefok", true, EmailType.MONTHLY, "Jadranska 65", 10000, "Zagreb"));
    data.put(UUID.randomUUID().toString(), createUserData("Maja", "Brlek", false, null, "Slavonska 34", 21000, "Split"));
    data.put(UUID.randomUUID().toString(), createUserData("Ivan", "Babić", true, EmailType.WEEKLY, "Zagorska 32", 31000, "Osijek"));
    data.put(UUID.randomUUID().toString(), createUserData("Petra", "Horvat", false, null, "Dubrovačka 212",  51000, "Rijeka"));

    return data;
  }

  private static UserData createUserData(
		  String firstName, String lastName,
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
