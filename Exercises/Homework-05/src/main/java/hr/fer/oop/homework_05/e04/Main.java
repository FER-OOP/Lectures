package hr.fer.oop.homework_05.e04;

public class Main {

	public static void main(String[] args) {
		
		Computer c = new Desktop("HP Pavilion", "HP", "FreeDOS", 52);
		Desktop d = new Desktop("Alienware R10", "Dell", "Linux", 45);
		Laptop l = new Laptop("Legion 7", "Lenovo", "Windows", 80, 2.25);
		Computer n = new Netbook("Ideapad S12", "Lenovo", "Windows", 50, 1.55);		
		
		PortableDevice[] devices = new PortableDevice[3];
		
		devices[0] = l;
		devices[1] = (Netbook)n; //Zašto ovdje treba cast? Zašto ne mora biti cast na PortableDevice?
		//devices[2] = (PortableDevice) c; //A ovdje? Što æe se dogoditi ako pokrenemo program?		
		devices[2] = new Mp3Player("iPod touch", "Apple", 20, 8192);
		
		for (PortableDevice pd : devices) {
			System.out.println(pd.getModel() + " : " + pd.getBatteryCapacity());
			//System.out.println(pd.getManufacturer()); Zašto ovo ne radi?
		}
	}

}
