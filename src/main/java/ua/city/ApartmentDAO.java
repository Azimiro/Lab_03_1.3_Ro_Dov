package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {

	// ApartmentDAO.java

	// Метод для додавання нової квартири
	public int addApartment(Apartment apartment) {
	    String sql = "INSERT INTO apartment (building_id, apartment_number, residents_count) VALUES (?, ?, ?)";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        pstmt.setInt(1, apartment.getBuildingId());
	        pstmt.setString(2, apartment.getApartmentNumber());
	        pstmt.setInt(3, apartment.getResidentsCount());
	        pstmt.executeUpdate();

	        ResultSet rs = pstmt.getGeneratedKeys();
	        if (rs.next()) {
	            return rs.getInt(1); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}

	// Метод для отримання квартири за ID
	public Apartment getApartmentById(int id) throws SQLException {
	    String sql = "SELECT * FROM apartment WHERE id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return new Apartment(rs.getInt("id"), rs.getInt("building_id"),
	                                 rs.getString("apartment_number"), rs.getInt("residents_count"), rs.getDouble("area"));
	        }
	    }
	    return null;
	}

	// Метод для отримання всіх квартир
	public List<Apartment> getAllApartments() throws SQLException {
	    List<Apartment> apartments = new ArrayList<>();
	    String sql = "SELECT * FROM apartment";
	    try (Connection conn = DatabaseConnection.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            apartments.add(new Apartment(rs.getInt("id"), rs.getInt("building_id"),
	                                         rs.getString("apartment_number"), rs.getInt("residents_count"), rs.getDouble("area")));
	        }
	    }
	    return apartments;
	}
}
