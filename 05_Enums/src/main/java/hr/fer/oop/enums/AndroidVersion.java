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

}
