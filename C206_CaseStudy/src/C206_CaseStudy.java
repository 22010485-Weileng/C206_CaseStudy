import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_CURRENCY_MANAGEMENT = 2;
	private static final int DELETE_CURRENCY = 3;
	private static final int VIEW_ALL_CURRENCIES = 2;
	private static final int ADD_CURRENCY = 1;
	private static final int OPTION_QUIT = 5;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("Tom Lee","T1234567A","Adminstrator"));
		userList.add(new User("Amy Lim","T2985239B","User"));
		
		
		ArrayList<Currency> currencyList = new ArrayList<Currency>();
		currencyList.add(new Currency("MYR","Malaysian Ringgit", 3.40));
		currencyList.add(new Currency("CNY", "Yuan Renminbi", 5.35));
		currencyList.add(new Currency("USD", "US Dollar", 0.75));
		
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		ArrayList<Account> accountList = new ArrayList<Account>();

		int option = 0;
		
		while (option != OPTION_QUIT) {
			
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
			   // Manage users
				C206_CaseStudy.setHeader("Manage users");
				System.out.println("1. Add new user");
				System.out.println("2. View all users");
				System.out.println("3. Delete existing user");
				
				int userManagement = Helper.readInt("Enter option to select to manage users > ");
				
				if (userManagement == 1) {
					// Add a user
					C206_CaseStudy.addUser(userList);
					
					
				} else if (userManagement  == 2) {
					//view all users
					C206_CaseStudy.viewAllUsers(userList);
					
				} else if(userManagement==3) {
					//delete user
					C206_CaseStudy.deleteUser(userList);
					
					
				}else {
					System.out.println("Invalid option.Please try again.");
				}
			
			
			} else if (option == OPTION_CURRENCY_MANAGEMENT) {
				//Manage currency
				C206_CaseStudy.setHeader("Manage currency");
				currencyManagementMenu();
				
				int currencyManagement = Helper.readInt("Enter option to select to manage currency > ");
				
				if (currencyManagement == ADD_CURRENCY) {
					// Add a currency
					C206_CaseStudy.addCurrency(currencyList);
					
					
				} else if (currencyManagement  == VIEW_ALL_CURRENCIES) {
					//view all currencies
					C206_CaseStudy.viewAllCurrencies(currencyList);
					
				} else if(currencyManagement==DELETE_CURRENCY) {
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

				} else if (option == OPTION_QUIT) {
					System.out.println("Exiting the Money Exchange Management System. Goodbye!");
				} else {
					System.out.println("Invalid option");
			 }
		}
	}

	public static void currencyManagementMenu() {
		System.out.println("1. Add new currency");
		System.out.println("2. View all currencies");
		System.out.println("3. Delete existing currency");
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
	

	private static void addUser(ArrayList<User> userList) {
		  // TODO Auto-generated method stub
		  String user = Helper.readString("Enter username >");
		  String userID = Helper.readString("Enter user ID >");
		  String role = Helper.readString("Enter role >");
		  
		  userList.add(new User(user, userID, role));
		  System.out.println("User is successfully added!");
		}
	private static void viewAllUsers(ArrayList<User> userList) {
		  // TODO Auto-generated method stub
		  
		    String header = String.format("%-15s%-20s%-20s", "Username", "UserID", "Role");
		    
		    System.out.println("");
		    System.out.println(header);
		    
		    for (int i = 0; i<userList.size();i++) {
		      String output = String.format("%-15s%-20s%-20s", userList.get(i).getUsername(), userList.get(i).getUserID(),userList.get(i).getRole()); 
		      System.out.println(output);
		    }
		      System.out.println("\n");
		}
	 private static void deleteUser(ArrayList<User> userList) {
		  // TODO Auto-generated method stub
		  String username = Helper.readString("Enter username");
		  
		  for (int i = 0; i < userList.size(); i++) {
		    if (userList.get(i).getUsername().equalsIgnoreCase(username)) {
		      userList.get(i).display();
		      char removeuser = Helper.readChar("Confirm to delete this user?(y/n)");
		      if (removeuser == 'y') {
		        userList.remove(i);
		        System.out.println("This user has been deleted");
		      } else if (removeuser == 'n') {
		        System.out.println("This user is not deleted");
		      }
		      
		    }}}
	 

	  public static void addCurrency(ArrayList<Currency> currencyList) {
		  //ask administrator to input currency details to add
		  String currencyCode = Helper.readString("Enter the currency code to add: ");
		  String currencyName = Helper.readString("Enter the currency name to add: ");
		  double exchangeRate = Helper.readDouble("Enter the exchange rate to add: ");
		  // Check if the currency code already exists in the currencyList
		  if (isCurrencyCodeExists(currencyCode, currencyList)) {
		        System.out.println("A currency with the same code already exists.");
		        
		  } else {
			  // Create and add the new currency to the list
		      Currency newCurrency = new Currency(currencyCode, currencyName, exchangeRate);
		      currencyList.add(newCurrency);
		      System.out.println("Currency added successfully!");

	  }

		  }
	         
		    
	  public static boolean isCurrencyCodeExists(String currencyCode, ArrayList<Currency> currencyList) {
			
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

				String currencyCode = currencyList.get(i).getCurrencyCode();
				String currencyName = currencyList.get(i).getCurrencyName();
				double exchangeRate = currencyList.get(i).getExchangeRate();
				output += String.format(" %-20s %-20s %-10.2f\n", currencyCode,
						currencyName,exchangeRate);
					
				
			}
			return output;
		}
	  
	  public static void viewAllCurrencies(ArrayList<Currency> currencyList) {
			// TODO Auto-generated method stub
				C206_CaseStudy.setHeader("CURRENCIES LIST");
				String output = String.format(" %-20s %-20s %-10s\n","CURRENCY CODE", "CURRENCY NAME", "EXCHANGE RATE");
				output += retrieveAllCurrency(currencyList);
				System.out.println(output);
			}
	  
	  public static boolean deleteCurrency(ArrayList<Currency> currencyList) {
		    C206_CaseStudy.viewAllCurrencies(currencyList);
		    String currencyCodeToDelete = Helper.readString("Enter the currency code to delete: ");

		    // Find the currency to delete and remove it from the list
		    Currency currencyToDelete = null;
		    for (Currency c : currencyList) {
		        if (c.getCurrencyCode().equalsIgnoreCase(currencyCodeToDelete)) {
		            currencyToDelete = c;
		            break;
		        }
		    }

		    if (currencyToDelete != null) {
		        String currencyCode = currencyToDelete.getCurrencyCode();
				String currencyName = currencyToDelete.getCurrencyName();
				double exchangeRate = currencyToDelete.getExchangeRate();
				String confirmation = Helper.readString("Are you sure you want to delete " + currencyCode
		            + " - " + currencyName + "-" + exchangeRate + "? (Y/N): ");

		        if (confirmation.equalsIgnoreCase("y")) {
		            currencyList.remove(currencyToDelete);
		            System.out.println("A currency has been deleted.");
		        } else {
		            System.out.println("Currency deletion canceled.");
		        }
		    } else {
		        System.out.println("Currency code not found. Currency deletion canceled.");
		    }
			return false;
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

			public static void addCurrency(ArrayList<Currency> currencyList, Currency cur1) {
				// TODO Auto-generated method stub
				
			}

			public static boolean deleteCurrency(ArrayList<Currency> currencyList, String string) {
				// TODO Auto-generated method stub
				return false;
			}
		}


			
				    
				



			


	  
		  	  
	
	
	
	
	

	







     										