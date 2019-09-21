package ca.ulaval.glo4003.labodesignpatterns1.tools;

public class CreditStandingValidationClient {

	public enum CreditCards {
		VISA, MASTERCARD
	};

	public CreditStandingValidationClient() {
	}

	public boolean validateCreditStandingByCardNumber(String cardNumber,
			CreditCards cardType) {

		try {
			Thread.sleep(300l);
			boolean isValid = Math.random() < 0.5;

			return isValid;
		} catch (InterruptedException e) {
			// This is to keep the API simple, so we would consider as not in
			// good standing.
			e.printStackTrace();
			return false;
		}
	}
}
