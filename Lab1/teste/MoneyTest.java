import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {
	@Test
	public void add_AssertTrue(){
		Money money = new Money();
		money.setAmount(10);
		money.setCurrency("RSS");
		assertTrue("OI?",20 == money.add(money).getAmount());
	}
	
	@Test
	public void add_assertEquals(){
		Money money1 = new Money();
		Money money2 = new Money();
		money1.setAmount(10);
		money1.setCurrency("RSS");
		money2.setAmount(0);
		money2.setCurrency("RSS");
		assertEquals(money1.getAmount(),money2.add(money1).getAmount());
	}
}
