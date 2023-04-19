package com.vti.backend.repository;

import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public List<User> findAll() throws SQLException, IOException {
        String sql = "SELECT * FROM users";
        try (
                Connection connection = JdbcUtils.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            return handleResult(rs);
        }
    }

    @Override
    public List<User> findById(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE id = ?";
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
    public List<User> findByEmailAndPassword(String email, String password) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setString(1, email);
            pStmt.setString(2, password);
            try (ResultSet rs = pStmt.executeQuery()) {
                return handleResult(rs);
            }
        }
    }

    @Override
    public int create(User user) throws SQLException, IOException {
        String sql = "{CALL sp_create_user(?, ?)}";
        try (
                Connection connection = JdbcUtils.getConnection();
                CallableStatement cStmt = connection.prepareCall(sql)
        ) {
            cStmt.setString(1, user.getFullName());
            cStmt.setString(2, user.getEmail());
            return cStmt.executeUpdate();
        }
    }

    @Override
    public int update(User user) throws SQLException, IOException {
        String sql = "{CALL sp_update_user(?, ?, ?, ?, ?)}";
        try (
                Connection connection = JdbcUtils.getConnection();
                CallableStatement cStmt = connection.prepareCall(sql)
        ) {
            cStmt.setString(1, user.getFullName());
            cStmt.setString(2, user.getEmail());
            cStmt.setString(3, user.getPassword());
            cStmt.setString(4, user.getRole().toString());
            cStmt.setInt(5, user.getId());
            return cStmt.executeUpdate();
        }
    }

    @Override
    public int deleteById(int id) throws SQLException, IOException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setInt(1, id);
            return pStmt.executeUpdate();
        }
    }

    private List<User> handleResult(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFullName(rs.getString("full_name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            users.add(user);
        }
        return users;
    }
}
