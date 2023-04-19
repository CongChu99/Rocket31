package backend.service;

import backend.repository.EmployeeRepository;
import backend.repository.IEmployeeRepository;
import entity.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository repository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() throws SQLException, IOException {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) throws SQLException, IOException {
        return repository.findById(id);
    }

    @Override
    public int create(Employee employee) throws SQLException, IOException {
        return repository.create(employee);
    }

    @Override
    public int update(Employee employee) throws SQLException, IOException {
        return repository.update(employee);
    }

    @Override
    public int deleteById(int id) throws SQLException, IOException {
        return repository.deleteById(id);
    }
}
