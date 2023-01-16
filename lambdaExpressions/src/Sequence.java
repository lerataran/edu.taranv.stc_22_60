public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        int temp = array.length;
        int a = 0;
        int index;
        int[] mas = new int[temp];
        for (int j : array) {
            index = 0;
            if (!condition.isOk(j)) {
                index++;
            }
            if (index == 0) {
                mas[a] = j;
                a++;
                temp--;
            }
        }
        int[] mass = new int[array.length - temp];
        System.arraycopy(mas, 0, mass, 0, array.length - temp);
        return mass;
    }
}
