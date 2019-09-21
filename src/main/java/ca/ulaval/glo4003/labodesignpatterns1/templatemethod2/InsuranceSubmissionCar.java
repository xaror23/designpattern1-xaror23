package ca.ulaval.glo4003.labodesignpatterns1.templatemethod2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InsuranceSubmissionCar extends InsuranceSubmission {

  private static final List<String> CAR_COVERAGES = Arrays.asList("Theft", "Fire", "Collision");


  private String address;
  private String name;
  private String phoneNumber;
  private String email;
  private String type;
  private LocalDate buildDate;
  private ArrayList<String> coverages;

  public InsuranceSubmissionCar(String address,
                                String name,
                                String phoneNumber,
                                String email,
                                String type,
                                LocalDate date,
                                ArrayList<String> coverages){
    super(address,
        name,
        phoneNumber,
        email,
        type,
        date,
        coverages);
  }


  private boolean isCoveragesValid() {
      List<String> filteredCoverages =
          coverages.stream()
              .filter(coverage -> CAR_COVERAGES.contains(coverage))
              .collect(Collectors.toList());

      return coverages.size() == filteredCoverages.size();

  }

  private boolean isBuildDateValid() {

      return buildDate.isBefore(LocalDate.now()) && buildDate.isAfter(LocalDate.of(2000, 1, 1));

  }

  private boolean isAddressValid() {
    return !address.isEmpty();
  }

  private boolean isNameValid() {
    return !name.isEmpty();
  }

  private boolean isPhoneNumberValid() {
    Pattern pattern = Pattern.compile("^[0-9]{10}$");
    Matcher matcher = pattern.matcher(phoneNumber);
    return matcher.matches();
  }

  private boolean isEmailValid() {
    Pattern pattern = Pattern.compile("^.+@\\w+\\.\\w+$");
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

  public boolean isValid() {
    if (!isNameValid()) {
      System.out.println(name + ": Invalid submission: " + name + ": Invalid name");
      return false;
    }
    if (!isEmailValid()) {
      System.out.println(name + ": Invalid submission: " + email + ": Invalid email");
      return false;
    }
    if (!isAddressValid()) {
      System.out.println(name + ": Invalid submission: " + address + ": Invalid address");
      return false;
    }
    if (!isPhoneNumberValid()) {
      System.out.println(name + ": Invalid submission: " + phoneNumber + ": Invalid phone number");
      return false;
    }
    if (!isBuildDateValid()) {
      System.out.println(name + ": Invalid submission: " + buildDate + ": Invalid build date");
      return false;
    }
    if (!isCoveragesValid()) {
      System.out.println(name + ": Invalid submission: " + coverages + ": Invalid coverage");
      return false;
    }

    System.out.println(name + ": Valid Submission");
    return true;
  }

}
