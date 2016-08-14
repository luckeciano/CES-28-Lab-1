
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



