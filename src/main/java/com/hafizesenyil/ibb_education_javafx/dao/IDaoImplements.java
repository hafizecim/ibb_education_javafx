package com.hafizesenyil.ibb_education_javafx.dao;


import com.hafizesenyil.ibb_education_javafx.database.SingletonPropertiesDBConnection;
import com.hafizesenyil.ibb_education_javafx.dto.UserDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface IDaoImplements <T> {

    // CREATE
    Optional<T> create(T t);

    // LIST
    Optional<List<T>>  list();

    // FIND
    Optional<T> findByName(String name);
    Optional<T> findById(int id);

    // UPDATE
    Optional<T> update(int id, T entity);

    // DELETE
    Optional<T> delete(int id);

    // Gövdeli Method
    default Connection iDaoImplementsDatabaseConnection(){
        return SingletonPropertiesDBConnection.getInstance().getConnection();
    }
}
