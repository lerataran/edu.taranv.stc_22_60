public class ActionsOnNumbers {

    public static int max(int... number) {
        int num = number[0];
        for (int j : number) {
            if (j > num) {
                num = j;
            }
        }
        return num;
    }

    public static int sumNumbers(int... number) {
        int sum = 0;
        for (int j : number) {
            sum += j;
        }
        return sum;
    }

    public static int subtractionNumbers(int... number) {
        int subtractionMax = max(number);
        int subtraction = max(number);
        for (int j : number) {
            if (subtractionMax != j) {
                subtraction -= j;
            }
        }
        return subtraction;
    }

    public static int multiplicationNumbers(int... number) {
        int multiplication = 1;
        for (int i : number) {
            multiplication *= i;
        }
        return multiplication;
    }

    public static double dividendNumbers(int... number) {
        double dividend = number[0];
        for (int i = 1; i < number.length; i++) {
            if (dividend > 0 && dividend > number[i]) {
                dividend = dividend / number[i];
            } else {
                return dividend;
            }
        }
        return dividend;
    }

    public static long factorialNumbers(int n) {
        long factorial = 1;
        if (n > 0) {
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }
}

