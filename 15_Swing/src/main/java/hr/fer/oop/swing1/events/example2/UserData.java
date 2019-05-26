package hr.fer.oop.swing1.events.example2;

public class UserData {
  private String firstName, lastName;
  private boolean receiveEmails;
  private EmailType emailType;
  private String street, city;
  private int postalCode;

  public static enum EmailType {
    WEEKLY, DAILY, MONTHLY;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean isReceiveEmails() {
    return receiveEmails;
  }

  public void setReceiveEmails(boolean receiveEmails) {
    this.receiveEmails = receiveEmails;
  }

  public EmailType getEmailType() {
    return emailType;
  }

  public void setEmailType(EmailType emailType) {
    this.emailType = emailType;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "UserData [firstName=" + firstName + ", lastName=" + lastName
        + ", receiveEmails=" + receiveEmails + ", emailType=" + emailType
        + ", street=" + street + ", city=" + city + ", postalCode="
        + postalCode + "]";
  }

}
