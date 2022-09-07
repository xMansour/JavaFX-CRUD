module com.mansourappdevelopment.jdbcjavafxcrud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    opens com.mansourappdevelopment.jdbcjavafxcrud to javafx.fxml;
    exports com.mansourappdevelopment.jdbcjavafxcrud;
    exports com.mansourappdevelopment.jdbcjavafxcrud.controllers;
    opens com.mansourappdevelopment.jdbcjavafxcrud.controllers to javafx.fxml;
}