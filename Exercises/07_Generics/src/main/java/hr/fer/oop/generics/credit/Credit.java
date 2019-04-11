package hr.fer.oop.generics.credit;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Credit {
	private Client owner;
	private double interestRate,amount;
	private int rates;
	
	public Credit(Client owner,int rates,double interestRate,double amount) {
		this.owner=owner;
		this.rates=rates;
		this.interestRate=interestRate;
		this.amount=amount;
	}

	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Credit owned by ").append(owner.getName());
		sb.append(", rates:").append(this.rates);
		sb.append(", interest rate:").append(this.interestRate);
		DecimalFormatSymbols dfs=new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		DecimalFormat df=new DecimalFormat("####0,000.00",dfs);
		sb.append(", total amount:").append(df.format(this.amount));
		return(sb.toString());
	}
	
}
