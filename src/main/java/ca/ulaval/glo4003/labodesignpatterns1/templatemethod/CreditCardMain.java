package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

import ca.ulaval.glo4003.labodesignpatterns1.tools.CreditStandingValidationClient;

public class CreditCardMain {

	public static void main(String[] args) {

		CreditStandingValidationClient creditStandingValidationClient = new CreditStandingValidationClient();

		System.out.println("Let's create multiple credit cards!");

		VisaCard visaCard1 = new VisaCard("Albert Einstein",
				"4500123412341234", 03, 2017, 412,
				creditStandingValidationClient);
		VisaCard visaCard2 = new VisaCard("Alan Turing", "5500123412341234",
				03, 2017, 412, creditStandingValidationClient);
		VisaCard visaCard3 = new VisaCard("Stephen Hawking",
				"4500432143211234", 03, 2020, 412,
				creditStandingValidationClient);

		AmexCard amexCard1 = new AmexCard("Edsger W. Dijkstra",
				"34551234561234", 01, 1990, 518);
		AmexCard amexCard2 = new AmexCard("Bellman-Ford", "371234567891234",
				02, 2016, 250);
		AmexCard amexCard3 = new AmexCard("Bjarne Stroustrup",
				"550000000000000", 03, 2017, 111);

		MasterCard masterCard1 = new MasterCard("Master Yi",
				"5512345678912345", 8, 2015, 334,
				creditStandingValidationClient);
		MasterCard masterCard2 = new MasterCard("Gank Plank",
				"5543215678912345", 9, 2016, 645,
				creditStandingValidationClient);
		MasterCard masterCard3 = new MasterCard("Ashe", "5587654321912345", 10,
				2017, 1234, creditStandingValidationClient);

		visaCard1.isValid();
		visaCard2.isValid();
		visaCard3.isValid();

		amexCard1.isValid();
		amexCard2.isValid();
		amexCard3.isValid();

		masterCard1.isValid();
		masterCard2.isValid();
		masterCard3.isValid();
	}

}
