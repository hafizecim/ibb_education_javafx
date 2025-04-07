package com.hafizesenyil.ibb_education_javafx.dao;


import com.hafizesenyil.ibb_education_javafx.database.SingletonPropertiesDBConnection;
import com.hafizesenyil.ibb_education_javafx.dto.UserDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.Optional;

public interface IDaoImplements <T> extends ILogin{

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

    /// ////////////////////////////////////////////////////////////////
    /// Daha sonra bu metod dao da açılan : IGenericsMethod interface ile ayrılştılmıştır
    // GENERICS METOTO (LIST,FIND)
    // ResultSet'ten UserDTO oluşturmayı tek bir yardımcı metot
    // ResultSetten UserDTO oluştur
    T mapToObjectDTO(ResultSet resultSet) throws SQLException;

    // dizi elemanları(Değişkenler birden fazla olabilir)
    // ID veya NAME ile veri çektiğimizde bu ortak metot kullanılır
    // Generics ile Tek kayıt Döndüren Metot
    public Optional<T> selectSingle(String sql, Object... params); // herşey gelebilir

    /// ////////////////////////////////////////////////////////////////


    // Gövdeli Method
    default Connection iDaoImplementsDatabaseConnection(){
        return SingletonPropertiesDBConnection.getInstance().getConnection();
    }
}
