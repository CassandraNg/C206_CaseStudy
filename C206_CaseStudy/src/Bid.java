
public class Bid {
	private int id;
	private String name;
	private String sellerEmail;
	private String buyerEmail;
	private String endDate;
	private int price;
	
	public Bid(int id, String name, String sellerEmail, String buyerEmail, String endDate, int price) {
		this.id = id;
		this.name = name;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.endDate = endDate;
		this.price = price;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}


