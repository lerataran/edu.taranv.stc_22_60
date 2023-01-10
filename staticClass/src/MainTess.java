public class MainTess {
    private static final int[] mass1 = {6, -3, 2, 7, -1, 5};
    private static final int[] mass2 = {4, 4, 6, 22, 4};
    private static final int[] mass3 = {4, 6, 2, 3, 8};
    private static final int[] mass4 = {100, 5, 40, 2};
    private static final int x = 3;
    private static final int y = 11;

    public static boolean isEmpty(int x, int y) {
        return x == y;
    }

    public static void main(String[] args) {
        int actualSumNumbers1 = ActionsOnNumbers.sumNumbers(mass1);
        int expectedSumNumbers1 = 16;
        System.out.println(isEmpty(actualSumNumbers1, expectedSumNumbers1));

        int actualSumNumbers2 = ActionsOnNumbers.sumNumbers(mass2);
        int expectedSumNumbers2 = 40;
        System.out.println(isEmpty(actualSumNumbers2, expectedSumNumbers2));

        int actualSubtractionNumbers1 = ActionsOnNumbers.subtractionNumbers(mass2);
        int expectedSubtractionNumbers1 = 4;
        System.out.println(isEmpty(actualSubtractionNumbers1, expectedSubtractionNumbers1));

        int actualSubtractionNumbers2 = ActionsOnNumbers.subtractionNumbers(mass3);
        int expectedSubtractionNumbers2 = -7;
        System.out.println(isEmpty(actualSubtractionNumbers2, expectedSubtractionNumbers2));

        int actualMultiplicationNumbers1 = ActionsOnNumbers.multiplicationNumbers(mass3);
        int expectedMultiplicationNumbers1 = 1152;
        System.out.println(isEmpty(actualMultiplicationNumbers1, expectedMultiplicationNumbers1));

        int actualDividendNumbers1 = (int) ActionsOnNumbers.dividendNumbers(mass4);
        int expectedDividendNumbers1 = 20;
        System.out.println(isEmpty(actualDividendNumbers1, expectedDividendNumbers1));

        int actualFactorialNumbers1 = (int) ActionsOnNumbers.factorialNumbers(x);
        int expectedFactorialNumbers1 = 6;
        System.out.println(isEmpty(actualFactorialNumbers1, expectedFactorialNumbers1));

        int actualFactorialNumbers2 = (int) ActionsOnNumbers.factorialNumbers(y);
        int expectedFactorialNumbers2 = 39916800;
        System.out.println(isEmpty(actualFactorialNumbers2, expectedFactorialNumbers2));
    }


}
