import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {45, 31, 44, 71, 8};
        int[] array2 = {45, 32, 404, 71, 82};
        int[] array3 = {76, 421, 404, 722, 8};
        int[] array4 = {76037, 424, 4124, 722, 810};
        System.out.println(Arrays.toString(Sequence.filter(array1, Main::isEven)));
        System.out.println(Arrays.toString(Sequence.filter(array2, Main::isSumEven)));
        System.out.println(Arrays.toString(Sequence.filter(array3, Main::isEvenOfDigits)));
        System.out.println(Arrays.toString(Sequence.filter(array4, Main::isPalindromicNumber)));
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isSumEven(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            number /= 10;
            sum += lastDigit;
        }
        return sum % 2 == 0;
    }

    public static boolean isEvenOfDigits(int number) {
        while (number > 0) {
            int lastDigit = number % 10;
            number /= 10;
            if (lastDigit % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromicNumber(int number) {
        int remainingNumber = number;
        int reversedNumber = 0;
        while (remainingNumber != 0) {
            int remainder = remainingNumber % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            remainingNumber /= 10;
        }
        return number == reversedNumber;
    }
}
