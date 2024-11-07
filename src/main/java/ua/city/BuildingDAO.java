package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingDAO {

	    public int addBuilding(Building building) throws SQLException {
	        String sql = "INSERT INTO building (street_id, name, address) VALUES (?, ?, ?)";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
	            
	            // Встановлення параметрів для запиту
	            stmt.setInt(1, building.getStreetId());
	            stmt.setString(2, building.getName());
	            stmt.setString(3, building.getAddress());
	            
	            // Виконання запиту
	            int affectedRows = stmt.executeUpdate();
	            
	            // Перевірка, що вставка пройшла успішно та отримання згенерованого ID
	            if (affectedRows == 0) {
	                throw new SQLException("Створення будівлі не вдалося, не додано жодного рядка.");
	            }

	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    // Повертаємо згенерований ID
	                    return generatedKeys.getInt(1);
	                } else {
	                    throw new SQLException("Створення будівлі не вдалося, ID не отримано.");
	                }
	            }
	        }
	    }
	

	    // Метод для отримання будівлі за ID
	    public Building getBuildingById(int id) throws SQLException {
	        String sql = "SELECT * FROM building WHERE id = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Building(rs.getInt("id"), 
	                                    rs.getString("name"), 
	                                    rs.getString("address"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    // Метод для оновлення інформації про будівлю
	    public void updateBuilding(Building building) throws SQLException {
	        String sql = "UPDATE building SET name = ?, address = ? WHERE id = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, building.getName());
	            stmt.setString(2, building.getAddress());
	            stmt.setInt(3, building.getId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Метод для отримання всіх будівель
	    public List<Building> getAllBuildings() throws SQLException {
	        List<Building> buildings = new ArrayList<>();
	        String sql = "SELECT * FROM building";
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                buildings.add(new Building(rs.getInt("id"), 
	                                           rs.getString("name"), 
	                                           rs.getString("address")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return buildings;
	    }
	}


