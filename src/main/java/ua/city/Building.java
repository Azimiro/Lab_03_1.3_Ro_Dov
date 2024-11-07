package ua.city;

public class Building {
    private int id;
    private int streetId;
    private String name;
    private String address;

    public Building() {
    }
    
    public Building(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Геттери та сетери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}



