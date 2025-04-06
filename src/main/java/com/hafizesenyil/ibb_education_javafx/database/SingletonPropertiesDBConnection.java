package com.hafizesenyil.ibb_education_javafx.database;

import com.hafizesenyil.ibb_education_javafx.utils.SpecialColor;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SingletonPropertiesDBConnection {

    // Field
    // Database  Information Data
    //private static String URL = "jdbc:h2:./h2db/user_management" + "AUTO_SERVER=TRUE";
    private static String URL = "jdbc:h2:~/h2db/user_management" + "AUTO_SERVER=TRUE";
    private static String USERNAME = "sa";
    private static String PASSWORD = "";

    // Singleton Design pattern
    private static SingletonPropertiesDBConnection instance;
    private Connection connection;

    // Parametresiz Constructor (private ile dışarıdan erişilemez olmasını sağlamak)
    private SingletonPropertiesDBConnection() {
        try {
            // JDBC Yükle
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Veritabanı bağlantısı başarılı");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(SpecialColor.RED + "Veri tabani baglantisi basarisiz" + SpecialColor.RESET);
            throw new RuntimeException("Veritabanı bağlantısı başarısız!");
        }
    }

    // Singleton Design Instance
    public static synchronized SingletonPropertiesDBConnection getInstance() {
        if (instance==null){
            instance=new SingletonPropertiesDBConnection();
        }
        return instance;
    }

    //Bağlantı nesnesi çağırma (sağ klik getter and setter --> alt + Ins (0))
    public Connection getConnection() {
        return connection;
    }

    // Database kapatmak
    public static void closeConnection()
    {
        if(instance!=null && instance.connection!=null){
            try {
                instance.connection.close();
                System.out.printf(SpecialColor.RED + "Veri tabani baglantisi kapatildi" + SpecialColor.RESET);
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
    // Database Text
    public static void main(String[] args){

    }

} // end class
