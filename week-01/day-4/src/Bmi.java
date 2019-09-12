import java.lang.Math;


public class Bmi {
    public static void main(String[] args) {
        double massInKg = 81.2;
        double heightInM = 1.78;

        // Print the Body mass index (BMI) based on these values
        // BMI = weight(kg) / [height(m)]^^2

        double BMI = massInKg / Math.pow(heightInM, 2);
        System.out.println(BMI);
    }
}
