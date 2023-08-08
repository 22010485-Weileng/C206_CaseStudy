public class Transaction {
	
	private String ID; 
	private static String customerFirstName;
	private String customerLastName;
	private double amount;
	private String date;
	private String type;
	
	public Transaction(String ID, String customerFirstName, String customerLastName, double amount, String date, String type) {
		this.ID = ID;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public static String getCustomerFirstName() {
		return customerFirstName;
	}

	public static void setCustomerFirstName(String customerFirstName) {
		Transaction.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}

