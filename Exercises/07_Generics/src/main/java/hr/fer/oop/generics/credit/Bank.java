package hr.fer.oop.generics.credit;

public class Bank {
	
	public static void main(String[] args) {
		CreditOffering<Student> co1=new CreditOffering<Student>("Travel credit", 24, 10.0, 20000.0);
		CreditOffering<Student> co2=new CreditOffering<Student>("Car credit", 62, 7.5, 180000.0);
		CreditOffering<Pensioner> co3=new CreditOffering<Pensioner>("Generic credit", 12, 8.5, 200000);
		
		Student s1=new Student("Marko Markić",10000,8000);
		Student s2=new Student("Ivo Ivić",7000,6000);
		Pensioner p1=new Pensioner("Silvestar Starić", 3100);
		try {
			Credit c1=co1.issueCredit(s1,12000);
			System.out.println(c1);
			Credit c2=co1.issueCredit(s2,18000);
			System.out.println(c2);
			Credit c3=co3.issueCredit(p1,30000);
			System.out.println(c3);
			Credit c4=co2.issueCredit(s1,150000);
			System.out.println(c4);
		} catch (NotSuitableException e) {
			e.printStackTrace();
		}
		
	}
}
