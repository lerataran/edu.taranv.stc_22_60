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
        return lastName + " " + name + " " + patronymic + '\n' +
                "Паспорт:" + '\n' +
                "Серия: " + passportSeries + " Номер: " + numberPassport + '\n' +
                "Город " + city + ", " + street + ", дом " + house + ", квартира " + flat;
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
