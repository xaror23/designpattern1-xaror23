package ca.ulaval.glo4003.labodesignpatterns1.templatemethod2;

import java.time.LocalDate;
import java.util.ArrayList;

public class InsuranceSubmissionMain {

  private static final LocalDate DATE_IN_FUTURE = LocalDate.of(2020, 9, 21);
  private static final LocalDate YESTERDAY = LocalDate.of(2018, 9, 20);
  private static final LocalDate DATE_FROM_THE_PAST = LocalDate.of(1950, 9, 20);

  private static final String ADDRESS = "930 rue d'Aiguillon Quebec";
  private static final String EMAIL = "john.doe@email.com";
  private static final String CAR = "car";
  private static final String HOME = "house";

  public static void main(String[] args) {
    InsuranceSubmissionCar carSubmission = new InsuranceSubmissionCar(ADDRESS,
                                                                "John Doe",
                                                                "4181234567",
                                                                EMAIL,
                                                                CAR,
                                                                YESTERDAY,
                                                                new ArrayList<String>()
                                                                {
                                                                  {
                                                                    add("Theft");
                                                                    add("Collision");

                                                                  }
                                                                });
    InsuranceSubmissionCar invalidCarTNSubmission = new InsuranceSubmissionCar(ADDRESS,
                                                                         "Jane Lalande",
                                                                         "418Patate",
                                                                         EMAIL,
                                                                         CAR,
                                                                         YESTERDAY,
                                                                         new ArrayList<String>()
                                                                         {
                                                                           {
                                                                             add("Fire");
                                                                             add("Collision");
                                                                           }
                                                                         });

    InsuranceSubmissionCar invalidModelYearSubmission = new InsuranceSubmissionCar(ADDRESS,
                                                                             "Antoine L'Anglais",
                                                                             "4181234567",
                                                                             EMAIL,
                                                                             CAR,
                                                                             DATE_IN_FUTURE,
                                                                             new ArrayList<String>()
                                                                             {
                                                                               {
                                                                                 add("Theft");
                                                                                 add("Collision");
                                                                               }
                                                                             });

    InsuranceSubmissionHouse homeSubmission = new InsuranceSubmissionHouse(ADDRESS,
                                                                 "Hecules Sebouai",
                                                                 "4181234567",
                                                                 EMAIL,
                                                                 HOME,
                                                                 DATE_FROM_THE_PAST,
                                                                 new ArrayList<String>()
                                                                 {
                                                                   {
                                                                     add("Theft");
                                                                     add("Floods");
                                                                   }
                                                                 });
    InsuranceSubmissionHouse invalidHomeTNSubmission = new InsuranceSubmissionHouse(ADDRESS,
                                                                          "Tom Lee Pearson",
                                                                          "418Patate",
                                                                          EMAIL,
                                                                          HOME,
                                                                          DATE_FROM_THE_PAST,
                                                                          new ArrayList<String>()
                                                                          {
                                                                            {
                                                                              add("Earthquake");
                                                                              add("Fire");
                                                                            }
                                                                          });
    InsuranceSubmissionHouse invalidHomeSecuritySubmission =
                                                      new InsuranceSubmissionHouse(ADDRESS,
                                                                              "Max Power 2000",
                                                                              "4181234567",
                                                                              EMAIL,
                                                                              HOME,
                                                                              DATE_FROM_THE_PAST,
                                                                              new ArrayList<String>()
                                                                              {
                                                                                {
                                                                                  add("Theft");
                                                                                  add("Collision");
                                                                                }
                                                                              });

    carSubmission.isValid();
    homeSubmission.isValid();

    invalidCarTNSubmission.isValid();
    invalidHomeTNSubmission.isValid();

    invalidModelYearSubmission.isValid();
    invalidHomeSecuritySubmission.isValid();
  }
}
