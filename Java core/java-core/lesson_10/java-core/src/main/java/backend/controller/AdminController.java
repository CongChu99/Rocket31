package backend.controller;

import backend.service.AdminService;
import backend.service.IAdminService;
import entity.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminController implements IAdminController {
    private final IAdminService service = new AdminService();

    @Override
    public List<Admin> findAll() throws SQLException, IOException {
        return service.findAll();
    }

    @Override
    public Admin findById(int id) throws SQLException, IOException {
        return service.findById(id);
    }

    @Override
    public int create(Admin admin) throws SQLException, IOException {
        return service.create(admin);
    }

    @Override
    public int update(Admin admin) throws SQLException, IOException {
        return service.update(admin);
    }

    @Override
    public int deleteById(int id) throws SQLException, IOException {
        return service.deleteById(id);
    }
}
