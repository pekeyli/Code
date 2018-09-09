package book.jzoffer.ch3;

/**
 * Created by pekey on 2017/11/14.
 */
public class Example11 {

    boolean invalidInput = false;

    public static double Power(double base, int exponent) {
        if (equals(base, 0.0) && exponent < 0) {
            throw new RuntimeException("异常");
        }

        if (!equals(base, 0.0) && exponent == 0) {
            return 1.0;
        }

        double result = 1.0;

        if (exponent < 0) {
            result = Compute(base, (-exponent) >> 1);
        } else {
            result = Compute(base, exponent >> 1);
        }
        result *= result;

        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return (exponent > 0) ? result : (1.0 / result);
    }

    public static double Compute(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static boolean equals(double a, double b) {
        if (a - b > -0.0000001 && a - b < 0.0000001)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        double res = Power(4, -2);
        System.out.println(res);

        System.out.println(5 >> 1);
    }

}
