module org.suppor.p4_group_8_repo.application.suppor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.suppor.p4_group_8_repo.application.suppor to javafx.fxml;
    exports org.suppor.p4_group_8_repo.application.suppor;
    exports com.lagocp.gameEngine.sprite;
}