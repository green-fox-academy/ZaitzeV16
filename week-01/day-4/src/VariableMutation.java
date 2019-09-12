import java.lang.Math;


public class VariableMutation {
    public static void main(String[] args) {
        int a = 3;
        // make the "a" variable's value bigger by 10
        System.out.print("Adding 10 to " + a + " is: ");
        a += 10;
        System.out.println(a);

        int b = 100;
        // make b smaller by 7
        System.out.print("Subtructing 7 from " + b + " is: ");
        b -= 7;
        System.out.println(b);

        int c = 44;
        // please double c's value
        System.out.print("The double of " + c + " is: ");
        c *= 2;
        System.out.println(c);

        int d = 125;
        // please divide by 5 d's value
        System.out.print("Dividing " + d + " by 5 is: ");
        d /= 5;
        System.out.println(d);

        int e = 8;
        // please cube of e's value
        System.out.print("The cube of " + e + " is: ");
        System.out.println(Math.pow(e, 3));

        int f1 = 123;
        int f2 = 345;
        // tell if f1 is bigger than f2 (print as a boolean)
        System.out.print(f1 + " is bigger than " + f2 + ": ");
        if (f1 > f2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        int g1 = 350;
        int g2 = 200;
        // tell if the double of g2 is bigger than g1 (print as a boolean)


        if (2 * g2 > g1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        int h = 135798745;
        // tell if it has 11 as a divisor (print as a boolean)
        System.out.print(h + " has 11 as a divisor: ");
        boolean elevenIsDivisor = ((h / 11) * 11) == h;
        System.out.println(elevenIsDivisor);

        int i1 = 10;
        int i2 = 3;
        // tell if i1 is higher than i2 squared and smaller than i2 cubed (print as a boolean)
        System.out.print((int) (Math.pow(i2, 2)) +
                         " < " + i1 + " < " +
                         (int) (Math.pow(i2, 3)) + ": ");

        if ((i1 > Math.pow(i2, 2)) &&
            (i1 < Math.pow(i2, 3))) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        int j = 1521;
        // tell if j is dividable by 3 or 5 (print as a boolean)
        boolean dividableBy3Or5 = false;

        System.out.print(j + " is dividable with at least one of the following numbers (3, 5): ");
        if (((j / 3) * 3 == j) ||
            (((j / 5) * 5 == j))) {
            dividableBy3Or5 = true;
        }
        System.out.println(dividableBy3Or5);
    }
}
