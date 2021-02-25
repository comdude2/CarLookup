package net.comdude2.apps.carlookup.main;

/**
 * A Class that gets car details from rapidcarcheck.co.uk
 * Only provide the registration plate.
 * Formula:	https://www.rapidcarcheck.co.uk/results?RegPlate=(PLATE)
 * @author comdude2
 */
public class CarLookup {
	
	//	Link example:
	//	https://www.rapidcarcheck.co.uk/results?RegPlate=L21+LWS
	//	Formula:	https://www.rapidcarcheck.co.uk/results?RegPlate=(PLATE)
	
	public static void main(String[] args) {
		System.out.println("CarLookup Library by comdude2 / Matt Armer");
		if (args != null) {
			if (args.length > 0) {
				CarLookup.lookupAndPrint(args[0]);
			} else {
				CarLookup.lookupAndPrint("L21+LWS");
			}
		} else {
			CarLookup.lookupAndPrint("L21+LWS");
		}
	}
	
	/**
	 * Looks up the car details for a UK registration plate on rapidcarcheck.co.uk
	 * @param reg
	 */
	public static CarDetails lookup(String reg) {
		Page p = PageDownloader.downloadPage("https://www.rapidcarcheck.co.uk/results?RegPlate=" + reg);
		if (p != null) {
			CarDetails cd = new CarDetails(p);
			return cd;
		} else {
			System.out.println("Error getting reg.");
		}
		return null;
	}
	
	/**
	 * Looks up the car details for a UK registration plate on rapidcarcheck.co.uk
	 * @param reg
	 */
	public static void lookupAndPrint(String reg) {
		Page p = PageDownloader.downloadPage("https://www.rapidcarcheck.co.uk/results?RegPlate=" + reg);
		if (p != null) {
			CarDetails cd = new CarDetails(p);
			cd.print();
		} else {
			System.out.println("Error getting reg.");
		}
	}
	
}
