public class Cuboid {
    public static void main(String[] args) {
        // Write a program that stores 3 sides of a cuboid as variables (doubles)
        // The program should write the surface area and volume of the cuboid like:
        //
        // Surface Area: 600
        // Volume: 1000

        double a, b, c;
        a = 10.5;
        b = 56.012;
        c = 0.9;

        double surfaceArea, volume;

        surfaceArea = 2 * (a * b + a * c + b * c);
        volume = a * b * c;

        System.out.println("Surface Area: " + surfaceArea);
        System.out.println("Volume: " + volume);
    }
}
