package hr.fer.oop.generics.credit;

public class CreditOffering<T extends Client> {
	protected int rates;
	protected double interestRate,maximalAmount;
	protected String name;
	
	public CreditOffering(String name,int rates,double interestRate,double maximalAmount) {
		this.name=name;
		this.rates=rates;
		this.interestRate=interestRate;
		this.maximalAmount=maximalAmount;
	}
	
	public Credit issueCredit(T client,double amountRequested) throws NotSuitableException {
		double maxAllowedRates=client.getMaxAllowedRates();
		if(maxAllowedRates<this.rates)
			throw new NotSuitableException("Client "+client.getName()+" cannot return credit in more than "+maxAllowedRates+" rates");
		double amount=Math.min(this.maximalAmount, client.getCreditAbility(this.rates));
		return(new Credit(client,this.rates,this.interestRate,Math.min(amount,amountRequested)));
	}

	public int getRates() {
		return rates;
	}

	public void setRates(int rates) {
		this.rates = rates;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getMaximalAmount() {
		return maximalAmount;
	}

	public void setMaximalAmount(double maximalAmount) {
		this.maximalAmount = maximalAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
