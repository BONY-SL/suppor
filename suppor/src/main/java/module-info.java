module org.suppor.p4_group_8_repo.application.suppor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    // JUnit's modules for testing
    requires org.junit.jupiter.api; // JUnit API
    requires org.junit.jupiter.engine; // JUnit Engine
    requires org.junit.platform.commons; // JUnit Platform Commons

    // Open packages for reflection (required by JUnit and JavaFX)
    opens org.suppor.p4_group_8_repo.application.suppor to javafx.fxml, org.junit.platform.commons;
    opens org.suppor.p4_group_8_repo.application.suppor.model to javafx.fxml, org.junit.platform.commons;
    opens org.suppor.p4_group_8_repo.application.suppor.controller to javafx.fxml, org.junit.platform.commons;

    // Export application packages
    exports org.suppor.p4_group_8_repo.application.suppor;
    exports org.suppor.p4_group_8_repo.application.suppor.view;
    exports org.suppor.p4_group_8_repo.application.suppor.model;
    exports org.suppor.p4_group_8_repo.application.suppor.controller;
}
