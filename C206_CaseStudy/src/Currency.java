public class Currency {
	private String number;
	private String currencyCode;
	private String currencyName;
	private double exchangeRate;
	
	public Currency(String number,String currencyCode,String currencyName,double exchangeRate) {
		this.number=number;
		this.currencyCode=currencyCode;
		this.currencyName= currencyName;
		this.exchangeRate=exchangeRate;
	}
	public String getNumber() {
		return number;
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
