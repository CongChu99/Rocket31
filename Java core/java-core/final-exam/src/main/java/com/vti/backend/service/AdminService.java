package com.vti.backend.service;

import com.vti.backend.repository.AdminRepository;
import com.vti.backend.repository.IAdminRepository;
import com.vti.entity.Admin;

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
    public List<Admin> findById(int id) throws SQLException, IOException {
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
