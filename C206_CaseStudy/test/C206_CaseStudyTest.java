import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
    private ArrayList<Currency> currencyList;
    
    //currencyManagement
    @Before
    public void setUp() throws Exception {
    	//prepare test data
        currencyList = new ArrayList<Currency>();
           
    }

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
        Currency currency = new Currency("", "Korean Won",974.40);
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
        C206_CaseStudy.deleteCurrency(currencyList, "MYR");    
        assertEquals("Check that the list size is now 1", 1, currencyList.size());
    

        //Test case 3:Test currency deletion that is not found in the list - Error condition
        boolean isDeletedNotFound = C206_CaseStudy.deleteCurrency(currencyList, "JPY");
        assertFalse("Currency should not be deleted if not found",isDeletedNotFound);
        assertEquals("Check that the list size remains 1", 1, currencyList.size());
    }

    @After
    public void tearDown() throws Exception {
        currencyList = null;
    }

    @Test
    public void c206_test() {
        assertTrue("C206_CaseStudy_SampleTest ", true);
    }

}