package ca.ulaval.glo4003.labodesignpatterns1.templatemethod2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class InsuranceSubmission {

  private static final String HOUSE = "house";
  private static final String CAR = "car";
  private static final List<String> CAR_COVERAGES = Arrays.asList("Theft", "Fire", "Collision");
  private static final List<String> HOME_COVERAGES = Arrays.asList("Theft",
                                                                   "Fire",
                                                                   "Floods",
                                                                   "Earthquake");

  private String address;
  private String name;
  private String phoneNumber;
  private String email;
  private String type;
  private LocalDate buildDate;
  private ArrayList<String> coverages;

  public InsuranceSubmission(String address,
                             String name,
                             String phoneNumber,
                             String email,
                             String type,
                             LocalDate date,
                             ArrayList<String> coverages)
  {
    this.address = address;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.type = type;
    this.buildDate = date;
    this.coverages = coverages;
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



}
