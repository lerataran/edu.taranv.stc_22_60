import java.util.Objects;

public class Human {
    private String name;
    private String lastName;
    private String patronymic;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String numberPassport;

    public Human(String name, String lastName, String patronymic, String city, String street, String house, String flat, String numberPassport) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.numberPassport = numberPassport;
    }

    @Override
    public String toString() {
        int passportSeries = 3622;
        var sb = new StringBuilder();
        var string = sb.append(lastName).append(" ").append(name).append(" ").append(patronymic).append('\n')
                .append("Паспорт:").append('\n')
                .append("Серия: ").append(passportSeries).append(" Номер: ").append(numberPassport).append('\n')
                .append("Город ").append(city).append(", ").append(street)
                .append(", дом ").append(house).append(", квартира ").append(flat);
        return String.valueOf(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return numberPassport.equals(human.numberPassport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic, city, street, house, flat, numberPassport);
    }
}
