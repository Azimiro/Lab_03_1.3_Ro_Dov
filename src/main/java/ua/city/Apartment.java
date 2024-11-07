package ua.city;

public class Apartment {
    private int id;
    private int buildingId; 
    private String apartmentNumber; 
    private int residentsCount;
    private double area; 

    // Конструктор за замовченням
    public Apartment() {
    }
    
    // Конструктор за замовченням
    public Apartment(int id, int buildingId, String apartmentNumber, double area) {
        this.id = id;
        this.buildingId = buildingId;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
    }

    // Додатковий конструктор для зручного створення об'єкту
    public Apartment(int id, int buildingId, String apartmentNumber, int residentsCount, double area) {
        this.id = id;
        this.buildingId = buildingId;
        this.apartmentNumber = apartmentNumber;
        this.residentsCount = residentsCount;
        this.area = area;
    }

    // Геттери та сетери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getResidentsCount() {
        return residentsCount;
    }

    public void setResidentsCount(int residentsCount) {
        this.residentsCount = residentsCount;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}



