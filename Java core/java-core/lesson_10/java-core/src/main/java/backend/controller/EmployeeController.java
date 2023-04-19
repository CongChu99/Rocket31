package backend.controller;

import backend.service.EmployeeService;
import backend.service.IEmployeeService;
import entity.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController implements IEmployeeController {
    private final IEmployeeService service = new EmployeeService();

    @Override
    public List<Employee> findAll() throws SQLException, IOException {
        return service.findAll();
    }

    @Override
    public Employee findById(int id) throws SQLException, IOException {
        return service.findById(id);
    }

    @Override
    public int create(Employee employee) throws SQLException, IOException {
        return service.create(employee);
    }

    @Override
    public int update(Employee employee) throws SQLException, IOException {
        return service.update(employee);
    }

    @Override
    public int deleteById(int id) throws SQLException, IOException {
        return service.deleteById(id);
    }
}
