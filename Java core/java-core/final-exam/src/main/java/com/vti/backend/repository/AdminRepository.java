package com.vti.backend.repository;

import com.vti.entity.Admin;
import com.vti.utils.JdbcUtils;

import java.io.IOException;
import java.sql.CallableStatement;
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
        String sql = "SELECT * FROM users WHERE role = 'ADMIN'";
        try (
                Connection connection = JdbcUtils.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            return handleResult(rs);
        }
    }

    @Override
    public List<Admin> findById(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE id = ? AND role = 'ADMIN'";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setInt(1, id);
            try (ResultSet rs = pStmt.executeQuery()) {
                return handleResult(rs);
            }
        }
    }

    @Override
    public int create(Admin admin) throws SQLException, IOException {
        String sql = "{CALL sp_create_admin(?, ?, ?, ?)}";
        try (
                Connection connection = JdbcUtils.getConnection();
                CallableStatement cStmt = connection.prepareCall(sql)
        ) {
            cStmt.setString(1, admin.getFullName());
            cStmt.setString(2, admin.getEmail());
            cStmt.setString(3, admin.getPassword());
            cStmt.setInt(4, admin.getExpInYear());
            return cStmt.executeUpdate();
        }
    }

    @Override
    public int update(Admin admin) throws SQLException, IOException {
        String sql = "{CALL sp_update_admin(?, ?, ?, ?, ?)}";
        try (
                Connection connection = JdbcUtils.getConnection();
                CallableStatement cStmt = connection.prepareCall(sql)
        ) {
            cStmt.setString(1, admin.getFullName());
            cStmt.setString(2, admin.getEmail());
            cStmt.setString(3, admin.getPassword());
            cStmt.setInt(4, admin.getExpInYear());
            cStmt.setInt(5, admin.getId());
            return cStmt.executeUpdate();
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

    private List<Admin> handleResult(ResultSet rs) throws SQLException {
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
