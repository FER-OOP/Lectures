package hr.fer.oop.generics.toys;

import hr.fer.oop.generics.list.ParametrizedArrayList;

/**
 * Task 3
 * 
 * Ivan has a son Marko that needs to clean up his messy playroom. In his playroom, Marko has two
 * type of toys, cars and teddy bears. Ivan gave Marko plastic bags and card boxes to put his toys
 * in them. Marko has one rule: not to mix toy types in the same plastic bag or card box. Once he
 * puts a car in a plastic bag or card box, he needs to fill it with cars.
 * Each plastic bag and card box has its own capacity in cm3 (cubic centimeters), as each toy has
 * its own volume in cm3. Containers cannot be overfilled, i.e., if a toy exceeds the capacity of
 * the container, it must be put into another one.
 * 
 * Use ParametrizedArrayList created in task 1.
 * 
 * Zadatak 3
 * 
 * Ivan ima sina Marka koji treba pospremiti sobu u kojoj se igra. U igraonici, Marko ima dva tipa
 * igračaka: autiće i medeke. Ivan je dao Marku plastične vrećice i kartonske kutije kako bi pospremio
 * svoje igračke, uz jedno pravilo: svaka plastična vrećica ili kartonska kutija mora sadržavati samo
 * jedan tip igračaka. Jednom kada je u vrećicu ili kutiju stavljen autić, ta vrećica ili kutija
 * mora biti do kraja napunjena autićima.
 * Svaka plastična vrećica i kartonska kutija ima svoj volumni kapacitet izražen u kubnim centimetrima.
 * Svaka igračka ima svoju veličinu izraženu isto u kubnim centimetrima. Vrećice i kutije ne smiju
 * biti prepunjene, to jest ako igračka ne stane u vrećicu ili kutiju, mora se spremiti u drugu, u
 * kojoj još ima slobodnog mjesta.
 * 
 * Koristiti ParametrizedArrayList implementiran u zadatku 1.
 * 
 * @author Dalibor Krleža
 *
 */

public class RoomCleanUp {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		ParametrizedArrayList<PlasticBag> bags=new ParametrizedArrayList<PlasticBag>();
		ParametrizedArrayList<CardBox> boxes=new ParametrizedArrayList<CardBox>();
		
		try {
			PlasticBag<CarToy> bag1=new PlasticBag<CarToy>();
			CarToy car1=new CarToy(500,"The red car");
			bag1.addToy(car1);
			CarToy car2=new CarToy(1500,"The bulldozer");
			bag1.addToy(car2);
			bags.add(bag1);
			
			PlasticBag<CarToy> bag2=new PlasticBag<CarToy>();
			CarToy car3=new CarToy(100,"The racer");
			bag2.addToy(car3);
			bags.add(bag2);
			
			CardBox<TeddyBearToy> box1=new CardBox<TeddyBearToy>();
			TeddyBearToy bear1=new TeddyBearToy(15000,"Teddy with blue eyes");
			box1.addToy(bear1);
			TeddyBearToy bear2=new TeddyBearToy(7000,"Small teddy");
			box1.addToy(bear2);
			TeddyBearToy bear3=new TeddyBearToy(22000,"Big brown teddy missing one ear");
			box1.addToy(bear3);
			boxes.add(box1);
			
			System.out.println(bags);
			System.out.println(boxes);
		
			TeddyBearToy doesntFit=new TeddyBearToy(22000,"Too big teddy :(");
			box1.addToy(doesntFit);
		} catch (TooLittleSpace e) {
			e.printStackTrace();
		}
	}
}
