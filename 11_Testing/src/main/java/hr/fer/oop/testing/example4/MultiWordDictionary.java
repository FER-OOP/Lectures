package hr.fer.oop.testing.example4;

import hr.fer.oop.testing.example3.Dictionary;

public interface MultiWordDictionary extends Dictionary {

    /**
     * Iz rječnika briše prijevod za prevedenu riječ.
     *
     * @param originalWord riječ čiji prijevod treba obrisati
     * @param translatedWord prijevod treba obrisati
     */
    public void remove(String originalWord, String translatedWord);

    /**
     * Iz rječnika briše sve prijevode za prevedenu riječ.
     *
     * @param deletedWord riječ čije prijevode treba obrisati
     */
    @Override
    public void remove(String deletedWord);

    /**
     * Za predanu riječ dohvaća sve njene prijevode iz rječnika.
     *
     * @param originalWord riječ koju treba prevesti
     * @return prijevodi predane riječi
     */
    @Override
    public String get(String originalWord);
}
