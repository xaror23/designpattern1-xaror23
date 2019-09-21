package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

public interface CreditCard {

	public boolean isExpirationDateValid();

	public boolean hasValidChars();

	public boolean isValidPrefix();

	public boolean isNumberOfDigitsValid();

	public boolean isAccountInGoodStanding();

	public boolean isCvvValid();

	public boolean isValid();
}
