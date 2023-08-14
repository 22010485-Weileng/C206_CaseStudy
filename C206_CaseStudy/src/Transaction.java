public class Transaction {

	private String ID;
	private String customerName;
	private double balance;
	private double amount;
	private String date;
	private String curr;
	private double amountToGet;
<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/22010485-Weileng/C206_CaseStudy.git

<<<<<<< HEAD

	public Transaction(String ID, String customerName,double balance, double amount, String date,
			   String curr, double amountToGet) {
		
=======
	public Transaction(String ID, String customerName,double balance, double amount, String date,
			String curr, double amountToGet) {
>>>>>>> branch 'master' of https://github.com/22010485-Weileng/C206_CaseStudy.git
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

<<<<<<< HEAD
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
	 public double getAmountToGet() {
		  return amountToGet;
		 }
=======
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
>>>>>>> branch 'master' of https://github.com/22010485-Weileng/C206_CaseStudy.git

	public void setAmountToGet(double amountToGet) {
		  this.amountToGet = amountToGet;
}}

		 

		
		 

		 
	

<<<<<<< HEAD
		
=======
	public String getCurr() {
		return curr;
	}
>>>>>>> branch 'master' of https://github.com/22010485-Weileng/C206_CaseStudy.git

<<<<<<< HEAD
=======
	public void setCurr(String curr) {
		this.curr = curr;
	}
>>>>>>> branch 'master' of https://github.com/22010485-Weileng/C206_CaseStudy.git

<<<<<<< HEAD
	

		 


		 	 
		
		 
		 
=======
	public double getAmountToGet() {
		return amountToGet;
	}

	public void setAmountToGet(double amountToGet) {
		this.amountToGet = amountToGet;
	}

}
>>>>>>> branch 'master' of https://github.com/22010485-Weileng/C206_CaseStudy.git
