
import java.util.ArrayList;


public class MoneyBag implements MoneyFactory {
	private ArrayList <Money> _moneyList;
	
	public MoneyBag() {
		_moneyList = new ArrayList<Money>();
	}
	
	public MoneyBag(Money...moneys) {
		_moneyList = new ArrayList<Money>();
		for (Money money:moneys) {
			_moneyList.add(money);
		}		
	}
	public ArrayList<Money> getTotalAmount() {
		return _moneyList; 
	}
	public int getSpecificAmount (Money money) {
		for (Money moneyInBag:_moneyList) {
			if (moneyInBag.getCurrency().getCurrencyName() == money.getCurrency().getCurrencyName())
				return moneyInBag.getAmount(); 
		}
		return 0;
	}
	
	public int getMoneyBagSize() {
		return _moneyList.size();
	}
	
	public void setTotalAmount(ArrayList<Money> moneyList) {
		_moneyList = moneyList;
	}
	//set the amount of a specific type of currency
	public void addSpecificAmount(Money money) {
		boolean hasInBag = false;
		for (Money moneyInBag:_moneyList) {
			if (moneyInBag.getCurrency().getCurrencyName() == money.getCurrency().getCurrencyName()) {		
				hasInBag = true;
				moneyInBag.setAmount(moneyInBag.getAmount() + money.getAmount());
			}			
		}
		if (!hasInBag) {
			_moneyList.add(money);
		}
	}
	//verify if exists a specific currency in the money bag
	public boolean hasCurrency (Money money) {
		for (Money moneyInBag: _moneyList) {
			if (moneyInBag.getCurrency().getCurrencyName() == money.getCurrency().getCurrencyName()) {
				return true;
			}
		}
		return false;
	}
	//convert all money in money bag into BRL
	public int convertToBRL() {
		int result = 0;
		for (Money moneyInTheBag: _moneyList) {
			if (moneyInTheBag.getCurrency().getCurrencyName() == "USD")
				result += 3*moneyInTheBag.getAmount();
			else if (moneyInTheBag.getCurrency().getCurrencyName() == "CHF")
				result += 2*moneyInTheBag.getAmount();
			else if (moneyInTheBag.getCurrency().getCurrencyName() == "BRL")
				result += moneyInTheBag.getAmount();
			else if (moneyInTheBag.getCurrency().getCurrencyName() == "EUR")
				result += 4*moneyInTheBag.getAmount();
		}
		return result;
	}
	
	//Application of Money Bag
	public static void main (String[] args) {
		System.out.println("Application of a MoneyBag with multiple currencies:");
		System.out.println("1) Constructing a MoneyBag with 10 USD + 20 CHF");
		Money moneyUSD = new Money(new Currency("USD"));
		moneyUSD.setAmount(10);
		Money moneyCHF = new Money(new Currency("CHF"));
		moneyCHF.setAmount(20);
		MoneyBag moneyBag = new MoneyBag(moneyUSD, moneyCHF);
		for (Money moneyInBag:moneyBag.getTotalAmount()) {
			System.out.println(moneyInBag.getAmount() + " " + moneyInBag.getCurrency().getCurrencyName());
		}
		System.out.println("2) Adding a new amount in USD");
		Money newMoneyUSD = new Money(new Currency("USD"));
		newMoneyUSD.setAmount(20);
		moneyBag.addSpecificAmount(newMoneyUSD);
		System.out.println( moneyBag.getSpecificAmount(newMoneyUSD) + " USD");
		System.out.println("3) Finally, adding a new currency in Money Bag");
		Money newMoneyBRL = new Money(new Currency("BRL"));
		newMoneyBRL.setAmount(15);
		moneyBag.addSpecificAmount(newMoneyBRL);
		for (Money moneyInBag:moneyBag.getTotalAmount()) {
			System.out.println(moneyInBag.getAmount() + " " + moneyInBag.getCurrency().getCurrencyName());
		}
		
	}

}
