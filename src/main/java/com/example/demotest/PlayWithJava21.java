package com.example.demotest;

public class PlayWithJava21 {

	public static void main(String[] args) {
		var loan = new SecuredLoan();
		final var loan2 = new UnsecuredLoan(5);
		final var s = displayLoan(loan2);
		System.out.println(s);

	}

	static String displayLoan(Loan loan) {
	/*	if(loan instanceof SecuredLoan sl) {
			return "Secured Loan";
		}
		if(loan instanceof UnsecuredLoan usl) {
			return "Unsecured load, interest rate " + usl.interestRate + " will hurt!";
		}
		return  null;*/
		return switch(loan) {
			case SecuredLoan sl -> "Secured Loan";
			case UnsecuredLoan usl -> "Unsecured load, interest rate " + usl.interestRate + " will hurt!";
		};
	}

	sealed interface Loan permits SecuredLoan, UnsecuredLoan {}

	static final class SecuredLoan implements Loan {}
	record UnsecuredLoan(float interestRate) implements Loan{}
}
