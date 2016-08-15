
public class Currency {
	private String _currency;
	public Currency(){
	}
	public Currency (String type){
		this._currency = type;
	}
	public void setCurrencyName(String currency){ 
		this._currency = currency;
	}
	public String getCurrencyName(){ 
		return _currency;
	}

}
