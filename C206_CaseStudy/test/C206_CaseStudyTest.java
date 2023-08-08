import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Currency cur1;
	private Currency cur2;
	private Currency cur3;
	ArrayList<Currency> currencyList = new ArrayList<Currency>();

	@Before
	public void setUp() throws Exception {
		cur1 = new Currency("MYR","Malaysian Ringgit", 3.40);
		cur2 = new Currency("CNY", "Yuan Renminbi", 5.35);
		cur3 = new Currency("USD", "US Dollar", 0.75);
		
		currencyList= new ArrayList<Currency>();
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
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
