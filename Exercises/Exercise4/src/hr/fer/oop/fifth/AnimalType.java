package hr.fer.oop.fifth;

/**
 * @author OOP
 */
public enum AnimalType {
	EARTH{

		@Override
		public AnimalType winner(AnimalType enemy) {
			if(enemy == SEA) return SEA;
			else return EARTH;
		}
	},
	SEA{

		@Override
		public AnimalType winner(AnimalType enemy) {
			if(enemy == AIR) return AIR;
			else return SEA;
		}
		
	},
	AIR{

		@Override
		public AnimalType winner(AnimalType enemy) {
			if(enemy == EARTH) return EARTH;
			else return AIR;
		}
		
	};

	public abstract AnimalType winner(AnimalType enemy);
}
