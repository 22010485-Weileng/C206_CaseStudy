import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User usr1;
	private User usr2;
	
	private ArrayList<User> userList;
    private ArrayList<Currency> currencyList;
    private ArrayList<Transaction> transactionList;
    private ArrayList<Account>  accountList;
    
   
    @Before
    public void setUp() throws Exception {
    	//prepare test data for user management
    	userList = new ArrayList<User>();
    	usr1 = new User("John", "S1234567Z", "user");
    	usr2 = new User("Jack", "S9876543Z", "admin");
        
    	//prepare test data for currency management
        currencyList = new ArrayList<Currency>();
        
        //prepare test data for transaction processing
        transactionList = new ArrayList<Transaction>();
        
        //prepare test data for account management
        accountList = new ArrayList<Account>();
     
     //user Management   
    }
    @Test
    public void testAddUser() {
    	// Test adding a user
    	userList.add(new User("Tom", "S1122334Z", "user"));
        assertEquals("Checking if the user was added", 3, userList.size());
        assertEquals("Checking if the user was added correctly", userList.get(2));
        
        // Test for adding duplicate users
        userList.add(new User("Tom", "S1122334Z", "user"));
        assertEquals("Checking if duplicate user was added", 3, userList.size());
        
        
    }
    @Test
    public void testviewAllUser() {
    	// Test if the list is empty
    	 userList.clear(); // Make sure the list is empty
         String testOutput = "";
         String allUser=  C206_CaseStudy.viewAllUsers(userList);
         
        //Test if the output is empty when the userList is empty
         assertEquals("Test if nothing is displayed for empty userList", testOutput, allUser);
         // Test and check if the list is not empty
         userList.clear(); // Clear the list
         // Add user details to the userList to test
         userList.add(new User("John", "S1234567Z", "user"));
         userList.add(new User("Jack", "S9876543Z", "admin"));
         // Reset testOutput   
         testOutput = ""; 
         
         testOutput += String.format("%-10s %-20s %-10s \n", "John", "S1234567Z", "user");
         testOutput += String.format("%-10s %-20s %-10s \n", "Jack", "S9876543Z", "admin");

         // Test that the details are displayed correctly when userList is not empty
         assertEquals("Test that the display is correct for non-empty userList", testOutput, allUser);
     
         
         
 }
    @Test
    public void testDeleteuser() {
      ArrayList<User> userList = new ArrayList<>();
      userList.add(new User("John", "S1234567Z", "user"));
      
    //Test to delete an existing user in the system
    //Delete by the name of the existing user
       String nameToDelete = "John";
       C206_CaseStudy.deleteUser(userList, nameToDelete); 
       assertEquals("Checking if the user was deleted", 0, userList.size()); 
       
       //Test if the deleted user is still inside the list
       assertFalse("Checking if the deleted user is no longer in the list", 
       userList.contains(new User("John", "S1234567Z", "user")));
       
       //Test another user by adding another user to the list for the test  
       userList.add(new User("Jack", "S9876543Z", "admin"));
       
       
       // Test if it is possible to delete a user that does not exist in the system
       String nonExistingName = "James"; 
       
       C206_CaseStudy.deleteUser(userList, nonExistingName); 
       assertEquals("Checking if the list remains unchanged", 1, userList.size());
 
}
 
    //currency Management
    @Test
    public void testAddCurrency() {
    	//fail("Not yet implemented");
        //Test case 1:Currency list is not null and empty, so that can add a new currency - boundary condition
        assertNotNull("Check if there is valid Currency arraylist to add to", currencyList);
        assertEquals("Test that the Currency arraylist is empty.", 0, currencyList.size());
        
        //Test case 2:Add a currency to an empty list,after adding 1 item, the size of the list is 1- Normal condition
        currencyList.add(new Currency("MYR","Malaysian Ringgit",3.40));
        assertEquals("Check that the size of the Currency list is 1", 1, currencyList.size());
        
        //Test case 3:Error condition: Add a new currency with missing details such as currency code
        Currency missingCurrencyCode = new Currency("", "Korean won", 974.40);
        C206_CaseStudy.addCurrency(currencyList, missingCurrencyCode);
        assertFalse("Test that currency with missing Currency Code is not added to the list.",
        		currencyList.contains(missingCurrencyCode));
        assertEquals("Check that the size of the Currency list remains 1", 1, currencyList.size());
    }

    @Test
    public void testViewAllCurrencies() {
    	//fail("Not yet implemented");
        //Test case 1: Test if it is able to view an empty list -Boundary condition
    	ArrayList<Currency> emptyList = new ArrayList<Currency>();
    	String allCurrencies = C206_CaseStudy.retrieveAllCurrency(emptyList); // Retrieve from empty list
   	    String testOutput = ""; // Expected empty output
   	    assertEquals("Test if viewing an empty list returns an empty list", testOutput, allCurrencies);
        
        //Test if the list of currencies retrieved from the SourceCentre is empty - boundary condition
  		assertEquals("Check that the Currencies list is empty", testOutput, allCurrencies );

        //Test case 2:Test if it is able to view currencies after adding one currency -Normal condition
  		currencyList.add(new Currency("MYR","Malaysian Ringgit",3.40));
  		assertEquals("Test that Currency arraylist size is 1.", 1, currencyList.size());
  		
  	    //Test if the expected output string same as the list of currencies retrieved from the SourceCentre	
        allCurrencies= C206_CaseStudy.retrieveAllCurrency(currencyList);
  		testOutput = String.format("%-20s %-20s %-10.2f\n","MYR","Malaysian Ringgit",3.40);
  
        //Test case 3:Error condition: Test if it is able to view supported currencies with invalid data such as empty currency code
        Currency currency = new Currency("", "Malaysian Ringgit",3.40);
        C206_CaseStudy.addCurrency(currencyList,currency);
        assertFalse("Test if invalid currency is not present in the list", currencyList.contains(currency));
       
    }
    

    @Test
    public void testDeleteCurrency() {
    	//fail("Not yet implemented");
    	//Test case 1: Test if Currency list is not null and empty - boundary condition
    	assertNotNull("Test if there is valid Currency arraylist to add and delete from",currencyList);
    	assertEquals("Test that the Currency arraylist is empty.", 0, currencyList.size());
        
        //Test case 2:Test currency deletion with valid confirmation - Normal condition
        currencyList.add(new Currency("MYR","Malaysian Ringgit",3.40));
        Boolean isDeleted = C206_CaseStudy.deleteCurrency(currencyList, "MYR");
        assertFalse("Test if the currency is not successfully deleted from the list.", isDeleted);

        //Test case 3:Test currency deletion that is not found in the list - Error condition
        boolean isDeletedNotFound = C206_CaseStudy.deleteCurrency(currencyList, "JPY");
        assertFalse("Currency should not be deleted if not found",isDeletedNotFound);
        assertEquals("Check that the list size remains 1", 1, currencyList.size());
    }
    
    // transaction processing
    @Test
    public void testViewAllCurrency() {
    	ArrayList<Transaction> transactionList = new ArrayList<>();
        Transaction Transac1 = (new Transaction("1", "1", 1, 1, "1", "1", 1));
        Transaction Transac2 = (new Transaction("2", "2", 2, 2, "2", "2", 2));

        // Test with empty list
        assertEquals(0, transactionList.size());

        // Test with one transaction in the list
        transactionList.add(Transac1);
        assertEquals(1, transactionList.size());

        // Test with multiple transactions in the list
        transactionList.add(Transac2);
        assertEquals(2, transactionList.size());
       
    }
     

    @Test
    public void testAddTransaction() {
    	 ArrayList<Transaction> transactionList = new ArrayList<>();
         Transaction Transac1 = (new Transaction("1", "1", 1, 1, "1", "1", 1));
         Transaction Transac2 = (new Transaction("2", "2", 2, 2, "2", "2", 2));
         // Test adding Transaction
         transactionList.add(Transac1);
         assertEquals("Test if Transac1 is added to the list", 1, transactionList.size());
         assertTrue("Test if Transac1 is added to the list", transactionList.contains(Transac1));

         // Test adding another transaction
         transactionList.add(Transac2);
         assertEquals("Test if Transac2 is added to the list", 2, transactionList.size());
         assertTrue("Test if Transac2 is added to the list", transactionList.contains(Transac2));

         //Test adding transaction with an existing ID
         Transaction dup = (new Transaction("1", "dup", 1, 1, "dup", "dup", 1));
         transactionList.add(dup);
         assertEquals("Test to see if transaction added is duplicated", dup, transactionList.get(transactionList.size()-1));
        
    }
    
    
    
    // account management
    @Test
    public void testAddAccount_Success() {
    	
        // Arrange
        ArrayList<Account> accountList = new ArrayList<>();
        Account acc = new Account("TestAccount", "test@example.com", "password");

        // Act
        C206_CaseStudy.addAccount(accountList, acc);

        // Assert
        assertEquals(1, accountList.size());
        assertEquals("TestAccount", accountList.get(0).getAccountName()); // Use index 0
    }

    @Test
    public void testAddAccount_DuplicateEmail() {
        // Arrange
        ArrayList<Account> accountList = new ArrayList<>();
        Account existingAccount = new Account("ExistingAccount", "test@example.com", "password");
        accountList.add(existingAccount);

        Account acc = new Account("NewAccount", "test@example.com", "password");

        // Act
        C206_CaseStudy.addAccount(accountList, acc);

        // Assert
        assertEquals(1, accountList.size());
        assertEquals("ExistingAccount", accountList.get(0).getAccountName()); // Use index 0
    }

    @Test
    public void testAddAccount_EmptyEmailOrPassword() {
        // Arrange
        ArrayList<Account> accountList = new ArrayList<>();
        Account acc = new Account("TestAccount", "", "password");

        // Act
        C206_CaseStudy.addAccount(accountList, acc);

        // Assert
        assertEquals(0, accountList.size());
    }


    @After
    public void tearDown() throws Exception {
        currencyList = null;
        transactionList=null;
        accountList=null;
        
    }

    @Test
    public void c206_test() {
        assertTrue("C206_CaseStudy_SampleTest ", true);
    }

}