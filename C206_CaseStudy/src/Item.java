public class Item {

	
	private String name;
	private String description;
	private double minimumBid;
	private String startDate;
	private String endDate;
	private int increment;
	
	// test commit 
	
	public Item(String name, String description, double minimumBid, String startDate, String endDate, int increment) {
		this.name = name;
		this.description = description;
		this.minimumBid = minimumBid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.increment = increment;
	}

	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", minimumBid=" + minimumBid + ", startDate=" + startDate + ", endDate=" + endDate 
				+ ", increment=" + increment + "]";
	}

	public String getName() { return name; }
	
	public String getDescription() { return description; }
	
	public double getMinimumBid() {	return minimumBid; }
	
	public String getStartDate() { return startDate; }
	
	public String getEndDate() { return endDate; }
	
	public int getIncrement() { return increment; }
	
	public void setName(String name) { this.name = name; }
	
	public void setDescription(String description) { this.description = description; }
	
	public void setMinimumBid(double minimumBid) { this.minimumBid = minimumBid; }
	
	public void setStartDate(String startDate) { this.startDate = startDate; }
	
	public void setEndDate(String endDate) { this.endDate = endDate; }
	
	public void setIncrement(int increment) { this.increment = increment; }
	
	
}
