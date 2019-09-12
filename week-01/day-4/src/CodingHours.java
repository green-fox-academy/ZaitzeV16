public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        int weeks = 17;
        int dailyHours = 6;

        int weekDays = weeks * 5;
        int wholeCodingHours = weekDays * dailyHours;

        System.out.println(wholeCodingHours);
        System.out.println();

        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52
        int avgWeeklyWorkHours = 52;
        int wholeWorkHours = weeks * avgWeeklyWorkHours;

        double ratio = (double) (wholeCodingHours) / (double) (wholeWorkHours);
        int percentage = (int) (ratio * 100);

        System.out.println("Percentage of coding hours: ");
        System.out.print(percentage + "%");
    }
}