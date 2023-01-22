
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SequenceTest {

    @Test
    void testIsEven() {
        int[] array = {45, 31, 44, 71, 8};
        int[] expected = {44, 8};
        ByCondition isEven = Main::isEven;
        int[] actual = Sequence.filter(array, isEven);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, аолучили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }

    @Test
    void testIsSumEven() {
        int[] array = {45, 32, 404, 71, 82};
        int[] expected = {404, 71, 82};
        ByCondition isSumEven = Main::isSumEven;
        int[] actual = Sequence.filter(array, isSumEven);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, аолучили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }

    @Test
    void testIsEvenOfDigits() {
        int[] array = {76, 421, 404, 722, 8};
        int[] expected = {404, 8};
        ByCondition isEvenOfDigits = Main::isEvenOfDigits;
        int[] actual = Sequence.filter(array, isEvenOfDigits);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, аолучили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }

    @Test
    void testIsPalindromicNumber() {
        int[] array = {76037, 424, 4124, 722, 810};
        int[] expected = {424};
        ByCondition isPalindromicNumber = Main::isPalindromicNumber;
        int[] actual = Sequence.filter(array, isPalindromicNumber);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, аолучили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }
}