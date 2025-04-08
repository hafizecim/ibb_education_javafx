package com.hafizesenyil.ibb_education_javafx.controller;


import com.hafizesenyil.ibb_education_javafx.dao.UserDAO;
import com.hafizesenyil.ibb_education_javafx.dto.UserDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Optional;

public class LoginController {

    // Injection
    // Veri tabanı işlemleri için)
    private UserDAO userDAO;

    // Parametresiz Constructor
    public LoginController() {
        userDAO = new UserDAO();
    }

    /// /////////////////////////////////////////////////////////////////////////////
    ///  FXML Field (burada field yapıları bağlanacak)
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    /// //////////////////////////////////////////////////////////////////////////////////////
    // ShowAlert (Kullanıcıya bilgi veya hata mesajları göstermek için kullanılan yardımcı metot)
    // INFORMATION:BILGI,  ERROR: HATA
    private void showAlert(String title, String message, Alert.AlertType type) {
        // Alert nesnesi oluşturuyoruz ve parametre olarak alınan başlık, mesaj ve tipi ayarlıyoruz
        Alert alert = new Alert(type);

        // Title
        alert.setTitle(title);

        // Message
        alert.setContentText(message);

        // Alert penceresini gösteriyoruz ve kullanıcıdan bir yanıt bekliyoruz
        alert.showAndWait();
    } //end showAlert

    /// //////////////////////////////////////////////////////////////////////////////////////
    // Klavyeden ENTER tuşuna bastığımda giriş yapsın
    @FXML
    private void specialOnEnterPressed(KeyEvent keyEvent) {
        // Eğer basılan tuş ENTER ise
        if (keyEvent.getCode() == KeyCode.ENTER) {
            // Eğer Enter'a basarsam login() sayfasına gitsin
            login();
        }
    } // onEnterPressed

    /// /////////////////////////////////////////////////////////////////////////////////////
    // Login ( Kullanıcı giriş işlemini gerçekleştiren metot)
    @FXML
    public void login() {
        // Kullanıcı Giriş Yaparken Username, Password Almak
        String username, password;
        username = usernameField.getText();
        password = passwordField.getText();

        // optionalUserDTO(Veri tabanına ekle)
        Optional<UserDTO> optionalUserDTO = userDAO.loginUser(username, password);

        // Eğer Veri Boş değilse
        if (optionalUserDTO.isPresent()) {
            // Veriyi almak
            UserDTO userDTO = optionalUserDTO.get();

            // Eğer başarılıysa Pop-up göster
            showAlert("Başarılı", "Giriş Başarılı", Alert.AlertType.INFORMATION);

            // Kayıt başarılı ise Admin Panelkine geçiş sağla
            openAdminPane();

        } else {
            // Eğer bilgiler yanlışsa, database kayıt olmamışsa
            showAlert("Başarılı", "Giriş Başarılı", Alert.AlertType.ERROR);
        }
    }

    // Eğer Login başarılıysa Admin Panel(Dashboard)
    private void openAdminPane() {
    }

    }
