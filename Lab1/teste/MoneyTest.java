import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	private Money money1, money2;
	
	@Before
	public void setUp(){
		money1 = new Money(new Currency("BRL"));
		money2 = new Money(new Currency("BRL"));
		money1.setAmount(10);
		money2.setAmount(5);
	}	
	
	
	@Test
	public void WhenAddsThenSumAmountAssertTrue(){
		assertTrue(((Money) money1.add(money2)).getAmount() == 15);
	}
	
	@Test
	public void WhenAddsThenSumAmountAssertEquals(){
		Money moneyFinal = (Money) money2.add(money1);
		assertEquals(15, moneyFinal.getAmount());
	}
	
	@Test
	public void WhenAddsSameCurrencyThenReturnsMoney() {
		assertEquals (money2.add(money1).getClass().getName(), "Money");
	}
	
	@Test
	public void WhenAddsDifferentCurrenciesThenReturnsMoneyBag() {
		Money money = new Money();
		money.setAmount(20);
		money2.setCurrency(new Currency("USD"));
		assertEquals (money2.add(money1).getClass().getName(), "MoneyBag");
	}
	
	
}
