package hr.fer.oop.topic11.example3;

public interface Dictionary {
    /**
     * U rječnik pohranjuje par originalna riječ - prijevod.
     * @param originalWord riječ koju treba prevesti
     * @param translatedWord prijevod
     */
    public void add(String originalWord, String translatedWord);
    
    /**
     * Iz rječnika briše prijevod za prevedenu riječ.
     * @param deletedWord riječ čiji prijevod treba obrisati
     */
    public void remove(String deletedWord);
    
    /**
     * Za predanu riječ dohvaća njen prijevod iz rječnika.
     * @param originalWord riječ koju treba prevesti
     * @return prijevod predane riječi
     */
    public String get(String originalWord);
    
    /**
     * Vraća broj riječi koje imaju pohranjen prijevod u rječniku.
     * @return broj riječi u rječniku
     */
    public int size();    
}
