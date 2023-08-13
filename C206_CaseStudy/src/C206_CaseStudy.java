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
		
		ArrayList<Transaction> TransactionList = new ArrayList<Transaction>();
		
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
			} else if (option == 3) {
				
				// Manage transactions
				C206_CaseStudy.setHeader("Process transactions");
				
				int transactionOption = 0;
				
				while (transactionOption != 6) {
				 
				     C206_CaseStudy.transactionMenu();
				     transactionOption = Helper.readInt("Enter an option > ");

				     if (transactionOption == 1) {
				    	 C206_CaseStudy.viewTransactions(TransactionList); 
				        
				     } else if (transactionOption == 2) {
				    	 
				    	 C206_CaseStudy.setHeader("Add transaction");
					     C206_CaseStudy.addTransaction(TransactionList);
				     				      
				     } else if (transactionOption == 3) {
				    	 C206_CaseStudy.setHeader("Delete transaction");
					     C206_CaseStudy.deleteTransaction(TransactionList);
				     
				     } else if (transactionOption == 4) {
				    	 C206_CaseStudy.setHeader("Update transaction");
					     C206_CaseStudy.updateTransaction(TransactionList);
				     
				     } else if (transactionOption == 5) {
				    	 C206_CaseStudy.setHeader("Search transaction");
					     C206_CaseStudy.searchTransaction(TransactionList);
				   
				     
				     } else if (transactionOption == 6) {
				    	 System.out.println("Bye! ");
					     C206_CaseStudy.menu();
					     option = Helper.readInt("Enter an option > ");
				     
				      
				     } else {
				    	 System.out.println("Invalid Option");
				     
				      

				     }

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
		
	  
	  public static void transactionMenu() {
			System.out.println("1. Display Transaction");
			System.out.println("2. Add Transaction");
			System.out.println("3. Delete Transaction");
			System.out.println("4. Quit");
			Helper.line(80, "-");
		}

		//View all transactions
		public static void viewTransactions(ArrayList<Transaction> TransactionList) {
			
			Helper.line(80, "=");
			System.out.println("TRANSACTIONS");
			Helper.line(80, "=");
			String output = String.format("%-5s %-15s %-12s %-12s %-8s\n","ID", "Name", "Amount", "Date", "Type" );
			
			for (int i = 0; i < TransactionList.size(); i++) {
		    output += String.format("%-5s %-15s %-12.2f %-12s %-8s\n", TransactionList.get(i).getID(), TransactionList.get(i).getCustomerName(), TransactionList.get(i).getAmount(), TransactionList.get(i).getDate(), TransactionList.get(i).getType());
	}
		System.out.println(output);	
	}

		

		//Add new transaction
		public static void addTransaction(ArrayList<Transaction> TransactionList) {
			String ID = Helper.readString("Enter resume ID: ");
			String Name = Helper.readString("Enter name: ");
			double amount = Helper.readDouble("Enter amount: ");
			String date = Helper.readString("Enter Date: ");
			String type = Helper.readString("Enter transaction type details: ");

			Transaction addTransaction = new Transaction(ID, Name, amount, date, type);
			TransactionList.add(addTransaction);
			System.out.println("Transaction added successfully!");
		}

		//Delete existing transaction
		public static void deleteTransaction(ArrayList<Transaction> TransactionList) {
			String del = Helper.readString("Enter the resume ID you want to delete: ");
			Transaction transactionToDelete = null;
			for (Transaction transaction : TransactionList) {
				if (transaction.getID().equals(ID)) {
					transactionToDelete = transaction;
					break;
				}
			}

			if (transactionToDelete != null) {
				TransactionList.remove(transactionToDelete);
				System.out.println("Resume with ID " + del + " deleted successfully!");
			} else {
				System.out.println("No resume found with the given ID!");
			}
	}

		// Update existing transaction
		public static void updateTransaction(ArrayList<Transaction> TransactionList) {
			String upd = Helper.readString("Enter the resume ID you want to update >");
			for (int i = 0; i < TransactionList.size(); i++) {
				if (TransactionList.get(i).getID().equals(upd)) {
					tUpdateMenu();
					int opt = Helper.readInt("Select an option(1-8) > ");
					
						if (opt == 1) {
							String updID = Helper.readString("Enter new ID >");
							TransactionList.get(i).setID(updID);
							System.out.println("ID successfully updated to " + updID);
							
						} else if (opt == 2) {
							String updName = Helper.readString("Enter new name > ");
							TransactionList.get(i).setCustomerName(updName);
							System.out.println("Name successfully updated to " + updName);
							
						} else if (opt == 3) {
							int updBal = Helper.readInt("Enter new balance > ");
							TransactionList.get(i).setBalance(updBal);
							System.out.println("Balance successfully updated to " + updBal);
							
						} else if (opt == 4) {
							int updAmt = Helper.readInt("Enter new amount > ");
							TransactionList.get(i).setAmount(updAmt);
							System.out.println("Amount successfully updated to " + updAmt);
							
						} else if (opt == 5) {
							String updDate = Helper.readString("Enter new Date >");
							TransactionList.get(i).setDate(updDate);
							System.out.println("Date successfully updated to " + updDate);
							
						} else if (opt == 6) {
							String updCurr = Helper.readString("Enter new currency >");
							TransactionList.get(i).setCurr(updCurr);
							System.out.println("Currency type updated to " + updCurr);
							
						} else if (opt == 7) {
							int updATG = Helper.readInt("Enter new amount to get > ");
							TransactionList.get(i).setAmountToGet(updATG);
							System.out.println("Amount to get successfully updated to " + updATG);
							
						} else if (opt == 8) {
							break;
							
						} 
						
					} else {
						System.out.println("Transaction ID not found!");
					}
				}
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


			
				    
				



			


	  
		  	  
	
	
	
	
	

	







     										
