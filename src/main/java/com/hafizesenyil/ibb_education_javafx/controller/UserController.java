package com.hafizesenyil.ibb_education_javafx.controller;

 import com.hafizesenyil.ibb_education_javafx.dao.IDaoImplements;
 import com.hafizesenyil.ibb_education_javafx.dto.UserDTO;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.List;
 import java.util.Optional;

    public class UserController  implements IDaoImplements<UserDTO> {

            // Injection

            /// ////////////////////////////////////////////////////////////////
            /// CREATE
            @Override
            public Optional<UserDTO> create(UserDTO userDTO) {
                return Optional.empty();
            }

            /// LIST
            @Override
            public Optional<List<UserDTO>> list() {
                return Optional.empty();
            }

            /// FINDBYNAME
            @Override
            public Optional<UserDTO> findByName(String name) {
                return Optional.empty();
            }

            /// FINDBYID
            @Override
            public Optional<UserDTO> findById(int id) {
                return Optional.empty();
            }

            /// UPDATE
            @Override
            public Optional<UserDTO> update(int id, UserDTO userDTO) {
                return Optional.empty();
            }

            /// CREATEDELETE
            @Override
            public Optional<UserDTO> delete(int id) {
                return Optional.empty();
            }

            // GENERICS METOTO (LIST,FIND)
            // ResultSet'ten UserDTO oluşturmayı tek bir yardımcı metot
            // ResultSetten UserDTO oluştur
            @Override
            public UserDTO mapToObjectDTO(ResultSet resultSet) throws SQLException {
                return null;
            }


            @Override
            public Optional<UserDTO> selectSingle(String sql, Object... params) {
                return Optional.empty();
            }

            @Override
            public Optional loginUser(String username, String password) {
                return Optional.empty();
            }
    }
