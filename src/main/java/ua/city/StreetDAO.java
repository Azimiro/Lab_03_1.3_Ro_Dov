package ua.city;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StreetDAO {
    
	public int addStreet(Street street) {
	    String sql = "INSERT INTO Street (name) VALUES (?)";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        pstmt.setString(1, street.getName());
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


    public List<Street> getAllStreets() {
        List<Street> streets = new ArrayList<>();
        String sql = "SELECT * FROM Street";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Street street = new Street();
                street.setId(rs.getInt("id"));
                street.setName(rs.getString("name"));
                streets.add(street);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return streets;
    }

    public void updateStreet(Street street) {
        String sql = "UPDATE Street SET name = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, street.getName());
            pstmt.setInt(2, street.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStreet(int id) {
        String sql = "DELETE FROM Street WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
