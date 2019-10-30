package com.dependency_injection.di.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

  ArrayList<String> colors;
  Random random;

  public UtilityService() {
    colors = new ArrayList<>();
    colors.add("red");
    colors.add("blue");
    colors.add("lime");
    colors.add("orange");
    colors.add("magenta");
    random = new Random();
  }

  public String randomColor() {
    return colors.get(random.nextInt(colors.size()));
  }

  // ## Email validator
  // - Endpoint at `/useful/email` with a queryparam
  // - Have a link at the main page to an example: `/useful/email?email=is@this.valid`
  // - Create a `validateEmail` method in the `UtilityService`
  //     - check if the string contains a `@` and a `.`
  // - Display the following to the user
  //     - `is@this.valid is a valid email address` in green
  //     - `not_valid_email.com is not a valid email address` in red

  public HashMap<String, String> validateEmail(String email) {
    HashMap<String, String> result = new HashMap<>();
    boolean isValid = email.contains("@") && email.contains(".");

    String msg = (isValid) ? email + " is a valid email address" :
        email + " is not a valid email address";

    result.put("msg", msg);
    result.put("color", (isValid) ? "green" : "red");

    return result;
  }

  // ## Caesar encoder/decoder
  // _Caesar coding is just shifting every character in the text with a specific number of amount in the alphabet, coded `example` with `1` is `fybnqmf`._
  // - Endpoints for encoding and decoding with a `text` and `number` query param
  // - Link at the main page for both
  // - Service method:

  public String caesar(String text, int number) {
    if (number < 0) {
      number = 26 + number;
    }

    String result = "";
    for (int i = 0; i < text.length(); i++) {
      int offset = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
      result += (char) (((int) text.charAt(i) + number - offset) % 26 + offset);
    }
    return result;
  }
}
