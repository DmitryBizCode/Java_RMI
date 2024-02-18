module rmi_controller.java_rmi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.rmi;

    opens rmi_controller.java_rmi to javafx.fxml;
    exports rmi_controller.java_rmi;
    exports RMI;
}