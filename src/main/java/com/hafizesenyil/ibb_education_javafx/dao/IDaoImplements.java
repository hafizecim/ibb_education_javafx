package com.hafizesenyil.ibb_education_javafx.dao;


import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface IDaoImplements <T> {

    // CREATE
    Optional<T> create(T t);

    // LIST
    List<T> list();

    // FIND
    Optional<T> findByName(String name);
    Optional<T> findById(int id);

    // UPDATE
    Optional<T> update(int id, T entity);

    // DELETE
    Optional<T> delete(int id);

    // Gövdeli Method
    default Connection iDaoImplementsDatabaseConnection(){
        return null;
    }
}
