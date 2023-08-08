public class Currency {
	private String currencyCode;
	private String currencyName;
	private double exchangeRate;
	
	public Currency(String currencyCode,String currencyName,double exchangeRate) {

		this.currencyCode=currencyCode;
		this.currencyName= currencyName;
		this.exchangeRate=exchangeRate;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	
	}

	public String getCurrencyName() {
		return currencyName;
	
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	
	

}
