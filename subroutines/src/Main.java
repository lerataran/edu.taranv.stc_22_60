public class Main {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sortMass(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == 0 && array[j] != 0) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] mas = {0, 1, 0, 3, 4};
        sortMass(mas);
    }

}
