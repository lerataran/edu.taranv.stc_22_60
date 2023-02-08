import java.util.Arrays;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        int count = 0;
        int index;
        int[] mas = new int[array.length];
        for (int j : array) {
            index = 0;
            if (!condition.isOk(j)) {
                index++;
            }
            if (index == 0) {
                mas[count] = j;
                count++;
            }
        }
        return Arrays.copyOf(mas, count);
    }
}
