class Money implements MoneyFactory {
	private int _amount;
	private String _currency;
	
	public Money() {
	}
	public MoneyFactory add(Money m) {
		if (this.getCurrency() == m.getCurrency()) {
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
	public String getCurrency(){ 
		return _currency;
	}
	public void setCurrency(String currency){ 
		this. _currency = currency;
	}

}