module com.hafizesenyil.ibb_education_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    //requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;

    opens com.hafizesenyil.ibb_education_javafx to javafx.fxml;
    exports com.hafizesenyil.ibb_education_javafx;
}