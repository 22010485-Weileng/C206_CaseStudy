import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency("MYR","Malaysian Ringgit", 3.40));
		currencyList.add(new Currency("CNY", "Yuan Renminbi", 5.35));
		currencyList.add(new Currency("USD", "US Dollar", 0.75));
		
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		ArrayList<Account> accountList = new ArrayList<Account>();

		int option = 0;
		
		while (option != 12) {
			
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if(option ==1) {
			   // Manage users
				C206_CaseStudy.setHeader("Manage users");
				System.out.println("1. Add new user");
				System.out.println("2. View all users");
				System.out.println("3. Delete existing user");
				
				int userManagement = Helper.readInt("Enter option to select to manage users > ");
				
				if (userManagement == 1) {
					// Add a user
					User usr = inputUser();
					C206_CaseStudy.addUser(userList,usr);
					System.out.println("User added. ");
					
				} else if (userManagement  == 2) {
					//view all users
					C206_CaseStudy.viewAllUsers(userList);
					
				} else if(userManagement==3) {
					//delete user
					User usr = inputUser();
					C206_CaseStudy.deleteUser(userList,usr);
					System.out.println("User deleted. ");
					
				}else {
					System.out.println("Invalid option.Please try again.");
				}
			
			
			} else if (option == 2) {
				//Manage currency
				C206_CaseStudy.setHeader("Manage currency");
				System.out.println("1. Add new currency");
				System.out.println("2. View all currencies");
				System.out.println("3. Delete existing currency");
				
				int currencyManagement = Helper.readInt("Enter option to select to manage currency > ");
				
				if (currencyManagement == 1) {
					// Add a currency
					Currency currency = inputCurrency();
					C206_CaseStudy.addCurrency(currencyList,currency);
					
					
				} else if (currencyManagement  == 2) {
					//view all currencies
					C206_CaseStudy.viewAllCurrencies(currencyList);
					
				} else if(currencyManagement==3) {
					//delete existing currency
					C206_CaseStudy.deleteCurrency(currencyList);
					
					
				}else {
					System.out.println("Invalid option. Please try again.");
				}
				
			 }else if (option == 3) {
				// Manage transactions
				C206_CaseStudy.setHeader("Process transactions");
				System.out.println("1. Add new transaction");
				System.out.println("2. View all transactions");
				System.out.println("3. Delete existing transaction");
				
				int transactionManagement = Helper.readInt("Enter option to select to manage transactions > ");
				
				if (transactionManagement == 1) {
					// Add a transaction
					Transaction transc = inputTransaction();
					C206_CaseStudy.addTransaction(transactionList,transc);
					System.out.println("A transaction is added to the system.");
					
				} else if (transactionManagement == 2) {
					//view all transactions
					C206_CaseStudy.viewAllTransaction(transactionList);
					
				} else if(transactionManagement ==3) {
					//delete existing transaction
					Transaction transc = inputTransaction();
					C206_CaseStudy.deleteTransaction(transactionList,transc);
					System.out.println("A transaction has been deleted.");
					
					
				}else {
					System.out.println("Invalid option. Please try again.");
				}
				
			 }else if (option == 4) {
					// Manage accounts
					C206_CaseStudy.setHeader("Manage accounts");
					System.out.println("1. Add new account");
					System.out.println("2. View all accounts");
					System.out.println("3. Delete existing account");
					
					int accountManagement = Helper.readInt("Enter option to select to manage accounts > ");
					
					if (accountManagement == 1) {
						// Add a account
						Account acc = inputAccount();
						C206_CaseStudy.addAccount(accountList,acc);
						System.out.println("A account is added to the system.");
						
					} else if (accountManagement == 2) {
						//view all accounts
						C206_CaseStudy.viewAllAccounts(accountList);
						
					} else if(accountManagement ==3) {
						//delete existing account
						Account acc = inputAccount();
						C206_CaseStudy.deleteAccount(accountList,acc);
						
						
						
					}else {
						System.out.println("Invalid option. Please try again.");
					}

				} else if (option == 5) {
					System.out.println("Exiting the Money Exchange Management System. Goodbye!");
				} else {
					System.out.println("Invalid option");
			 }
		}
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("Money Exchange Management System");
		System.out.println("1. User Management");
		System.out.println("2. Currency Management");
		System.out.println("3. Transaction Processing");
		System.out.println("4. Account Management");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
}

	private static User inputUser() {
	// TODO Auto-generated method stub
	return null;
}
	private static void addUser(ArrayList<User> userList, User usr) {
	// TODO Auto-generated method stub
	
}
		
	private static void viewAllUsers(ArrayList<User> userList) {
	// TODO Auto-generated method stub
	
}
	private static void deleteUser(ArrayList<User> userList, User usr) {
	// TODO Auto-generated method stub
	
}
	private static Currency inputCurrency() {
	// TODO Auto-generated method stub
		String currencyCode = Helper.readString("Enter currency code > ");
		String currencyName = Helper.readString("Enter currency name > ");
	    double exchangeRate = Helper.readDouble("Enter exchange rate > ");

		Currency currency = new Currency(currencyCode,currencyName,exchangeRate);
		
		return currency;
	
}
	private static void addCurrency(ArrayList<Currency> currencyList, Currency currency) {
	    // Check if the currency code already exists in the currencyList
	    if (isCurrencyCodeExists(currency.getCurrencyCode(), currencyList)) {
	        System.out.println("A currency with the same code already exists.");
	        return;
	    }

	    // Check if the currency code or currency name is empty
	    if (currency.getCurrencyCode().isEmpty() || currency.getCurrencyName().isEmpty()) {
	        System.out.println("Currency code and name cannot be empty.");
	        return;
	    }

	    // If the currency code is unique and not empty, add the currency to the currencyList
	    currencyList.add(currency);
	    System.out.println("Currency added sucessfully!");
	    return;
	}
	   
		  
	private static boolean isCurrencyCodeExists(String currencyCode, ArrayList<Currency> currencyList) {
	    for (Currency currency : currencyList) {
	        if (currency.getCurrencyCode().equalsIgnoreCase(currencyCode)) {
	            return true; // If the currency code exists in the list, return true
	        }
	    }
	    return false; // If the currency code does not exist in the list, return false
	}
	
	public static String retrieveAllCurrency(ArrayList<Currency> currencyList) {
		String output = "";

		for (int i = 0; i < currencyList.size(); i++) {

			output += String.format(" %-20s %-20s %-10.2f\n", currencyList.get(i).getCurrencyCode(),
					currencyList.get(i).getCurrencyName(),currencyList.get(i).getExchangeRate());
				
			
		}
		return output;
	}
	private static void viewAllCurrencies(ArrayList<Currency> currencyList) {
	// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("CURRENCIES LIST");
		String output = String.format(" %-20s %-20s %-10s\n","CURRENCY CODE", "CURRENCY NAME", "EXCHANGE RATE");
		output += retrieveAllCurrency(currencyList);
		System.out.println(output);
	}
	private static void deleteCurrency(ArrayList<Currency> currencyList) {
	    C206_CaseStudy.viewAllCurrencies(currencyList);
	    String currencyCodeToDelete = Helper.readString("Enter the currency code to delete: ");

	    Currency currency = null;
	    for (Currency c : currencyList) {
	        if (c.getCurrencyCode().equalsIgnoreCase(currencyCodeToDelete)) {
	            currency = c;
	            break;
	        }
	    }

	    if (currency != null) {
	        String confirmation = Helper.readString("Are you sure you want to delete " + currency.getCurrencyCode()
            + " - " + currency.getCurrencyName() + "-" + currency.getExchangeRate() + "? (Y/N): ");

	        if (confirmation.equalsIgnoreCase("y")) {
	            currencyList.remove(currency);
	            System.out.println("A currency has been deleted.");
	        } else {
	            System.out.println("Currency deletion canceled.");
	        }
	    } else {
	        System.out.println("Currency code not found. Currency deletion canceled.");
	    }
	}

	

	private static Transaction inputTransaction() {
	// TODO Auto-generated method stub
	return null;
}
	private static void addTransaction(ArrayList<Transaction> transactionList, Transaction transc) {
	// TODO Auto-generated method stub
	
}
	private static void viewAllTransaction(ArrayList<Transaction> transactionList) {
	// TODO Auto-generated method stub
	
}
	private static void deleteTransaction(ArrayList<Transaction> transactionList, Transaction transc) {
	// TODO Auto-generated method stub
	
}

	private static Account inputAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	private static void addAccount(ArrayList<Account> accountList, Account acc) {
	// TODO Auto-generated method stub
	
}

	private static void viewAllAccounts(ArrayList<Account> accountList) {
	// TODO Auto-generated method stub
	
}

	private static void deleteAccount(ArrayList<Account> accountList, Account acc) {
	// TODO Auto-generated method stub
	
}
}


	
		    
		










     										