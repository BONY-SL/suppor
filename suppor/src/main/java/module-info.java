module org.suppor.p4_group_8_repo.application.suppor {
    // JavaFX dependencies
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    // JUnit and TestFX for testing
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.engine;
    requires org.junit.platform.commons;

    // JavaFX reflection support for testing
    requires java.base;

    // Export and open packages for reflection and testing
    opens org.suppor.p4_group_8_repo.application.suppor to org.junit.platform.commons;

}
