package com.hafizesenyil.ibb_education_javafx.database;

import com.hafizesenyil.ibb_education_javafx.utils.SpecialColor;

import java.sql.*;


public class SingletonPropertiesDBConnection {

    // Field
    // Database  Information Data
    private static String URL = "jdbc:h2:./h2db/user_management"; // . bulunduğu dizin
    //private static String URL = "jdbc:h2:~/h2db/user_management" + "AUTO_SERVER=TRUE"; // ~ kök dizin
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
    public static void dataSet() throws SQLException{
        // Singleton Instance ile Bağlantıyı al
        SingletonPropertiesDBConnection dbConnection = SingletonPropertiesDBConnection.getInstance();
        Connection conn = dbConnection.getConnection();

        Statement stmt = conn.createStatement();

        // Örnek bir tablo oluştur
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(255), "
                + "email VARCHAR(255))";
        stmt.execute(createTableSQL);
        System.out.println("Users tablosu oluşturuldu!");

        // Veri Ekleme
        String insertDataSQL = "INSERT INTO Users (name, email) VALUES "
                + "('Ali Veli', 'ali@example.com'), "
                + "('Ayşe Fatma', 'ayse@example.com')";
        stmt.executeUpdate(insertDataSQL);
        System.out.println("Veriler eklendi!");

        // Veri Okuma
        String selectSQL = "SELECT * FROM Users";
        ResultSet rs = stmt.executeQuery(selectSQL);

        System.out.println("\nUsers Tablosu İçeriği:");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Email: " + rs.getString("email"));
        }
        // Bağlantıyı Kapat
        SingletonPropertiesDBConnection.closeConnection();
    }
    public static void main(String[] args) throws SQLException {
        // Test etmek için şağıdaki yorum satırını aç
        //dataSet();
    }
} // end class
