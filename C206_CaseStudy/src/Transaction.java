public class Transaction {

	private String ID;
	private String customerName;
	private double amount;
	private String date;
	private String type;

	public Transaction(String ID, String customerName, double amount, String date,
			String type) {
		this.ID = ID;
		this.customerName = customerName;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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