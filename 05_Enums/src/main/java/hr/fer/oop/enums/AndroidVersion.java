package hr.fer.oop.enums;

public enum AndroidVersion {
  MARSHMALLOW("6"),
  NOUGAT("7"),
  OREO("8"),
  PIE("9"),
  ANDROID_10("10"),
  ANDROID_11("11");

  private String version;

  AndroidVersion(String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

// new Java 17 construct (does not require break, and allows multiple values per case)
  public static void printOpinion(AndroidVersion version){
      switch (version){
          case MARSHMALLOW -> System.out.println(" Marshmallow is too old version!");
          case ANDROID_10, ANDROID_11 -> System.out.println(" " + version + " is too new version. Just few phones supports it!!!");
          default -> System.out.println(" " + version + " is OK.");
      }
  }

//	public static void printOpinion(AndroidVersion version) {
//		switch (version) {
//		case MARSHMALLOW:
//			System.out.println("Marshmallow is too old version!");
//			break;
//		case ANDROID_10:
//		case ANDROID_11:
//			System.out.println(" " + version + " is too new version. Just few phones supports it!!!");
//			break;
//		default:
//			System.out.println(" " + version + " is OK.");
//			break;
//		}
//	}
}
