package backend.service;

import entity.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IAdminService {
    List<Admin> findAll() throws SQLException, IOException;

    Admin findById(int id) throws SQLException, IOException;

    int create(Admin admin) throws SQLException, IOException;

    int update(Admin admin) throws SQLException, IOException;

    int deleteById(int id) throws SQLException, IOException;
}
