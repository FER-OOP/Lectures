package hr.fer.oop.topic11.example3;

import java.util.HashMap;
import java.util.Map;

public final class MemoryDictionary implements Dictionary {
    
    private Map<String,String> pairs;
    
    /**
     * Podrazumijevani konstruktor
     */
    public MemoryDictionary() {  
        pairs = new HashMap<>();
    }
    
    /**
     * Konstruktor koje se mogu predati parovi originalna riječ - prijevod
     * @param originalWord prva originalna riječ
     * @param translatedWord prvi prijevod
     * @param otherPairs ostali parovi originalna riječ - prijevod 
     */
    public MemoryDictionary(String originalWord, String translatedWord, String... otherPairs) {
        this();
        if (otherPairs.length % 2 == 1) {
            throw new IllegalArgumentException("The otherWords should be in pairs");
        }
        
        this.add(originalWord, translatedWord);
        
        for (int i = 0; i < otherPairs.length; i++) {
            this.add(otherPairs[i], otherPairs[++i]);
        }
    }

    @Override
    public void add(String originalWord, String translatedWord) {
        this.pairs.put(originalWord, translatedWord);
    }

    @Override
    public String get(String originalWord) {
        return this.pairs.get(originalWord); 
    }

    @Override
    public int size() {
        return this.pairs.size();
    }  

    @Override
    public void remove(String deletedWord) {
        this.pairs.remove(deletedWord);
    }
}
