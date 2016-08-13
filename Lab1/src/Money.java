class Money {
	private int _amount;
	private String _currency;
	
	public Money() {
	}
	public Money add(Money m) {
		Money money = new Money();
		money.setAmount(this.getAmount() + m.getAmount());
		money.setCurrency(this.getCurrency());
		return money;
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