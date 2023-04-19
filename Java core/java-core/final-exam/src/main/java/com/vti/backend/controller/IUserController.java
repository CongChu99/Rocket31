package com.vti.backend.controller;

import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserController {
    List<User> findAll() throws SQLException, IOException;

    List<User> findById(int id) throws SQLException, IOException;

    List<User> findByEmailAndPassword(String email, String password) throws SQLException, IOException;

    int create(User user) throws SQLException, IOException;

    int update(User user) throws SQLException, IOException;

    int deleteById(int id) throws SQLException, IOException;
}
