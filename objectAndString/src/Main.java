public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Валерия", "Таран", "Викторовна", "Самара",
                "Московское шоссе", "27", "523", "3622 456783");
        Human human2 = new Human("Виктор", "Таран", "Федорович", "Самара",
                "Московское шоссе", "27", "523", "3622 489234");

        // System.out.println(human1.toString());
        System.out.println(human1.equals(human2));
        System.out.println(human1.hashCode());
        System.out.println(human2.hashCode());
    }
}
