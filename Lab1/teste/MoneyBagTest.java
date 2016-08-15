import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagTest {
	private Money moneyOne, moneyTwo, moneyThree;
	private MoneyBag moneyBag;

	@Before
	public void setUp() {
		moneyOne = new Money(new Currency("USD"));
		moneyTwo = new Money(new Currency("CHF"));
		moneyThree = new Money(new Currency("EUR"));
		moneyOne.setAmount(10);
		moneyTwo.setAmount(20);
		moneyThree.setAmount(15);		
		moneyBag = new MoneyBag(moneyOne, moneyTwo, moneyThree);
	}
	
	@Test
	public void WhenCreatesThenConstructsEmptyList() {
		MoneyBag emptyMoneyBag = new MoneyBag();
		assertEquals(0,emptyMoneyBag.getTotalAmount().size());
	}
	
	@Test
	public void WhenCreatesWithMoneyThenConstructsNonEmptyList() {
		assertEquals(3,moneyBag.getTotalAmount().size());
		
	}
	
	@Test
	public void WhenHasThisCurrencyInBag() {
		assertTrue(moneyBag.hasCurrency(moneyOne));
		assertTrue(moneyBag.hasCurrency(moneyTwo));
		assertTrue(moneyBag.hasCurrency(moneyThree));
	}
	
	@Test
	public void WhenDontHaveThisCurrencyInBag() {
		Money money = new Money();
		money.setAmount(100);
		money.setCurrency(new Currency("BRL"));
		assertFalse(moneyBag.hasCurrency(money));
	}
	
	@Test
	public void WhenAddCurrencyAlreadInBagThenSetsItsAmount() {
		Money money = new Money();
		money.setAmount(100);
		money.setCurrency(new Currency("USD"));
		moneyBag.addSpecificAmount(money);
		assertEquals(110,moneyBag.getSpecificAmount(money));
	}
	
	@Test
	public void WhenAddCurrencyNotInBagThenAddsToList() {
		int previousMoneyBagSize = moneyBag.getMoneyBagSize();
		Money money = new Money();
		money.setAmount(100);
		money.setCurrency(new Currency("BRL"));		
		moneyBag.addSpecificAmount(money);
		assertEquals (100, moneyBag.getSpecificAmount(money));
		assertEquals(moneyBag.getMoneyBagSize(),previousMoneyBagSize + 1);
	}
	
	@Test
	public void WhenConvertToBRLThenShowsAmountInBRL() {
		assertEquals (130, moneyBag.convertToBRL());
	}

}
