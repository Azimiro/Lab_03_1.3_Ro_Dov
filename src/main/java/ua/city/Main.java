package ua.city;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StreetDAO streetDAO = new StreetDAO();
        BuildingDAO buildingDAO = new BuildingDAO();
        ApartmentDAO apartmentDAO = new ApartmentDAO();

        // Приклад додавання вулиці
        Street street = new Street();
        street.setName("Авіаторів");
        int streetId = streetDAO.addStreet(street);  
        street.setId(streetId);  

        if (street.getId() > 0) {
            // Приклад додавання будинку на вулиці
        	Building building = new Building();
        	building.setStreetId(street.getId());
        	building.setName("Назва будівлі");
        	building.setAddress("Адреса будівлі");
        	int buildingId = buildingDAO.addBuilding(building); 
        	building.setId(buildingId); 

            if (building.getId() > 0) {
                // Приклад додавання квартири в будинку
                Apartment apartment = new Apartment();
                apartment.setBuildingId(building.getId());
                apartment.setApartmentNumber("42");
                apartment.setResidentsCount(3);
                apartmentDAO.addApartment(apartment);
            } else {
                System.out.println("Помилка: не вдалося додати будинок.");
            }
        } else {
            System.out.println("Помилка: не вдалося додати вулицю.");
        }

        // Виведення всіх вулиць
        System.out.println("Список вулиць:");
        for (Street s : streetDAO.getAllStreets()) {
            System.out.println("ID: " + s.getId() + ", Назва: " + s.getName());
        }

        // Виведення всіх будівель
        System.out.println("\nСписок будівель:");
        for (Building b : buildingDAO.getAllBuildings()) {
            System.out.println("ID: " + b.getId() + ", Назва: " + b.getName() + ", Адрес: " + b.getAddress() + ", Вулиця ID: " + b.getStreetId());
        }

        // Виведення всіх квартир
        System.out.println("\nСписок квартир:");
        for (Apartment a : apartmentDAO.getAllApartments()) {
            System.out.println("ID: " + a.getId() + ", Номер квартири: " + a.getApartmentNumber() + ", Жителів: " + a.getResidentsCount() + ", Площа: " + a.getArea() + ", Будівля ID: " + a.getBuildingId());
        }
    }
        
    }



