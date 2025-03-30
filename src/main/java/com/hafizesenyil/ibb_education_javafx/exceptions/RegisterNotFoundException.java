package com.hafizesenyil.ibb_education_javafx.exceptions;

// Öğrenci bulunamazsa Fırlatılacak Özel Excepiton
public class RegisterNotFoundException extends RuntimeException {

    // Parametresiz Constructor
    public RegisterNotFoundException() {
        super("Kayıt bulunamadı");
    }

    // Parametreli Constructor
    public RegisterNotFoundException(String message) {
        super(message);
    }
}