package backend.service;

import backend.repository.AdminRepository;
import backend.repository.IAdminRepository;
import entity.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminService implements IAdminService {
    private final IAdminRepository repository = new AdminRepository();

    @Override
    public List<Admin> findAll() throws SQLException, IOException {
        return repository.findAll();
    }

    @Override
    public Admin findById(int id) throws SQLException, IOException {
        return repository.findById(id);
    }

    @Override
    public int create(Admin admin) throws SQLException, IOException {
        return repository.create(admin);
    }

    @Override
    public int update(Admin admin) throws SQLException, IOException {
        return repository.update(admin);
    }

    @Override
    public int deleteById(int id) throws SQLException, IOException {
        return repository.deleteById(id);
    }
}
