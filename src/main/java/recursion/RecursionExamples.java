package recursion;

public class RecursionExamples {

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n*factorial(n-1);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static String reverse(String s) {
        // FILL IN CODE
        int n = s.length();
        if (n == 1)
            return s;
        else {
            return s.charAt(n - 1) + reverse(s.substring(0, n - 1));
        }
    }

    public static String convertDigitalToBinary(int n, String s) {

        int num = n / 2;
        int mod = n % 2;

        if (num == 0)
            return mod + s;

        return convertDigitalToBinary(num, mod + s);
    }

    public static void main(String[] args) {
        System.out.println(convertDigitalToBinary(5, ""));
    }
}
