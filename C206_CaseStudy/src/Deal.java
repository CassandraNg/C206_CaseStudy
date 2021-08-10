
public class Deal {

	private int dealID;
	private String item;
	private String buyerEmail;
	private String sellerEmail;
	private double price;
	private String closeDate;

	public Deal(int dealID, String item, double price, String buyerEmail, String sellerEmail, String closeDate) {
		this.dealID = dealID;
		this.item = item;
		this.buyerEmail = buyerEmail;
		this.sellerEmail = sellerEmail;
		this.price = price;
		this.closeDate = closeDate;
	}

	public int getDealID() {
		return dealID;
	}

	public void setDealID(int dealID) {
		this.dealID = dealID;
	}

	public String getItem() {
		return item;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public double getPrice() {
		return price;
	}

	public String getCloseDate() {
		return closeDate;
	}

	
	
}

