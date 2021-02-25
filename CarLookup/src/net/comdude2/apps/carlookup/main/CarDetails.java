package net.comdude2.apps.carlookup.main;

import java.util.LinkedList;

/**
 * A holding and converting object for storing car details.
 * @author comdude2
 *
 */

public class CarDetails {
	
	//GENERAL
	private String reg = "Not found";
	private String make = "Not found";
	private String model = "Not found";
	private String colour = "Not found";
	private String vehicleType = "Not found";
	private String bodyStyle = "Not found";
	private String fuelType = "Not found";
	private String engineSize = "Not found";
	
	//STATS
	private String BHP = "Not found";
	private String topSpeed = "Not found";
	private String zeroToSixty = "Not found";
	private String averageYearlyMileage = "Not found";
	
	//OTHER
	private String insuranceGroup = "Not found";
	private String v5cIssueDate = "Not found";
	private String vehicleAge = "Not found";
	private String year = "Not found";
	
	//MOT
	private String motDueDate = "Not found";
	private String motDaysLeft = "Not found";
	private String previousMOTRecords = "Not found";
	private String lastMOTDate = "Not found";
	
	//TAX
	private String taxDueDate = "Not found";
	private String taxDaysLeft = "Not found";
	private String emissions = "Not found";
	private String tax12Months = "Not found";
	private String tax6Months = "Not found";
	
	private static boolean debug = false;
	
	public CarDetails(Page page) {
		this.fromPage(page);
	}
	
