package hr.fer.oop.topic16.example4;

import java.util.HashMap;
import java.util.Map;

public final class MultiWordMemoryDictionary implements MultiWordDictionary {

    private Map<String, String> pairs;

    /**
     * Podrazumijevani konstruktor
     */
    public MultiWordMemoryDictionary() {
        pairs = new HashMap<>();
    }

    /**
     * Konstruktor koje se mogu predati parovi originalna riječ - prijevod
     *
     * @param originalWord prva originalna riječ
     * @param translatedWord prvi prijevod
     * @param otherPairs ostali parovi originalna riječ - prijevod
     */
    public MultiWordMemoryDictionary(String originalWord, String translatedWord, String... otherPairs) {
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
        String translations = this.pairs.get(originalWord);
        if (translations == null) {
            this.pairs.put(originalWord, translatedWord + " ");
        } else if (!translations.contains(translatedWord)) {
            this.pairs.put(originalWord, (translations + translatedWord + " "));
        }
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
    public void remove(String originalWord, String translatedWord) {
        String translations = this.pairs.get(originalWord);
        if (translations.contains(translatedWord)) {
            this.pairs.put(originalWord, translations.replace(translatedWord + " ", ""));
        }
    }

    @Override
    public void remove(String deletedWord) {
        this.pairs.remove(deletedWord);
    }
}
