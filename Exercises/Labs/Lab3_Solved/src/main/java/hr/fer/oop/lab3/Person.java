package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;

/**
 * TODO: Document this class...
 */
public abstract class Person {
    private String name;
    private String country;
    private int emotion = Constants.DEFAULT_EMOTION;

    protected Person(String name, String country) {
    	this(name, country, Constants.DEFAULT_EMOTION);
    }
    
    protected Person(String name, String country, int emotion) {
        this.name = name;
        this.country = country;
        setEmotion(emotion);
    }

    public final String getName() {
        return name;
    }

    public final String getCountry() {
        return country;
    }

    public final int getEmotion() {
        return emotion;
    }

    public final void setEmotion(int emotion) {
        if(emotion>=Constants.MIN_EMOTION && emotion<=Constants.MAX_EMOTION)
            this.emotion = emotion;
        else {
        	System.err.println("Emotion is out of range! :(");        	
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o instanceof Person) {
        	Person person = (Person) o;
            return person.country.equals(this.country) && person.name.equals(this.name);
        }
        else {
        	return false;
        }                
    }   
}
