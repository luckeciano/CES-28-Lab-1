class Money implements MoneyFactory {
	private int _amount;
	private Currency _currency;
	public Money () {
		
	}
	public Money(Currency currency) {
		setCurrency(currency);
	}
	public MoneyFactory add(Money m) {
		if (this.getCurrency().getCurrencyName() == m.getCurrency().getCurrencyName()) {
			Money money = (Money) MoneyFactory.choose(1);
			money.setAmount(this.getAmount() + m.getAmount());
			money.setCurrency(this.getCurrency());
			return money;
		}
		else {
			MoneyBag moneyBag = (MoneyBag) MoneyFactory.choose(2);
			moneyBag.addSpecificAmount(m);
			moneyBag.addSpecificAmount(this);
			return moneyBag;
		}
	}
	public int getAmount(){ 
		return _amount;
	}
	public void setAmount(int amount){
		this. _amount = amount;
	}
	public Currency getCurrency(){ 
		return _currency;
	}
	public void setCurrency(Currency currency){ 
		this. _currency = currency;
	}

}