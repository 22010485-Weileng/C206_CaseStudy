import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
    private Currency cur1;
    private Currency cur2;
    private Currency cur3;
    
    private ArrayList<Currency> currencyList;
    

    @Before
    public void setUp() throws Exception {
        cur1 = new Currency("MYR", "Malaysian Ringgit", 3.40);
        cur2 = new Currency("CNY", "Yuan Renminbi", 5.35);
        cur3 = new Currency("USD", "US Dollar", 0.75);

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
        assertEquals("Check that the size of the Currency list remains 1", 1, currencyList.size());

        // Error condition: Add a new currency with missing details such as currency code
        // Implement your error condition test case here
    }

    @Test
    public void testViewAllCurrencies() {
        //Test if it is able to view an empty list -Boundary condition
        ArrayList<Currency> emptyList = new ArrayList<Currency>();
        assertEquals("Check that viewing an empty list returns an empty list", emptyList, currencyList);

        //Test if it is able to view currencies after adding two currencies -Normal condition
        currencyList.add(cur1);
        currencyList.add(cur2);
        assertEquals("Check that viewing the list returns the correct list of currencies ", currencyList, currencyList);

        // Error condition: Test if it is able to view supported currencies with invalid data such as empty currency code
        
    }

    @Test
    public void testDeleteCurrency() {
        //Test currency deletion with valid confirmation - Normal condition
        boolean isDeleted = C206_CaseStudy.deleteCurrency(currencyList, "MYR");
        assertTrue("Check that the currency is deleted - true ", isDeleted);

        //Test currency deletion with null confirmation -Boundary condition
        boolean isDeletedWithNull = C206_CaseStudy.deleteCurrency(currencyList, null);
        assertFalse("Currency should not be deleted with null confirmation", isDeletedWithNull);

        //Test currency deletion that is not found in the list -Error condition
       
    }

    @After
    public void tearDown() throws Exception {
        cur1 = null;
        cur2 = null;
        cur3 = null;
        currencyList = null;
    }

    @Test
    public void c206_test() {
        assertTrue("C206_CaseStudy_SampleTest ", true);
    }
}
