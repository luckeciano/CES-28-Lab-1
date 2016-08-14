
//This interface was implemented because of the necessity of
//returning Money or MoneyBag in a single method. For this, we create
//a Factory Pattern, which designs a interface called MoneyFactory that
//controls the creation of a Money or MoneyBag object

public interface MoneyFactory {
	
	public static MoneyFactory choose(int type) {
		if (type == 1) {
			Money money = new Money();
			return money;
		}
		else if (type == 2) {
			MoneyBag moneyBag = new MoneyBag();
			return moneyBag;
		}
		else return null;
	}
}



