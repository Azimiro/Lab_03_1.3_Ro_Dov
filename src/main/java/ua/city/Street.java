package ua.city;

public class Street {
    private int id;
    private String name;
    private String city;

    // Конструктор за замовчуванням
    public Street() {}

    // Конструктор із параметрами
    public Street(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Геттери та сетери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

