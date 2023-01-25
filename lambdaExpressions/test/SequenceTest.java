import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SequenceTest {
    private static Stream<Arguments> methodForEven() {
        return Stream.of(
                Arguments.of(new int[]{45, 31, 44, 71, 8}, new int[]{44, 8}),
                Arguments.of(new int[]{76, 421, 404, 722, 8}, new int[]{76, 404, 722, 8}),
                Arguments.of(new int[]{45, 348, 676, 49, 23}, new int[]{348, 676})
        );
    }

    private static Stream<Arguments> methodForSumEven() {
        return Stream.of(
                Arguments.of(new int[]{45, 32, 404, 71, 82}, new int[]{404, 71, 82}),
                Arguments.of(new int[]{44, 453, 56, 45, 237}, new int[]{44, 453, 237}),
                Arguments.of(new int[]{45, 348, 676, 49, 24}, new int[]{24})
        );
    }

    private static Stream<Arguments> methodForEvenOfDigits() {
        return Stream.of(
                Arguments.of(new int[]{76, 421, 404, 722, 8}, new int[]{404, 8}),
                Arguments.of(new int[]{646, 3466, 234, 998, 234}, new int[]{646}),
                Arguments.of(new int[]{45, 348, 676, 49, 22}, new int[]{22})
        );
    }

    private static Stream<Arguments> methodForPalindromicNumber() {
        return Stream.of(
                Arguments.of(new int[]{76_037, 424, 4_124, 722, 810}, new int[]{424}),
                Arguments.of(new int[]{4524, 345, 223, 4_321_234, 456}, new int[]{4_321_234}),
                Arguments.of(new int[]{456, 2_334, 678, 3_443, 22}, new int[]{3_443, 22})
        );
    }

    @ParameterizedTest
    @MethodSource("methodForEven")
    void testIsEven(int[] array, int[] expected) {
        ByCondition isEven = Main::isEven;
        int[] actual = Sequence.filter(array, isEven);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, получили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }

    @ParameterizedTest
    @MethodSource("methodForSumEven")
    void testIsSumEven(int[] array, int[] expected) {
        ByCondition isSumEven = Main::isSumEven;
        int[] actual = Sequence.filter(array, isSumEven);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, получили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }

    @ParameterizedTest
    @MethodSource("methodForEvenOfDigits")
    void testIsEvenOfDigits(int[] array, int[] expected) {
        ByCondition isEvenOfDigits = Main::isEvenOfDigits;
        int[] actual = Sequence.filter(array, isEvenOfDigits);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, получили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }

    @ParameterizedTest
    @MethodSource("methodForPalindromicNumber")
    void testIsPalindromicNumber(int[] array, int[] expected) {
        ByCondition isPalindromicNumber = Main::isPalindromicNumber;
        int[] actual = Sequence.filter(array, isPalindromicNumber);
        assertArrayEquals(expected, actual, String.format("Массивы не равны: ожидалось %s, получили %s",
                Arrays.toString(expected),
                Arrays.toString(actual)));
    }
}