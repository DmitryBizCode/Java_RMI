module rmi_controller.java_rmi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.rmi;

    requires javafx.graphics;


    opens RMI to javafx.fxml;

    exports RMI;
    opens rmi_controller.java_rmi to javafx.fxml;
    exports rmi_controller.java_rmi;

}