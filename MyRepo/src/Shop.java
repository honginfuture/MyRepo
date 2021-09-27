
public class Shop {
	public String sName;
	public String badge;
	public String promo;
	public int ShopCount = 0;

	public Shop(String sName, String promo, String badge) {
		this.sName = sName;
		this.promo = promo;
		this.badge = badge;
		ShopCount++;
	}

//	public Product(String pName, String promotion) {
//		this.name = pName;
//
//		this.disPrice = disPrice;
//		productCount++;
//	}

}
