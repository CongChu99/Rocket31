package backend.repository;

import entity.Employee;
import utils.JdbcUtils;

import java.io.IOException;
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

    @Override
    public Employee findById(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE id = ? AND role = 'EMPLOYEE'";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setInt(1, id);
            try (ResultSet rs = pStmt.executeQuery()) {
                if (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setFullName(rs.getString("full_name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setPassword(rs.getString("password"));
                    employee.setRole(rs.getString("role"));
                    employee.setProSkill(rs.getString("pro_skill"));
                    return employee;
                }
                return null;
            }
        }
    }

    @Override
    public int create(Employee employee) throws SQLException, IOException {
        String sql = "INSERT INTO users (full_name, email, password, role, pro_skill) VALUES (?, ?, ?, 'EMPLOYEE', ?)";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setString(1, employee.getFullName());
            pStmt.setString(2, employee.getEmail());
            pStmt.setString(3, employee.getPassword());
            pStmt.setString(4, employee.getProSkill());
            return pStmt.executeUpdate();
        }
    }

    @Override
    public int update(Employee employee) throws SQLException, IOException {
        String sql = "UPDATE users SET full_name = ?, email = ?, password = ?, exp_in_year = ? WHERE id = ? AND role = 'EMPLOYEE'";
        try (
                Connection connection = JdbcUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql)
        ) {
            pStmt.setString(1, employee.getFullName());
            pStmt.setString(2, employee.getEmail());
            pStmt.setString(3, employee.getPassword());
            pStmt.setString(4, employee.getProSkill());
            pStmt.setInt(5, employee.getId());
            return pStmt.executeUpdate();
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
}
