public class Transaction {

	private String ID;
	private String customerName;
	private double balance;
	private double amount;
	private String date;
	private String curr;
	private double amountToGet;


	public Transaction(String ID, String customerName,double balance, double amount, String date,
			   String curr, double amountToGet) {
		
		this.ID = ID;
		this.customerName = customerName;
		this.balance = balance;
		this.amount = amount;
		this.date = date;
		this.curr = curr;
		this.amountToGet = amountToGet;
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
	 public double getBalance() {
		  return balance;
		 }
	 public void setBalance(double balance) {
		  this.balance = balance;
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
	 public String getCurr() {
		  return curr;
		 }
	 public void setCurr(String curr) {
		  this.curr = curr;
		 }
	 public void setAmountToGet(double amountToGet) {
		this.amountToGet = amountToGet;
	}
	public double getAmountToGet() {
		  return amountToGet;
		 }
}
	
	




		 

		
		 

		 
	


	

		 


		 	 
		
		 
		 