	/**
	 * Converts a web page stored in a <Page> into variables containing car details.
	 * @param page
	 */
	public void fromPage(Page page) {
		String d = null;
		for (String line : page.getPageContent()) {
			if (line.contains("<p>Reg:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setReg(d);
				}
			} else if (line.contains("<p>Make:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setMake(d);
				}
			} else if (line.contains("<p>Model:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setModel(d);
				}
			} else if (line.contains("<p>Colour:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setColour(d);
				}
			} else if (line.contains("<p>Vehicle Type:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setVehicleType(d);
				}
			} else if (line.contains("<p>Body Style:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setBodyStyle(d);
				}
			} else if (line.contains("<p>Fuel Type:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setFuelType(d);
				}
			} else if (line.contains("<p>Engine Size:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setEngineSize(d);
				}
			} else if (line.contains("<div class=\"wpb_text_column wpb_content_element \"><div class=\"wpb_wrapper\"><p>BHP:")) {
				LinkedList <String> data = CarDetails.getDataFromGroupedLine(line);
				for (String l : data) {
					if (l.contains("<p>BHP:")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setBHP(d);
						}
					} else if (l.contains("<p>Top Speed:")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setTopSpeed(d);
						}
					} else if (l.contains("<p>0-60 MPH:")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setZeroToSixty(d);
						}
					} else if (l.contains("<p>AVG Yearly Mileage:")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setAverageYearlyMileage(d);
						}
					}
				}
			} else if (line.contains("<div class=\"wpb_text_column wpb_content_element \"><div class=\"wpb_wrapper\"><p>TAX Due Date:")) {
				LinkedList <String> data = CarDetails.getDataFromGroupedLine(line);
				for (String l : data) {
					if (l.contains("<p>TAX Due Date:")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setTaxDueDate(d);
						}
					} else if (l.contains("<p>Days Left:")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setTaxDaysLeft(d);
						}
					} else if (l.contains("Emissions:")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setEmissions(d);
						}
					} else if (l.contains("<p>Tax (12 Months):")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setTax12Months(d);
						}
					} else if (l.contains("<p>Tax (6 Months):")) {
						d = CarDetails.getDataFromLine(l);
						if (d != null) {
							this.setTax6Months(d);
						}
					}
				}
			} else if (line.contains("<p>Insurance Group:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setInsuranceGroup(d);
				}
			} else if (line.contains("<p>V5C Issue Date:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setV5cIssueDate(d);
				}
			} else if (line.contains("<p>Vehicle Age:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setVehicleAge(d);
				}
			} else if (line.contains("<p>Year:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setYear(d);
				}
			} else if (line.contains("<p>MOT Due Date:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setMotDueDate(d);
				}
			} else if (line.contains("<p>Days Left:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setMotDaysLeft(d);
				}
			} else if (line.contains("<p>Previous MOT Records:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setPreviousMOTRecords(d);
				}
			} else if (line.contains("<p>Last MOT Date:")) {
				d = CarDetails.getDataFromLine(line);
				if (d != null) {
					this.setLastMOTDate(d);
				}
			} else if (line.contains("")) {
				
			}
		}
	}
	
	/**
	 * Extract data from HTML lines.
	 * @param line
	 * @return data
	 * TODO make a smarter system that removes anything encapsulated in HTML tags so that the system is more dynamic.
	 */
	private static String getDataFromLine(String line) {
		boolean colonFound = false;
		boolean insideBrackets = false;
		String value = "";
		for (int i = 0; i < line.length(); i++) {
			if (debug) { System.out.println("Char: " + line.substring(i, i + 1));}
			if (line.substring(i, i + 1).equalsIgnoreCase(":")) {
				colonFound = true;
				if (debug) {System.out.println("Colon Found!");}
			} else if (line.substring(i, i + 1).equalsIgnoreCase(">") && colonFound == true) {
				insideBrackets = true;
				if (debug) {System.out.println("Inside Brackets!");}
			} else if ((line.substring(i, i + 1).equalsIgnoreCase("<")) && insideBrackets == true) {
				if (debug) {System.out.println("Value ended!");}
				if (value.length() == 0) {
					debug = false;
					return null;
				} else {
					if (debug) {System.out.println("Value: " + value + " Colon Found: " + colonFound);}
					debug = false;
					return value;
				}
			} else if (insideBrackets == true) {
				value = value + line.substring(i, i + 1);
			}
		}
		debug = false;
		return null;
	}
	
	private static LinkedList <String> getDataFromGroupedLine(String line){
		LinkedList <String> preFilteredLines = new LinkedList <String> ();
		String[] lines = line.split("</div></div>");
		for (String l : lines) {
			String t = null;
			t = l.replace("<div class=\"wpb_text_column wpb_content_element  vc_custom_1570540199484\">", "");
			t = t.replace("<div class=\"wpb_wrapper\">", "");
			t = t.replace("<div class=\"wpb_text_column wpb_content_element \">", "");
			t = t.replace("<div class=\"wpb_text_column wpb_content_element  vc_custom_1560779012742\">", "");
			t = t.replace("<div class=\"vc_empty_space\" style=\"height: 32px\"><span class=\"vc_empty_space_inner\"></span></div><img src=\"https://www.rapidcarcheck.co.uk/wp-content/uploads/2018/08/TAX-F-1.png\" alt=\"\" width=\"345\" height=\"290\" class=\"aligncenter size-full wp-image-708\" />", "");
			if (!t.equalsIgnoreCase("")) {
				preFilteredLines.add(t);
			}
		}
		if (debug) {
			System.out.println("Sub lines:");
			for (String s : preFilteredLines) {
				System.out.println("		" + s);
			}
		}
		if (preFilteredLines.size() > 0) {return preFilteredLines;}
		return null;
	}
	
	public void print() {
		System.out.println("Reg: " + this.reg);
		System.out.println("Make: " + this.make);
		System.out.println("Model: " + this.model);
		System.out.println("Colour: " + this.colour);
		System.out.println("Vehicle Type: " + this.vehicleType);
		System.out.println("Body Style: " + this.bodyStyle);
		System.out.println("Fuel Type: " + this.fuelType);
		System.out.println("Engine Size: " + this.engineSize);
		System.out.println("BHP: " + this.BHP);
		System.out.println("Top Speed: " + this.topSpeed);
		System.out.println("0-60: " + this.zeroToSixty);
		System.out.println("Average Yearly Mileage: " + this.averageYearlyMileage);
		System.out.println("Insurance Group: " + this.insuranceGroup);
		System.out.println("V5C Issue Date: " + this.v5cIssueDate);
		System.out.println("Vehicle Age: " + this.vehicleAge);
		System.out.println("Year: " + this.year);
		System.out.println("MOT Due Date: " + this.motDueDate);
		System.out.println("MOT Days Left: " + this.motDaysLeft);
		System.out.println("Previous MOT Records: " + this.previousMOTRecords);
		System.out.println("Last MOT Date: " + this.lastMOTDate);
		System.out.println("Tax Due Date: " + this.taxDueDate);
		System.out.println("Tax Days Left: " + this.taxDaysLeft);
		System.out.println("Tax 12 Months: " + this.tax12Months);
		System.out.println("Tax 6 Months: " + this.tax6Months);
	}
	
	//GETTER AND SETTER

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public String getBHP() {
		return BHP;
	}

	public void setBHP(String bHP) {
		BHP = bHP;
	}

	public String getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(String topSpeed) {
		this.topSpeed = topSpeed;
	}

	public String getZeroToSixty() {
		return zeroToSixty;
	}

	public void setZeroToSixty(String zeroToSixty) {
		this.zeroToSixty = zeroToSixty;
	}

	public String getAverageYearlyMileage() {
		return averageYearlyMileage;
	}

	public void setAverageYearlyMileage(String averageYearlyMileage) {
		this.averageYearlyMileage = averageYearlyMileage;
	}

	public String getInsuranceGroup() {
		return insuranceGroup;
	}

	public void setInsuranceGroup(String insuranceGroup) {
		this.insuranceGroup = insuranceGroup;
	}

	public String getV5cIssueDate() {
		return v5cIssueDate;
	}

	public void setV5cIssueDate(String v5cIssueDate) {
		this.v5cIssueDate = v5cIssueDate;
	}

	public String getVehicleAge() {
		return vehicleAge;
	}

	public void setVehicleAge(String vehicleAge) {
		this.vehicleAge = vehicleAge;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMotDueDate() {
		return motDueDate;
	}

	public void setMotDueDate(String motDueDate) {
		this.motDueDate = motDueDate;
	}

	public String getMotDaysLeft() {
		return motDaysLeft;
	}

	public void setMotDaysLeft(String motDaysLeft) {
		this.motDaysLeft = motDaysLeft;
	}

	public String getPreviousMOTRecords() {
		return previousMOTRecords;
	}

	public void setPreviousMOTRecords(String previousMOTRecords) {
		this.previousMOTRecords = previousMOTRecords;
	}

	public String getLastMOTDate() {
		return lastMOTDate;
	}

	public void setLastMOTDate(String lastMOTDate) {
		this.lastMOTDate = lastMOTDate;
	}

	public String getTaxDueDate() {
		return taxDueDate;
	}

	public void setTaxDueDate(String taxDueDate) {
		this.taxDueDate = taxDueDate;
	}

	public String getTaxDaysLeft() {
		return taxDaysLeft;
	}

	public void setTaxDaysLeft(String taxDaysLeft) {
		this.taxDaysLeft = taxDaysLeft;
	}

	public String getEmissions() {
		return emissions;
	}

	public void setEmissions(String emissions) {
		this.emissions = emissions;
	}

	public String getTax12Months() {
		return tax12Months;
	}

	public void setTax12Months(String tax12Months) {
		this.tax12Months = tax12Months;
	}

	public String getTax6Months() {
		return tax6Months;
	}

	public void setTax6Months(String tax6Months) {
		this.tax6Months = tax6Months;
	}
	
}
