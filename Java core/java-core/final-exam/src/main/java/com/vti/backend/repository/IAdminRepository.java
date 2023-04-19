package com.vti.backend.repository;

import com.vti.entity.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IAdminRepository {
    List<Admin> findAll() throws SQLException, IOException;

    List<Admin> findById(int id) throws SQLException, IOException;

    int create(Admin admin) throws SQLException, IOException;

    int update(Admin admin) throws SQLException, IOException;

    int deleteById(int id) throws SQLException, IOException;
}
