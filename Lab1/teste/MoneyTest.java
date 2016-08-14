import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {
	@Test
	public void WhenAddsThenSumAmount_AssertTrue(){
		Money money = new Money();
		money.setAmount(10);
		money.setCurrency("BRL");
		assertTrue(20 == ((Money) money.add(money)).getAmount());
	}
	
	@Test
	public void WhenAddsThenSumAmount_assertEquals(){
		Money money1 = new Money();
		Money money2 = new Money();
		money1.setAmount(10);
		money1.setCurrency("BRL");
		money2.setAmount(0);
		money2.setCurrency("BRL");
		Money moneyFinal = (Money) money2.add(money1);
		assertEquals(money1.getAmount(), moneyFinal.getAmount());
	}
	
	@Test
	public void WhenAddsSameCurrencyThenReturnsMoney() {
		Money money1 = new Money();
		Money money2 = new Money();
		money1.setAmount(10);
		money1.setCurrency("BRL");
		money2.setAmount(0);
		money2.setCurrency("BRL");
		assertEquals (money2.add(money1).getClass().getName(), "Money");
	}
	
	@Test
	public void WhenAddsDifferentCurrenciesThenReturnsMoneyBag() {
		Money money1 = new Money();
		Money money2 = new Money();
		money1.setAmount(10);
		money1.setCurrency("BRL");
		money2.setAmount(0);
		money2.setCurrency("USD");
		assertEquals (money2.add(money1).getClass().getName(), "MoneyBag");
	}
	
	
}
