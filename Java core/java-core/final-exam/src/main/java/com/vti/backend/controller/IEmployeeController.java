package com.vti.backend.controller;

import com.vti.entity.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeController {
    List<Employee> findAll() throws SQLException, IOException;

    List<Employee> findById(int id) throws SQLException, IOException;

    int create(Employee employee) throws SQLException, IOException;

    int update(Employee employee) throws SQLException, IOException;

    int deleteById(int id) throws SQLException, IOException;
}
