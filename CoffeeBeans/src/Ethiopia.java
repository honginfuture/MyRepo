public class Ethiopia extends Beans {
	private String type = "Arabica";
	private int altitude = 1931;
	private double price = 195;
	private String region = "Bench Maji";
	private String varietal = "Gesha 1931";
	
	public Ethiopia(String type, int altitude, int price,String region,String varietal) {}



	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setVarietal(int altitude) {
		this.altitude = altitude;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getVarietal() {
		return varietal;
	}

	public void setVarietal(String varietal) {
		this.varietal = varietal;
	}

	public String roast() {
		return "I taste smell of foot!";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}