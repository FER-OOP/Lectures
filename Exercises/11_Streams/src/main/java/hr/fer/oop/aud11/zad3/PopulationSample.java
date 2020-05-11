package hr.fer.oop.aud11.zad3;

public class PopulationSample {

    private String fileName;
    private String gender;
    private Integer age;

    public PopulationSample(String fileName, String gender, int age) {
        this.fileName = fileName;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("PopulationSample(Name: %s, Age: %s, Gender: %s)", this.fileName, this.age, this.gender);
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getGender() {
        return this.gender;
    }

    public Integer getAge() {
        return this.age;
    }
}
