package backend.repository;

import entity.Admin;
import utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements IAdminRepository {
    @Override
    public List<Admin> findAll() throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE `role` = 'ADMIN'";
        try (
                Connection connection = JdbcUtils.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            List<Admin> admins = new ArrayList<>();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setFullName(rs.getString("full_name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getString("role"));
                admin.setExpInYear(rs.getInt("exp_in_year"));
                admins.add(admin);
            }
            return admins;
        }
    }

    @Override
    public Admin findById(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE id = ? AND `role` = 'ADMIN'";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setInt(1, id);
            try (ResultSet rs = pStmt.executeQuery()) {
                if (rs.next()) {
                    Admin admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setFullName(rs.getString("full_name"));
                    admin.setEmail(rs.getString("email"));
                    admin.setPassword(rs.getString("password"));
                    admin.setRole(rs.getString("role"));
                    admin.setExpInYear(rs.getInt("exp_in_year"));
                    return admin;
                }
                return null;
            }
        }
    }

    @Override
    public int create(Admin admin) throws SQLException, IOException {
        String sql = "INSERT INTO users (full_name, email, password, role, exp_in_year) VALUES (?, ?, ?, 'ADMIN', ?)";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setString(1, admin.getFullName());
            pStmt.setString(2, admin.getEmail());
            pStmt.setString(3, admin.getPassword());
            pStmt.setInt(4, admin.getExpInYear());
            return pStmt.executeUpdate();
        }
    }

    @Override
    public int update(Admin admin) throws SQLException, IOException {
        String sql = "UPDATE users SET full_name = ?, email = ?, password = ?, exp_in_year = ? WHERE id = ? AND role = 'ADMIN'";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setString(1, admin.getFullName());
            pStmt.setString(2, admin.getEmail());
            pStmt.setString(3, admin.getPassword());
            pStmt.setInt(4, admin.getExpInYear());
            pStmt.setInt(5, admin.getId());
            return pStmt.executeUpdate();
        }
    }

    @Override
    public int deleteById(int id) throws SQLException, IOException {
        String sql = "DELETE FROM users WHERE id = ? AND role = 'ADMIN'";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setInt(1, id);
            return pStmt.executeUpdate();
        }
    }
}
