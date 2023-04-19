package com.vti.backend.repository;

import com.vti.entity.Employee;
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

public class EmployeeRepository implements IEmployeeRepository {
    @Override
    public List<Employee> findAll() throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE role = 'EMPLOYEE'";
        try (
                Connection connection = JdbcUtils.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            return handleResult(rs);
        }
    }

    @Override
    public List<Employee> findById(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE id = ? AND role = 'EMPLOYEE'";
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
    public int create(Employee employee) throws SQLException, IOException {
        String sql = "{CALL sp_create_employee(?, ?, ?, ?)}";
        try (
                Connection connection = JdbcUtils.getConnection();
                CallableStatement cStmt = connection.prepareCall(sql)
        ) {
            cStmt.setString(1, employee.getFullName());
            cStmt.setString(2, employee.getEmail());
            cStmt.setString(3, employee.getPassword());
            cStmt.setString(4, employee.getProSkill());
            return cStmt.executeUpdate();
        }
    }

    @Override
    public int update(Employee employee) throws SQLException, IOException {
        String sql = "{CALL sp_update_employee(?, ?, ?, ?, ?)}";
        try (
                Connection connection = JdbcUtils.getConnection();
                CallableStatement cStmt = connection.prepareCall(sql)
        ) {
            cStmt.setString(1, employee.getFullName());
            cStmt.setString(2, employee.getEmail());
            cStmt.setString(3, employee.getPassword());
            cStmt.setString(4, employee.getProSkill());
            cStmt.setInt(5, employee.getId());
            return cStmt.executeUpdate();
        }
    }

    @Override
    public int deleteById(int id) throws SQLException, IOException {
        String sql = "DELETE FROM users WHERE id = ? AND role = 'EMPLOYEE'";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setInt(1, id);
            return pStmt.executeUpdate();
        }
    }

    private List<Employee> handleResult(ResultSet rs) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setFullName(rs.getString("full_name"));
            employee.setEmail(rs.getString("email"));
            employee.setPassword(rs.getString("password"));
            employee.setRole(rs.getString("role"));
            employee.setProSkill(rs.getString("pro_skill"));
            employees.add(employee);
        }
        return employees;
    }
}
