package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

import java.time.LocalDate;

import ca.ulaval.glo4003.labodesignpatterns1.tools.CreditStandingValidationClient;
import ca.ulaval.glo4003.labodesignpatterns1.tools.CreditStandingValidationClient.CreditCards;

public class VisaCard implements CreditCard {
	private String name;
	private String number;
	private int expirationYYYY;
	private int expirationMM;
	private int cvv;
	private CreditStandingValidationClient creditStandingValidationClient;

	public VisaCard(String name, String number, int expirationMM,
			int expirationYYYY, int cvv,
			CreditStandingValidationClient creditStandingValidationClient) {
		this.name = name;
		this.number = number;
		this.expirationMM = expirationMM;
		this.expirationYYYY = expirationYYYY;
		this.cvv = cvv;
		this.creditStandingValidationClient = creditStandingValidationClient;
	}

	@Override
	public boolean isExpirationDateValid() {
		if (expirationMM >= 1 && expirationMM <= 12) {
			int validityTime = expirationYYYY - LocalDate.now().getYear();
			if (validityTime <= 3 && validityTime >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasValidChars() {
		try {
			Long.parseLong(number);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	public boolean isValidPrefix() {
		if (number.startsWith("4")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isNumberOfDigitsValid() {
		if (number.length() == 13 || number.length() == 16) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isAccountInGoodStanding() {
		return creditStandingValidationClient
				.validateCreditStandingByCardNumber(number, CreditCards.VISA);
	}

	@Override
	public boolean isCvvValid() {
		if (cvv > 100 && cvv < 400) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid() {
		if (!isExpirationDateValid()) {
			System.out.println(name + ": Invalid expiration date");
			return false;
		}
		if (!hasValidChars()) {
			System.out.println(name + ": Invalid characters in card number");
			return false;
		}
		if (!isValidPrefix()) {
			System.out.println(name + ": Invalid card prefix");
			return false;
		}
		if (!isNumberOfDigitsValid()) {
			System.out.println(name
					+ ": Invalid number of digits in card number");
			return false;
		}
		if (!isAccountInGoodStanding()) {
			System.out.println(name + ": Account is not in good standing");
			return false;
		}
		if (!isCvvValid()) {
			System.out.println(name + ": Invalid CVV number");
			return false;
		}

		System.out.println(name + ": Credit card is valid.");
		return true;
	}

}
