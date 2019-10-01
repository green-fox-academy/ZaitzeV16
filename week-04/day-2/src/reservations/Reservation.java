package reservations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reservation implements Reservable {

  // fields
  private final String[] CHAR_SET = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789"};
  private final String[] DAYS = {"MON", "THU", "WED", "THU", "FRI", "SAT", "SUN"};

  private String code;
  private String day;

  // constructors
  public Reservation() {
    this.code = getCodeBooking();
    this.day = getDowBooking();
  }

  // getters and setters
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }


  // overrides
  @Override
  public String getDowBooking() {
    Random random = new Random();
    return this.DAYS[random.nextInt(this.DAYS.length)];
  }

  @Override
  public String getCodeBooking() {
    Random random = new Random();
    List<String> newCode = new ArrayList<>();

    do {
      String currCharSet = this.CHAR_SET[random.nextInt(this.CHAR_SET.length)];
      String currLetter = String.valueOf(
          currCharSet.charAt(
              random.nextInt(currCharSet.length())
          )
      );
      newCode.add(currLetter);
    } while (newCode.size() < 8);

    return String.join("", newCode);
  }

  public void booking() {
    System.out.printf("Booking# %s for %s.\n", this.getCode(), this.getDay());
  }
}
