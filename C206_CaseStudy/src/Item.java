public class Item {

	
	private String name;
	private String description;
	private double minimumBid;
	private String date;
	private int increment;
	
	
	public Item(String name, String description, double minimumBid, String date, int increment) {
		this.name = name;
		this.description = description;
		this.minimumBid = minimumBid;
		this.date = date;
		this.increment = increment;
	}

	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", minimumBid=" + minimumBid + ", date=" + date
				+ ", increment=" + increment + "]";
	}

	public String getName() { return name; }
	
	public String getDescription() { return description; }
	
	public double getMinimumBid() {	return minimumBid; }
	
	public String getDate() { return date; }
	
	public int getIncrement() { return increment; }
	
	public void setName(String name) { this.name = name; }
	
	public void setDescription(String description) { this.description = description; }
	
	public void setMinimumBid(double minimumBid) { this.minimumBid = minimumBid; }
	
	public void setDate(String date) { this.date = date; }
	
	public void setIncrement(int increment) { this.increment = increment; }
	
	
}
