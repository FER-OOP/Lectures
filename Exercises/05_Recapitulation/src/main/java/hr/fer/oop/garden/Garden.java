package hr.fer.oop.garden;

import hr.fer.oop.garden.plants.Growable;
import hr.fer.oop.garden.plants.Plant;
import hr.fer.oop.garden.plants.Tomato;
import hr.fer.oop.garden.plants.Violet;

/**
 * Task 3
 *
 * You need to create a garden. A garden has two plants: Violets and Tomatoes.
 * Plants first need to be grown properly, meaning that they need to be watered
 * with enough water and in a specific manner, and afterwards need to be
 * fertilized. After being grown, the plants can be plucked. Assume all plants
 * in the garden belong to the same gardener and the gardener intends to keep
 * them.
 *
 * The plants can be watered iteratively with any amount of water. The required
 * amount of water for violets is 2 liters. The Violets can only be watered
 * using a watering can. The required amount of water for tomatoes is 10 liters.
 * The Tomatoes can only be watered using a sprinkler.
 *
 * Both plants need to be fertilized only once.
 *
 * It is only necessary to implement the collection of water per plant. All
 * other functionalities can be simulated by printing to standard out.
 *
 * Zadatak 3
 *
 * Potrebno je napraviti vrt. U vrtu se nalaze dvije biljke: Ljubičice i
 * Rajčice. Biljke je potrebno ispravno uzgojiti, što znači da ih je potrebno
 * zaliti s dovoljno vode i na određeni način. Nakon toga ih je potrebno
 * zagnojiti. Nakon što su biljke ispravno uzgojene, biljke je moguće ubrati.
 * Pretpostavite da sve biljke u vrtu pripadaju jednom vrtlaru te da ih on
 * planira zadržati.
 *
 * Biljke je moguće iterativno zalijevati s proizvoljnom količinom vode. Za
 * ljubičice je potrebno 2 litre vode. Ljubičice je moguće zalijevati samo
 * koristeći kanticu za zalijevanje. Rajčici je potrebno 10 litara vode i treba
 * ju zalijevati prskalicom.
 *
 * Sve je biljke potrebno zagnojiti samo jednom.
 *
 * Implementirajte sakupljanje vode za svaku biljku. Ostale je radnje dovoljno
 * simulirati ispisom na konzolu.
 *
 * @author OOP
 *
 */
public class Garden {
  public static void main(String[] args) {
    // Creating an array of plants
    Plant[] plants = new Plant[2];
    // A violet needs 2 liters of water
    Violet violet = new Violet(2);

    // A tomato needs 10 liters of water
    // Keep in mind - a Tomato is a Plant, and a Plant is a Growable
    Growable tomato = new Tomato(10);

    plants[0] = violet;

    // Be careful, not every Growable is a Plant - we just know this one is!
    // For example, mushrooms can be grown, but are not plants.
    plants[1] = (Plant) tomato;

    System.out.println("Gardener " + Plant.GARDENER + " is grooming the garden");

    for (Plant plant : plants) {
      // Plants can't be plucked immediately
      plant.pluck();
      // We spend some time watering our plants
      plant.water(1);
      plant.water(1);
      // Here we managed to water our Violet, but not our Tomato
      // We fertilize both plants
      plant.fertilize();
      // We succeed in plucking the Violet, but not our Tomato
      plant.pluck();
    }
  }
}
