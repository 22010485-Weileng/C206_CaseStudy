import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
    private Currency cur1;
    private Currency cur2;
  
    
    private ArrayList<Currency> currencyList;
    

    @Before
    public void setUp() throws Exception {
        cur1 = new Currency("MYR", "Malaysian Ringgit", 3.40);
        cur2 = new Currency("CNY", "Yuan Renminbi", 5.35);

        currencyList = new ArrayList<Currency>();
    }

    @Test
    public void testAddCurrency() {
        //Add a currency to an empty list - Normal condition
        currencyList.add(cur1);
        assertEquals("Check that the size of the Currency list is 1", 1, currencyList.size());
        assertEquals("Check that the added currency is the first currency", cur1, currencyList.get(0));

        //Add a currency that is already in the list -Boundary condition
        // The size of the list remains the same
        currencyList.add(cur1); // Add the same currency again
        assertEquals("Check that the size of the Currency list remains 2", 2, currencyList.size());

        // Error condition: Add a new currency with missing details such as currency code
        Currency missingCurrencyCode = new Currency("", "Korean won",974.40);
        boolean isAdded = currencyList.add(missingCurrencyCode);
        assertFalse("Check that currency with missing code is not added", isAdded);
        assertEquals("Check that the size of the Currency list remains 2", 2, currencyList.size());
    }
        
    

    @Test
    public void testViewAllCurrencies() {
        //Test if it is able to view an empty list -Boundary condition
        ArrayList<Currency> emptyList = new ArrayList<Currency>();
        assertEquals("Test if viewing an empty list returns an empty list", emptyList, currencyList);

        //Test if it is able to view currencies after adding two currencies -Normal condition
        currencyList.add(cur1);
        currencyList.add(cur2);
        assertEquals("Test if viewing the list returns the correct list of currencies ", currencyList, currencyList);

        // Error condition: Test if it is able to view supported currencies with invalid data such as empty currency code
        Currency invalidCurrency = new Currency("", "Korean Won",975.24);
        currencyList.add(invalidCurrency);
        assertFalse("Test if invalid currency is not present in the list", currencyList.contains(invalidCurrency));
    }
    

    @Test
    public void testDeleteCurrency() {
        //Test currency deletion with valid confirmation - Normal condition
    	currencyList.add(cur1); 
        boolean isDeleted = C206_CaseStudy.deleteCurrency(currencyList, "MYR");
        assertTrue("Test if the currency is deleted - true ", isDeleted);

        //Test currency deletion with null confirmation -Boundary condition
        boolean isDeletedWithNull = C206_CaseStudy.deleteCurrency(currencyList, null);
        assertFalse("Currency should not be deleted with null confirmation", isDeletedWithNull);
        assertEquals("Check that the list size remains 2", 2, currencyList.size());

        //Test currency deletion that is not found in the list -Error condition
        boolean isDeletedNotFound = C206_CaseStudy.deleteCurrency(currencyList, "EUR");
        assertFalse("Currency should not be deleted if not found", isDeletedNotFound);
        assertEquals("Check that the list size remains 2", 2, currencyList.size());
       
    }

    @After
    public void tearDown() throws Exception {
        cur1 = null;
        cur2 = null;
        currencyList = null;
    }

    @Test
    public void c206_test() {
        assertTrue("C206_CaseStudy_SampleTest ", true);
    }
}
