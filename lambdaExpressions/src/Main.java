import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {45, 31, 44, 71, 8};
        int[] array2 = {45, 32, 404, 71, 82};
        int[] array3 = {76, 421, 404, 722, 8};
        int[] array4 = {76037, 424, 4124, 722, 810};
        System.out.println(Arrays.toString(Sequence.filter(array1, (int number) -> number % 2 == 0)));
        System.out.println(Arrays.toString(Sequence.filter(array2, (int number) -> {
            int sum = 0;
            while (number > 0) {
                int temp = number % 10;
                number /= 10;
                sum += temp;
            }
            return sum % 2 == 0;
        })));
        System.out.println(Arrays.toString(Sequence.filter(array3, (int number) -> {
            while (number > 0) {
                int temp = number % 10;
                number /= 10;
                if (!(temp % 2 == 0)) {
                    return false;
                }
            }
            return true;
        })));
        System.out.println(Arrays.toString(Sequence.filter(array4, (int number) -> {
            int palindrome = number;
            int temp = 0;
            while (palindrome != 0) {
                int remainder = palindrome % 10;
                temp = temp * 10 + remainder;
                palindrome /= 10;
            }
            return number == temp;
        })));
    }
}
