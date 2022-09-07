module com.mansourappdevelopment.jdbcjavafxcrud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.mansourappdevelopment.jdbcjavafxcrud to javafx.fxml;
    exports com.mansourappdevelopment.jdbcjavafxcrud;
}