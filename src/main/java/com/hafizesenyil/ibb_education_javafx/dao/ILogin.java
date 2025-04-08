package com.hafizesenyil.ibb_education_javafx.dao;

import java.util.Optional;

public interface  ILogin <T> {

    // Login olması için gerekli yapılar eklenmiştir.
    // Bir interfacesi başka bir interface ye eklemek istersek implement yapılır
    Optional<T> loginUser(String username, String password);
}
