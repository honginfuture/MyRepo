
public class Product {
	public String name;
	public double price;
	public double disPrice;
	public String promotion;
	public int productCount = 0;

	public Product(String pName, double pPrice) {
		this.name = pName;
		this.price = pPrice;
		this.disPrice = disPrice;
		productCount++;
	}

	public Product(String pName, String promotion) {
		this.name = pName;

		this.disPrice = disPrice;
		productCount++;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public void setPrice(double pPrice) {
		this.price = pPrice;
	}

	public void setdisPrice(double disPrice) {
		this.disPrice = disPrice;
	}
}
