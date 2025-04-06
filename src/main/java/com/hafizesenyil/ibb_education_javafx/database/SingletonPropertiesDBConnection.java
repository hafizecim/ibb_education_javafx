package com.hafizesenyil.ibb_education_javafx.database;

import com.hafizesenyil.ibb_education_javafx.utils.SpecialColor;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonPropertiesDBConnection {

    // Field
    // Database  Information Data
    private static String URL = "jdbc:h2:./h2db/blog" + "AUTO_SERVER=TRUE";
    private static String USERNAME = "sa";
    private static String PASSWORD = "";

    // Parametresiz Constructor (private ile dışarıdan erişilemez olmasını sağlamak)
    private SingletonPropertiesDBConnection() {
    }

    //  For Database Constructor
    private static Connection connection;

    // Method
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println(SpecialColor.GREEN + "Veritabani baglantisi basarili" + SpecialColor.RESET);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.out.println(SpecialColor.RED + "Veri tabani baglantisi basarisiz" + SpecialColor.RESET);
                throw new RuntimeException("Veri tabani baglantisi basarisiz");
            }

        }
        return connection;
    }
} // end class
